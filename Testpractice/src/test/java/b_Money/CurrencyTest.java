package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CurrencyTest {

    Currency SEK, DKK, EUR;

    @Before
    public void setUp() throws Exception {

        SEK = new Currency("SEK", 0.15);
        DKK = new Currency("DKK", 0.20);
        EUR = new Currency("EUR", 1.5);
    }

    @Test
    public void testGetName() {

        assertEquals("SEK", SEK.getName());
        assertEquals("DKK", DKK.getName());
        assertEquals("EUR", EUR.getName());
    }

    @Test
    public void testGetRate() {

        assertEquals(0.15, SEK.getRate(), 0.0001);
        assertEquals(0.20, DKK.getRate(), 0.0001);
        assertEquals(1.5, EUR.getRate(), 0.0001);
    }

    @Test
    public void testSetRate() {

        SEK.setRate(0.30);

        assertEquals(0.30, SEK.getRate(), 0.0001);
    }

    @Test
    public void testGlobalValue() {

        assertEquals(Integer.valueOf(1500),
                     SEK.universalValue(10000));

        assertEquals(Integer.valueOf(3000),
                     EUR.universalValue(2000));
    }

    @Test
    public void testValueInThisCurrency() {

        Integer result =
                SEK.valueInThisCurrency(1000, EUR);

        assertEquals(Integer.valueOf(10000),
                     result);
    }
}