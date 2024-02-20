package org.deus;

import org.deus.task_2.Dictionary;

import java.util.Arrays;
import java.util.List;

public class Main_Task_2 {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();

        initializeDictionary(dictionary);

        dictionary.displayTranslations("dog");
        dictionary.displayTranslations("cat");
        dictionary.displayTranslations("bird");

        dictionary.editTranslations("dog", Arrays.asList("собака", "пес"));
        dictionary.displayTranslations("dog");

        dictionary.editWord("dog", "puppy", List.of("щеня"));
        dictionary.displayTranslations("puppy");

        dictionary.displayTopPopularWords();
        dictionary.displayTopUnpopularWords();
    }

    public static void initializeDictionary(Dictionary dictionary) {
        dictionary.addWord("dog", List.of("собака"));
        dictionary.addWord("cat", List.of("кішка"));
        dictionary.addWord("bird", List.of("пташка"));
    }
}