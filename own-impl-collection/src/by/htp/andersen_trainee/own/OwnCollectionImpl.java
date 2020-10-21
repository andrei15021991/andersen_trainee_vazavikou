package by.htp.andersen_trainee.own;

import java.util.Iterator;

public class OwnCollectionImpl<E> implements OwnCollection<E> {

	private E[] items;

	@SuppressWarnings("unchecked")
	public OwnCollectionImpl() {

		items = (E[]) new Object[0];
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean add(E item) {

		try {

			E[] temp = items;
			items = (E[]) new Object[temp.length + 1];
			System.arraycopy(temp, 0, items, 0, temp.length);
			items[items.length - 1] = item;

			return true;

		} catch (ClassCastException e) {
			e.printStackTrace();
		}

		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void remove(int index) {

		try {

			E[] temp = items;
			items = (E[]) new Object[temp.length - 1];
			System.arraycopy(temp, 0, items, 0, index);
			int afterIndex = temp.length - index - 1;
			System.arraycopy(temp, index + 1, items, index, afterIndex);

		} catch (ClassCastException e) {
			e.printStackTrace();
		}

	}

	@Override
	public E get(int index) {

		return items[index];
	}

	@Override
	public int size() {

		return items.length;
	}

	@Override
	public void set(int index, E item) {

		items[index] = item;

	}

	@Override
	public Iterator<E> iterator() {

		return new OwnArrayIterator<>(items);
	}

	@Override
	public boolean contains(E item) {

		for (int i = 0; i < items.length; i++) {
			if (items[i].equals(item)) {
				return true;
			}
		}

		return false;
	}

}
