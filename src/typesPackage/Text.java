package typesPackage;

import java.util.Arrays;

/**
 * Represents a complete text entity composed of an array of Sentences.
 */
public class Text {
    private final Sentence[] sentences;

    /**
     * Constructs a Text object by cleaning consecutive whitespaces/tabs
     * and splitting the raw text into distinct sentences.
     *
     * @param rawText the raw input string containing sentences and possibly uneven whitespace
     */
    public Text(String rawText) {
        // Replace all sequences of spaces and tabs with a single space character
        String cleanText = rawText.replaceAll("[\\s\\t]+", " ");

        // Split text using a lookbehind regex that finds standard sentence ending punctuation (. ! ?)
        String[] sentenceSplits = cleanText.split("(?<=[.!?])\\s*");
        this.sentences = new Sentence[sentenceSplits.length];

        // Instantiate internal Sentence object components
        for (int i = 0; i < sentenceSplits.length; i++) {
            this.sentences[i] = new Sentence(sentenceSplits[i]);
        }
    }

    /**
     * Compares this text to another object for deep equality based on its sentences.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Text text = (Text) o;
        return Arrays.equals(sentences, text.sentences);
    }

    /**
     * Generates a hash code utilizing the contents of the sentences array.
     */
    @Override
    public int hashCode() {
        return Arrays.hashCode(sentences);
    }

    /**
     * Joins all composite sentences back together separated by a single space.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sentences.length; i++) {
            sb.append(sentences[i].toString());
            // Add a separating space between sentences, but not after the last one
            if (i < sentences.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}