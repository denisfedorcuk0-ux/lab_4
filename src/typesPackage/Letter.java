package typesPackage;

/**
 * Represents a single character component (letter) of a word.
 */
public class Letter {
    private final char value;

    /**
     * Constructs a Letter object with the specified char value.
     *
     * @param value the character primitive
     */
    public Letter(char value) {
        this.value = value;
    }

    /**
     * Gets the primitive char value of this Letter.
     *
     * @return the character value
     */
    public char getValue() {
        return value;
    }

    /**
     * Compares this letter to another object for equality based on its character value.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Letter letter = (Letter) o;
        return value == letter.value;
    }

    /**
     * Generates a hash code compatible with the equals method.
     */
    @Override
    public int hashCode() {
        return Character.hashCode(value);
    }

    /**
     * Returns the string representation of the character.
     */
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}