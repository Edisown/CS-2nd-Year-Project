public class GraphConstructor {
    /**
     * Constructors for the Directed and The Undirected Graphs
     */
    public static final int UNDIRECTED = 1;
    public static final int DIRECTED = 2;

    /**
     * Switch case type sets for the UNDIRECTED and DIRECTED graph
     * @param type
     * @return
     */
    public static Graph type(int type){
        switch (type){
            case UNDIRECTED -> {
                return new UndirectedGraph();
            }
            case DIRECTED -> {
                return new DirectedGraph();
            }
            default -> {
                throw new IllegalArgumentException("Unknown graph type: "+ type);
            }
        }
    }
}
