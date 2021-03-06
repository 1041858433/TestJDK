package RE;

/**
 * @author DingYin
 * 2018/5/18 11:23
 */

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class ReflectGetValue {
    /**
     * 取出bean 属性和值
     *
     * @param obj
     * @return
     * @throws Exception
     */
    public static Map<Object, Object> getFileValue(Object obj) throws Exception {
        Map<Object, Object> map = new HashMap<Object, Object>();
        Class<?> cls = obj.getClass();
        Method methods[] = cls.getDeclaredMethods();
        Field fields[] = cls.getDeclaredFields();

        for (Field field : fields) {

            String fldtype = field.getType().getSimpleName();
            String getMetName = pareGetName(field.getName());
            Object result = null;
            if (!checkMethod(methods, getMetName)) {
                continue;
            }
            Method method = cls.getMethod(getMetName, null);
            Object object = method.invoke(obj, new Object[]{});
            if (null != object) {
                if (fldtype.equals("Date")) {
                    result = fmlDate((Date) object);
                } else if (fldtype.equals("Integer")) {
                    result = (Integer) object;
                } else if (fldtype.equals("int")) {
                    result = (int) object;
                } else if (fldtype.equals("Double")) {
                    result = (Double) object;
                } else if (fldtype.equals("double")) {
                    result = (double) object;
                } else {
                    result = String.valueOf(object);
                }
            }
            map.put(field.getName(), result);
        }

        return map;
    }

    /**
     * 设置bean 属性值
     *
     * @param map
     * @param bean
     * @throws Exception
     */
    public static void setFieldValue(Map<Object, Object> map, Object bean) throws Exception {
        Class<?> cls = bean.getClass();
        Method methods[] = cls.getDeclaredMethods();
        Field fields[] = cls.getDeclaredFields();

        for (Field field : fields) {
            String fldtype = field.getType().getSimpleName();
            String fldSetName = field.getName();
            String setMethod = pareSetName(fldSetName);
            if (!checkMethod(methods, setMethod)) {
                continue;
            }
            Object value = map.get(fldSetName);
            System.out.println(value.toString());
            Method method = cls.getMethod(setMethod, field.getType());
            System.out.println(method.getName());
            if (null != value) {
                if ("String".equals(fldtype)) {
                    method.invoke(bean, (String) value);
                } else if ("Double".equals(fldtype)) {
                    method.invoke(bean, (Double) value);
                } else if ("double".equals(fldtype)) {
                    method.invoke(bean, (double) value);
                } else if ("Integer".equals(fldtype)) {
                    method.invoke(bean, (Integer) value);
                } else if ("int".equals(fldtype)) {
                    int val = (int) value;
                    method.invoke(bean, val);
                }
            }

        }
    }

    /**
     * 拼接某属性get 方法
     *
     * @param fldname
     * @return
     */
    public static String pareGetName(String fldname) {
        if (null == fldname || "".equals(fldname)) {
            return null;
        }
        String pro = "get" + fldname.substring(0, 1).toUpperCase() + fldname.substring(1);
        return pro;
    }

    /**
     * 拼接某属性set 方法
     *
     * @param fldname
     * @return
     */
    public static String pareSetName(String fldname) {
        if (null == fldname || "".equals(fldname)) {
            return null;
        }
        String pro = "set" + fldname.substring(0, 1).toUpperCase() + fldname.substring(1);
        return pro;
    }

    /**
     * 判断该方法是否存在
     *
     * @param methods
     * @param met
     * @return
     */
    public static boolean checkMethod(Method methods[], String met) {
        if (null != methods) {
            for (Method method : methods) {
                if (met.equals(method.getName())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 把date 类转换成string
     *
     * @param date
     * @return
     */
    public static String fmlDate(Date date) {
        if (null != date) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CANADA);
            return sdf.format(date);
        }
        return null;
    }
}