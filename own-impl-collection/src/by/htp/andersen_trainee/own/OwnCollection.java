package by.htp.andersen_trainee.own;

public interface OwnCollection<E> extends Iterable<E> {

	boolean add(E item);

	void remove(int index);

	E get(int index);

	int size();

	void set(int index, E item);

	boolean contains(E item);

}
