from crewai import Agent, Task, Crew
import google.generativeai as genai
import os
from typing import Dict, Any
from crewai import LLM

class TravelCrew:
    def __init__(self):


        self.llm = LLM(
            model="gemini/gemini-2.5-flash-preview-04-17",
            temperature=0.7,
        )

        # Initialize agents
        self.research_agent = Agent(
            role='Travel Researcher',
            goal='Research and gather detailed information about travel destinations',
            backstory='Expert travel researcher with vast knowledge of global destinations',
            allow_delegation=False,
            llm=self.llm
        )

        self.planner_agent = Agent(
            role='Travel Planner',
            goal='Create detailed and personalized travel itineraries',
            backstory='Experienced travel planner who specializes in creating custom travel experiences',
            allow_delegation=False,
            llm=self.llm
        )

        self.budget_agent = Agent(
            role='Budget Specialist',
            goal='Optimize travel plans according to budget constraints',
            backstory='Financial expert specializing in travel budgeting and cost optimization',
            allow_delegation=False,
            llm=self.llm
        )

    def plan_trip(self, destination: str, duration: int, budget: float, preferences: str) -> Dict[str, Any]:
        # Create tasks for the crew
        research_task = Task(
            description=f"""Research {destination} thoroughly including:
            1. Best time to visit
            2. Main attractions
            3. Local customs and culture
            4. Transportation options
            5. Accommodation options
            Consider the preferences: {preferences}""",
            expected_output="A detailed research report about the destination",
            agent=self.research_agent
        )

        planning_task = Task(
            description=f"""Create a detailed day-by-day itinerary for {duration} days in {destination}.
            Include:
            1. Daily activities and attractions
            2. Recommended restaurants
            3. Transportation between locations
            4. Time management
            Based on the research and considering: {preferences}""",
            expected_output="A day-by-day travel itinerary",
            agent=self.planner_agent
        )

        budget_task = Task(
            description=f"""Create a detailed budget breakdown for the trip with total budget of ${budget}.
            Include:
            1. Accommodation costs
            2. Transportation costs
            3. Activities and entrance fees
            4. Food and dining
            5. Emergency fund allocation
            Optimize the plan to stay within budget while maximizing experiences.""",
            expected_output="A detailed budget breakdown",
            agent=self.budget_agent
        )

        # Create and run the crew
        crew = Crew(
            agents=[self.research_agent, self.planner_agent, self.budget_agent],
            tasks=[research_task, planning_task, budget_task]
        )

        result = crew.kickoff()

        # Process and structure the result
        return {
            "destination": destination,
            "duration": duration,
            "budget": budget,
            "preferences": preferences,
            "plan": result
        }
