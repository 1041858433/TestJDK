/**
 * @author DingYin
 * 2018/3/22 19:00
 */
public class Down extends Top{

    static class X<K,V> implements Top.entry<K,V>{
        @Override
        public K getKey() {
            return null;
        }

        @Override
        public V setValue(V value) {
            return null;
        }
    }
}
