package typesPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Represents a sentence consisting of an ordered sequence of elements (Words and Punctuation marks).
 */
public class Sentence {
    // Array storing Word and Punctuation objects dynamically determined during initialization
    private final Object[] elements;

    /**
     * Constructs a Sentence object by parsing a raw string into structured components (Words and Punctuation).
     *
     * @param sentenceStr the raw string representing a single sentence
     */
    public Sentence(String sentenceStr) {
        List<Object> list = new ArrayList<>();
        StringBuilder wordBuilder = new StringBuilder();

        // Parse character by character to distinguish words from punctuation/spaces
        for (int i = 0; i < sentenceStr.length(); i++) {
            char ch = sentenceStr.charAt(i);

            // Treat letters, digits, and apostrophes as parts of a word
            if (Character.isLetterOrDigit(ch) || ch == '\'') {
                wordBuilder.append(ch);
            } else {
                // If a word was being accumulated, finalize and add it before processing punctuation
                if (wordBuilder.length() > 0) {
                    list.add(new Word(wordBuilder.toString()));
                    wordBuilder.setLength(0);
                }
                // Add the current non-alphanumeric character as a Punctuation object
                list.add(new Punctuation(ch));
            }
        }
        // Add any remaining trailing word after the loop ends
        if (wordBuilder.length() > 0) {
            list.add(new Word(wordBuilder.toString()));
        }
        this.elements = list.toArray();
    }

    /**
     * Compares this sentence with another object for deep equality based on its elements.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Sentence sentence = (Sentence) o;
        return Arrays.equals(elements, sentence.elements);
    }

    /**
     * Generates a hash code based on the deep contents of the elements array.
     */
    @Override
    public int hashCode() {
        return Arrays.hashCode(elements);
    }

    /**
     * Reconstructs the sentence string by concatenating the string representations of all elements.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Object element : elements) {
            sb.append(element.toString());
        }
        return sb.toString();
    }
}