package com.silenteight.homework.gender;

import com.silenteight.homework.gender.intefaces.IGender;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

import java.util.Iterator;

@Component
public class GenderRepository implements IGender<String> {

    @Lookup(value = "femaleFileIterator")
    public Iterator<String> getFemales() {
        return null;
    }

    @Lookup(value = "maleFileIterator")
    public Iterator<String> getMales() {
        return null;
    }

    @Override
    public Boolean isMale(String value) {
        return checkForValue(value, this.getMales());
    }

    @Override
    public Boolean isFemale(String value) {
        return checkForValue(value, this.getFemales());
    }

    private Boolean checkForValue(String value, Iterator<String> fileIterator) {
        value = value.toUpperCase();
        while(fileIterator.hasNext()) {
            if(fileIterator.next().contentEquals(value)) {
                return true;
            }
        }
        return false;
    }
}
