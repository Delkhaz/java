package edu.csci;

import java.util.stream.*;
import java.lang.*;

public class MyBrokenString implements MyBrokenStringInterface {

    private String myBrokenString;

    /**
     *
     * Resets myBrokenString before each test with -> @BeforeEach
     */
    @Override
    public void setBrokenString(String inputString) {
        this.myBrokenString = inputString;
    }

    @Override
    public String getBrokenString() {
        return this.myBrokenString;
    }

    /**
     *
     * Returns just the even items from a string
     */
    @Override
    public StringBuilder getEvenCharacters() throws NullPointerException  {
        //this.myBrokenString = inputString;
        if(this.myBrokenString == null) throw new NullPointerException("No Null input");
        if(this.myBrokenString.length() + 1 < 0) throw new NullPointerException("INVALID String length");

        /*
        (params) -> expression
        (params) -> statement
        (params) -> { statements }
         */

        StringBuilder[] getEven =
                IntStream.range(0, this.myBrokenString.length())
                        .collect(
                                () -> new StringBuilder[] { new StringBuilder(), new StringBuilder() },
                                (a, i) -> a[i % 2].appendCodePoint(this.myBrokenString.charAt(i)),
                                (a1, a2) -> {
                                    a1[0].append(a2[0]);
                                    a1[1].append(a2[1]);
                                }
                        );

        return getEven[1];
    }

    /**
     *
     * Returns just the odd items from a string
     */
    @Override
    public StringBuilder getOddCharacters() throws NullPointerException  {
        if(this.myBrokenString == null) throw new NullPointerException("No Null input");
        if(this.myBrokenString.length() + 1 < 0) throw new NullPointerException("INVALID String length");

        /*
        (params) -> expression
        (params) -> statement
        (params) -> { statements }
         */

        //even and odd is determined off a % operation of the index.
        StringBuilder[] getOdd =
                IntStream.range(0, this.myBrokenString.length())
                        .collect(
                                () -> new StringBuilder[] { new StringBuilder(), new StringBuilder() },
                                (a, i) -> a[i % 2].appendCodePoint(this.myBrokenString.charAt(i)),
                                (a1, a2) -> {
                                    a1[0].append(a2[0]);
                                    a1[1].append(a2[1]);
                                }
                        );

        return getOdd[0];
    }

    /**
     *
     * Returns total count of individual digits in a String
     */
    @Override
    public int countDigits() throws NullPointerException  {
        //regex \\D = [^0-9]- replace all matching the regex and we return just [^0-9] - a non digit
        //it leaves us with a string of Only numbers so then we just get the length of that string and return it.
        if(this.myBrokenString == null) throw new NullPointerException("No Null input");
        if(this.myBrokenString.length() + 1 < 0) throw new NullPointerException("INVALID String length");

        return this.myBrokenString.replaceAll("\\D", "").length();
    }

    /**
     *
     * Removes digits from String
     */
    @Override
    public StringBuilder numbersDroppedString()  {
        if(this.myBrokenString == null) throw new NullPointerException("No Null input");
        if(this.myBrokenString.length() + 1 < 0) throw new NullPointerException("INVALID String length");

        //another regex similar to above but \\d matches any digit
        String s = this.myBrokenString.replaceAll("\\d", "");
        StringBuilder sb = new StringBuilder(s);
        return sb;
    }

    /**
     *
     * Removes commas from String
     */
    @Override
    public StringBuffer commasDroppedString()  {
        if(this.myBrokenString == null) throw new NullPointerException("No Null input");
        if(this.myBrokenString.length() + 1 < 0) throw new NullPointerException("INVALID String length");

        //regex to find the "," replace them with "" nothing, left with a string of no commas
        String s = this.myBrokenString.replaceAll("[,]", "");
        StringBuffer sb = new StringBuffer(s);
        return sb;
    }

    /**
     *
     * Removes spaces from String
     */
    @Override
    public StringBuilder spacesDroppedString() {
        if(this.myBrokenString == null) throw new NullPointerException("No Null input");
        if(this.myBrokenString.length() + 1 < 0) throw new NullPointerException("INVALID String length");

        //regex \\s matches a whitespace char, replace all whitespaces with "", left with a string of no whitespaces
        String s = this.myBrokenString.replaceAll("\\s", "");
        StringBuilder sb = new StringBuilder(s);
        return sb;
    }

    /**
     *
     * Sorts String in ascending order
     */
    @Override
    public String sortedAscendingString()  {
        if(this.myBrokenString == null) throw new NullPointerException("No Null input");
        if(this.myBrokenString.length() + 1 < 0) throw new NullPointerException("INVALID String length");

        this.myBrokenString = Stream.of(this.myBrokenString.split(""))
                .sorted() // sorted according to natural order.
                .collect(Collectors.joining()); // joining - in encounter order. essentially ascending order

        return this.myBrokenString;
    }

    /**
     *
     * Sorts String in descending order
     */
    @Override
    public String sortedDescendingString()  {
        if(this.myBrokenString == null) throw new NullPointerException("No Null input");
        if(this.myBrokenString.length() + 1 < 0) throw new NullPointerException("INVALID String length");

        //sort ascending then just reverse the string for descending
        this.myBrokenString = Stream.of(this.myBrokenString.split(""))
                .sorted()
                .collect(Collectors.joining());

        StringBuilder sb = new StringBuilder(this.myBrokenString);
        this.myBrokenString = sb.reverse().toString();

        return this.myBrokenString;
    }

    /**
     *
     * Reverses a String
     */
    @Override
    public String getReverseString()  {
        if(this.myBrokenString == null) throw new NullPointerException("No Null input");
        if(this.myBrokenString.length() + 1 < 0) throw new NullPointerException("INVALID String length");

        this.myBrokenString = Stream.of(this.myBrokenString)
                .map(word->new StringBuilder(word).reverse().toString())
                .collect(Collectors.joining());

        return this.myBrokenString;
    }
}
