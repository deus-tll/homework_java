package org.deus.task_2;

import java.util.List;

public class Word {
    private final String word;
    private List<String> translations;
    private int accessCount;

    public Word(String word, List<String> translations) {
        this.word = word;
        this.translations = translations;
        this.accessCount = 0;
    }

    public String getWord() {
        return word;
    }

    public List<String> getTranslations() {
        return translations;
    }

    public int getAccessCount() {
        return accessCount;
    }

    public void incrementAccessCount() {
        accessCount++;
    }

    public void setTranslations(List<String> translations) {
        this.translations = translations;
    }
}
