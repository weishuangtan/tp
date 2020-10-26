# User Guide
![Trippie Logo](https://i.imgur.com/jSwGL7O.png)

## Introduction
Trippie is a command-line app to plan any of your upcoming trips. It is tailored to match the needs of student travellers. Whether you are planning for your summer holiday, or a leisure trip on your student exchange program, Trippie got you covered!

### Purpose of User Guide
This User Guide helps you in using the various features available in Trippie.

## How to use
Begin with the [Quick Start](#quick-start) section if it is your first time using Trippie. All the commands are listed out in the table of contents. To find out the details on each command, just click and follow the links. Please check the [FAQ](#faq) section for frequently encountered problems.

## Table of Contents
* [Quick Start](#quick-start)
* [Features](#features)
    * [Creating a new trip: `new trip`](#creating-new-trip-new-trip)
    * [Loading an existing trip: `load trip`](#loading-an-existing-trip)
    * [Deleting a trip: `delete trip`](#deleting-a-trip)
    * [Viewing help: `help`](#viewing-help-help)
    * [Adding a place: `add`](#adding-a-place-add)
    * [Listing all places: `list /p`](#listing-all-places-list-p)
    * [Searching for place: `search`](#searching-for-place-search)
    * [Deleting place: `delete /p`](#deleting-place-delete-p)
    * [Editing budget: `budget`](#editing-budget-budget)
    * [Adding an expense: `buy`](#adding-an-expense-buy)
    * [Listing all expenses: `list /e`](#listing-all-expenses-list-e)
    * [Deleting an expense: `delete /e`](#deleting-an-expense-delete-e)
    * [Converting Currency: `convert /to`](#convert-currency-convert-to)
    * [Exiting the Trippie: `exit`](#exiting-the-trippie-exit)
    * [Saving the data](#saving-the-data)
* [FAQ](#faq)
* [Command Summary](#command-summary)

## Quick Start
1. Verify that you have Java 11 or above installed in your computer by running `java --version`.
2. Download the latest `trippie.jar` from [here](https://github.com/AY2021S1-CS2113T-W11-2/tp/releases/tag/v2.0).
3. Copy the file to a folder where you want to run it from.
4. Using the terminal, navigate to the path of `trippie.jar`.
5. Run `java -jar trippie.jar`
6. If the setup is correct, you should see a welcome message. Then, it is now ready to go.
7. Create your first trip by entering [`new trip`](#creating-new-trip-new-trip) to the command line. Then, enter your trip name, start date, exhange rate, currency, and budget.
8. Add your first place using [`add`](#adding-a-place-add). Then buy your first item with [`buy`](#adding-an-expense-buy).
9. Try listing your places by entering `list /p` and your expenses with `list /e`.
10. `exit` and check your folder to check your Trippie files!

## Features 
<div markdown="span" class="alert alert-info" role="alert"><i class="fa fa-info-circle"></i> <b>Notes on command format:</b> 

* The **`bolded syntax`** represents the key command.
* Words in `CAPITAL LETTERS` are arguments that you need to supply. 
    * e.g. **`add`**`/n PLACE_NAME /d DAY /t TIME`
    * `PLACE_NAME`, `DAY`, `TIME` are arguments needed accordingly.
* Items in `[square brackets]` are optional. 
    * e.g. **`list`**`/p [/d DAY]`
</div>


### Creating a new trip: `new trip`
Creates a new trip. You will be prompted to enter some details (i.e. name, start date, exchange rate, and budget) after entering this command. Trippie allows you to organize multiple trips, thus you can use this command to create many trips conveniently.


Format: **`new trip`**

Example: **`new trip`**

Expected Output:
```
Enter your new trip's name: Summer Exchange Peru
Enter your new trip's start date (dd-mm-yyyy):12-12-2020
Enter the foreign exchange rate:2.65
Enter the foreign currency abbreviation (eg. MYR): SOL
Enter your budget for the trip (in SGD):500
Added the trip 4  Summer Exchange Peru 12-12-2020
```

<div markdown="span" class="alert alert-warning" role="alert"><i class="fa fa-exclamation-circle"></i> <b>Warning</b> 

* Enter your trip name without slashes i.e. "\\" or "/".
* Input your start date with the given format.
* Currency abbreviation should only be 3 characters.
* Budget is accurate only to 2 decimal places.

</div>

---

### Loading an existing trip: `load trip`
Loads a specific trip from the list of saved trips in `trippie_data`. Trippie will prompt you to enter the index of your preferred trip and sets it as the current trip. Before entering this command, Trippie will automatically load your last opened trip.

Format: **`load trip`**

Example: **`load trip`**

Expected output:
```
Here are your existing trips.
1. 1 Day - Chigago Trip
2. 3 Days - Jakarta Festival
3. 5 Days - Wonderful Singapore
4. 6 Days - Malaysia KL

Which one do you want to load? Enter the index:3
I found a file in your directory!
Setting up the file now...
```

<div markdown="span" class="alert alert-warning" role="alert"><i class="fa fa-exclamation-circle"></i> <b>Warning</b> 

* You need to enter a valid trip index!

</div>

---

### Deleting a trip: `delete trip` [Proposed]

Deletes a specific trip from the list of saved trip in `trippie_data`. Trippie will prompt you to enter the index of your preferred trip.

Format: **`delete trip`**

Example: **`delete trip`**

Expected output:
```
Here are your existing trips.
1. 1 Day - Chigago Trip
2. 3 Days - Jakarta Festival
3. 5 Days - Wonderful Singapore
4. 6 Days - Malaysia KL

Which one do you want to delete? Enter the index:3
Are you sure you want to permanently remove "Wonderful Singapore"? Enter [Y/N]:Y
"Wonderful Singapore" has been deleted.
```
---

### Viewing help: `help`
Shows a concise list of commands available. 

Format: **`help`**

Example: **`help`**

Expected output:
```
[new trip] |   Creates a new trip. You will be prompted to enter some details
           |   Format: new trip
___________|______________________________________________________________
[load trip]|   Loads a specific trip from the saved list
           |   Format: load trip
___________|______________________________________________________________
[help]     |   Shows a concise list of commands available
           |   Format: help
___________|______________________________________________________________
[add]      |   Adds a place to your trip
           |   Format: add /n PLACE_NAME /d DAY /t TIME
           |   Example: add /n Dinner at Marina Bay Sands /d 2 /t 1800 to 2000
___________|______________________________________________________________
[list]     |   Displays all places in a timetable format
(places)   |   Format: list /p [/d DAY]
           |   list /p /d 2
___________|______________________________________________________________
[search]   |   Displays all places that includes the search keyword
(places)   |   Format: search KEYWORD
           |   search Dinner
___________|______________________________________________________________
[delete]   |   Deletes the specified place from the list
(place)    |   Format: delete /p PLACE_INDEX
           |   Example: delete /p 1
___________|______________________________________________________________
[budget]   |   Edits a budget to keep track of in expenditure list
           |   Format: budget AMOUNT
           |   Example: budget 100
___________|______________________________________________________________
[buy]      |   Adds an item with its final cost into an expenditure list
           |   Format: buy /i ITEM_NAME /c FINAL_COST /d DAY_NUMBER
           |   Example: buy /i R&B Brown Sugar /c 3.00 /d 2
___________|______________________________________________________________
[list]     |   Displays all the items bought in the expenditure list
(expenses) |   Format: list /e
___________|______________________________________________________________
[delete]   |   Deletes the specified place from the list
(expense)  |   Format: delete /e EXPENSE_INDEX
           |   Example: delete /e 1
___________|______________________________________________________________
[convert   |   Converts an amount to the requested currency
/to]       |   Format: convert /toSGD AMOUNT
           |   Format: convert /toSGD 500
           |   Format: convert /toFOR AMOUNT
           |   Format: convert /toFOR 500
___________|______________________________________________________________
[exit]     |   Exit the program and auto-saves
           |   Format: exit
__________________________________________________________________________
```

---
### Adding a place: `add`
Adds a place to your trip.

Format: **`add`**`/n PLACE_NAME /d DAY /t TIME`

* `PLACE_NAME` is the label of the place.
* `DAY` indicates which day you want to visit the place.
* `TIME` indicates the time in the 24-hour format. Separate starting time and ending time with `to`.

Example:
**`add`**`/n Dinner at Marina Bay Sands /d 2 /t 1800 to 2000`

Expected output:
```
Got it. I've added this place:
1800 - 2000 Dinner at Marina Bay 
Now you have 1 place in the list.
```

<div markdown="span" class="alert alert-warning" role="alert"><i class="fa fa-exclamation-circle"></i> <b>Warning</b> 

* The tags should be in the correct order.
* Use 24-hour format for time.

</div>


---

### Listing all places: `list /p`
Displays all places in a timetable format.

Format: **`list /p`**`[/d DAY]`

* `DAY` indicates the specific day which timetable should display.
* If `[/d DAY]` is not specified, displays the full timetable.

Example:
**`list /p`**

Expected output:
```
DAY 2: (2020-10-21)
[1] 1800 - 2000 Dinner at Marina Bay Sands
```

---

### Searching for place: `search`
Displays all places that includes the search keyword. 

Format: **`search`**`KEYWORD`

Example:
**`search`**`Dinner`

Expected output:
```
Here is your search result:
1.1800 - 2000 Dinner at Marina Bay Sands on DAY 2
```

---

### Deleting place: `delete /p`
Deletes the specified place from the list.

Format: **`delete /p`**`PLACE_INDEX`

* `PLACE_INDEX` refers to the index of the place that you want to delete.

Example:
**`delete /p`**`1`

Expected output:
```
Noted. I've removed this place from the place list.
1800 - 2000 Dinner at Marina Bay Sands
Now you have 0 place in the list.
```

<div markdown="span" class="alert alert-warning" role="alert"><i class="fa fa-exclamation-circle"></i> <b>Warning</b> 

* Refer to the index from `list /p` to delete. Enter a valid place index.

</div>

---

### Editing budget: `budget`
Edits a budget to keep track of in expenditure list. The budget is stored in the local currency SGD.

Format: **`budget`**`AMOUNT`

* `AMOUNT` indicates your planned budget to spend for the trip, in SGD.

Example:
**`budget`**`100`

Expected output:
```
Successfully set your total budget to 100.00
```

<div markdown="span" class="alert alert-warning" role="alert"><i class="fa fa-exclamation-circle"></i> <b>Warning</b> 

* Watch out when shrinking your budget.

</div>


---

### Adding an expense: `buy`
Adds an item and its final cost in foreign currency into the current trip's expense list. 

Format: **`buy`**`/i ITEM_NAME /c FINAL_COST /d DAY`

* `ITEM_NAME` is the label of the item.
* `FINAL_COST` indicates the cost of the item you purchased.
* `DAY` indicates the specific day when you bought the item.

Example:
**`buy`**`/i R&B Brown Sugar /c 3.00 /d 2`

Expected output:
```
Got it! I've added the following item: Day 2: R&B Brown Sugar - $3.00
Now you have 1 item in the list.
```

---

### Listing all expenses: `list /e`
Displays all the items bought in the expenditure list and reminds you on your budget limit.

Format: **`list /e`**

Example: **`list /e`**

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
<div markdown="span" class="alert alert-warning" role="alert"><i class="fa fa-exclamation-circle"></i> <b>Warnings!</b> 

* If you were to buy an item that exceeds the total budget, Trippie will send a warning message and recommand you to increase your budget limit.

</div>

Expected output:
```
Total budget: $141680.00 SWE (5600.00 SGD)
Expense List:
[1] Day 1: glassware - $8000.00
[2] Day 1: jersey - $19900.50
[3] Day 1: tissue - $2.00
[4] Day 2: picture - $200.00
[5] Day 3: clothes - $2000.00
[6] Day 5: house - $120000.00
Your current total spending is $150102.50 SWE (5932.91 SGD)
WARNING! You have exceeded your initial budget.
Recommended action: Increase budget limit.
```

---

### Deleting an expense: `delete /e`
Deletes the specified place from the list.

Format: **`delete /e`**`EXPENSE_INDEX`

* `EXPENSE_INDEX` refers to the index of the expense based on the list that you want to delete.

Example:
**`delete /e`**`1`

Expected output:
```
Noted. I've removed this item from the expenditure list.
Day 2: R&B Brown Sugar - $3.00
Now you have 0 item in the list.
```

---

### Convert currency: `convert /to`
Converts an amount to the requested currency. The requested currency can either be in SGD or the foreign currency specified when creating the trip.

#### Convert to SGD
Format: **`convert /toSGD`**`AMOUNT`

* `AMOUNT` refers to the amount to be converted into the preferred currency.

Example:
**`convert /toSGD`**`500`

Expected output:
```
Processing... Please Wait.
That amount in your local currency is 188.68 SGD.
```

#### Convert to Foreign Currency (FOR)
Format: **`convert /toFOR`**`AMOUNT`

* `AMOUNT` refers to the amount to be converted into the preferred currency.

Example:
**`convert /toFOR`**`500`

Expected output:
```
Processing... Please Wait.
That amount in your foreign currency is 1325.00 SOL.
```

---

### Exiting the Trippie: `exit`
Exits the program and auto-saves.

Format: **`exit`**

Example: **`exit`**

Expected output:
```
Bye. Hope to see you again soon!
```

---

### Saving the data:
Trippie data are saved in a folder named `trippie_data` automatically. This folder will be created in the same location as your `trippie.jar`.

## FAQ
**Q:** Will I be able to view my trips after exiting Trippie?
**A:** Yes, Trippie is able to automatically save your trips for your viewing every time.

**Q:** Can I transfer my old Trippie files to another computer?
**A:** Yes, you can copy the `trippie_data` folder to your new computer before running Trippie there.

**Q:** Does Trippie need Internet?
**A:** No, Trippie is fully offline.

## Command Summary
**Action** | **Format, Examples**
------------ | -------------
**`new trip`**|`new trip`
**`load trip`**|`load trip`
**`delete trip`**|`delete trip`
**`help`**|`help`
**`add`**|`add /n PLACE_NAME /d DAY /t TIME`<br>e.g., `add /n Dinner at Marina Bay Sands /d 2 /t 1800 to 2000`
**`list /p`**|`list /p [/d DAY]` <br>e.g., `list /p`
**`search`**|`search KEYWORD` <br>e.g., `search Dinner`
**`delete /p`**|`delete /p PLACE_INDEX` <br>e.g., `delete 1`
**`budget`**|`budget AMOUNT`<br>e.g., `budget 100`
**`buy`**|`buy /i ITEM_NAME /c FINAL_COST /d DAY` <br>e.g., `buy /i R&B Brown Sugar /c 3.00 /d 2`
**`list /e`**|`list /e`
**`delete /e`**|`delete /p EXPENSE_INDEX` <br>e.g., `delete 1`
**`convert /to`**|`convert /toCURRENCY AMOUNT` <br>e.g., `convert /toSGD 500`<br>`convert /toFOR 500`
**`exit`**|`exit`
