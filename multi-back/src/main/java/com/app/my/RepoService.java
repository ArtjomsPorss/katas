package com.app.my;

import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class RepoService {
    private HashMap<Long, Person> inMemoryDb = new HashMap<Long, Person>();

    public Person add() {
        int nextId = inMemoryDb.size() + 1;
        return inMemoryDb.put((long) nextId, new Person((long) nextId));
    }

    public Person get(Long id) {
        return inMemoryDb.get(id);
    }
}
