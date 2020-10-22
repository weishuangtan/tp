# Developer Guide

## Introduction

Trippie is a command-line app to plan any of your upcoming trips. It is tailored to match the needs of student travellers. Trippie lets users plan multiple trips through timetabling and also allows users to track their expenses overseas. Trippie is designed for users to enter their input quickly and efficiently.

## Setting up the project in your computer

**Prerequisites:**
* JDK 11
* IntelliJ IDE

<div markdown="span" class="alert alert-warning">

⚠ **Caution:**

Follow the steps in the following guide precisely. Things will not work out if you deviate in some steps.
</div>

First, **fork** this repo, and **clone** the fork into your computer.

If you plan to use Intellij IDEA (highly recommended):
1. **Configure the JDK**: Follow the guide [_[se-edu/guides] IDEA: Configuring the JDK_](https://se-education.org/guides/tutorials/intellijJdk.html) to to ensure Intellij is configured to use **JDK 11**.
1. **Import the project as a Gradle project**: Follow the guide [_[se-edu/guides] IDEA: Importing a Gradle project_](https://se-education.org/guides/tutorials/intellijImportGradleProject.html) to import the project into IDEA.<br>
  :exclamation: Note: Importing a Gradle project is slightly different from importing a normal Java project.
1. **Verify the setup**:
   1. Run the `seedu.trippie.Trippie` and try a few commands.
   2. [Run the tests](Testing.md) to ensure they all pass. 

## Design & Implementation

This section explains the high-level design of the application. Given below is an overview of each component and a more detailed explanation of the architecture. Trippie is the main class which manages the initialization of the relevant classes and their execution.

### Architecture

![UML Diagram Main](https://github.com/AY2021S1-CS2113T-W11-2/tp/blob/master/docs/Trippie%20UML-Main.jpg?raw=true)
<center><i>Figure 1: Overall Architecture</i></center>

The Architecture Diagram given above explains the high-level design of Trippie. Given below is a quick overview of each component.
![UML Diagram](https://github.com/AY2021S1-CS2113T-W11-2/tp/blob/master/docs/Trippie%20UML-Class%20Diagram.jpg?raw=true)
<center><i>Figure 2: Class Types and Parameters</i></center>

Figure 2 above shows an overview on how various Classes are created for the different parameters, mainly Place and Expense.

![UML Diagram Command](https://github.com/AY2021S1-CS2113T-W11-2/tp/blob/master/docs/Trippie%20UML-Command.jpg?raw=true)
<center><i>Figure 3: Commands Classes</i></center>

Figure 3 above shows an overview of the various command classes created which attributes to `Trippie`'s function.

![UML Diagram Exception](https://github.com/AY2021S1-CS2113T-W11-2/tp/blob/master/docs/Trippie%20UML-Exception.jpg?raw=true)
<center><i>Figure 4: Exception Classes</i></center>

Figure 4 above shows the various exception classes used to handle the different errors met.

**`Trippie`** has one class called [`Trippie`](https://github.com/AY2021S1-CS2113T-W11-2/tp/blob/master/src/main/java/seedu/trippie/Trippie.java?) It is responsible for:
* At app launch: Initializes the components in the correct sequence, and connects them up with each other.
* At shut down: Shuts down the components and invokes cleanup methods where necessary.

The rest of the App consists of three components.
- **UI** : The UI of the App.
- **Parser** : Parses user input and its information to respective commands.
- **Storage** : Reads data from, and write data to, the text file.
- **Command** : Executes each command respectively.

The Sequence diagram below shows how the program flows across the different classes when parsing or executing user commands.

![UML Sequence Diagram](https://i.imgur.com/hHq7ltY.png)

<center><i>Figure 5: Sequence Diagram during Command execution</i></center>

## Implementation

This section elaborates on some unique details about how certain features are implemented.
### Trippie
The main trippie class
### Ui
The UI class
### Parser
Parses the user input
### TrippieData
Stores all the user's data
### Storage
Handles file input and output


## Appendix: Requirements

### Product scope

#### Target user profile

- Students who loves to travel.
- Students going on exchange trips e.g. Student Exchange Program (SEP), NUS Overseas College (NOC).
- Students who like to challenge themselves to plan for their own trips.
- Students who seek convenience in tracking their expenses under the same planning application.

#### Value proposition

It allows users to plan multiple trips in a one-stop platform before and during the trip. It provides user with a convenient method of tracking expenditure while not spending past their budget. It also allows user to quickly convert any amount from local to foreign currency, vice versa. 

### User Stories

|Version| As a ... | I want ... | So that I can ...|
|--------|----------|---------------|------------------|
|v1.0|Student event planner|A good organiser|Update details of the trips conveniently|
|v1.0|Student who loves travelling with friends|To easily plan my group trip and share it with my friends|Plan our trips together by being able to seek their advice easily|
|v1.0|Student who is unfamiliar with complex travel planners|To have a simple platform that is easy to use|Efficiently plan out my itinerary|
|v1.0|Studious student|To have my trips automatically saved|Not worry about my trips getting lost if I focus on something else|
|v1.0|Student who likes to plan as I travel|To update my trips daily|use them again in the future|
|v1.0|Student who wants to plan trips online|To take note of any links and/or online references to certain accomodations, places, or restaurants|Open them later|
|v1.0|Student in a student exchange planning committee|To note down some tourist attraction places in Singapore|Bring the exchange students around during orientation|
|v1.0|Student who likes to keep notes on places I travel before|To note down my fresh experiences while on travel trips|Open and look back at it anytime|
|v1.0|Student who is always on-the-go|To input my spendings in a very quick manner|Input my spendings without a hassle|
|v2.0|Student traveling to a foreign country for the first time|To record cultural differences and some other travel notes before traveling there|Access them quickly in that country to avoid any misunderstandings|
|v2.0|Student unsure on which country to visit for exchange | To plan various trips before looking at them individually | Make an informed decision which country I'm most interested in for exchange|
|v2.0|Student who is not very good at managing expenses|To be reminded when my spendings are going to exceed my initial budget|Reduce my spendings if required|
|v2.0|Student who plans trip ahead of time|To be able to edit whatever has been planned easily|Improve my itinerary easily|
|v2.0|Student who is interested in many overseas opportunities|To create ane edit multiple trips simultaneously|Plan multiple trips ahead at a time|

### Use Cases

### Non-Functional Requirements

| Requirement Type | Description |
|------------------|-------------|
|Constraint|Single user product|
|Performance|Software should not be dependent on a remote server|
|Performance|Software should not exceed 100Mb for JAR file and 15MB per PDF file|
|Quality|Users should prefer CLI/Typing|
|Technical|Must have Java 11 installed|
|Technical|No DBMS, all data to be stored locally|
|Technical|Data stored must be in human-editable files|
|Technical|Programme should be platform independent|
|Technical|Programme should work without an installer|

### Glossary

* *CLI* - Command Line Interface
* *IntelliJ* - A Java IDE developed by Jetbrains
* *JUnit* - Java Unit Testing Framework
* *Java* - A programming language

## Appendix: Instructions for Manual Testing

Given below are the instructions to test the app manually.

### Launch and Shutdown

1. Initial Launch
    1. Download the jar file and copy it into an empty folder.
    2. Double-click the jar file or run it through terminal with `java -jar Trippie.jar`. A start-up menu with a default trip will be shown in the CLI.

Expected outcome: 
```
Welcome to
  _            _   ____   ____   _            __T___T__   
 _| |_   ____ |_| | __ \ | __ \ |_|   ____   /         \ 
|_   _| /  __\ _  | |_| || |_| | _   / __ \ | |_|   |_| |  
  | | _ | |   | | |  __/ |  __/ | | | |__|_||    ___    |
  | |/ || |   | | | |    | |    | | | \____  \  \WWW/  /
   \__/ |_|   |_| |_|    |_|    |_|  \____/   \_______/

							Travel made easy
_________________________________________________________________________
I found a file in your directory!
Setting up the file now...
Found these trips in your computer 
0. 1 Day - Bangkok
```
2. Shutdown
    1. Enter `exit` command into the CLI.

Expected outcome: 
```
_________________________________________________________________________
Bye. Hope to see you again soon!
_________________________________________________________________________
```

### Adding and Loading Trip
1. Adding a new trip from scratch
    1. Enter `new trip` command into the CLI.
    2. Key in `test trip` when prompted to enter a trip name.
    3. Fill in the other relevant information required by Trippie.
    4. Enter `exit` command into the CLI.
2. Loading a saved trip
    1. Double click to re-launch the jar file.
    2. Look out for `test trip` listed in the main menu and its respective index.
    3. Enter `load trip` command into the CLI.
    4. Key in the respective index when prompted.
    5. Make sure that the following outcome is printed.

Expected outcome:
```
I found a file in your directory!
Setting up the file now...
```
