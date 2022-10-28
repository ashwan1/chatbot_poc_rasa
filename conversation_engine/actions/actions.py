from datetime import datetime
from typing import Any, Text, Dict, List

import requests
from rasa_sdk import Action, Tracker
from rasa_sdk.executor import CollectingDispatcher

BASE_URL = "http://localhost:8080"

class GetXtraCardNumber(Action):

    def name(self) -> Text:
        return "get_xtracard_number"

    def run(self, dispatcher: CollectingDispatcher,
            tracker: Tracker,
            domain: Dict[Text, Any]) -> List[Dict[Text, Any]]:
        email = tracker.get_slot("email")
        url = f"{BASE_URL}/admin/xtracareNumber/{email}"
        resp = requests.get(url).json()
        if resp['status'] == 'success':
            bot_response = f'Your xtracard number is {resp["data"]["xtraCardNumber"]}'
        else:
            bot_response = 'Sorry! I was unable to fetch ur xtracard number'

        dispatcher.utter_message(bot_response)

        return []

class GetLatestTransaction(Action):

    def name(self) -> Text:
        return 'get_latest_transaction'

    def run(self, dispatcher: "CollectingDispatcher", 
            tracker: Tracker, 
            domain: Dict[Text, Any]) -> List[Dict[Text, Any]]:
        xtracard_number = tracker.get_slot("xtracard_number")
        url = f"{BASE_URL}/transaction/{xtracard_number}/latest"
        resp = requests.get(url).json()
        if resp['status'] == 'success':
            date = datetime.fromisoformat(resp['data']['date'].split(" ")[0])
            dispatcher.utter_message(f"You made last transaction on {date.strftime('%a, %b %d, %Y')}")
            dispatcher.utter_message(f"from {resp['data']['store']['name']}, {resp['data']['store']['stateCode']}")
            dispatcher.utter_message(f"of ${resp['data']['amount']}")
        else:
            bot_response = 'Sorry! I was unable to fetch ur xtracard number'
            dispatcher.utter_message(bot_response)
        return []