/**
 *  @Author: Malasan, Edison M.
 *  @Date: 11/25/2024
 *  @ActivityName: Hash Table/Individual Final Exercise 2
 *  @ClassCode: 9344B - (10:30 AM - 12:00 PM)
 */
package hashtable;

import java.util.*;
import java.io.*;

public class Person implements Comparable<Person>{
    private String name;
    private int age;

    /**
     * Constructor
     */
    public Person(){
        name = "";
        age = 0;
    }

    /**
     * Constructor
     *
     * @param n
     * @param a
     */
    public Person(String n, int a) {
        name = n;
        age = a;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "("+ name +", "+age+")";
    }

    public boolean equals(Person other) {
        return toString().equals(((Person)other).toString());
    }

    @Override
    public int compareTo(Person another) {
        return toString().compareTo(another.toString());
    }
}
