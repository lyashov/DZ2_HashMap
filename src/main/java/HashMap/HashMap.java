package HashMap;

interface HashMap<T1,T2> {
    T2 put(T1 key, T2 value);
    T2 remove(T1 key);
    T2 get (T1 key);
    boolean containsKey(T1 key);
    boolean containsValue(T2 value);
    boolean isEmpty();
    int size();

}