package com.ievleva.util;


import org.junit.Test;

import static junit.framework.Assert.assertTrue;

public class ConverterTest {
    private  Converter converter = new Converter();

    @Test
    public void testToStringInt() throws Exception {
        assertTrue(converter.toString(-155).equals("-155"));
        assertTrue(converter.toString(155).equals("155"));
        assertTrue(converter.toString(0).equals("0"));
        assertTrue(converter.toString(100).equals("100"));
        assertTrue(converter.toString(-100).equals("-100"));
        assertTrue(converter.toString(15).equals("15"));
    }

    @Test
    public void testToInt() {
        assertTrue(converter.toInt("-123") == -123);
        assertTrue(converter.toInt("123") == 123);
        assertTrue(converter.toInt("0") == 0);
        assertTrue(converter.toInt("-0") == 0);
        assertTrue(converter.toInt("100") == 100);
        assertTrue(converter.toInt("-100") == -100);
        assertTrue(converter.toInt("-1000") == -1000);
    }

    @Test
    public void testToDouble() {
        assertTrue(converter.toDouble("123456.123456") == 123456.123456);
        assertTrue(converter.toDouble("-123456.123456") == -123456.123456);
        assertTrue(converter.toDouble("5.005") == 5.005);
        assertTrue(converter.toDouble("-5.005") == -5.005);
        assertTrue(converter.toDouble("0.0099") == 0.0099);
    }

    @Test
    public void testToStringDouble() {
        assertTrue(converter.toString(-1.501).equals("-1.501"));
        assertTrue(converter.toString(1.56).equals("1.56"));
        assertTrue(converter.toString(987.985).equals("987.985"));
        assertTrue(converter.toString(1234.1239).equals("1234.1239"));
        assertTrue(converter.toString(0.98612).equals("0.98612"));
        assertTrue(converter.toString(-0.98612).equals("-0.98612"));
        assertTrue(converter.toString(0.002).equals("0.002"));
        assertTrue(converter.toString(-0.002).equals("-0.002"));
    }
}
