# Developer Guide

<center>

![Trippie Logo](https://i.imgur.com/jSwGL7O.png)

</center>

## Table of Content
Below is a list of contents that is included in this document.
* [1.0 Introduction](#10-Introduction)
* [2.0 Setting up the project in your computer](#20-Setting-up-the-project-in-your-computer)
* [3.0 Design](#30-Design)
    * [3.1 Architecture](#31-Architecture-Felix)
    * [3.2 Ui](#32-Ui-Felix)
    * [3.3 Parser](#33-Parser-Wei-Shuang)
    * [3.4 TrippieData](#34-TrippieData-Ivander)
    * [3.5 Storage](#35-Storage-Ivander)
    * [3.6 Command](#36-Command-Wei-Shuang)
    * [3.7 Exceptions](#37-Exceptions-Wei-Shuang)
* [4.0 Implementation](#40-Implementation-DG-to-complete-by-Wed-28-Oct-soft)
    * [4.1 Multiple Trips Structure](#41-Multiple-Trips-Structure-Ivander)
    * [4.2 Sorting Place List](#42-Sorting-Place-List-Kian-En)
    * [4.3 Budget and Expenses](#43-Budget-and-Expenses-Shawn)
    * [4.4 Foreign Exchange Converter](#Foreign-Exchange-Converter-Shawn)
    * [4.5 Import and Export Files](#45-Import-and-Export-Files-Wei-Shuang)
    * [4.6 [Proposed] Colors](#46-Proposed-Colors)
* [5.0 Appendix: Requirements](#50-Appendix-Requirements)
    * [5.1 Product Scope](#51-Product-scope)
        * [5.1.0 Target user profile](#510-Target-user-profile)
        * [5.1.1 Value proposition](#511-Value-proposition)
    * [5.2 User Stories](#52-User-Stories)
    * [5.3 Use Cases](#53-Use-Cases)
    * [5.4 Non-Functional Requirements](#54-Non-Functional-Requirements)
    * [5.5 Glossary](#55-Glossary)
* [6.0 Appendix: Instructions for Manual Testing](#60-Appendix-Instructions-for-Manual-Testing)
    * [6.1 Launch and Shutdown](#61-Launch-and-Shutdown)


## 1.0 Introduction

Trippie is a command-line app to plan any of your upcoming trips. It is tailored to match the needs of student travellers. Trippie lets users plan multiple trips through timetabling and also allows users to track their expenses overseas. Trippie is designed for users to enter their input quickly and efficiently.

## 2.0 Setting up the project in your computer
This sections gives an overview on how to set up the project in your computer.

**Prerequisites:**
* JDK 11
* IntelliJ IDE

<div markdown="span" class="alert alert-warning">

⚠️ **Caution:**
Follow the steps in the following guide precisely. Things will not work out if you deviate in some steps.
</div>

First, **fork** this repo, and **clone** the fork into your computer.

If you plan to use Intellij IDEA (highly recommended):
1. **Configure the JDK**: Follow the guide [_[se-edu/guides] IDEA: Configuring the JDK_](https://se-education.org/guides/tutorials/intellijJdk.html) to to ensure Intellij is configured to use **JDK 11**.
1. **Import the project as a Gradle project**: Follow the guide [_[se-edu/guides] IDEA: Importing a Gradle project_](https://se-education.org/guides/tutorials/intellijImportGradleProject.html) to import the project into IDEA.
:exclamation: Note: Importing a Gradle project is slightly different from importing a normal Java project.
1. **Verify the setup**:
   1. Run the `seedu.trippie.Trippie` and try a few commands.
   2. [Run the tests](TestingGuide.md) to ensure they all pass. 

## 3.0 Design

This section explains the high-level design of the application. Given below is an overview of each component and a more detailed explanation of the architecture. Trippie is the main class which manages the initialization of the relevant classes and their execution.


### 3.1 Architecture (Felix)

<kbd>

![UML Diagram Main](https://i.imgur.com/V3vUpoo.jpg)
<center><i>Figure 1: Overall Architecture</i></center>

</kbd>

The Architecture Diagram given above explains the high-level design of Trippie. Shown below is a diagram of Trippie's high-level structure.

The main class of`Trippie` is called [`Trippie.java`](https://github.com/AY2021S1-CS2113T-W11-2/tp/blob/master/src/main/java/seedu/trippie/Trippie.java?) It is responsible for:
* At app launch: Initializes the components in the correct sequence, and connects them up with each other.
* At shut down: Shuts down the components and invokes cleanup methods where necessary.

The rest of the App consists of three components.
- **UI** : The UI of the App.
- **Parser** : Parses user input and its information to respective commands.
- **Storage** : Reads data from, and write data to, the text file.
- **Command** : Executes each command respectively.

The Sequence diagram below shows how the program flows across the different classes when parsing or executing user commands.

![UML Sequence Diagram](https://i.imgur.com/hHq7ltY.png)
<center><i>Figure 2: Sequence Diagram during Command execution</i></center>

### 3.2 Ui (Felix)

The UI class is in charge of the user's input, from the `readCommand` or `getLine` methods. Other functions of the Ui is to provide shorthands of Trippie's outputs, such as `greetUser` or `showFarewells`.

### 3.3 Parser (Wei Shuang)
The `Parser` class is implemented to parse the user's input, and returns a `Command` object. The `Trippie` class will read in this object and call the `execute` method under the object.

When the `Parser` class is unable to successfully parse the user's input, `TrippieIllegalCommandException` will be thrown. (Refer to 3.7 Exceptions)

### 3.4 TrippieData (Ivander)

The `TrippieData` class is implemented to store all of your data during Trippie's runtime. Below is an architecture diagram of the class.

<kbd>

![TrippieData UML Diagram](https://i.imgur.com/3eAMiob.jpg)
<center><i>Figure 3: Class Architecture</i></center>

</kbd>

The explanation for the above *Figure 3* is as follows:
1. `TrippieData` can contain many `Trip` objects.
2. Each `Trip` consists of a `PlaceList` and an `ExpenseList`.
3. `PlaceList` contains an ArrayList of `Places`.
4. `ExpenseList` contains an ArrayList of `Expense`.

To get the name of a `Place` of index 5 in `PlaceList` and from Trip of index 4 in TrippieData, the program will be implemented based on the following UML diagram.

<kbd>

![](https://i.imgur.com/6xMMhDI.png)
<center><i>Figure 4: Getting a name of a Place object.</i></center>
</kbd>


### 3.5 Storage (Ivander)

The storage class is in charge of all file input and output. More importantly, in managing *trip files* and *master file*.

Important methods inside this class are:
- `setupMasterFile`: Setups *master file* from an existing file, or creates the master file if it is nonexistent.
- `saveMasterFile`: Saves (overwrites) the current *master file* with current user data in `TrippieData`.
- `saveTrip`: Saves (overwrites) a specified `Trip` into a *trip file*. Saves both the `ExpenseList` and the `PlaceList` of that trip.
- `loadMasterFile`: Loads the master file from a specified file scanner and updates the given `TrippieData`.
- `loadTrip`: Loads a trip file from a specified file scanner, and returns a complete `Trip` object.

Refer to Multiple Trips Implementation to find out more about the file structure.

### 3.6 Command (Wei Shuang)
The `Command` class is designed as the parent class for other command classes (e.g. `NewTripCommand`, `AddExpenseCommand`, `ExitCommand` etc). Below shows the architecture diagram for the `Command` class:

<kbd>

![Command UML Diagram](https://i.imgur.com/2puXxO7.jpg)

<center><i>Figure 5: Commands Classes</i></center>

</kbd>

Classes inherited from the `Command` class will overwrite the `execute` method in the parent class, which is written in correspond to the command class' name. 

### 3.7 Exceptions (Wei Shuang)
The `TrippieException` class is designed as the parent class for the other exception classes like the `TrippieIllegalCommandException` class. These exception classes are created to specify the exceptions faced when `Trippie` is running.

Below shows the architecture for `TrippieException`:
<kbd>

![Exception UML Diagram](https://i.imgur.com/ps7ZxEQ.jpg)

<center><i>Figure 6: Exception Classes</i> </center></kbd>

* `TrippieIllegalCommandException` is thrown when `Parser` class is unable to parse the command successfully.
* `TrippieInvalidArgumentException` is thrown when the individual commands inherited from `Command` class meets an error.
* `TrippieExceedBudgetException` is thrown when expenses in the saved trip exceeds the budget given by user.


## 4.0 Implementation [DG to complete by Wed 28 Oct (soft)]

This section elaborates on some unique details about how certain features are implemented.

### 4.1 Multiple Trips Structure (Ivander)

Trippie is built for travelers, those who most probably has more than a single trip in mind. Therefore, the multiple trips feature is designed so that someone can easily work and switch between many trips.

All your `Trip` objects are stored in a java ArrayList object called tripList inside the `TrippieData` object. In this `TrippieData` object, an attribute called `currentTrip` is used to point to `Trip` object inside the ArrayList that is currently being worked on.

Multiple trips feature is designed to **minimize program startup time** and **minimize memory usage**. These aims are achieved by:
1. Reading only one Master File `trippie.txt` that will be loaded on startup.
2. Saving each trip in separate files.
3. Loading only the user's most recently edited trip on startup. This is set as the *default trip* which will be set as the *current trip* during runtime.
4. It is only possible to work on one `Trip` at a single point in time.
5. The commands `new trip` and `load trip` will change the *current trip*.
6. Current trips are automatically saved after each command execution.

The format of `trippie.txt` is as follows:
```
DEFAULT <trip_index>
<trip_index - 1>,<trip_name>,<trip_date (dd-mm-yyyy)>,<trip_max_day>
1,Amazing Bali,03-04-2021,3
2,Australia,01-01-2021,8
3,Wonderful Singapore,02-01-2021,9
```
Here the `trip_name` serves both as the Trip's name and the file name, hence it should not contain invalid characters for file names, i.e. `<>:"/\|?*.` A sample directory structure containing 3 trips is as the following:
```
trippie_data
    ├── Amazing Bali.txt
    ├── Australia.txt
    ├── Wonderful Singapore.txt
    └── trippie.txt
```



### 4.2 Sorting Place List (Kian En)

The way Trippie sorts its place list, regardless of the order the places are added by the user, is through **bubble sort**. The sorting algorithm is called every time a new place is added by the user. 

When listing either places, Trippie will sort them based on both *Day* and *Time*. Hence, there is a need to use a **stable** sorting algorithm. Bubble sort is used for its simplicity and easy implementation. Furthermore, since this sorting algorithm is called every time a new place is added, the list will always be sorted, allowing the time complexity of the sorting algorithm to be **O(n)**.

Likewise when sorting expenses, Trippie will sort them based on *Day*.

### 4.3 Budget and Expenses (Shawn)

Trippie provides travellers an easy and convenient way to track expenses while constantly ensuring that the budget is not exceeded.

<kbd>

![Expenses UML Diagram](https://i.imgur.com/xuZNMxG.jpg)

<center><i>Figure 7: Expenses Classes</i></center>
</kbd>

The `NewTripCommand` receives `currencyAbbreviation`, `budgetValue` and `ForExValue` from the inputs and stores it within the current `Trip` object. `ExpenseList` array object which consists of `Expense` object uitilized the relevant objects stored in `Trip`. This allows `AddExpenseCommand`, `DeleteExpenseCommand` and `ListExpenseCommand` to access the data and edit or list them respectively.
`AddExpenseCommand` consist of `ExpenseComparator` which implements `Comparator<Expense>`. The `ExpenseComparator` sorts the variables in a blackbox by <b>comparing</b> two objects at a time.
`ListExpenseCommand` further access the `currencyAbbreviation` and `ForExValue` objects to print out both local and foreign currency based on the input provided.

A sample output can be seen as follows:
```
Total budget: $300.00 MYR (200.00 SGD)
Expense List:
[1] Day 1: bubble tea - $8.00
[2] Day 2: hotel room - $200.00
Your current total spending is $208.00 MYR (138.67 SGD)
Your current remaining budget is $92.00 MYR (61.33 SGD)
You are still spending within your budget.
[=======---] 69.3%
```

### 4.4 Foreign Exchange Converter (Shawn)

Trippie provide travellers with a quicker alternative to convert any amount into local or foreign currency.

<kbd>

![Currency UML Diagram](https://i.imgur.com/wxM71AO.jpg)


<center><i>Figure 8: Currency Classes</i></center>
</kbd>

Similar to [4.3 Budget and Expense](#Budget-and-Expenses-Shawn), `currencyAbbreviation`, `budgetValue` and `forExValue` are retrivable from `Trip` object.
`Currency` object composes of an **enummeration** `CurrencyType` object. This provides **clarity** since it consists of only `LOCAL` and `FOREIGN` contants.
`CalculateCurrencyCommand` retrive data and convert the input amount according to the input choice.

Here's an example of the conversion based on the relevant data and inputs.
```
Processing... Please Wait.
That amount in your local currency is 13.33 SGD.
```


### 4.5 Import and Export Files (Wei Shuang)
Trippie aims to let its users save and view their files in a reader-friendly format, which is why the import and export files feature is implemented. This feature is designed for users to view their trips via a **text file** anywhere and anytime during their trip conveniently.

Each trip will be saved individually into their respective text files, and each file will contain the trip's `ExpenseList` and `PlaceList`. These information are portrayed in a **reader-friendly format** for users to read the text files easily during their trip.

Here is an example of a saved trip in text file:
```
This file shows your saved trips under Trippie!

Here is your itinerary! Enjoy your trip :)
Day | Start Time | End Time | Place
1 | 1400 | 1700 | Shopping at Johor Bahru City Square
1 | 2000 | 2200 | Check-in hotel
2 | 0900 | 1200 | Dinosaurs Alive Water Theme Park
2 | 1800 | 2000 | Dinner at Cafe BLD

These are your expenses!
Day | Item | Cost
1 | Hand Bag | $60.00
2 | Tickets | $75.00
2 | Buffet Dinner | $70.00

Total budget: $1000.00

Forex Abbreviation: MYR

Forex Rate: 3.0
```

### 4.6 [Proposed] Colors
Who doesn't like colors? 

---

## 5.0 Appendix: Requirements

### 5.1 Product scope

The following sections displays Trippie's potential target user profile, its value proposition.

#### 5.1.0 Target user profile

Here are 4 factors for our targetted user profile

- Students who loves to travel.
- Students going on exchange trips e.g. Student Exchange Program (SEP), NUS Overseas College (NOC).
- Students who like to challenge themselves to plan for their own trips.
- Students who seek convenience in tracking their expenses under the same planning application.

#### 5.1.1 Value proposition

It allows users to plan multiple trips in a one-stop platform before and during the trip. It provides user with a convenient method of tracking expenditure while not spending past their budget. It also allows user to quickly convert any amount from local to foreign currency, vice versa. 

### 5.2 User Stories

This table demostrates a list of user stories relevant to Trippie.

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

### 5.3 Use Cases

Here are the list of use cases for Trippie.

1. Don't have a tool to plan trips.
2. Use Trippie to plan trips.
3. Able to create trips easily.
4. Share the trip files to others.
5. Be a happy student.

### 5.4 Non-Functional Requirements

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

### 5.5 Glossary

* *CLI* - Command Line Interface
* *IntelliJ* - A Java IDE developed by Jetbrains
* *JUnit* - Java Unit Testing Framework
* *Java* - A programming language

## 6.0 Appendix: Instructions for Manual Testing

<kbd>

![UML Diagram Main](https://github.com/AY2021S1-CS2113T-W11-2/tp/blob/master/docs/Trippie%20UML-Main.jpg?raw=true)
<center><i>Figure 9: Overall Architecture</i></center>
</kbd>

![UML Diagram](https://github.com/AY2021S1-CS2113T-W11-2/tp/blob/master/docs/Trippie%20UML-Class%20Diagram.jpg?raw=true)
<center><i>Figure 10: Class Types and Parameters</i></center>

![UML Diagram Command](https://github.com/AY2021S1-CS2113T-W11-2/tp/blob/master/docs/Trippie%20UML-Command.jpg?raw=true)
<center><i>Figure 11: Commands Classes</i></center>

![UML Diagram Exception](https://github.com/AY2021S1-CS2113T-W11-2/tp/blob/master/docs/Trippie%20UML-Exception.jpg?raw=true)
<center><i>Figure 12: Exception Classes</i></center>

Given below are the instructions to test the app manually.

### 6.1 Launch and Shutdown

1. Initial Launch
    1. Download the jar file and copy it into an empty folder.
    2. Double-click the jar file or run it through terminal with `java -jar Trippie.jar`. A start-up menu with a default trip will be shown in the CLI.
