# Quiz App Team 1

### Scope

The following feature allows users to interact with the quiz app. A user can click on a button to generate a new question and choose 
from a list of answers.


### Current Implementation

The current implementation includes a React user interface.

### Overview

 
1. Questions from a csv file are added into the H2 database are. This can be accomplished in the Constants class within the Data package. 

   ```package Data;
   public class constants {
    public static final String CsvFileLocation = "/Users/sergiybabenkov/IdeaProjects/2102-Quiz-App-Team-1/src/Data/Questions.csv"; 
    }```
    
2. To view the questions three servers will need to be running prior to running the app. 
   + Start Restlet Server in the main class
   + Then start Proxy Server
   + Then start the React Server 
3. The UI will be updated through a REST HTTP endpoint.
4. When a user clicks on the new question a new question is generated. 

### Unit Test 

1. The tests from the TestQuestionsTable class ensure that the questions are associated with the correct answer 
2. The tests from the TestQuizTakerTable class ensure that the users are updated with the correct first and last name.
3. The test from the  TestScoresTable class ensures that the scores are updated for the associated user. 

### Running the App
1. Clone the repo 
2. Prior to running the app node.js, react, npm, and nvm will need to be installed. 
3. Flask and Requests will also need to be installed prior to running server.py. If flask or requests are not installed an error will occur in the terminal
5. To start server:
    +  ``` git clone https://github.com/runarfu/cors-proxy``` 
    +  ```cd cors-proxy```
    +  ``` python3 server.py ```
   In a sperate terminal:
   ```curl http://localhost:8182```
   In the directory containing the app run:
   ```npm start```
