package com.example;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
public class Enabled30Test {
    @Inject
    MyBean myBean;

    @Test
    public void test() {
        assertEquals("hello", myBean.hello());
    }

    @Test
    public void alwaysExecute() {
        assertEquals("hello", myBean.hello());
    }

    @Test
    public void neverExecute() {
        assertEquals("hello", myBean.hello());
    }
}
