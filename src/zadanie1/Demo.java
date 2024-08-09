package zadanie1;

public class Demo {
    @Test(a = 1, b = 5)
    public void testMethod(int a, int b) {
        System.out.println("a: " + a + ", b: " + b);
    }
}
