import java.util.Random;

public class Main {
    public static void main(String[] args) {
        BST<ID, String> binarySearchTree = new BST<>();
        for (int i=0; i < 10; i++) {
            String name = "Name" + i;
            String surname = "Surname" + i;
            ID key = new ID(name, surname);
            binarySearchTree.put(key, name + " " + surname);
        }

        for (BST<ID, String>.Node node : binarySearchTree) {
            System.out.println("Key: " + node.getKey() + ", Value:  " + node.getValue());
        }

        MyHashTable<ID, String> hashTable = new MyHashTable<>();
        Random random = new Random();
        for (int i=0; i < 10000; i++) {
            String name = "Name" + random.nextInt(1000);
            String surname = "Surname" + random.nextInt(1000);
            ID key = new ID(name, surname);
            hashTable.put(key, name + " " + surname);
        }
        hashTable.printBucketSize();
    }
}