# User Guide

## Introduction

Trippie is a command-line app to plan any of your upcoming trips. It is tailored to match the needs of student travellers. Whether you are planning for your summer holiday, or a leisure trip on your student exchange program, Trippie got you covered! 

* [Quick Start](#quick-start)
* [Features](#features)
    * [Create new trip: `new trip`](#creating-new-trip-new-trip)
    * [View help: `help`](#viewing-help-help)
    * [Add a place: `add`](#adding-a-place-add)
    * [List all places: `list /p`](#listing-all-places-list-p)
    * [Search for place: `search`](#searching-for-place-search)
    * [Delete place: `delete /p`](#deleting-place-delete-p)
    * [Edit budget: `budget`](#editing-budget-budget)
    * [Add an expense: `buy`](#adding-an-expense-buy)
    * [List all expenses: `list /e`](#listing-all-expenses-list-e)
    * [Delete an expense: `delete /e`](#deleting-an-expense-delete-e)
    * [Convert Currency: `convert /to`](#convert-currency-convert-to)
    * [Exit the Trippie: `exit`](#exiting-the-trippie-exit)
    * [Save the data](#saving-the-data)
* [Command Summary](#command-summary)

## Quick Start

1. Verify that you have Java 11 or above installed in your computer.
2. Download the latest `trippie.jar`.
3. Copy the file to a folder where you want to run it from.
4. Using the terminal, navigate to the path of `trippie.jar`.
5. Run `java -jar trippie.jar`
6. If the setup is correct, you should see a welcome message. Then, it is now ready to go.

## Features 

### Creating new trip: `new trip`
Creates a new trip. You will be prompted to enter some details (i.e. name, start date, exchange rate, and budget) on
 your
 new trip. This allows you to organize multiple trips conveniently.

Format: `new trip`

Example: `new trip`

Expected Output:

```
Enter your new trip's name: Summer Exchange Peru
Enter your new trip's start date (dd-mm-yyyy):12-12-2020
Enter the foreign exchange rate:2.65
Enter the foreign currency abbreviation (eg. MYR): SOL
Enter your budget for the trip (in SGD):500
Added the trip 4  Summer Exchange Peru 12-12-2020
```
### Viewing help: `help`
Shows a concise list of commands available. 

Format: `help`

### Adding a place: `add`
Adds a place to your trip.

Format: `add /n PLACE_NAME /d DAY /t TIME`

* `PLACE_NAME` is the label of the place.
* `DAY` indicates which day you want to visit the place.
* `TIME` indicates the time in the 24-hour format. Separate starting time and ending time with `to`.

Example:
`add /n Dinner at Marina Bay Sands /d 2 /t 1800 to 2000`

Expected output:
```
Got it. I've added this place:
1800 - 2000 Dinner at Marina Bay Sands
```

### Listing all places: `list /p`
Displays all places in a timetable format.

Format: `list /p [/d DAY]`

* `DAY` indicates the specific day which timetable should display.
* If `[/d DAY]` is not specified, displays the full timetable.

Example:
`list /p`

Expected output:
```
DAY 2: (2020-10-21)
1. 1800 - 2000 Dinner at Marina Bay Sands
```

### Searching for place: `search`
Displays all places that includes the search keyword. 

Format: `search KEYWORD`

Example:
`search Dinner`

Expected output:
```
Here is the matching place in your list:
1.1800 - 2000 Dinner at Marina Bay Sands on DAY 2
```

### Deleting place: `delete /p`
Deletes the specified place from the list.

Format: `delete /p PLACE_INDEX`

* `PLACE_INDEX` refers to the index of the place that you want to delete.

Example:
`delete /p 1`

Expected output:
```
Noted. I've removed this place.
1800 - 2000 Dinner at Marina Bay Sands
There are 0 items in the list.
```

### Editing budget: `budget`
Edits a budget to keep track of in expenditure list.

Format: `budget AMOUNT`

* `AMOUNT` indicates your planned budget to spend for the trip.

Example:
`budget 100`

Expected output:
```
Successfully set your total budget to 100.00
```

### Adding an expense: `buy`
Adds an item with its final cost into an expenditure list.

Format: `buy /i ITEM_NAME /c FINAL_COST /d DAY`

* `ITEM_NAME` is the label of the item.
* `FINAL_COST` indicates the cost of the item you purchased.
* `DAY` indicates the specific day when you bought the item.

Example:
`buy /i R&B Brown Sugar /c 3.00 /d 2`

Expected output:
```
Got it! I've added the following item: Day 2: R&B Brown Sugar - $3.00
There are 1 items in the list.
```

### Listing all expenses: `list /e`
Displays all the items bought in the expenditure list
and reminds user on their budget limit.

Format: `list /e`

Expected output:
```
Total budget: $1325.00 SOL (500.00 SGD)
Expense List:
[1] Day 2: R&B Brown Sugar - $3.00
Your current total spending is $3.00 SOL (1.13 SGD)
Your current remaining budget is $1322.00 SOL (498.87 SGD)
You are still spending within your budget.
[=---------] 0.2%
```

### Deleting an expense: `delete /e`
Deletes the specified place from the list.

Format: `delete /p EXPENSE_INDEX`

* `EXPENSE_INDEX` refers to the index of the expense based on the list that you want to delete.

Example:
`delete /p 1`

Expected output:
```
Noted. I've removed this item from the expenditure list.
Day 2: R&B Brown Sugar - $3.00
There are 0 items in the list.
```

### Convert currency: `convert /to`
Converts an amount to the requested currency.

Format: `convert /to[CURRENCY] AMOUNT`

* `CURRENCY` refers to either local currency `SGD` or foreign currency `FOR`.
* `AMOUNT` refers to the amount to be converted into the preferred currency.

Example:
`convert /toSGD 500`

Expected output:
```
Processing... Please Wait.
That amount in your local currency is 188.68 SGD.
```

Example:
`convert /toFOR 500`

Expected output:
```
Processing... Please Wait.
That amount in your foreign currency is 1325.00 SOL.
```

### Exiting the Trippie: `exit`
Exits the program and auto-saves.

Expected output:
```
Bye. Hope to see you again soon!
```

### Saving the data:

Trippie data are saved in the hard disk automatically.

## Command Summary

**Action** | **Format, Examples**
------------ | -------------
**new trip**|`new trip`
**help**|`help`
**add**|`add /n PLACE_NAME /d DAY /t TIME`<br>e.g., `add /n Dinner at Marina Bay Sands /d 2 /t 1800 to 2000`
**list /p**|`list /p [/d DAY]` <br>e.g., `list /p`
**search**|`search KEYWORD` <br>e.g., `search Dinner`
**delete /p**|`delete /p PLACE_INDEX` <br>e.g., `delete 1`
**budget**|`budget AMOUNT`<br>e.g., `budget 100`
**buy**|`buy /i ITEM_NAME /c FINAL_COST /d DAY` <br>e.g., `buy /i R&B Brown Sugar /c 3.00 /d 2`
**list /e**|`list /e`
**delete /e**|`delete /p EXPENSE_INDEX` <br>e.g., `delete 1`
**convert /to**|`convert /toCURRENCY AMOUNT` <br>e.g., `convert /toSGD 500`<br>`convert /toFOR 500`
**exit**|`exit`
