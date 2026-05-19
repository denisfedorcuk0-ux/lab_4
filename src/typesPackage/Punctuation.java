package typesPackage;

public class Punctuation {
    private final char value;

    public Punctuation(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

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

    @Override
    public int hashCode() {
        return Character.hashCode(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}