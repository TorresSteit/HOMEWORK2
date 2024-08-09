package zadanie1;

import java.lang.reflect.*;


public class Main {
    public static void main(String[] args) throws Exception {
        Demo demo = new Demo();


        Method[] methods = Demo.class.getDeclaredMethods();

        for (Method method : methods) {

            if (method.isAnnotationPresent(Test.class)) {

                Test testAnnotation = method.getAnnotation(Test.class);


                int a = testAnnotation.a();
                int b = testAnnotation.b();


                System.out.println("Pametri  "+a+"   "+b);
            }
        }
    }
}

