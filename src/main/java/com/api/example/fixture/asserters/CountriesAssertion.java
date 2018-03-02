package com.api.example.fixture.asserters;

import com.api.example.fixture.asserters.models.ExpectedCountry;
import com.api.example.fixture.asserters.models.ExpectedLocalizedName;
import com.api.example.fixture.invoke.response.countries.CountriesResponse;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

/**
 * Created by daniel on 26/11/2016.
 * assertion wrapper for countries response object, provides reusable assertions to all tests
 */
public class CountriesAssertion implements IAssertion {

    private final CountriesResponse countriesResponse;

    public CountriesAssertion(CountriesResponse countriesResponse) {
        this.countriesResponse = countriesResponse;
    }

    public CountriesAssertion thisCountryHasTheseLocalizedNames(String countryToCheck, List<ExpectedLocalizedName> expectedLocalizedNames) {
        for (ExpectedLocalizedName expectedLocalizedName : expectedLocalizedNames) {
            assertThat(countriesResponse.getCountries()).filteredOn("code", countryToCheck).flatExtracting("localizedNames")
                    .extracting("name", "locale")
                    .contains(tuple(
                            expectedLocalizedName.getName(),
                            expectedLocalizedName.getLocale()));
        }
        return this;
    }

    public CountriesAssertion allCountriesAreIdentifiedAsBeingActiveOrInactive() {
        assertThat(countriesResponse.getCountries()).extracting("isActive").hasOnlyElementsOfType(Boolean.class);
        return this;
    }

    public CountriesAssertion thereWereCountriesReturned() {
        assertThat(countriesResponse.getCountries()).size().isGreaterThan(0);
        return this;
    }

    public CountriesAssertion theseCountriesWereAllReturned(List<String> expectedCountries) {
        String[] expectedCountriesArray = expectedCountries.toArray(new String[0]);
        assertThat(countriesResponse.getCountries())
                .extracting("code")
                .containsExactlyInAnyOrder(expectedCountriesArray);
        return this;
    }

    public CountriesAssertion theseCountriesWereReturned(List<ExpectedCountry> expectedCountries) {
        for (ExpectedCountry expectedCountry : expectedCountries) {
            //TODO more work here to check other contents from the expected object
            assertThat(countriesResponse.getCountries())
                    .extracting("code", "isActive")
                    .contains(tuple(
                            expectedCountry.getCountryCode(),
                            expectedCountry.isActive()));
        }
        return this;
    }

    public CountriesAssertion theseCountriesWereNotReturned(List<String> inactiveCountriesInTheExampleDatabase) {
        assertThat(countriesResponse.getCountries())
                .extracting("code")
                .doesNotContain(inactiveCountriesInTheExampleDatabase);
        return this;
    }
}
