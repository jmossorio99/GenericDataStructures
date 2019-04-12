package structures;

import java.util.ArrayList;

public class GenericQueue<T> {

	private ArrayList<T> queue = new ArrayList<T>();

	public GenericQueue(T[] arr) {

		for (int i = 0; i < arr.length; i++) {
			queue.add(arr[i]);
		}

	}

	public T peek() {
		return queue.isEmpty() ? null : queue.get(0);
	}

	public void offer(T elem) {
		queue.add(elem);
	}

	public T poll() {
		T aux = null;
		if (!queue.isEmpty()) {
			aux = queue.get(0);
			queue.remove(0);
		}
		return aux;
	}

}
