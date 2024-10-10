package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class VowelSorterTest {
    private StringBuffer text;
    private char[] vowels;

    @BeforeEach
    void setUp() {
        text = new StringBuffer("Programming is fun and interesting");
        vowels = new char[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
    }

    @Test
    void testSortWordsByVowels() {
        String expected = "is fun and Programming interesting ";

        StringBuffer sortedText = VowelSorter.sortWordsByVowels(text, vowels);

        assert sortedText != null;
        assertEquals(expected, sortedText.toString());
    }

    @Test
    void testCountVowels() {
        StringBuffer word = new StringBuffer("Programming");

        int expectedCount = 3;
        int actualCount = VowelSorter.countVowels(word);

        assertEquals(expectedCount, actualCount);
    }

    @Test
    void testIsVowel() {
        assertTrue(VowelSorter.isVowel('a'));
        assertTrue(VowelSorter.isVowel('O'));

        assertFalse(VowelSorter.isVowel('z'));
        assertFalse(VowelSorter.isVowel('X'));
    }

    @Test
    void testSplitTextIntoWords() {
        ArrayList<StringBuffer> words = VowelSorter.splitTextIntoWords(text);

        String[] expectedWords = {"Programming", "is", "fun", "and", "interesting"};
        assertEquals(expectedWords.length, words.size());

        for (int i = 0; i < expectedWords.length; i++)
            assertEquals(expectedWords[i], words.get(i).toString());
    }
}