package HashMap;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyHashMapTest {
    MyHashMap map;
    @Test
    public void put() {
        map = new MyHashMap();
        for (int i = 1; i<=100; i++)
            map.put(i, "value" + i);

        for (int i = 1; i<=map.size()-1; i++) {
            Object result = map.get(i);
            System.out.println((String)result);
            assertEquals("value" + i, (String) result);
        }
    }

    @Test
    public void delete() {
        for (int i = 1; i<=100; i++)
            map.put(i, "value" + i);
        for (int i = 1; i<=99; i++)
            map.remove(i, "value" + i);
        System.out.println("Map size" + map.size());
        assertEquals(map.size(), 0);
    }

    @Test
    public void get() {
        map = new MyHashMap();
        for (int i = 1; i<=100; i++)
            map.put(i, "value" + i);

        for (int i = 1; i<=map.size()-1; i++) {
            Object result = map.get(i);
            System.out.println((String)result);
            assertEquals("value" + i, (String) result);
        }
    }



    @Test
    public void size() {
        map = new MyHashMap();
        for (int i = 1; i<=100; i++)
            map.put(i, "value" + i);

        int size = map.size();
        assertNotEquals(-1, size);
    }
}