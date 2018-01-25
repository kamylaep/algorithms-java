import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Dijkstra {

    public static final String INVALID_NODE_WIGHT_ERROR_MESSAGE = "Invalid node wight!";

    public List<String> find(Map<String, Map<String, Double>> graph, String start, String end) {
        Map<String, Double> costs = initCost(graph, start);
        Map<String, String> parents = initParents(graph, start);
        Map<String, Boolean> processed = new HashMap<>();

        String curr = calculateLowestCostNode(costs, processed);

        while (curr != null) {
            Double cost = costs.get(curr);
            Map<String, Double> neighbors = graph.get(curr);

            for (Map.Entry<String, Double> entry : neighbors.entrySet()) {
                Double newCost = cost + entry.getValue();
                if (costs.get(entry.getKey()) > newCost) {
                    costs.put(entry.getKey(), newCost);
                    parents.put(entry.getKey(), curr);
                }
            }

            processed.put(curr, true);
            curr = calculateLowestCostNode(costs, processed);
        }

        return calculateFinalPath(end, parents);
    }

    private Map<String, Double> initCost(Map<String, Map<String, Double>> graph, String start) {
        HashMap<String, Double> costs = new HashMap<>(graph.get(start));
        graph.forEach((k, v) -> costs.putIfAbsent(k, Double.POSITIVE_INFINITY));
        return costs;
    }

    private Map<String, String> initParents(Map<String, Map<String, Double>> graph, String start) {
        Map<String, String> parents = new HashMap<>();
        graph.get(start).forEach((k, v) -> parents.putIfAbsent(k, start));
        return parents;
    }

    private String calculateLowestCostNode(Map<String, Double> costs, Map<String, Boolean> processed) {
        Double lowest = Double.POSITIVE_INFINITY;
        String lowestCostNode = null;

        for (Map.Entry<String, Double> entry : costs.entrySet()) {
            if (entry.getValue() < 0) {
                throw new RuntimeException(INVALID_NODE_WIGHT_ERROR_MESSAGE);
            }
            if (entry.getValue() < lowest && processed.get(entry.getKey()) == null) {
                lowest = entry.getValue();
                lowestCostNode = entry.getKey();
            }
        }
        return lowestCostNode;
    }

    private List<String> calculateFinalPath(String end, Map<String, String> parents) {
        List<String> shortestPath = new ArrayList<>();

        String temp = parents.get(end);
        while (temp != null) {
            shortestPath.add(temp);
            temp = parents.get(temp);
        }

        List<String> shortestPathReversed = new ArrayList<>();
        shortestPath.stream()
                .collect(Collectors.toCollection(java.util.LinkedList::new))
                .descendingIterator().forEachRemaining(shortestPathReversed::add);

        shortestPathReversed.add(end);
        return shortestPathReversed;
    }

}
