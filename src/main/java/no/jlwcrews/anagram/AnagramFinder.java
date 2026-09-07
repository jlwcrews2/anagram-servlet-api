package no.jlwcrews.anagram;

import java.util.*;

public class AnagramFinder {

    public Map<String, List<String>> findAnagrams(List<String> words) {
        var anagrams = new HashMap<String, List<String>>();

        words.forEach( word -> {
            var key = alphabetizeWord(word);
            var existing = anagrams.get(key);
            if (existing == null) {
                anagrams.put(key, List.of(word));
            } else {
                var newList = new ArrayList<>(existing);
                newList.add(word);
               anagrams.put(key, newList);
            }
        });
        return anagrams;
    }

    private String alphabetizeWord(String word) {
        char [] letters = word.toCharArray();
        Arrays.sort(letters);
        return new String(letters);
    }
}
