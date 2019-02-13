package ca.ualberta.cs.lonelytwitter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    @Test
    public void testAddition(){
        Calculator c = new Calculator();
        int num = c.add(5,6); // expected: 11
        assertEquals(11,num);
    }
}
