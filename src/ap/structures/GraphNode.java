package ap.structures;

import java.util.LinkedList;

public class GraphNode {
    int id;
    LinkedList<GraphNode> adjacent = new LinkedList<GraphNode>();
    public GraphNode(int id) {
        this.id = id;
    }
}
