package com.api.example.fixture.asserters;

import com.api.example.fixture.invoke.response.passengertitles.PassengerTitle;
import com.api.example.fixture.invoke.response.passengertitles.PassengerTitlesResponse;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Created by daniel on 26/11/2016.
 * assertion wrapper for passenger titles response object, provides reusable assertions to all tests
 */
public class PassengerTitlesAssertion implements IAssertion {

    private final PassengerTitlesResponse passengerTitlesResponse;

    public PassengerTitlesAssertion(PassengerTitlesResponse passengerTitlesResponse) {
        this.passengerTitlesResponse = passengerTitlesResponse;
    }

    public PassengerTitlesAssertion theNumberOfPassengerTitlesReturnedWas(int expectedNumberOfPassengerTitles) {
        assertThat(passengerTitlesResponse.getPassengerTitles().size()).isEqualTo(expectedNumberOfPassengerTitles);
        return this;
    }

    public PassengerTitlesAssertion titlesAreAsExpected(List<String> expectedTitles) {
        String[] expectedTitlesArray = expectedTitles.toArray(new String[0]);
        assertThat(passengerTitlesResponse.getPassengerTitles()).extracting("code")
                .containsExactlyInAnyOrder(expectedTitlesArray);
        return this;
    }

    public PassengerTitlesAssertion allLocalisationDataIsPresent(List<String> expectedLocales) {
        String[] expectedLocalesArray = expectedLocales.toArray(new String[0]);
        for (PassengerTitle actualPassengerTitle : passengerTitlesResponse.getPassengerTitles()) {
            assertThat(actualPassengerTitle.getLocalizedNames()).extracting("locale").containsExactlyInAnyOrder(expectedLocalesArray);
        }
        return this;
    }

    public PassengerTitlesAssertion allLocalisationDataIsPresentForLanguage(String languageToCheck, List<String> expectedLocales) {
        String[] expectedLocalesArray = expectedLocales.toArray(new String[0]);
        for (PassengerTitle actualPassengerTitle : passengerTitlesResponse.getPassengerTitles()) {
            assertThat(actualPassengerTitle.getLocalizedNames()).filteredOn("locale", languageToCheck)
                    .extracting("locale").containsExactlyInAnyOrder(expectedLocalesArray);
        }
        return this;
    }
}
