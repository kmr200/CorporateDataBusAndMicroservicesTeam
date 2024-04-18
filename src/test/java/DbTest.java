import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class DbTest {

    private Db db;

    @BeforeEach
    public void setUp() {
        db = new Db();
    }

    @Test
    public void testPutAndGetByAccount() {
        db.put(1L, "Alice", 100.0);
        Assertions.assertEquals("account: 1\nname: Alice\nvalue: 100.0\n", db.getByAccount(1L));
    }

    @Test
    public void testGetByAccountNotFound() {
        Assertions.assertNull(db.getByAccount(1L));
    }

    @Test
    public void testGetByName() {
        db.put(1L, "Alice", 100.0);
        db.put(2L, "Bob", 200.0);
        db.put(3L, "Alice", 300.0);

        List<String> aliceEntries = db.getByName("Alice");
        Assertions.assertEquals(2, aliceEntries.size());
        Assertions.assertTrue(aliceEntries.contains("account: 1\nname: Alice\nvalue: 100.0\n"));
        Assertions.assertTrue(aliceEntries.contains("account: 3\nname: Alice\nvalue: 300.0\n"));
    }

    @Test
    public void testGetByNameNotFound() {
        Assertions.assertTrue(db.getByName("Unknown").isEmpty());
    }

    @Test
    public void testGetByValue() {
        db.put(1L, "Alice", 100.0);
        db.put(2L, "Bob", 200.0);
        db.put(3L, "Charlie", 100.0);

        List<String> valueEntries = db.getByValue(100.0);
        Assertions.assertEquals(2, valueEntries.size());
        Assertions.assertTrue(valueEntries.contains("account: 1\nname: Alice\nvalue: 100.0\n"));
        Assertions.assertTrue(valueEntries.contains("account: 3\nname: Charlie\nvalue: 100.0\n"));
    }

    @Test
    public void testGetByValueNotFound() {
        Assertions.assertTrue(db.getByValue(999.0).isEmpty());
    }

    @Test
    public void testRemove() {
        db.put(1L, "Alice", 100.0);
        Assertions.assertEquals(1, db.size());
        Assertions.assertNotNull(db.remove(1L));
        Assertions.assertEquals(0, db.size());
        Assertions.assertNull(db.getByAccount(1L));
    }
}
