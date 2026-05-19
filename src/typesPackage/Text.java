package typesPackage;

import java.util.Arrays;

public class Text {
    private final Sentence[] sentences;

    public Text(String rawText) {
        String cleanText = rawText.replaceAll("[\\s\\t]+", " ");
        String[] sentenceSplits = cleanText.split("(?<=[.!?])\\s*");
        this.sentences = new Sentence[sentenceSplits.length];
        for (int i = 0; i < sentenceSplits.length; i++) {
            this.sentences[i] = new Sentence(sentenceSplits[i]);
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
        Text text = (Text) o;
        return Arrays.equals(sentences, text.sentences);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(sentences);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sentences.length; i++) {
            sb.append(sentences[i].toString());
            if (i < sentences.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}