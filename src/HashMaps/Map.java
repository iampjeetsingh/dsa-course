package HashMaps;

import java.util.ArrayList;

public class Map<K, V> {
    ArrayList<MapNode<K,V>> buckets;
    int count;
    int numBuckets;

    public Map() {
        buckets = new ArrayList<>();
        numBuckets = 20;
        for(int i=0; i<numBuckets; i++){
            buckets.add(null);
        }
    }

    public int size(){
        return count;
    }

    public double loadFactor() {
        return (1.0*count)/numBuckets;
    }

    private int getBucketIndex(K key){
        int hc = key.hashCode();
        int index = hc%numBuckets;
        return index;
    }

    public void insert(K key, V value){
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = buckets.get(bucketIndex);
        while (head!=null){
            if(head.key.equals(key)){
                head.value = value;
            }
            head = head.next;
        }
        head = buckets.get(bucketIndex);
        MapNode<K,V> newNode = new MapNode<>(key, value);
        newNode.next = head;
        buckets.set(bucketIndex, newNode);
        count++;
        double loadFactor = (1.0*count)/numBuckets;
        if(loadFactor>0.7){
            rehash();
        }
    }

    public V getValue(K key){
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = buckets.get(bucketIndex);
        while (head!=null){
            if(head.key.equals(key)){
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public V removeKey(K key){
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = buckets.get(bucketIndex);
        MapNode<K, V> prev = null;
        while (head!=null){
            if(head.key.equals(key)){
                if(prev==null){
                    buckets.set(bucketIndex, head.next);
                }else {
                    prev.next = head.next;
                }
                count--;
                return head.value;
            }
            prev = head;
            head = head.next;
        }
        return null;
    }

    private void rehash(){
        ArrayList<MapNode<K,V>> temp = buckets;
        buckets = new ArrayList<>();
        count = 0;
        numBuckets = 2*numBuckets;
        for(int i=0; i<numBuckets; i++){
            buckets.add(null);
        }
        for(MapNode<K,V> head : temp){
            while (head!=null){
                insert(head.key, head.value);
                head = head.next;
            }
        }
    }
}
