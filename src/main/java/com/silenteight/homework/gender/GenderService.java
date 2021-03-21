package com.silenteight.homework.gender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        String[] names = { name.split(TOKEN)[FIRST] };
        return getGender(getDecision(names));
    }

    public String decideGenderTokenized(String name) {
        String[] names = name.split(TOKEN);
        return getGender(getDecision(names));
    }

    private String getGender(int decision) {
        if (decision > 0) {
            return FEMALE;
        } else if (decision < 0) {
            return MALE;
        } else {
            return INCONCLUSIVE;
        }
    }

    private int getDecision(String[] names) {
        int decision = 0;

        for (String n : names) {
            if (repo.isFemale(n)) {
                decision++;
            } else if (repo.isMale(n)) {
                decision--;
            }
        }
        return decision;
    }
}
