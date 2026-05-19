
import java.util.Arrays;

public class Word {
    private final Letter[] letters;

    public Word(String wordStr) {
        this.letters = new Letter[wordStr.length()];
        for (int i = 0; i < wordStr.length(); i++) {
            this.letters[i] = new Letter(wordStr.charAt(i));
        }
    }

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

    @Override
    public int hashCode() {
        return Arrays.hashCode(letters);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Letter letter : letters) {
            sb.append(letter.toString());
        }
        return sb.toString();
    }
}