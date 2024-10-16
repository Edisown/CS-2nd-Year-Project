package midterms.queue;

import java.util.*;

/**
 * A typical Service system has servers and clients.
 * <p>
 * An arriving client joins the queue of clients.
 * The server serves a client following First Come First Served discipline.
 *
 * REQUIRED:
 * WRITE THE ALGORITHM BELOW
 *
 * Algorithm:
 * 1. Initialize a random number generator for client arrivals and service times.
 * 2. set the average inter-arrival time and simulation duration.
 * 3. Generate the arrival time for the first client.
 * 4. create an empty queue to hold clients.
 * 5. Instantiate the server with no assigned client.
 * 6. For each time unit from 0 to the simulation duration:
 *     I. if the current time matches the next arrival time:
 *         a. create a new client and add it to the queue.
 *         b. display the details of the client and the queue status.
 *         c. update the next arrival time.
 *     II. If the server is idle and there are clients in the queue:
 *         a. remove the first client from the queue.
 *         b. assign the client to the server and set the start service time.
 *         c. generate a random service time and calculate when the server will be free.
 *         d. display the details of the client being served and the server's status.
 *     III. if the current time matches the time when the server will finish serving:
 *         a. display the completion message for the client.
 *         b. set the server's status to idle.
 * 7. End of simulation loop.
 * </p>
 */
public class QueueSimulation {
    public static void main(String[] args) {
        QueueSimulation simulation;
        try {
            simulation = new QueueSimulation();
            simulation.run();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.exit(0);
    }

    public void run() {
        java.util.Random randomArrivalGenerator = new java.util.Random();
        java.util.Random randomServiceTimeGenerator = new java.util.Random();
        int averageInterarrival = 4;
        int simulationTimeDuration = 50; // length of simulation time
        double meanServiceTime = 5;
        // Generate random arrival of the first client
        int nextArrivalTime = randomArrivalGenerator.nextInt(averageInterarrival);
        // Create an ArrayList that will hold Queue of Clients
        Queue<Client> myListOfClients = new LinkedList<Client>();
        int clientId = 1;
        // Instantiate the server with no assigned client
        Server server = new Server();
        //Let simulation run from time =0 to a set length of time
        for (int time = 0; time <= simulationTimeDuration; time += 1) {
            // check if a client arrives
            if (time == nextArrivalTime) {
                System.out.println("Client " + clientId + " has arrived at time = " + nextArrivalTime + ".");
                // Construct a client object and add the client object to the Queue of waiting clients
                Client newClient = new Client(clientId, nextArrivalTime);
                myListOfClients.add(newClient);

                // Show the Queue of waiting clients and the number of waiting clients
                showList(myListOfClients);
                System.out.println("Number of clients in the list = " + myListOfClients.size());
                // Prepare the id of the next client that will arrive next
                clientId += 1;
                // Generate the random arrival time of the next client
                nextArrivalTime += 1 + randomArrivalGenerator.nextInt(averageInterarrival);
                System.out.println("Next client will arrive at time= " + nextArrivalTime);
            }
            // Check if the server is idle and if there is a client waiting to be served
            if (server.isIdle() && !myListOfClients.isEmpty()) {
                // Let the server start serving the first client in the Queue
                Client clientToServe = myListOfClients.remove();
                server.setClient(clientToServe);
                server.setStartServiceTime(time);
                // Generate the random length of time for the server to serve the client
                int serveTime = randomServiceTimeGenerator.nextInt((int) meanServiceTime);
                int timeForServerToBecomeFree = time + serveTime;
                server.setStopServiceTime(timeForServerToBecomeFree);
                System.out.println("At time= " + time + " Server started serving client " + clientToServe + ".");
                System.out.println("Server will be free at time = " + timeForServerToBecomeFree);
                //Show the updated Queue of waiting clients
                showList(myListOfClients);
            }
            // Check if the server is to finish serving a client
            if (time == server.getStopServiceTime() && time > 0) {
                System.out.println("At time = " + time + " Server finished serving client " + server.getClient() + ".");
                // Let the status of the server be idle
                server.setClient(null);
            }
        } // end of for
    } // end of run

    public void showList(Queue<Client> a) {
        System.out.print("Queue of Waiting Clients: ");
        for (Client c : a) {
            System.out.print(c.toString() + " ");
        }
        System.out.println();
        return;
    }
} // end of class