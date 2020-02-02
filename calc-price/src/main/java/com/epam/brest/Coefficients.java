package com.epam.brest;

import java.util.*;

public class Coefficients {

    private Map<Double, Double> parameters = new TreeMap<>();

    public Coefficients(List<String> stringParameters) {

        for (String stringParameter : stringParameters) {
            String[] strings = stringParameter.split(" ");

            parameters.put(Double.parseDouble(strings[0]), Double.parseDouble(strings[1]));
        }
    }

    public Double getCoefficientByValue(Double value) {

        Double maxKey = Collections.max(parameters.entrySet(), Map.Entry.comparingByKey()).getKey();
        Double minKey = Collections.min(parameters.entrySet(), Map.Entry.comparingByKey()).getKey();

        if (parameters.containsKey(value)) {
            return parameters.get(value);
        }
        else if (value > maxKey) {
            return parameters.get(maxKey);
        }
        else if (value < minKey) {
            return 1.0;
        }
        else {
            Double coefficient = 1.0;
            for(Map.Entry entry: parameters.entrySet()) {
                if((Double)entry.getKey() < value){
                    coefficient = (Double) entry.getValue();
                }
            }

            return coefficient;
        }
    }
}
