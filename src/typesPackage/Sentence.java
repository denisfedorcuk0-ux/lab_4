package typesPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sentence {
    private final Object[] elements;

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

    @Override
    public int hashCode() {
        return Arrays.hashCode(elements);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Object element : elements) {
            sb.append(element.toString());
        }
        return sb.toString();
    }
}