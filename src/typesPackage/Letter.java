package typesPackage;

public class Letter {
    private final char value;

    public Letter(char value) {
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
        Letter letter = (Letter) o;
        return value == letter.value;
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