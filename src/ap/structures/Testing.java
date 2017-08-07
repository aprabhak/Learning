package ap.structures;

import ap.algorithms.BinarySearch;

public class Testing {
    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("leetcode");
        t.insert("leet");
        t.insert("le");
        t.printTrie();
    }
}
