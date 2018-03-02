package com.api.example.fixture.asserters;

import com.api.example.fixture.asserters.models.ExpectedAirport;
import com.api.example.fixture.asserters.models.ExpectedLocalizedName;
import com.api.example.fixture.invoke.response.getairports.Airport;
import com.api.example.fixture.invoke.response.getairports.GetAirportsResponse;
import org.assertj.core.api.Java6Assertions;

import java.util.List;

import static org.assertj.core.api.Assertions.tuple;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

/**
 * Created by daniel on 26/11/2016.
 * assertion wrapper for airports response object, provides reusable assertions to all tests
 */
public class AirportsAssertion implements IAssertion {

    private final GetAirportsResponse getAirportsResponse;

    /**
     * @param getAirportsResponse the response object from the get Airports service
     */
    public AirportsAssertion(GetAirportsResponse getAirportsResponse) {
        this.getAirportsResponse = getAirportsResponse;
    }

    /**
     * @param expectedNumberOfAirports the expected number of airports
     * @return this
     */
    public AirportsAssertion theNumberOfAirportsReturnedWas(int expectedNumberOfAirports) {
        assertThat(getAirportsResponse.getAirports().size()).isEqualTo(expectedNumberOfAirports);
        return this;
    }

    /**
     * checks that the expected airports were returned, and that the code, country, currency and checkin properties are correct
     *
     * @param expectedAirports the airports expected in the response
     * @return this
     */
    public AirportsAssertion theseAirportsWereReturnedWithTheCorrectInformation(List<ExpectedAirport> expectedAirports) {
        for (ExpectedAirport expectedAirport : expectedAirports) {
            Java6Assertions.assertThat(getAirportsResponse.getAirports()).extracting(
                    "code",
                    "country",
                    "defaultCurrency",
                    "isOnlineCheckInAvailable",
                    "isMobileCheckInAvailable")
                    .contains(tuple(
                            expectedAirport.getCode(),
                            expectedAirport.getCountry(),
                            expectedAirport.getDefaultCurrency(),
                            expectedAirport.isOnlineCheckInAvailable(),
                            expectedAirport.isMobileCheckInAvailable()));
        }
        return this;
    }

    /**
     * checks that these localized names have been returned for the airport
     *
     * @param airportToCheck         the airport that you want to check
     * @param expectedLocalizedNames the localized name expected for the airport to check
     * @return this
     */
    public AirportsAssertion theAirportHasTheseLocalizedNames(String airportToCheck, List<ExpectedLocalizedName> expectedLocalizedNames) {
        for (ExpectedLocalizedName expectedLocalizedName : expectedLocalizedNames) {
            Java6Assertions.assertThat(getAirportsResponse.getAirports()).filteredOn("code", airportToCheck)
                    .flatExtracting("localizedNames")
                    .extracting("name", "locale")
                    .contains(tuple(
                            expectedLocalizedName.getName(),
                            expectedLocalizedName.getLocale()));
        }
        return this;
    }

    /**
     * checks that these airports were not returned
     *
     * @param inactiveAirportsFromDatabase the airports that should not have been returned
     * @return this
     */
    public AirportsAssertion theseAirportsWereNotReturned(List<String> inactiveAirportsFromDatabase) {
        assertThat(getAirportsResponse.getAirports()).extracting("code")
                .doesNotContain(inactiveAirportsFromDatabase);
        return this;
    }

    /**
     * checks that the correct airports were returned
     *
     * @param expectedAirports a list of expected
     * @return this
     */
    public AirportsAssertion theseAirportsWereReturned(List<String> expectedAirports) {
        String[] expectedAirportsArray = expectedAirports.toArray(new String[0]);
        assertThat(getAirportsResponse.getAirports()).extracting("code")
                .containsExactlyInAnyOrder(expectedAirportsArray);
        return this;
    }

    /**
     * checks that all airports
     */
    public AirportsAssertion allAirportsHaveLocalizedNames() {
        for (Airport airport : getAirportsResponse.getAirports()) {
            assertThat(airport.getLocalizedNames().size()).isGreaterThan(0);
        }
        return this;
    }
}
