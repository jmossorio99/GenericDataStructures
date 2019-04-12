package structures;

public class BSTNode<T extends Comparable<T>, K> {

	K key;
	T value;
	BSTNode<T, K> parent;
	BSTNode<T, K> left;
	BSTNode<T, K> right;

	public BSTNode() {

		parent = null;
		left = null;
		right = null;

	}

}
