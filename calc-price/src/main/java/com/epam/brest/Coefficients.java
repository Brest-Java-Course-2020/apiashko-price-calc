package com.epam.brest;

import java.math.BigDecimal;
import java.util.*;

public class Coefficients {

    private Map<BigDecimal, BigDecimal> parameters = new TreeMap<>();

    public Coefficients(List<String> stringParameters) {

        for (String stringParameter : stringParameters) {
            String[] strings = stringParameter.split(" ");

            parameters.put(new BigDecimal(strings[0]), new BigDecimal(strings[1]));
        }
    }

    public BigDecimal getCoefficientByValue(BigDecimal value) {

        BigDecimal maxKey = Collections.max(parameters.entrySet(), Map.Entry.comparingByKey()).getKey();
        BigDecimal minKey = Collections.min(parameters.entrySet(), Map.Entry.comparingByKey()).getKey();

        if (parameters.containsKey(value)) {
            return parameters.get(value);
        }
        else if (value.compareTo(maxKey) > 0) {
            return parameters.get(maxKey);
        }
        else if (value.compareTo(minKey) < 0) {
            return new BigDecimal("1");
        }
        else {
            BigDecimal coefficient = new BigDecimal("1");
            for(Map.Entry entry: parameters.entrySet()) {
                if(value.compareTo(new BigDecimal(entry.getKey().toString())) > 0){
                    coefficient = new BigDecimal(entry.getValue().toString());
                }
            }
            return coefficient;
        }
    }
}
