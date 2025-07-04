from fastapi import FastAPI, HTTPException
from fastapi.middleware.cors import CORSMiddleware
from pydantic import BaseModel
from dotenv import load_dotenv
import os
import asyncio
from crew.travel_crew import TravelCrew

# Load environment variables
load_dotenv()

# Initialize FastAPI app
app = FastAPI(
    title="Travel Planning API",
    description="An API that uses CrewAI and Gemini to generate travel plans",
    version="1.0.0"
)

# Configure CORS
app.add_middleware(
    CORSMiddleware,
    allow_origins=["http://localhost:5173"],  # Frontend URL
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
)

class TravelRequest(BaseModel):
    destination: str
    duration: int
    budget: float
    preferences: str

async def generate_travel_plan_with_timeout(request: TravelRequest):
    try:
        # Initialize the travel crew
        travel_crew = TravelCrew()

        # Generate the travel plan with a timeout of 110 seconds
        # Using asyncio.wait_for to add timeout
        travel_plan = await asyncio.wait_for(
            asyncio.to_thread(
                travel_crew.plan_trip,
                destination=request.destination,
                duration=request.duration,
                budget=request.budget,
                preferences=request.preferences
            ),
            timeout=110  # 110 seconds timeout (slightly less than frontend timeout)
        )

        return travel_plan
    except asyncio.TimeoutError:
        raise HTTPException(
            status_code=504,
            detail={
                "message": "Request timeout",
                "error": "The travel plan generation took too long. Please try again with simpler parameters."
            }
        )
    except Exception as e:
        print(f"Error generating travel plan: {str(e)}")
        raise HTTPException(
            status_code=500,
            detail={
                "message": "Error generating travel plan",
                "error": str(e)
            }
        )

@app.post("/generate-travel-plan")
async def handle_travel_plan(request: TravelRequest):
    travel_plan = await generate_travel_plan_with_timeout(request)
    return {"travel_plan": travel_plan}

@app.get("/")
async def root():
    return {"message": "Welcome to the Travel Planning API"}

if __name__ == "__main__":
    import uvicorn
    uvicorn.run(app, host="0.0.0.0", port=8000, reload=True)
