package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MoneyTest {

    private Currency SEK, EUR;

    private Money SEK100, EUR10;
    private Money SEK200;
    private Money SEK0, EUR0, SEKn100;

    @Before
    public void setUp() {

        SEK = new Currency("SEK", 0.15);
        EUR = new Currency("EUR", 1.5);

        SEK100 = new Money(10000, SEK);
        EUR10 = new Money(1000, EUR);

        SEK200 = new Money(20000, SEK);

        SEK0 = new Money(0, SEK);
        EUR0 = new Money(0, EUR);

        SEKn100 = new Money(-10000, SEK);
    }

    @Test
    public void testGetAmount() {

        assertEquals(Integer.valueOf(10000),
                     SEK100.getAmount());
    }

    @Test
    public void testGetCurrency() {

        assertSame(SEK,
                   SEK100.getCurrency());
    }

    @Test
    public void testToString() {

        assertEquals("100.0 SEK",
                     SEK100.toString());
    }

    @Test
    public void testUniversalValue() {

        assertEquals(Integer.valueOf(1500),
                     SEK100.universalValue());
    }

    @Test
    public void testEqualsMoney() {

        assertTrue(SEK100.equals(EUR10));
    }

    @Test
    public void testAdd() {

        Money result = SEK100.add(EUR10);

        assertEquals(Integer.valueOf(20000),
                     result.getAmount());
    }

    @Test
    public void testSub() {

        Money result = SEK200.sub(EUR10);

        assertEquals(Integer.valueOf(10000),
                     result.getAmount());
    }

    @Test
    public void testIsZero() {

        assertTrue(SEK0.isZero());
        assertTrue(EUR0.isZero());

        assertFalse(SEK100.isZero());
    }

    @Test
    public void testNegate() {

        Money result = SEK100.negate();

        assertEquals(Integer.valueOf(-10000),
                     result.getAmount());
    }

    @Test
    public void testCompareTo() {

        assertEquals(0,
                     SEK100.compareTo(EUR10));

        assertTrue(SEK200.compareTo(SEK100) > 0);

        assertTrue(SEKn100.compareTo(SEK100) < 0);
    }
}