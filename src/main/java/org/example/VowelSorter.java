package org.example;
import java.util.ArrayList;
import java.util.Comparator;

public class VowelSorter {
    static char[] vowels;

    public static StringBuffer sortWordsByVowels(StringBuffer text, char[] vowels) {
        VowelSorter.vowels = vowels;
        try {
            // Розбиваю текст на слова
            ArrayList<StringBuffer> words = splitTextIntoWords(text);

            // Сортую слова за кількістю голосних літер
            words.sort(Comparator.comparingInt(VowelSorter::countVowels));

            // Формую відсортований текст
            StringBuffer sortedText = new StringBuffer();
            for (StringBuffer word : words)
                sortedText.append(word).append(" ");

            return sortedText;

        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
            return null;
        }
    }

    // Метод для підрахунку голосних звуків у слові
    static int countVowels(StringBuffer word) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (isVowel(word.charAt(i)))
                count++;
        }
        return count;
    }

    // Метод для перевірки, чи є символ голосним звуком
    static boolean isVowel(char c) {
        for (char vowel : VowelSorter.vowels) {
            if (c == vowel)
                return true;
        }
        return false;
    }

    // Метод для розбиття тексту на слова
    static ArrayList<StringBuffer> splitTextIntoWords(StringBuffer text) {
        ArrayList<StringBuffer> words = new ArrayList<>();
        StringBuffer currentWord = new StringBuffer();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (!Character.isWhitespace(c)) { // Якщо символ - не пробіл, то додаю його до поточного слова
                currentWord.append(c);
                continue;
            }
            if (!currentWord.isEmpty()) { // Перевірка на декілька пробілів між словами
                words.add(new StringBuffer(currentWord)); // Додаю слово в список
                currentWord.setLength(0); // Очищаю буфер для наступного слова
            }
        }

        // Додаю останнє слово, якщо текст закінчується не пробілом
        if (!currentWord.isEmpty())
            words.add(currentWord);

        return words;
    }
}