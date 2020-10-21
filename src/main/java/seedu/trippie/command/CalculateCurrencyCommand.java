package seedu.trippie.command;

import seedu.trippie.Ui;
import seedu.trippie.data.Currency;
import seedu.trippie.data.CurrencyType;
import seedu.trippie.data.TrippieData;
import seedu.trippie.exception.TrippieInvalidArgumentException;


public class CalculateCurrencyCommand extends Command {

    private static final String FORMAT_ERROR_MESSAGE = "Incorrect format for [convert] command. "
            + "Please try the following:\n"
            + "Format: convert /toSGD AMOUNT_IN_FOREIGN_CURRENCY\n"
            + "Format: convert /toFOR AMOUNT_IN_SGD\n"
            + "Example: convert /toSGD 500\n"
            + "Example: convert /toFOR 500";

    private final CurrencyType currencyChoice;
    private final Float currencyAmount;

    public CalculateCurrencyCommand(String userInput) throws TrippieInvalidArgumentException {
        try {
            this.currencyChoice = extractCurrencyChoice(userInput);
            this.currencyAmount = extractCurrencyAmount(userInput);
        } catch (TrippieInvalidArgumentException e) {
            throw new TrippieInvalidArgumentException(FORMAT_ERROR_MESSAGE);
        }
    }

    public CurrencyType extractCurrencyChoice(String userInput) throws TrippieInvalidArgumentException {
        try {
            String withoutCommand = userInput.split(" /to")[1];
            String currencyChoice = withoutCommand.split(" ")[0];
            CurrencyType currencyType;
            if (currencyChoice.equals("SGD")) {
                currencyType = CurrencyType.LOCAL;
            } else if (currencyChoice.equals("FOR")) {
                currencyType = CurrencyType.FOREIGN;
            } else {
                throw new TrippieInvalidArgumentException(FORMAT_ERROR_MESSAGE);
            }
            return currencyType;
        } catch (IndexOutOfBoundsException e) {
            throw new TrippieInvalidArgumentException(FORMAT_ERROR_MESSAGE);
        }
    }

    public Float extractCurrencyAmount(String userInput) {
        String withoutChoice = userInput.split(" ")[2];
        return Float.parseFloat(withoutChoice);
    }

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public void execute(Ui ui, TrippieData trippieData) {
        float exchangeRate = trippieData.getCurrentTrip().getExpenseListObject().getForExValue();
        String currencyAbbreviation = trippieData.getCurrentTrip().getExpenseListObject().getCurrencyAbbreviation();
        Currency currencyEntry = new Currency(currencyChoice, currencyAmount);
        float initialInputAmount = currencyEntry.getCurrencyAmount();
        float finalOutputAmount;
        String finalOutputAbbreviation;
        System.out.println("Processing... Please Wait.");
        if (currencyEntry.getCurrencyChoice().equals("local")) {
            finalOutputAmount = initialInputAmount / exchangeRate;
            finalOutputAbbreviation = "SGD";
        } else {
            finalOutputAmount = initialInputAmount * exchangeRate;
            finalOutputAbbreviation = currencyAbbreviation;
        }
        System.out.println("That amount in your " + currencyEntry.getCurrencyChoice()
                + " currency is " + String.format("%.2f ", finalOutputAmount)
                + finalOutputAbbreviation + ".");
    }
}
