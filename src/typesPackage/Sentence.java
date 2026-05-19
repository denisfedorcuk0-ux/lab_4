package typesPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Represents a sentence consisting of an ordered sequence of elements (Words and Punctuation marks).
 */
public class Sentence {

    private final Object[] elements;

    /**
     * Constructs a Sentence object by parsing a raw string into structured components (Words and Punctuation).
     *
     * @param sentenceStr the raw string representing a single sentence
     */
    public Sentence(String sentenceStr) {
        List<Object> list = new ArrayList<>();
        StringBuilder wordBuilder = new StringBuilder();


        for (int i = 0; i < sentenceStr.length(); i++) {
            char ch = sentenceStr.charAt(i);


            if (Character.isLetterOrDigit(ch) || ch == '\'') {
                wordBuilder.append(ch);
            } else {

                if (wordBuilder.length() > 0) {
                    list.add(new Word(wordBuilder.toString()));
                    wordBuilder.setLength(0);
                }

                list.add(new Punctuation(ch));
            }
        }

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