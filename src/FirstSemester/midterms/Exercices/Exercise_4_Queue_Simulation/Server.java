package midterms.queue;

/**
 * Reference class for a typical server (e.g. Teller) in a service system.
 * A server has an assigned number (id) and serves clients with a
 * specific mean service time. This class models the service
 * behavior of a server, including the ability to generate
 * random service times for clients.
 */
public class Server implements java.lang.Comparable<Server> {
    private int id;
    private Client client;
    private double meanServiceTime;
    private int serviceTime;
    private int startServiceTime;
    private int stopServiceTime;
    private java.util.Random randomNumberGenerator;

    /**
     * Default constructor for the Server class.
     */
    public Server(){
        id = 1;
        client = null;
    }

    /**
     * Parameterized constructor for the Server class.
     *
     * @param id Unique identifier for the server
     * @param client The client being served
     * @param mean Average service time for clients
     * @param time Time when service starts
     */
    public Server(int id, Client client, double mean, int time){
        this.randomNumberGenerator = new java.util.Random();
        this.startServiceTime = time;
        this.id = id;
        this.client = client;
        this.meanServiceTime = mean;
        this.serviceTime = randomNumberGenerator.nextInt((int) Math.ceil(mean));
        this.stopServiceTime = startServiceTime + serviceTime;
    }

    /**
     * Sets the ID of the server.
     *
     * @param n The new ID for the server
     */
    public void setId(int n){
        this.id = n;
    }

    /**
     * Sets the client for the server.
     *
     * @param client The client to be served by the server
     */
    public void setClient(Client client){
        this.client = client;
    }

    /**
     * Sets the mean service time for the server.
     *
     * @param mean The new mean service time
     */
    public void setMeanServiceTime(double mean){
        this.meanServiceTime = mean;
    }

    /**
     * Sets the service time for the current client.
     *
     * @param t The service time for the client
     */
    public void setServiceTime(int t){
        this.serviceTime = t;
    }

    /**
     * Sets the start time for serving the current client.
     *
     * @param t The start time for the service
     */
    public void setStartServiceTime(int t){
        this.startServiceTime = t;
    }

    /**
     * Sets the stop time for serving the current client.
     *
     * @param t The stop time for the service
     */
    public void setStopServiceTime(int t){
        this.stopServiceTime = t;
    }

    /**
     * Returns the ID of the server.
     *
     * @return The ID of the server
     */
    public int getId(){
        return id;
    }

    /**
     * Returns the client being served by the server.
     *
     * @return The client being served
     */
    public Client getClient(){
        return client;
    }

    /**
     * Returns the mean service time for the server.
     *
     * @return The mean service time
     */
    public double getMeanServiceTime(){
        return meanServiceTime;
    }

    /**
     * Returns the service time for the current client.
     *
     * @return The service time
     */
    public int getServiceTime(){
        return serviceTime;
    }

    /**
     * Returns the start time for serving the current client.
     *
     * @return The start service time
     */
    public int getStartServiceTime(){
        return startServiceTime;
    }

    /**
     * Returns the stop time for serving the current client.
     *
     * @return The stop service time
     */
    public int getStopServiceTime(){
        return stopServiceTime;
    }

    /**
     * Checks if the server is currently idle (not serving any client).
     *
     * @return True if the server is idle, otherwise false
     */
    public boolean isIdle(){
        return (client == null);
    }

    /**
     * Compares this server with another server for ordering.
     *
     * @param another The server to compare with
     * @return A negative integer, zero, or a positive integer
     *         as this server is less than, equal to, or greater than
     *         the specified server
     */
    public int compareTo(Server another){
        return (this.toString().compareTo(another.toString()));
    }

    /**
     * Returns a string representation of the server.
     *
     * @return A string indicating the server ID
     */
    public String toString(){
        return ("S" + id);
    }
}
