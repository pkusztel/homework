package com.silenteight.homework.v1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GenderRepositoryTest {

    GenderRepository repo;

    @BeforeEach
    void setUp() {
        ArrayList<String> males = new ArrayList<>(Arrays.asList("MARCIN", "MICHAŁ"));
        ArrayList<String> females = new ArrayList<>(Arrays.asList("JULIA", "KATARZYNA"));

        GenderRepository repo = new GenderRepository();
        repo.setFemales(females.iterator());
        repo.setMales(males.iterator());

        this.repo = repo;
    }

    @Test
    void isMale() {
        boolean isMale = this.repo.isMale("MARCIN");
        assertTrue(isMale);
    }

    @Test
    void isFemale() {
        boolean isFemale = this.repo.isFemale("JULIA");
        assertTrue(isFemale);
    }
}