import java.util.Random;

public class MyTestingClass {
    private int value;

    public MyTestingClass(int value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }
        MyTestingClass that = (MyTestingClass) obj;
        return value == that.value;
    }

    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Integer> table = new MyHashTable<>();
        Random random = new Random();

        for (int i=0; i < 10000; i++) {
            MyTestingClass key = new MyTestingClass(random.nextInt(100000));
            table.put(key, i);
        }

        table.printBucketSize();
    }
}
