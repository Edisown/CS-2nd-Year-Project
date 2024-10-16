package midterms.queue;

/**
 * Reference class for a typical client of a service system.
 * A client who arrives at a random time (arrivalTime) is assigned a number (id).
 * The client will be given service at a certain start time (startServiceTime).
 */
public class Client implements java.lang.Comparable<Client> {
    private int id; // Unique identifier for the client
    private int arrivalTime; // Time when the client arrives
    private int startServiceTime; // Time when service starts for the client

    /**
     * Constructs a client object with a given identification number and arrival time.
     *
     * @param id The unique identifier for the client
     * @param arrival The arrival time of the client
     */
    public Client(int id, int arrival) {
        this.id = id;
        this.arrivalTime = arrival;
    }

    /**
     * Constructs a client object with a given id, arrival time, and start of service time.
     *
     * @param id The unique identifier for the client
     * @param arrival The arrival time of the client
     * @param start The start time for the service
     */
    public Client(int id, int arrival, int start) {
        this.id = id;
        this.arrivalTime = arrival;
        this.startServiceTime = start;
    }

    /**
     * Sets the ID of the client.
     *
     * @param n The new ID for the client
     */
    public void setId(int n) {
        this.id = n;
    }

    /**
     * Sets the arrival time of the client.
     *
     * @param t The new arrival time for the client
     */
    public void setArrivalTime(int t) {
        this.arrivalTime = t;
    }

    /**
     * Sets the start time for serving the client.
     *
     * @param t The start service time for the client
     */
    public void setStartServiceTime(int t) {
        this.startServiceTime = t;
    }

    /**
     * Returns the ID of the client.
     *
     * @return The ID of the client
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the arrival time of the client.
     *
     * @return The arrival time
     */
    public int getArrivalTime() {
        return arrivalTime;
    }

    /**
     * Returns the start time for serving the client.
     *
     * @return The start service time
     */
    public int getStartServiceTime() {
        return startServiceTime;
    }

    /**
     * Compares this client with another client for ordering.
     *
     * @param another The client to compare with
     * @return A negative integer, zero, or a positive integer
     *         as this client is less than, equal to, or greater than
     *         the specified client
     */
    public int compareTo(Client another) {
        return (this.toString().compareTo(another.toString()));
    }

    /**
     * Concatenates 'N', the identification number of this client, and a parenthesis enclosing
     * the arrival time of this client, then returns the result of the concatenation.
     *
     * @return A string representation of the client
     */
    public String toString() {
        return ("N" + id + "(" + arrivalTime + ")");
    }
}
