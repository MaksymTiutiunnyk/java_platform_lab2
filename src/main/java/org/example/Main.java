// 23 номер в списку групи, C3 = 2, C17 = 6
package org.example;

public class Main {
    // за потреби можна замінити насупні два рядочки на відповідники з іншої мови
    private static final StringBuffer TEXT = new StringBuffer("Programming is fun and interesting");
    private static final char[] VOWELS = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};

    public static void main(String[] args) {
        System.out.println("Initial text: " + TEXT);

        StringBuffer sortedText = VowelSorter.sortWordsByVowels(TEXT, VOWELS);

        System.out.println("Sorted text: " + sortedText);
    }
}
