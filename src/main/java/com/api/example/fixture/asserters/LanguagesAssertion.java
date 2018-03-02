package com.api.example.fixture.asserters;

import com.api.example.fixture.asserters.models.ExpectedLanguage;
import com.api.example.fixture.invoke.response.languages.LanguagesResponse;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Created by daniel on 02/12/2016.
 * assertion wrapper for languages response object, provides reusable assertions to all tests
 */
public class LanguagesAssertion implements IAssertion {


    private final LanguagesResponse languagesResponse;

    public LanguagesAssertion(LanguagesResponse languagesResponse) {
        this.languagesResponse = languagesResponse;
    }

    public void onlyTheseLanguagesWereReturned(List<ExpectedLanguage> expectedLanguages) {
        for (ExpectedLanguage expectedLanguage : expectedLanguages) {
            assertThat(languagesResponse.getLanguages())
                    .extracting(
                            "code")
                    .contains(
                            expectedLanguage.getCode().replace("_","-"));
        }
        assertThat(expectedLanguages.size()).isEqualTo(languagesResponse.getLanguages().size());
    }

    public void theseLanguagesWereNotReturned(List<ExpectedLanguage> notExpectedLanguages) {
        for (ExpectedLanguage notExpectedLanguage : notExpectedLanguages) {
            assertThat(languagesResponse.getLanguages())
                    .extracting("code")
                    .doesNotContain(notExpectedLanguage.getIsoCode());
        }
    }
}
