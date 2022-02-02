package com.examplewatson.ushieru;

import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.watson.natural_language_understanding.v1.NaturalLanguageUnderstanding;
import com.ibm.watson.natural_language_understanding.v1.model.AnalysisResults;
import com.ibm.watson.natural_language_understanding.v1.model.AnalyzeOptions;
import com.ibm.watson.natural_language_understanding.v1.model.EntitiesOptions;
import com.ibm.watson.natural_language_understanding.v1.model.Features;

public class App {
    public static void main(String[] args) {
        Authenticator authenticator = new IamAuthenticator.Builder().apikey("apikey").build();
        NaturalLanguageUnderstanding service = new NaturalLanguageUnderstanding("2019-07-12", authenticator);

        EntitiesOptions entities = new EntitiesOptions.Builder()
                .sentiment(true)
                .limit(1L)
                .build();
        Features features = new Features.Builder()
                .entities(entities)
                .build();
        AnalyzeOptions parameters = new AnalyzeOptions.Builder()
                .url("www.cnn.com")
                .features(features)
                .build();

        AnalysisResults results = service.analyze(parameters).execute().getResult();
        System.out.println(results);
    }
}
