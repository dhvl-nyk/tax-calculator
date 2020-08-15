package com.boku.dao;

import com.boku.dao.impl.InMemoryInputProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import static com.boku.util.Constants.DATABASE;
import static com.boku.util.Constants.INMEMORY;

/**
 * This is the input service which return in memory input.
 * This input can be extended to db type also
 */
@Service
public class InputService {

    @Autowired
    @Qualifier("inMemoryInputProvider")
    private IInputProvider                         inMemoryInputProvider;

    public IInputProvider getInputProvider(String inputProvider) {
        if (INMEMORY.equalsIgnoreCase(inputProvider)) {
            if (inMemoryInputProvider == null){
                inMemoryInputProvider=new InMemoryInputProvider();
            }
            return inMemoryInputProvider;
        }
        else if (DATABASE.equalsIgnoreCase(inputProvider)) {
            //this will give all database interface
        }
        return null;
    }
}
