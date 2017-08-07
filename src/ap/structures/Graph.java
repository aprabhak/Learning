package ap.structures;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Graph {
    public HashMap<Integer,GraphNode> nodeLookup = new HashMap<Integer,GraphNode>();

    public void addNode(int id) {
        GraphNode n = new GraphNode(id);
        nodeLookup.put(id,n);
    }

    public GraphNode getNode(int id) {
        GraphNode n = nodeLookup.get(id);
        return n;
    }

    public void addEdge(int source, int destination) {
        GraphNode s = getNode(source);
        GraphNode d = getNode(destination);
        s.adjacent.add(d);
    }

    public boolean hasPathDFS(int source, int destination) {
        GraphNode s = getNode(source);
        GraphNode d = getNode(destination);
        HashSet<Integer> visited = new HashSet<Integer>();
        return hasPathDFS(s,d,visited);
    }

    public boolean hasPathDFS(GraphNode source, GraphNode destination, HashSet<Integer> visited) {
        if (visited.contains(source.id)) {
            return false;
        }
        visited.add(source.id);
        if (source.equals(destination)) {
            return true;
        }
        for (GraphNode child : source.adjacent) {
            if (hasPathDFS(child,destination,visited)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasPathBFS(int source1, int destination1) {
        GraphNode source = getNode(source1);
        GraphNode destination = getNode(destination1);
        LinkedList<GraphNode> nextToVisit = new LinkedList<GraphNode>();
        HashSet<Integer> visited = new HashSet<Integer>();
        nextToVisit.add(source);
        while (!nextToVisit.isEmpty()) {
            GraphNode node = nextToVisit.remove();
            System.out.println(node.id);
            if (node.equals(destination)) {
                return true;
            }
            if (visited.contains(node.id)) {
                continue;
            }
            visited.add(node.id);
            for (GraphNode child : node.adjacent) {
                nextToVisit.add(child);
            }
        }
        return false;
    }
}
