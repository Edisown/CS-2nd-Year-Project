import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class FileLoader {
    /**
     * This section Loods and executes the FileLoader For the Graph Interface, AbstractGraph and The Graph application
     * @param path String set Path
     * @param type Integer for type
     * @return to the graph method
     * @throws IOException Cleans the file arrangement properly executable and applicable
     */
    public static Graph load(String path, int type) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            Graph graph = GraphConstructor.type(type);

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue; // Skip empty lines

                String[] parts = line.split(":");
                if (parts.length < 2) {
                    System.out.println("Skipping malformed line: " + line);
                    continue; // Skip lines that do not match the format
                }

                char id = parts[0].trim().charAt(0);
                Node src = new Node(id);
                String[] edges = parts[1].trim().split(",(?![^()]*\\))");

                for (String edge : edges) {
                    if (edge.trim().isEmpty())
                        continue; // Skip empty edges

                    edge = edge.trim().replaceAll("[()]", ""); // Remove all parentheses
                    String[] pair = edge.split(",");

                    try {
                        char adjId = pair[0].trim().charAt(0);
                        int weight = Integer.parseInt(pair[1].trim());
                        Node des = new Node(adjId);

                        graph.addEdge(src, des, weight);
                    } catch (NumberFormatException e) {
                        System.out.println("Error parsing edge: " + edge + " - " + e.getMessage());
                    }
                }
            }
            return graph;
        }
    }
}
