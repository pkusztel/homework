package com.silenteight.homework.v1;

import com.silenteight.homework.v1.intefaces.IGender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.Iterator;

@RequestScope
@Component
public class GenderRepository implements IGender<String> {

    private Iterator<String> males;
    private Iterator<String> females;

    @Autowired
    @Qualifier("maleFileIterator")
    public void setMales(Iterator<String> males) {
        this.males = males;
    }

    @Autowired
    @Qualifier("femaleFileIterator")
    public void setFemales(Iterator<String> females) {
        this.females = females;
    }

    @Override
    public Boolean isMale(String value) {
        return checkForValue(value, this.males);
    }

    @Override
    public Boolean isFemale(String value) {
        return checkForValue(value, this.females);
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
