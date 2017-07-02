package com.codeclan.example.fruitmachine;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 02/07/2017.
 */

public class TextUtilsTest {
    @Test
    public void testParseStringToArrayThreeNumbers() throws Exception {
        String input = "1 2 3";
        int result[] = TextUtils.parseStringToIntArray(input);
        assertEquals(0, result[0]);
        assertEquals(1, result[1]);
        assertEquals(2, result[2]);
    }

    @Test
    public void testParseStringToArrayOneNumber() throws Exception {
        String input = "1";
        int result[] = TextUtils.parseStringToIntArray(input);
        assertEquals(0, result[0]);
    }

    @Test
    public void testStars() throws Exception {
        String stars = TextUtils.getStars(10);
        assertEquals("**********", stars);
    }
}
