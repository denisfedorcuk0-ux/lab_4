package typesPackage;

import java.util.Arrays;

/**
 * Represents a single word composed of an ordered array of Letter entities.
 */
public class Word {
    private final Letter[] letters;

    /**
     * Constructs a Word object by breaking down the string input into individual characters.
     *
     * @param wordStr the alpha-numeric or standard sequence of characters representing a word
     */
    public Word(String wordStr) {
        this.letters = new Letter[wordStr.length()];
        // Initialize the array with Letter wrapped instances
        for (int i = 0; i < wordStr.length(); i++) {
            this.letters[i] = new Letter(wordStr.charAt(i));
        }
    }

    /**
     * Compares this word to another object for deep array equality based on its letters.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Word word = (Word) o;
        return Arrays.equals(letters, word.letters);
    }

    /**
     * Generates a hash code utilizing the specific deep values of the letters array.
     */
    @Override
    public int hashCode() {
        return Arrays.hashCode(letters);
    }

    /**
     * Assembles the word back into a clean string representation.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Letter letter : letters) {
            sb.append(letter.toString());
        }
        return sb.toString();
    }
}