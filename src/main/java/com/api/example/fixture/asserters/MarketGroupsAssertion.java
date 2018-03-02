package com.api.example.fixture.asserters;

import com.api.example.fixture.asserters.models.ExpectedLocalizedDescription;
import com.api.example.fixture.asserters.models.ExpectedMarketGroup;
import com.api.example.fixture.invoke.response.marketgroups.MarketGroupsResponse;
import org.assertj.core.api.Assertions;

import java.util.List;

import static org.assertj.core.api.Assertions.tuple;
import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Created by daniel on 26/11/2016.
 * assertion wrapper for market groups response object, provides reusable assertions to all tests
 */
public class MarketGroupsAssertion implements IAssertion {

    private final MarketGroupsResponse marketGroupsResponse;

    public MarketGroupsAssertion(MarketGroupsResponse marketGroupsResponse) {
        this.marketGroupsResponse = marketGroupsResponse;
    }

    public MarketGroupsAssertion theseMarketGroupsWereReturned(List<ExpectedMarketGroup> expectedMarketGroups) {
        for (ExpectedMarketGroup expectedMarketGroup : expectedMarketGroups) {
            assertThat(marketGroupsResponse.getMarketGroups())
                    .extracting(
                            "code",
                            "type",
                            "status")
                    .contains(tuple(
                            expectedMarketGroup.getCode(),
                            expectedMarketGroup.getType(),
                            expectedMarketGroup.getStatus()));
        }
        return this;
    }

    public MarketGroupsAssertion thisMarketGroupHasTheseLocalizedDescriptions(String marketGroupToCheck, List<ExpectedLocalizedDescription> expectedLocalizedDescriptions) {
        for (ExpectedLocalizedDescription expectedLocalizedDescription : expectedLocalizedDescriptions) {
            Assertions.assertThat(marketGroupsResponse.getMarketGroups())
                    .filteredOn("code", marketGroupToCheck).flatExtracting("localizedDescriptions")
                    .extracting("description", "locale")
                    .contains(tuple(
                            expectedLocalizedDescription.getDescription(),
                            expectedLocalizedDescription.getLocale()));
        }
        return this;
    }
}
