package com.api.example.fixture.asserters;

import com.api.example.fixture.asserters.models.ExpectedCurrency;
import com.api.example.fixture.invoke.response.currencies.CurrenciesResponse;
import org.assertj.core.api.Assertions;

import java.util.List;

import static org.assertj.core.api.Assertions.tuple;
import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Created by daniel on 26/11/2016.
 * assertion wrapper for currencies response object, provides reusable assertions to all tests
 */
public class CurrenciesAssertion implements IAssertion {
    private final CurrenciesResponse currenciesResponse;

    public CurrenciesAssertion(CurrenciesResponse currenciesResponse) {
        this.currenciesResponse = currenciesResponse;
    }

    public CurrenciesAssertion onlyTheseCurrenciesWereReturned(List<ExpectedCurrency> expectedCurrencies) {
        assertThat(expectedCurrencies.size()).isEqualTo(currenciesResponse.getCurrencies().size());
        for (ExpectedCurrency expectedCurrency : expectedCurrencies) {
            Assertions.assertThat(currenciesResponse.getCurrencies()).extracting(
                    "code",
                    "displaySymbol",
                    "decimalPlaces",
                    "isBaseCurrency")
                    .contains(tuple(
                            expectedCurrency.getCode(),
                            expectedCurrency.getDisplaySymbol(),
                            expectedCurrency.getDecimalPlaces(),
                            expectedCurrency.isBaseCurrency()
                    ));
        }
        return this;
    }

    public void theseCurrenciesWereNotReturned(List<ExpectedCurrency> inactiveCurrencies) {
        for (ExpectedCurrency inactiveCurrency : inactiveCurrencies) {
            assertThat(currenciesResponse.getCurrencies()).flatExtracting("code").doesNotContain(inactiveCurrency.getCode());
        }
    }
}
