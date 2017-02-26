package gitHubTest;
/**
 * list½Ó¿Ú
 * @author Administrator
 *
 */
public interface MyList<E> {
	public int size();
	public boolean isEmpty();
	public void add(E e);
	public void add(int index, E e);
	public void remove(int index);
}
