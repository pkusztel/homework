package com.silenteight.homework.gender.intefaces;

public interface IGender<T> {
    Boolean isMale(T value);
    Boolean isFemale(T value);
    byte[] getMaleTokens();
    byte[] getFemaleTokens();
}
