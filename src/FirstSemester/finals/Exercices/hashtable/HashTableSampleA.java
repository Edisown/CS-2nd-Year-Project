/**
 * @Author: Malasan, Edison M.
 * @Date: 11/25/2024
 * @ActivityName: Hash Table/Individual Final Exercise 2
 * @ClassCode: 9344B - (10:30 AM - 12:00 PM)
 *
 *
 * SAMPLE OUTPUT:
 *
 * {2374421=(Lord, 18), 1175645516=(Kathleen, 17)}
 * 2140939337=(Gracie, 20),2374421=(Lord, 18),1175645516=(Kathleen, 17)2140939337,2374421,1175645516(Gracie, 20),(Lord, 18),(Kathleen, 17)
 * Enter a name to search: Lord
 * (Lord, 18)
 *
 * {2374421=(Lord, 18), 1175645516=(Kathleen, 17)}
 * 2140939337=(Gracie, 20),2374421=(Lord, 18),1175645516=(Kathleen, 17)2140939337,2374421,1175645516(Gracie, 20),(Lord, 18),(Kathleen, 17)
 * Enter a name to search: Gracie
 * (Gracie, 20)
 *
 * {2374421=(Lord, 18), 1175645516=(Kathleen, 17)}
 * 2140939337=(Gracie, 20),2374421=(Lord, 18),1175645516=(Kathleen, 17)2140939337,2374421,1175645516(Gracie, 20),(Lord, 18),(Kathleen, 17)
 * Enter a name to search: Kathleen
 * (Kathleen, 17)
 *
 * {2374421=(Lord, 18), 1175645516=(Kathleen, 17)}
 * 2140939337=(Gracie, 20),2374421=(Lord, 18),1175645516=(Kathleen, 17)2140939337,2374421,1175645516(Gracie, 20),(Lord, 18),(Kathleen, 17)
 * Enter a name to search:
 */
package hashtable;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.Iterator;

public class HashTableSampleA {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void print(Iterator iterator) {
        if (iterator.hasNext()) {
            System.out.print(iterator.next());

            while (iterator.hasNext()) {
                System.out.print("," + iterator.next());
            }
        }
    }

    /**
     * Main
     * @param args
     */
    public static void main(String[] args) {
        /**
         * Created a loop
         */
        while (true) {
            try {

                Hashtable<Integer, Person> hashtable1 = new Hashtable<Integer, Person>(4); // create a new instance of HashTable
                hashtable1.put("Lord".hashCode(), new Person("Lord", 18)); // create a new instance of Person
                hashtable1.put("Kathleen".hashCode(), new Person("Kathleen", 17)); // create a new instance of Person
                System.out.println(hashtable1);

                hashtable1.put("Gracie".hashCode(), new Person("Gracie", 20)); // create a new instance of Person
                print(hashtable1.entrySet().iterator());
                print(hashtable1.keySet().iterator());
                print((Iterator) hashtable1.elements());

                System.out.print("\nEnter a name to search: "); // prompt the user to enter a name to search
                String searchKey = bufferedReader.readLine(); // read the user prompt
                System.out.println(hashtable1.get(searchKey.hashCode()) + "\n"); // print the name and the hashKey of associated with the Person
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
