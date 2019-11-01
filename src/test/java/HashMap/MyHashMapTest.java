package HashMap;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class MyHashMapTest {
    MyHashMap myMap;
    HashMap map;

    @Test
    public void put() {
        myMap = new MyHashMap();
        map = new HashMap();
        int rangeTest = 10000;

        for (int i = 0; i < rangeTest; i++) {
            myMap.put(i, "value" + i);
            map.put(i, "value" + i);
        }

        assertEquals(myMap.size(), rangeTest);
        assertEquals(map.size(), rangeTest);

    }

    @Test
    public void get() {
        myMap = new MyHashMap();
        map = new HashMap();
        int rangeTest = 10000;

        for (int i = 0; i < rangeTest; i++) {
            myMap.put(i, "value" + i);
            map.put(i, "value" + i);
        }

        for (int i = 0; i < myMap.size() ; i++) {
            Object myResult = myMap.get(i);
            assertEquals("value" + i, (String) myResult);
        }

        for (int i = 0; i < map.size() ; i++) {
            Object result = map.get(i);
            assertEquals("value" + i, (String) result);
        }
        assertEquals(myMap.size() , rangeTest);
        assertEquals(map.size() , rangeTest);
    }

    @Test
    public void size() {
        myMap = new MyHashMap();
        map = new HashMap();
        int rangeTest = 10000;

        for (int i = 0; i < rangeTest; i++)
            myMap.put(i, "value" + i);

        for (int i = 0; i < rangeTest; i++)
            map.put(i, "value" + i);

        int mySize = myMap.size();
            assertEquals(rangeTest, mySize);
        int size = myMap.size();
            assertEquals(rangeTest, size);
    }

    @Test
    public void remove() {
        myMap = new MyHashMap();
        map = new HashMap();
        int rangeTest = 10000;

        for (int i = 0; i < rangeTest; i++)
            myMap.put(i, "value" + i);

        for (int i = 0; i < rangeTest; i++)
            map.put(i, "value" + i);

        for (int i = 0; i < rangeTest; i++) {
            Object result = myMap.remove(i);
            assertEquals("value" + i, (String) result);
        }
        assertEquals(0, myMap.size());

        for (int i = 0; i < rangeTest; i++) {
            Object result = map.remove(i);
            assertEquals("value" + i, (String) result);
        }
        assertEquals(0, map.size());

    }

}