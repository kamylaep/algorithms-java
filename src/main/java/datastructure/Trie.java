package datastructure;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trie {

    TrieNode root = new TrieNode();

    public void add(String word) {
    }

    public void contains(String prefix) {

    }

    public List<String> find(String prefix) {
        return null;
    }

    private static class TrieNode {
        Map<Character, TrieNode> nodes = new HashMap<>();
        int size;

        void add(char c) {
            this.nodes.putIfAbsent(c, new TrieNode());
        }

        TrieNode getNode(char c) {
            return this.nodes.get(c);
        }

    }
}
