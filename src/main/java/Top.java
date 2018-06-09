/**
 * @author DingYin
 * 2018/3/22 17:04
 */
public class Top {
    int i = 0;
    int getI(){
       return i;
    }
    interface entry<K,V>{
        K getKey();
        V setValue(V value);
    }

}
