package search;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.function.Predicate;

public class BreadthFirstSearch {

    public <K, V> V search(Map<K, List<V>> graph, V startPoint, Predicate<V> predicate) {
        List<V> root = graph.get(startPoint);

        if (root == null || root.isEmpty()) {
            return null;
        }

        Queue<V> queue = new ArrayDeque<>(root);
        Map<V, V> searched = new HashMap<>();
        V currentValue;

        while ((currentValue = queue.poll()) != null) {
            boolean elementAlreadySearched = searched.get(currentValue) != null;
            if (elementAlreadySearched) {
                continue;
            }
            searched.put(currentValue, currentValue);

            if (predicate.test(currentValue)) {
                return currentValue;
            }

            List<V> next = graph.get(currentValue);

            if (next == null || next.isEmpty()) {
                continue;
            }

            for (V e : next) {
                queue.offer(e);
            }
        }

        return null;
    }
}
