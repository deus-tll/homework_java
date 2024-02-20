package org.deus.task_2;

import java.util.*;

public class Dictionary {
    private final Map<String, Word> dictionary;

    public Dictionary() {
        dictionary = new HashMap<>();
    }

    public void addWord(String word, List<String> translations) {
        dictionary.put(word, new Word(word, translations));
    }

    public void displayTranslations(String word) {
        Word w = dictionary.get(word);
        if (w != null) {
            System.out.println("Translations of word '" + word + "': " + w.getTranslations());
            w.incrementAccessCount();
        } else {
            System.out.println("There is no such word as '" + word + "' in dictionary.");
        }
    }

    public void editTranslations(String word, List<String> translations) {
        Word w = dictionary.get(word);
        if (w != null) {
            w.setTranslations(translations);
            w.incrementAccessCount();
        } else {
            System.out.println("There is no such word as '" + word + "' in dictionary.");
        }
    }

    public void editWord(String oldWord, String newWord, List<String> translations) {
        Word w = dictionary.remove(oldWord);
        if (w != null) {
            w = new Word(newWord, translations);
            dictionary.put(newWord, w);
            w.incrementAccessCount();
        } else {
            System.out.println("There is no such word as '" + oldWord + "' in dictionary.");
        }
    }

    public void displayTopPopularWords() {
        List<Word> sortedWords = new ArrayList<>(dictionary.values());
        sortedWords.sort(Comparator.comparingInt(Word::getAccessCount).reversed());
        System.out.println("Top 10 most popular words:");
        for (int i = 0; i < Math.min(10, sortedWords.size()); i++) {
            System.out.println(sortedWords.get(i).getWord());
        }
    }

    public void displayTopUnpopularWords() {
        List<Word> sortedWords = new ArrayList<>(dictionary.values());
        sortedWords.sort(Comparator.comparingInt(Word::getAccessCount));
        System.out.println("Top 10 most unpopular words:");
        for (int i = 0; i < Math.min(10, sortedWords.size()); i++) {
            System.out.println(sortedWords.get(i).getWord());
        }
    }
}
