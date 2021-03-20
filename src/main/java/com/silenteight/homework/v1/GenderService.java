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

    @Autowired
    GenderRepository repo;

    public String decideGender(String name) {
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
