package com.andersen_trainee;

import com.andersen_trainee.some_logic.MathOp;
import com.andersen_trainee.some_logic.SomeService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MathOpTest {
    private static MathOp mathOp;
    private static SomeService service;

    @BeforeClass
    public static void setUp() {
        service = mock(SomeService.class);
        mathOp = new MathOp(service);
    }

    @Test
    public void testAddMethod() {
        when(service.perform(1, 2)).thenReturn(3);
        int res = mathOp.add(1, 2);

        assertEquals(3, res);
    }

    @Ignore
    @Test
    public void testSubMethod() {
        when(service.perform(2, 2)).thenReturn(0);
        int res = mathOp.sub(2, 2);

        assertEquals(0, res);
    }

    @Test(expected = ArithmeticException.class)
    public void testDevMethod() {
        when(service.perform(2, 2)).thenReturn(1);
        int res = mathOp.dev(2, 0);

        assertEquals(1, res);
    }

    @Test(timeout = 1000)
    public void testMultMethod() {
        when(service.perform(2, 2)).thenReturn(4);
        int res = mathOp.mult(2, 2);

        assertEquals(4, res);
    }
}
