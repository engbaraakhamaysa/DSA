package review;

import java.util.Vector;

public class VectorDemo {

    public static void main(String[] args) {

        // =========================
        // Vector بدون Generics (Raw Type)
        // =========================
        Vector data = new Vector();

        // إضافة عناصر مختلفة الأنواع
        data.add("Ali");     // String
        data.add(100);       // Integer
        data.add(3.14);      // Double
        data.add(true);      // Boolean

        System.out.println("===== PRINT ALL ELEMENTS =====");

        for (int i = 0; i < data.size(); i++) {
            System.out.println(data.get(i));
        }

        System.out.println("\n===== TYPE CHECKING =====");

        for (int i = 0; i < data.size(); i++) {
            Object obj = data.get(i);

            if (obj instanceof String) {
                System.out.println("String: " + obj);
            }

            else if (obj instanceof Integer) {
                System.out.println("Integer: " + obj);
            }

            else if (obj instanceof Double) {
                System.out.println("Double: " + obj);
            }

            else if (obj instanceof Boolean) {
                System.out.println("Boolean: " + obj);
            }
        }

        System.out.println("\n===== CASTING EXAMPLE =====");

        // لازم Casting لأن النوع Object
        String name = (String) data.get(0);
        int number = (Integer) data.get(1);

        System.out.println("Name = " + name);
        System.out.println("Number = " + number);

        System.out.println("\n===== PROBLEM IN RAW VECTOR =====");

        // هذا خطأ منطقي لكنه لن يظهر compile error
        data.add("Hello again");

        // ممكن تعمل Runtime Error لو غلطت في casting
        try {
            Integer wrong = (Integer) data.get(4);
            System.out.println(wrong);
        } catch (Exception e) {
            System.out.println("Runtime Error: " + e);
        }

        System.out.println("\n===== UPDATE ELEMENT =====");

        data.set(0, "Updated Ali");

        for (Object obj : data) {
            System.out.println(obj);
        }
    }
}