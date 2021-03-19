package com.silenteight.homework.v1;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class GenderService {
    private final String MALE = "Male";
    private final String FEMALE = "Female";
    private final String INCONCLUSIVE = "Inconclusive";

    private final ArrayList<String> MALES = new ArrayList<>(Arrays.asList("JAN"));
    private final ArrayList<String> FEMALES = new ArrayList<>(Arrays.asList("MARIA"));

    public String decideGender(String name) {
        if(isFemale(name)) {
            return FEMALE;
        }
        else if(isMale(name)) {
            return MALE;
        }
        else {
            return INCONCLUSIVE;
        }
    }

    private Boolean isMale(String name) {
        return MALES.contains(name.toUpperCase());
    }

    private Boolean isFemale(String name) {
        return FEMALES.contains(name.toUpperCase());
    }
}
