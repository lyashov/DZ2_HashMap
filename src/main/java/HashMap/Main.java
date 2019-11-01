package HashMap;

import java.util.HashMap;


public class Main {
    public static void main(String[] args) {
        MyHashMap<Integer, String> myHashTable = new MyHashMap<Integer, String>();

        myHashTable = new MyHashMap();
        int rangeTest = 10;

        for (int i = 0; i < rangeTest; i++) {
            myHashTable.put(i, "value" + i);
        }

        for (int i = 0; i < myHashTable.size() ; i++) {
            Object myResult = myHashTable.get(i);
            System.out.println(myResult);
        }

        //Put pairs elements
        myHashTable.put(3,"My first value");
        myHashTable.put(8,"My second value");
        myHashTable.put(99,"My third value");

        //Size of HashMap
        System.out.println("Size of HashMap: " + myHashTable.size());

        //Get values by keys
        System.out.println(myHashTable.get(3));
        System.out.println(myHashTable.get(8));
        System.out.println(myHashTable.get(99));

        //Delete by key
        myHashTable.remove(99);
        System.out.println("Deleted value (key = 99) " + myHashTable.get(99));

        myHashTable.put(8,"My updated value (key = 8)");
        System.out.println(myHashTable.get(8));

        //Contains value
        System.out.println("Contains value (key = 3) is: " + myHashTable.containsKey(3));

        //Size of HashMap
        System.out.println("Size of HashMap: " + myHashTable.size());
    }
}
