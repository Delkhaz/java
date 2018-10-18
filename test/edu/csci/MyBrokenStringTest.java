package edu.csci;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyBrokenStringTest {

    private MyBrokenStringInterface myBrokenString;

    @BeforeEach
    void setUp() {
        myBrokenString = new MyBrokenString();
    }

    @AfterEach
    void tearDown() {
        myBrokenString = null;
    }


    @Test
    public void testGetEvenCharacters1() {
        myBrokenString.setBrokenString("Returns just the even items from a string.");
        assertEquals("eun utteee tm rmasrn.", myBrokenString.getEvenCharacters().toString());
    }

    @Test
    public void testGetEvenCharacters2() {
        assertThrows(NullPointerException.class,
                () -> {
                    myBrokenString.getEvenCharacters().toString();
                });
    }

    @Test
    public void testGetOddCharacters1() {
        myBrokenString.setBrokenString("Returns just the odd items from a string.");
        assertEquals("Rtrsjs h d tm rmasrn.", myBrokenString.getOddCharacters().toString());
    }

    @Test
    public void testGetOddCharacters2() {
        assertThrows(NullPointerException.class,
                () -> {
                    myBrokenString.getOddCharacters().toString();
                });
    }
    @Test
    public void testGetOddCharacters23() {
        assertThrows(NullPointerException.class,
                () -> {
                    myBrokenString.sortedAscendingString().toString();
                });
    }
    @Test
    public void testCountDigits1() {
        myBrokenString.setBrokenString("Returns total count of 1nd1v1dual d1g1ts 1n a Str1ng.");
        assertEquals(7, myBrokenString.countDigits());
    }

    @Test
    public void testCountDigits2() {
        assertThrows(NullPointerException.class,
                ()->{
                    myBrokenString.countDigits();
                });
    }

    @Test
    public void testNumbersDroppedString() {
        myBrokenString.setBrokenString("R3mov3s d1g1ts from Str1ng.");
        assertEquals("Rmovs dgts from Strng.", myBrokenString.numbersDroppedString().toString());
    }

    @Test
    public void testCommasDroppedString() {
        myBrokenString.setBrokenString("Removes, ,commas, ,from, S,t,r,i,n,g,.");
        assertEquals("Removes commas from String.", myBrokenString.commasDroppedString().toString());
    }

    @Test
    public void testSpacesDroppedString() {
        myBrokenString.setBrokenString("R e m o v e s spaces f r o m S t r i n g.");
        assertEquals("RemovesspacesfromString.", myBrokenString.spacesDroppedString().toString());
    }

    @Test
    public void testSortedAscendingString() {
        myBrokenString.setBrokenString("abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        assertEquals("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz", myBrokenString.sortedAscendingString());
    }

    @Test
    public void testSortedDescendingString() {
        myBrokenString.setBrokenString("abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        assertEquals("zyxwvutsrqponmlkjihgfedcbaZYXWVUTSRQPONMLKJIHGFEDCBA9876543210", myBrokenString.sortedDescendingString());
    }

    @Test
    public void testGetReverseString() {
        myBrokenString.setBrokenString("sator arepo tenet opera rotas");
        assertEquals("sator arepo tenet opera rotas", myBrokenString.getReverseString());
    }

    @Test
    public void testGetReverseString2() {
        myBrokenString.setBrokenString("Reverses a String, I LOVE CODING");
        assertEquals("GNIDOC EVOL I ,gnirtS a sesreveR", myBrokenString.getReverseString());
    }
}