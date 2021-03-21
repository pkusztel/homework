package com.silenteight.homework.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class GenderService {
    private final String MALE = "Male";
    private final String FEMALE = "Female";
    private final String INCONCLUSIVE = "Inconclusive";

    private final String TOKEN = " ";
    private final int FIRST = 0;

    @Autowired
    GenderRepository repo;

    public String decideGender(String name) {
        name = name.split(TOKEN)[FIRST];

        if(repo.isFemale(name)) {
            return FEMALE;
        }
        else if(repo.isMale(name)) {
            return MALE;
        }
        else {
            return INCONCLUSIVE;
        }
    }
}
