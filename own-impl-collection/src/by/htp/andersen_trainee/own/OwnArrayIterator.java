package by.htp.andersen_trainee.own;

import java.util.Iterator;

public class OwnArrayIterator<E> implements Iterator<E> {

	private int index = 0;
	private E[] items;

	public OwnArrayIterator(E[] items) {
		this.items = items;
	}

	@Override
	public boolean hasNext() {

		return index < items.length;
	}

	@Override
	public E next() {

		return items[index++];
	}

}
