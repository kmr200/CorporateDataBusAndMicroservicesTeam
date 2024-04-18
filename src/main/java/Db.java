import java.util.*;

/**
 * Db is an implementation of HashMap.
 * <p>
 * Db stores values in a HashMap in the following format:
 * (account id is considered to be the primary key, having original and non-null value across all the entries)
 * <Long account id, Contact[String name, Double value]>.
 * HashMap Collection was chosen for the class to perform its best when searching for entries by Account id.
 */

public class Db {

    private HashMap<Long, Contact> db;

    public Db(){
        db = new HashMap<>();
    }

    /**
     * Returns the number of key-value mappings in this map.
     *
     * @return the number of key-value mappings in this map
     */
    public int size() {
        return db.size();
    }

    /**
     * Returns {@code true} if this map contains no key-value mappings.
     *
     * @return {@code true} if this map contains no key-value mappings
     */
    public boolean isEmpty() {
        return db.isEmpty();
    }

    /**
     * Returns {@code true} if this map contains a mapping for the
     * specified key.
     *
     * @param   key   The key whose presence in this map is to be tested
     * @return {@code true} if this map contains a mapping for the specified
     * key.
     */
    public boolean containsKey(Object key) {
        return db.containsKey(key);
    }

    /**
     * Returns {@code true} if this map maps one or more keys to the
     * specified value.
     *
     * @param value value whose presence in this map is to be tested
     * @return {@code true} if this map maps one or more keys to the
     *         specified value
     */
    public boolean containsValue(Object value) {
        return db.containsValue(value);
    }

    /**
     * Performs HashMap.get() for entries stored in Db, resulting in
     * O(1) time complexity. If no matching entry is found, null
     * will be returned.
     *
     * @param account
     * @return String containing info about the matching entry
     */
    public String getByAccount(Long account) {
        Contact contact = db.get(account);
        if (contact == null) {
            System.out.println("No matching entry found for account: " + account);
            return null;
        } else {
            String result =
                    "account: " + account + "\n"
                    + "name: " + contact.getName() + "\n"
                    + "value: " + contact.getValue() + "\n";
            return result;
        }
    }

    /**
     * Iterates threw all the entries stored in Db matching name
     * passed as an argument, resulting in O(n) time complexity.
     * If no matching entry is found, empty ArrayList will be returned.
     *
     * @param name
     * @return ArrayList containing info about all the matching entries
     */
    public List<String> getByName(String name) {
        List<String> list = new ArrayList<>();
        for(Map.Entry<Long, Contact> entry : db.entrySet()) {
            if(entry.getValue().getName().equals(name)) {
                list.add(
                        "account: " + entry.getKey() + "\n"
                        + "name: " + entry.getValue().getName() + "\n"
                        + "value: " + entry.getValue().getValue() + "\n"
                );
            }
        }
        if(list.isEmpty()) System.out.println("No matching entry found for name: " + name);
        return list;
    }

    /**
     * Iterates threw all the entries stored in Db matching value
     * passed as an argument, resulting in O(n) time complexity.
     * If no matching entry is found, empty ArrayList will be returned.
     *
     * @param value
     * @return ArrayList containing info about all the matching entries
     */
    public List<String> getByValue(Double value) {
        List<String> list = new ArrayList<>();
        for(Map.Entry<Long, Contact> entry : db.entrySet()) {
            if(entry.getValue().getValue().equals(value)) {
                list.add(
                        "account: " + entry.getKey() + "\n"
                         + "name: " + entry.getValue().getName() + "\n"
                         + "value: " + entry.getValue().getValue() + "\n"
                );
            }
        }
        if(list.isEmpty()) System.out.println("No matching entry found for value: " + value);
        return list;
    }

    /**
     * Associates the specified value with the specified key in this map.
     * If the map previously contained a mapping for the key, the old
     * value is replaced. Throws IllegalArgumentException if name or
     * value parameters contain null value
     *
     * @param key key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     * @return the previous value associated with {@code key}, or
     *         {@code null} if there was no mapping for {@code key}.
     *         (A {@code null} return can also indicate that the map
     *         previously associated {@code null} with {@code key}.)
     */
    public Object put(Long key, String name, Double value) throws IllegalArgumentException{
        return db.put(key, new Contact(name, value));
    }

    /**
     * Removes the mapping for the specified key from this map if present.
     *
     * @param  key key whose mapping is to be removed from the map
     * @return the previous value associated with {@code key}, or
     *         {@code null} if there was no mapping for {@code key}.
     *         (A {@code null} return can also indicate that the map
     *         previously associated {@code null} with {@code key}.)
     */
    public Object remove(Object key) {
        return db.remove(key);
    }

    /**
     * Removes all the mappings from this map.
     * The map will be empty after this call returns.
     */
    public void clear() {
        db.clear();
    }
}
