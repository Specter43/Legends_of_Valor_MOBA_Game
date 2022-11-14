/**
 * An Interface to instruct that a Role class should be able to attack.
 *
 * @param <T> a Role class or subclass instance.
 */
public interface Attack<T extends Role> {
    void attack(T role);
}
