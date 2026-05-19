package typesPackage;

/**
 * Represents a single punctuation mark or whitespace character within a sentence.
 */
public class Punctuation {
    private final char value;

    /**
     * Constructs a Punctuation object with the specified char value.
     *
     * @param value the punctuation character
     */
    public Punctuation(char value) {
        this.value = value;
    }

    /**
     * Gets the primitive char value of this punctuation mark.
     *
     * @return the character value
     */
    public char getValue() {
        return value;
    }

    /**
     * Compares this punctuation mark to another object for equality.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Punctuation that = (Punctuation) o;
        return value == that.value;
    }

    /**
     * Generates a hash code compatible with the equals method.
     */
    @Override
    public int hashCode() {
        return Character.hashCode(value);
    }

    /**
     * Returns the string representation of the punctuation mark.
     */
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}