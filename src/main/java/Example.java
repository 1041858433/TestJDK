/**
 * @author DingYin
 * 2018/3/23 12:45
 */
public class Example {
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
