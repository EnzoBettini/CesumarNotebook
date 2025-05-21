# Travel Planning API

A FastAPI application that uses CrewAI and Google's Gemini AI to generate personalized travel plans.

## Setup

1. Create a virtual environment:

```bash
python -m venv venv
source venv/bin/activate  # On Windows: venv\Scripts\activate
```

2. Install dependencies:

```bash
pip install -r requirements.txt
```

3. Create a `.env` file in the root directory and add your Google Gemini AI API key:

```
GOOGLE_API_KEY=your_gemini_api_key_here
```

## Running the Application

1. Start the FastAPI server:

```bash
uvicorn main:app --reload
```

2. The API will be available at `http://localhost:8000`

## API Endpoints

### POST /generate-travel-plan

Generate a personalized travel plan based on your preferences.

Request body:

```json
{
  "destination": "Tokyo",
  "duration": 5,
  "budget": 2500.0,
  "preferences": "Interested in technology, food, and traditional culture"
}
```

## Documentation

- API documentation is available at `http://localhost:8000/docs`
- ReDoc alternative documentation at `http://localhost:8000/redoc`
