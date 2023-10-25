public class Pair<K,V> {
    public K key;
    public V value;
    public Pair(K key,V value)
    {
        this.key = key;
        this.value = value;
    }
    K getKey()
    {
        return key;
    }
    V getVale()
    {
        return value;
    }

}
class PairTest{
    public static void main(String[] args) {
        Pair<String,Integer> pair = new Pair<>("AB01234",1234);
        System.out.println(pair.key +" " +  pair.getVale() );
    }
}
