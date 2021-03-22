package com.silenteight.homework.gender;

import com.silenteight.homework.gender.intefaces.IGender;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

@Component
public class GenderRepository implements IGender<String> {

    @Lookup(value = "femaleStream")
    public InputStream getFemaleStream() {
        return null;
    }

    @Lookup(value = "maleStream")
    public InputStream getMaleStream() {
        return null;
    }

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

    @Override
    public byte[] getMaleTokens() {
        return getBytes(this.getMaleStream());
    }

    @Override
    public byte[] getFemaleTokens() {
        return getBytes(this.getFemaleStream());
    }

    private byte[] getBytes(InputStream is) {
        byte[] males;
        try {
            males = IOUtils.toByteArray(is);
        } catch (IOException e) {
            throw new RuntimeException("Error while getting byte[] from a stream");
        }
        return males;
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
