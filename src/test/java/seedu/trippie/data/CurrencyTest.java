package seedu.trippie.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CurrencyTest {

    @Test
    void getCurrencyChoice_currencyChosenIsLocal_success() {
        Currency currency = new Currency(CurrencyType.LOCAL, (float) 3.02);
        assertEquals(currency.getCurrencyChoice(), "local");
    }

    @Test
    void getCurrencyChoice_currencyChosenIsForeign_success() {
        Currency currency = new Currency(CurrencyType.FOREIGN, (float) 3.02);
        assertEquals(currency.getCurrencyChoice(), "foreign");
    }


}