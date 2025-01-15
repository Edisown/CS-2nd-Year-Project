import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * A command-line application to interact with graph data structures.
 * This program allows users to load graphs, perform searches (DFS, BFS),
 * and find the shortest paths within a graph.
 */
public class GraphApplication {

    static Graph graph;

    /**
     * Entry point of the program.
     * Handles exceptions that may occur during the program's execution.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        GraphApplication program;
        try {
            program = new GraphApplication();
            program.run();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Runs the main logic of the program, displaying a menu and processing user input.
     *
     * @throws IOException if an error occurs while reading graph data
     */
    private void run() throws IOException {
        while (true) {
            showMenu();

            System.out.print("Choice: ");
            int choice = getIntegerInput();
            choose(choice);
        }
    }

    /**
     * Displays the main menu for the application.
     */
    private void showMenu() {
        System.out.println("\n" +
                "╔══════════════════════════════════╗\n" +
                "║           GRAPH MENU             ║\n" +
                "╠══════════════════════════════════╣\n" +
                "║ [1] Load Graph                   ║\n" +
                "║ [2] Perform Depth First Search   ║\n" +
                "║ [3] Perform Breadth First Search ║\n" +
                "║ [4] Find the Shortest Paths      ║\n" +
                "║ [5] Exit                         ║\n" +
                "╚══════════════════════════════════╝");
    }

    /**
     * Processes the user's menu choice and performs the corresponding action.
     *
     * @param choice the menu option chosen by the user
     * @throws IOException if an error occurs while loading a graph
     */
    private void choose(int choice) throws IOException {
        if (graph == null && (choice == 2 || choice == 3 || choice == 4)) {
            System.err.println("Please load the graph first!");
            return;
        }
        switch (choice) {
            case 1 -> loadGraph();
            case 2 -> searchDepthFirst(getNode());
            case 3 -> searchBreadthFirst(getNode());
            case 4 -> findShortestPath(getNode());
            case 5 -> {
                System.out.println("\nThank you for using the Graph Application!");
                System.exit(0);
            }
            default -> System.err.println("Please enter a valid choice...");
        }
    }

    /**
     * Loads a graph from a file and initializes it based on user input.
     *
     * @throws IOException if an error occurs while reading the graph file
     */
    private void loadGraph() throws IOException {
        String graphFile = getGraph(chooseGraph());
        int type = getType();
        graph = FileLoader.load(graphFile, type);
        System.out.println("\n✔ Graph loaded successfully!");
    }

    /**
     * Displays a menu for selecting a graph file to load.
     *
     * @return the user's graph selection
     */
    private int chooseGraph() {
        while (true) {
            System.out.println("\n╔══════════════════════════════════╗");
            System.out.println("║      Select a Graph to Load      ║");
            System.out.println("╠══════════════════════════════════╣");
            System.out.println("║ [1] Graph 1                      ║");
            System.out.println("║ [2] Graph 2                      ║");
            System.out.println("║ [3] Graph 3                      ║");
            System.out.println("║ [4] Graph 4                      ║");
            System.out.println("║ [5] Graph 5                      ║");
            System.out.println("╚══════════════════════════════════╝");
            System.out.print("Choice: ");

            int graphChoice = getIntegerInput();
            if (graphChoice >= 1 && graphChoice <= 5) {
                return graphChoice;
            } else {
                System.err.println("Invalid choice. Please choose a number between 1-5 only");
            }
        }
    }

    /**
     * Performs a depth-first search starting from the specified node.
     *
     * @param start the starting node
     */
    private void searchDepthFirst(Node start) {
        List<Node> result = graph.searchDepthFirst(start);

        System.out.println("\n╔═══════════════════════════════╗");
        System.out.println("║   Depth-First Search Result   ║");
        System.out.println("╚═══════════════════════════════╝");

        if (result.isEmpty()) {
            System.out.println("No nodes found or the graph is empty.");
        } else {
            System.out.println("Nodes visited in DFS order:");
            for (Node node : result) {
                System.out.println(" - " + node);
            }
        }
        System.out.println("═══════════════════════════════");
    }

    /**
     * Performs a breadth-first search starting from the specified node.
     *
     * @param start the starting node
     */
    private void searchBreadthFirst(Node start) {
        List<Node> result = graph.searchBreadthFirst(start);

        System.out.println("\n╔═════════════════════════════════╗");
        System.out.println("║   Breadth-First Search Result   ║");
        System.out.println("╚═════════════════════════════════╝");

        if (result.isEmpty()) {
            System.out.println("No nodes found or the graph is empty.");
        } else {
            System.out.println("Nodes visited in BFS order:");
            for (Node node : result) {
                System.out.println(" - " + node);
            }
        }
        System.out.println("═══════════════════════════════");
    }

    /**
     * Finds the shortest paths from the specified node to all other nodes in the graph.
     *
     * @param start the starting node
     */
    private void findShortestPath(Node start) {
        List<List<Node>> result = graph.findShortestPath(start);

        System.out.println("\n╔══════════════════════════════╗");
        System.out.println("║   Shortest Path(s) Result    ║");
        System.out.println("╚══════════════════════════════╝");

        if (result.isEmpty()) {
            System.out.println("No path found or the graph is disconnected.");
        } else {
            System.out.println("Shortest path(s) found:");
            for (List<Node> path : result) {
                System.out.print("Path: ");
                for (Node node : path) {
                    System.out.print(node + " ");
                }
                System.out.println();
            }
        }
        System.out.println("═══════════════════════════════");
    }

    /**
     * Prompts the user for an integer input and validates it.
     *
     * @return the integer input from the user
     */
    private int getIntegerInput() {
        boolean isValid = false;
        int input = 0;
        Scanner scan = new Scanner(System.in);
        while (!isValid) {
            try {
                input = Integer.parseInt(scan.nextLine());
                isValid = true;
            } catch (NumberFormatException e) {
                System.err.println("Invalid input: " + e.getMessage());
            }
        }
        return input;
    }

    /**
     * Prompts the user to select a starting node from the graph.
     *
     * @return the selected starting node
     */
    private Node getNode() {
        Node node;
        List<Node> nodes = graph.getNodes();

        System.out.println("\n╔════════════════════════╗");
        System.out.println("║ Choose starting node   ║");
        System.out.println("╚════════════════════════╝");
        int i = 1;
        for (Node current : nodes) {
            System.out.println("[" + i + "] " + current.getId());
            i++;
        }

        System.out.print("Choice: ");
        int choice = getIntegerInput();

        while (choice < 1 || choice > nodes.size()) {
            System.out.print("Please enter a valid choice (1-" + nodes.size() + "): ");
            choice = getIntegerInput();
        }
        node = nodes.get(choice - 1);

        return node;
    }

    /**
     * Maps the user's graph selection to a file path.
     *
     * @param graph the graph number selected by the user
     * @return the file path of the selected graph
     */
    private String getGraph(int graph) {
        switch (graph) {
            case 1 -> {
                return "src/graphs/graph1";
            }
            case 2 -> {
                return "src/graphs/graph2";
            }
            case 3 -> {
                return "src/graphs/graph3";
            }
            case 4 -> {
                return "src/graphs/graph4";
            }
            case 5 -> {
                return "src/graphs/graph5";
            }
            default -> {
                System.err.println("Invalid graph selection.");
                return null;
            }
        }
    }

    /**
     * Displays a menu for selecting the graph type (undirected or directed).
     */
    private void showTypes
