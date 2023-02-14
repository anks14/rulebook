package com.example.rulebook;

import java.util.HashMap;
import java.util.Map;

public class RuleInput {

    private Map<String, String> headers = new HashMap<>();

    public WebSeriesCharacterDetails getWebSeriesCharacterDetails() {
        return webSeriesCharacterDetails;
    }

    public void setWebSeriesCharacterDetails
            (WebSeriesCharacterDetails webSeriesCharacterDetails) {
        this.webSeriesCharacterDetails = webSeriesCharacterDetails;
    }

    private WebSeriesCharacterDetails webSeriesCharacterDetails;




    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }




}
