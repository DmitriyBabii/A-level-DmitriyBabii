package com.alevel.cw3;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.Scanner;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void numberSum_positive() throws Exception {
        InputOutput in = Mockito.mock(InputOutput.class);
        Mockito.when(in.getInput()).thenReturn(1234);
        int number = in.getInput();

        assertEquals(10, Main.numberSum(number));
    }

    @Test(expected = Exception.class)
    public void numberSum_negative() throws Exception {
        InputOutput in = Mockito.mock(InputOutput.class);
        Mockito.when(in.getInput()).thenReturn(-1);
        int number = in.getInput();

        Main.numberSum(number);
    }

    @Test
    public void calculate_plus() throws Exception {
        assertEquals(8.0, Main.calculate("4 + 2 + 2"), 0.0);
    }

    @Test
    public void calculate_minus() throws Exception {
        assertEquals(0.0, Main.calculate("4 - 2 - 2"), 0.0);
    }

    @Test
    public void calculate_multiplication() throws Exception {
        assertEquals(8.0, Main.calculate("2 * 2 * 2"), 0.0);
    }

    @Test
    public void calculate_division() throws Exception {
        assertEquals(1.0, Main.calculate("4 / 2 / 2"), 0.0);
    }

    @Test(expected = Exception.class)
    public void calculate_InsufficientData() throws Exception {
        Main.calculate("- 1");
    }

    @Test(expected = Exception.class)
    public void calculate_NotInt() throws Exception {
        Main.calculate("1-");
    }

    @Test(expected = Exception.class)
    public void calculate_DivideByZero() throws Exception {
        Main.calculate("1 / 0");
    }

    @Test(expected = Exception.class)
    public void calculate_NotOperator() throws Exception {
        Main.calculate("1 % 1");
    }

}