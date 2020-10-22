
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