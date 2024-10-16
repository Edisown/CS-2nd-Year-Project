package midterms.queue;

/**
 * Reference class for a typical client of a service system.
 * A client who arrives at a random time (arrivalTime) is assigned number(id).
 * The client will be given service at a certain start time (StartServiceTime)
 *
 * */
public class Client implements java.lang.Comparable<Client>{
    private int id;
    private int arrivalTime;
    private int startServiceTime;
    /**
     * Construct a client object with a given identification number and arrival time
     * */
    public Client(int id, int arrival){
        this.id = id;
        this.arrivalTime = arrival;
    }
    /**
     * Construct a client object with a given id, arrival time and start of service time
     * */
    public Client(int id, int arrival, int start){
        this.id = id;
        this.arrivalTime = arrival;
        this.startServiceTime = start;

    }
    public void setId(int n){
        this.id = n;
    }
    public void setArrivalTime(int t){
        this.arrivalTime = t;
    }
    public void setStartServiceTime(int t){
        this.startServiceTime = t;
    }
    public int getId(){
        return id;
    }
    public int getArrivalTime(){
        return arrivalTime;
    }
    public int getStartServiceTime(){
        return startServiceTime;
    }
    public int compareTo(Client another){
        return (this.toString().compareTo(another.toString()));
    }
    /**
     * Concatenates N, identification number of this client, and a parethesis enclosing
     * the arrival time of this client then
     * returns the result of the concatenation
     * */
    public String toString(){
        return ("N"+id +"(" + arrivalTime+")");
    }
}
