/**
 *  MALASAN, Edison M.
 *  CS211 B/LAB - 10:30 AM - 12:00 PM
 *
 */
package graphdemo1;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private int id;
    private List<Edge> neighbours = new ArrayList<Edge>();

    public int getNodeId(){
        return this.id;
    }

    /**
     *  This method is used to add neighbours to the Edge
     * @param e
     */
    public void addNeighbours(Edge e){
        if (this.neighbours.contains(e)) {
            System.out.println("This edge has already been used for this node.");
        } else {
            System.out.println("Successfully added " + e);
            this.neighbours.add(e);
        }
    }

    /**
     * This method getNeighbours is simply display the list of all edges of a certain id has
     * by looping to the neighbours size
     */
    public void getNeighbours() {
        System.out.println("List of all edges that node " + this.id + "has: ");
        System.out.println("================================================");

        for (int i = 0; i < this.neighbours.size(); i++) {
            System.out.println("ID of Edge: " + neighbours.get(i).getId() + "\nID of the first node: " +
                    neighbours.get(i).getIdOfStartNode() +
                    "\nID of the second node: " + neighbours.get(i).getIdOfEndNode());
            System.out.println();
        }
        System.out.println(neighbours);
    }

    public Node(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return ""+id;
    }
}
