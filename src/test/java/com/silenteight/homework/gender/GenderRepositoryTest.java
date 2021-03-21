package com.silenteight.homework.gender;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GenderRepositoryTest {

    GenderRepository repo;

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