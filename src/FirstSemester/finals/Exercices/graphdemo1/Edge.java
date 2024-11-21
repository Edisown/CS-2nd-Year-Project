/**
 *  MALASAN, Edison M.
 *  CS211 B/LAB - 10:30 AM - 12:00 PM
 *
 */
package graphdemo1;

/**
 * Reference class Edge
 *
 */
public class Edge {
    private Node start;
    private Node end;
    private double weight;
    public int id;

    /**
     * Method for getting id that points to the variable id
     * @return
     */
    public int getId() {
        return this.id;
    }

    /**
     * Method for getting start node that points to the variable start
     * @return
     */
    public Node getStart() {
        return this.start;
    }

    /**
     * Method for getting the id of start node
     * @return
     */
    public int getIdOfStartNode() {
        return this.start.getNodeId();
    }

    /**
     * Method for getting end node that points to the variable end
     * @return
     */
    public Node getEnd() {
        return this.end;
    }

    /**
     * Method for getting the id of end node
     * @return
     */
    public int getIdOfEndNode() {
        return this.end.getNodeId();
    }

    /**
     * Method for getting the weight that points to the variable weight
     * @return
     */
    public double getWeight() {
        return this.weight;
    }

    public Edge(Node s, Node e, double w, int id) {
        this.start = s;
        this.end = e;
        this.weight = w;
        this.id = id;
    }

    @Override
    public String toString() {
        return ("("+start+"+"+end+")");
    }
}
