package com.api.example.fixture.helpers;

import org.apache.commons.lang.WordUtils;

/**
 * Created by dwebb on 11/11/2016.
 */
public class CaseConverter {

    public CaseConverter() {
    }

    public String Convert(String toConvert, String caseFormat) {
        switch (caseFormat.toLowerCase()) {
            case "camel":
                return ToCamel(toConvert);
            case "mixed":
                return ToMixed(toConvert);
            case "upper":
                return ToUpper(toConvert);
            case "lower":
                return ToLower(toConvert);
        }

        return toConvert;
    }

    public String ToCamel(String toConvert) {
        return WordUtils.capitalizeFully(toConvert);
    }

    public String ToUpper(String toConvert) {
        return toConvert.toUpperCase();
    }

    public String ToLower(String toConvert) {
        return toConvert.toLowerCase();
    }

    public String ToMixed(String toConvert) {
        return WordUtils.capitalizeFully(toConvert);
    }

}
