package zadanie3;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface Save {
}

class Test {
    @Save
    public int a;
    @Save
    public String b;

    public int getA() {
        return a;
    }

    public String getB() {
        return b;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(String b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "Test{" + "a=" + a + ", b='" + b + '\'' + '}';
    }
}