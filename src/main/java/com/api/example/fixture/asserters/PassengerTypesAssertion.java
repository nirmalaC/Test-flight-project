package com.api.example.fixture.asserters;

import com.api.example.database.example.models.PassengerTypeDbModel;
import com.api.example.fixture.asserters.models.ExpectedLocalizedName;
import com.api.example.fixture.asserters.models.ExpectedPassenger;
import com.api.example.fixture.invoke.response.passengertypes.PassengerTypesResponse;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

/**
 * Created by daniel on 26/11/2016.
 * assertion wrapper for passenger types response object, provides reusable assertions to all tests
 */
public class PassengerTypesAssertion implements IAssertion {

    private final PassengerTypesResponse passengerTypesResponse;

    public PassengerTypesAssertion(PassengerTypesResponse passengerTypesResponse) {
        this.passengerTypesResponse = passengerTypesResponse;
    }

    public PassengerTypesAssertion thePassengerTypesWereReturned(List<PassengerTypeDbModel> dbPassengers) {
        for (PassengerTypeDbModel expectedPassenger : dbPassengers) {
            assertThat(passengerTypesResponse.getPassengerTypes()).extracting(
                    "code",
                    "minAge",
                    "maxAge")
                    .contains(tuple(
                            expectedPassenger.getPassengerTypeCode(),
                            expectedPassenger.getMinAge(),
                            expectedPassenger.getMaxAge()
                    ));
        }
        return this;
    }

    public PassengerTypesAssertion thesePassengerTypesWereReturned(List<ExpectedPassenger> expectedPassengers) {
        for (ExpectedPassenger expectedPassenger : expectedPassengers) {
            assertThat(passengerTypesResponse.getPassengerTypes()).extracting(
                    "code",
                    "minAge",
                    "maxAge",
                    "maxPermitted")
                    .contains(tuple(
                            expectedPassenger.getPassengerCode(),
                            expectedPassenger.getMinAge(),
                            expectedPassenger.getMaxAge(),
                            expectedPassenger.getMaxPermitted()
                    ));
        }
        return this;
    }

    public void thisPassengerTypeHasTheseLocalizedNames(String passengerCodeToCheck, List<ExpectedLocalizedName> expectedLocalizedNames) {
        for (ExpectedLocalizedName expectedLocalizedName : expectedLocalizedNames) {
            assertThat(passengerTypesResponse.getPassengerTypes()).filteredOn("code", passengerCodeToCheck).flatExtracting("localizedNames")
                    .extracting("name", "locale")
                    .contains(tuple(
                            expectedLocalizedName.getName(),
                            expectedLocalizedName.getLocale()));
        }
    }
}
