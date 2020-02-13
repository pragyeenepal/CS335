import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


class TextCategorizeTest {
    TextCategorize tc;

    @BeforeEach
    void setUp() {
        tc = new TextCategorize("hello world");

    }

    @Test
    void categorize() {
        //before sending in a value
        boolean categorize = tc.hasCategories();
        assertFalse(categorize);
        //after sending a value
        tc.categorize();
        categorize = tc.hasCategories();
        assertTrue(categorize);
    }

    @Test
    void getCategories() {
        tc.categorize();
        ArrayList<String> cat = tc.getCategories();
        ArrayList<String> exp = new ArrayList<String>(){{add("w");add("h");}};
        assertEquals(exp, cat);
    }

    @Test
    void getWordCount() {
        tc.categorize();
        int count = tc.getWordCount();
        assertEquals(2, count);
    }

    @Test
    void getWordsFor() {
        tc.categorize();
        ArrayList<String> words = tc.getWordsFor("h");
        ArrayList<String> expect = new ArrayList<String>(){{add("hello");}};
        assertEquals(expect,words);
    }
}