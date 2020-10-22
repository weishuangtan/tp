package seedu.trippie.command;

import org.junit.jupiter.api.Test;
import seedu.trippie.data.CurrencyType;
import seedu.trippie.exception.TrippieInvalidArgumentException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculateCurrencyCommandTest {

    public static final String CURRENCY_CHOICE_TO_SGD = "convert /toSGD 5";
    public static final String CURRENCY_CHOICE_TO_FOR = "convert /toFOR 5";
    public static final String CURRENCY_AMOUNT = "convert /toSGD 500";

    @Test
    void extractCurrencyChoice_currencyChoiceIsLocalEnum_Success() throws TrippieInvalidArgumentException {
        CalculateCurrencyCommand command = new CalculateCurrencyCommand(CURRENCY_CHOICE_TO_SGD);
        assertEquals(command.extractCurrencyChoice(CURRENCY_CHOICE_TO_SGD), CurrencyType.LOCAL);
    }

    @Test
        void extractCurrencyChoice_currencyChoiceIsForeignEnum_Success() throws TrippieInvalidArgumentException {
        CalculateCurrencyCommand command = new CalculateCurrencyCommand(CURRENCY_CHOICE_TO_FOR);
        assertEquals(command.extractCurrencyChoice(CURRENCY_CHOICE_TO_FOR), CurrencyType.FOREIGN);
    }

    @Test
    void extractCurrencyAmount() throws TrippieInvalidArgumentException {
        CalculateCurrencyCommand command = new CalculateCurrencyCommand(CURRENCY_AMOUNT);
        assertEquals(command.extractCurrencyAmount(CURRENCY_AMOUNT), 500);
    }
}
