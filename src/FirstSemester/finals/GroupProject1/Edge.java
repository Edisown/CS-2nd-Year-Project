import java.util.Objects;

/**
 * Holds the edge Class of the program.
 */
public class Edge {
    /**
     * Constructor of the edge class
      */
    private Node des;
    private int weight;

    public Edge(){
    }

    /**
     * Default constructor of the edge class
     * @param des The destination of the edge
     * @param weight the weight of the edge
     */
    public Edge(Node des, int weight) {
        this.des = des;
        this.weight = weight;

    }

    /**
     * Getter method for the Des class
     * @return
     */
    public Node getDes() {
        return des;
    }

    /**
     * setter method for the Des class
     * @param end
     */
    public void setDes(Node end) {
        this.des = des;
    }

    /**
     * Getter method for the weight class
     * @return weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * setter method for the weight class
     * @param weight
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * ToString method for the Edge weight and des class
     * @return
     */
    public String toString() {
        return "Edge{" + "des=" + des + ", weight=" + weight + '}';
    }

    /**
     * Boolean method for the Graph Class
     * @param obj null
     * @return weight of the boolean equalsTo
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Edge edge = (Edge) obj;
        return weight == edge.weight &&
                des.equals(edge.des);
    }

    /**
     * HashCode method of the class
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(des, weight);
    }
}
