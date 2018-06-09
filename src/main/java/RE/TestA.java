package RE;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author DingYin
 * 2018/5/18 11:24
 */
public class TestA {
    public static void main(String[] args) {
        try {
            A a = new A();
            a.setA(1);
            a.setDog("dog");
            a.setT(10.0);
            a.setC(5);
            Date date = new Date();
            a.setDate(date);
            Map<Object, Object> m= ReflectGetValue.getFileValue(a);
            B bean = new B();
            ReflectGetValue.setFieldValue(m, bean);
            System.out.println(m.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
