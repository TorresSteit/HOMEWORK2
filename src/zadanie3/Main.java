package zadanie3;

public class Main {

    public static void main(String[] args) {

        Test test = new Test();
        test.setA(15);
        test.setB("hello world");

        Serialization ser = new Serialization();

        ser.serializeToFile(test, "test.txt");

        Object obj = ser.deserializeFromFile(Test.class, "test.txt");

        if (obj != null) {
            System.out.println(obj);
        }
    }
}
