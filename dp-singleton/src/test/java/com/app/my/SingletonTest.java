package com.app.my;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class SingletonTest {

    @Test
    public void differentSingletonReferencesShouldPointToSameObject() {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        assertEquals(s1, s2, "!!! Something went wrong, Singleton references must point to the same object !!!");
    }

}
