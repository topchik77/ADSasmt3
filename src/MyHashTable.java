import java.util.NoSuchElementException;
public class MyHashTable <K, V> {
    private class HashNode <K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode (K key, V value) {
            this.key = key;
            this.value = value;
        }
        @Override
        public String toString() {
            return "{" + key + " " +value + "}";
        }
    }
    private HashNode<K, V>[] chainArray;
    private int M = 11;
    private int size;
    private double load = 0.7;
    public MyHashTable() {
        chainArray = new HashNode[M];
    }

    public MyHashTable(int M) {
        this.M = M;
        chainArray = new HashNode[M];
    }
    public int hash(K key){
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % M;
    }
    public void put(K key, V value) {
        int hash = hash(key);
        HashNode<K, V> newNode = new HashNode<>(key, value);
        if (chainArray[hash] == null) {
            chainArray[hash] = newNode;
        } else {
            HashNode<K, V> current = chainArray[hash];
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }
    public V get(K key) {
        int hash = hash(key);
        HashNode<K, V> current = chainArray[hash];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        throw new NoSuchElementException("Key not found");
    }

    public V remove(K key) {
        int hash = hash(key);
        HashNode<K, V> current = chainArray[hash];
        HashNode<K, V> prev = null;
        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    chainArray[hash] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return current.value;
            }
            prev = current;
            current = current.next;
        }
        throw new NoSuchElementException("key not fuond");
    }
    public boolean contains(V value){
        for (HashNode<K, V> chain : chainArray) {
            HashNode<K, V> current = chain;
            while (current != null) {
                if (current.value.equals(value)) {
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }
    public void printBucketSize() {
        for (int i=0; i < chainArray.length; i++) {
            int count = 0;
            HashNode<K, V> current = chainArray[i];
            while (current != null) {
                count++;
                current = current.next;
            }
            System.out.println("Bucket " + i + ": " + count + " elements");
        }
    }
}
