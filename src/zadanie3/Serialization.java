package zadanie3;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Serialization {

    public void serializeToFile(Object obj, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            Class<?> clas = obj.getClass();
            Field[] fields = clas.getDeclaredFields();

            for (Field field : fields) {
                if (field.isAnnotationPresent(Save.class)) {
                    field.setAccessible(true);
                    oos.writeObject(field.get(obj));
                }
            }
        } catch (IOException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public Object deserializeFromFile(Class<?> clas, String fileName) {
        Object res = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            res = clas.getDeclaredConstructor().newInstance();
            Field[] fields = clas.getDeclaredFields();

            for (Field field : fields) {
                if (field.isAnnotationPresent(Save.class)) {
                    field.setAccessible(true);
                    field.set(res, ois.readObject());
                }
            }
        } catch (IOException | IllegalAccessException | InstantiationException | ClassNotFoundException |
                 NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return res;
    }
}
