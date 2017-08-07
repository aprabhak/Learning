package ap.structures;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode(); //has hashmap with some initial capacity
    }

    public void insert(String word) {
        HashMap<Character,TrieNode> children = root.children;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode t;
            if (children.containsKey(c)) {
                t = children.get(c);
            } else {
                t = new TrieNode(c);
                children.put(c,t);
            }
            children = t.children;
            if (i == word.length()-1) {
                t.isLeaf = true;
            }
        }
    }

    public boolean search(String word) {
        TrieNode t = searchNode(word);
        if (t != null && t.isLeaf) {
            return true;
        } else {
            return false;
        }
    }

    public boolean startsWith(String prefix) {
        TrieNode p = searchNode(prefix);
        if (searchNode(prefix) == null) {
            return false;
        } else {
            return true;
        }
    }

    public TrieNode searchNode(String str) {
        Map<Character,TrieNode> children = root.children;
        TrieNode t = null;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (children.containsKey(c)) {
                t = children.get(c);
                children = t.children;
            } else {
                return null;
            }
        }
        return t;
    }

    public void printTrie() {
        Map<Character,TrieNode> children = root.children;
        for ( Character key : children.keySet() ) {
            System.out.println( key );
            getTrieNode(children.get(key));
        }


    }
    public void getTrieNode(TrieNode t) {
        Map<Character,TrieNode> children = t.children;
        for ( Character key : children.keySet() ) {
            System.out.println( key );
            getTrieNode(children.get(key));
        }
    }

}
