package structures;

import java.util.ArrayList;

public class NAryNode<T extends Comparable<T>> {

	private T elem;
	private ArrayList<NAryNode<T>> children;

	public NAryNode(T elem) {

		this.elem = elem;
		children = new ArrayList<NAryNode<T>>();

	}

	public T getElem() {
		return elem;
	}

	public void addChild(NAryNode<T> child) {
		children.add(child);
	}

}
