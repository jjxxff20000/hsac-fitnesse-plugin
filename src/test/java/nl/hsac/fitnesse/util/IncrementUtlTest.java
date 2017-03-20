package nl.hsac.fitnesse.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests IncrementUtl.
 */
public class IncrementUtlTest {
//    private final IncrementUtl util = IncrementUtl.getInstance();

    /**
     * Tests int generation.
     */
    @Test
    public void testIntGenerate() {
        for (int i = 1; i <= 1000; i++) {
        	IncrementUtl util = IncrementUtl.getInstance();
            int result = util.incrementInt();
            assertTrue("Got: " + result + "Expected: "+ i, result == i);
        }
    }

    /**
     * Tests specify the init value to incrementInt.
     */
    @Test
    public void testSetCurrent() {
        for (int i = 1; i <= 1000; i++) {
			int tmp = i;
        	IncrementUtl util = IncrementUtl.getInstance();
			util.setCurrent(--tmp);
            int result = util.incrementInt();
            assertTrue("Got: " + result + "Expected: "+ i, result == i);
        }
    }
}
