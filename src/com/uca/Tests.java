package com.uca;

import org.junit.jupiter.api.Test;
import java.util.concurrent.Callable;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Tests {
	
	@Test
	public void testConverter(){
		assertThat(RomanConverter.getRomanFromNumber(4), equalTo("IV"));
		assertThat(exceptionOf(() -> RomanConverter.getRomanFromNumber(-2)), instanceOf(IllegalArgumentException.class));
	}
	
	//TODO : les autres tests
	@Test
    public void testRomanToValue(){
        assertThat("Erreur Invalid Number from Roman", RomanConverter.getNumberFromRoman("IV"), equalTo(4));
        assertThat("Erreur Invalid Number from Roman", RomanConverter.getNumberFromRoman("V"), equalTo(5));
        assertThat("Erreur Invalid Number from Roman", RomanConverter.getNumberFromRoman("III"), equalTo(3));
        assertThat("Erreur Invalid Number from Roman", RomanConverter.getNumberFromRoman("XLI"), equalTo(41));
        assertThat("Erreur Invalid Number from Roman", RomanConverter.getNumberFromRoman("LIII"), equalTo(53));
        assertThat("Erreur Invalid Number from Roman", RomanConverter.getNumberFromRoman("MMMCMXCIX"), equalTo(3999));
    }

    @Test
    public void testValueToRoman(){
        assertThat("Erreur Invalid Roman from Roman", RomanConverter.getRomanFromNumber(4), equalTo("IV"));
        assertThat("Erreur Invalid Number from Roman", RomanConverter.getRomanFromNumber(5), equalTo("V"));
        assertThat("Erreur Invalid Number from Roman", RomanConverter.getRomanFromNumber(3), equalTo("II"));
        assertThat("Erreur Invalid Number from Roman", RomanConverter.getRomanFromNumber(41), equalTo("XLI"));
        assertThat("Erreur Invalid Number from Roman", RomanConverter.getRomanFromNumber(53), equalTo("LIII"));
        assertThat("Erreur Invalid Number from Roman", RomanConverter.getRomanFromNumber(3999), equalTo("MMMCMXCIX"));
    }


    //Help you to handle exception. :-)
    public static Throwable exceptionOf(Callable<?> callable) {
        try {
            callable.call();
            return null;
        } catch (Throwable t) {
            return t;
        }
    }
}
