import java.util.Objects;

/**
 * Contact classes objects are used
 * to store both name and value properties
 * of users as a single object
 */

public class Contact {

    private final String name;
    private final Double value;

    public Contact(String name, Double value) throws IllegalArgumentException{
        if (name == null) {
            throw new IllegalArgumentException("Contact name cannot be null");
        } else if (value == null) {
            throw new IllegalArgumentException("Contact value cannot be null");
        }
        this.name = name;
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact contact)) return false;
        return Objects.equals(getName(), contact.getName()) && Objects.equals(getValue(), contact.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getValue());
    }
}
