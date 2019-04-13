package structures;

public class AVLTree<T extends Comparable<T>> {

	private AVLNode<T> root;

	public AVLTree() {
		root = null;
	}

	public AVLTree(AVLNode<T> root) {
		this.root = root;
	}

	public T getMax() {

		AVLNode<T> current = root;
		if (current == null) {
			return null;
		}
		while (current.getRight() != null) {
			current = current.getRight();
		}
		return current.getData();

	}

	public T getMin() {

		AVLNode<T> current = root;
		if (current == null) {
			return null;
		}
		while (current.getLeft() != null) {
			current = current.getLeft();
		}
		return current.getData();

	}

	public void insert(T data) {

		root = insert(root, data);

	}

	private AVLNode<T> insert(AVLNode<T> node, T data) {

		if (node == null) {
			return new AVLNode<T>(data);
		} else {
			if (node.getData().compareTo(data) > 0) {
				node.setLeft(insert(node.getLeft(), data));
			} else {
				node.setRight(insert(node.getRight(), data));
			}
			node.setHeight(Math.max(height(node.getLeft()), height(node.getRight())) + 1);
			int balanceFactor = balanceFactor(node);
			if (balanceFactor < -1) {
				if (balanceFactor(node.getRight()) > 0) {
					node.setRight(rotateRight(node.getRight()));
					return rotateLeft(node);
				} else {
					return rotateLeft(node);
				}
			} else if (balanceFactor > 1) {
				if (balanceFactor(node.getLeft()) < 0) {
					node.setLeft(rotateLeft(node.getLeft()));
					return rotateRight(node);
				} else {
					return rotateRight(node);
				}
			}
		}
		return node;

	}

	public int balanceFactor(AVLNode<T> node) {
		if (node == null) {
			return 0;
		}
		return height(node.getLeft()) - height(node.getRight());
	}

	private AVLNode<T> rotateLeft(AVLNode<T> node) {

		AVLNode<T> r = node.getRight();
		node.setRight(r.getLeft());
		r.setLeft(node);
		node.setHeight(Math.max(height(node.getLeft()), height(node.getRight())) + 1);
		r.setHeight(Math.max(height(r.getLeft()), height(r.getRight())) + 1);
		return r;

	}

	private AVLNode<T> rotateRight(AVLNode<T> node) {

		AVLNode<T> l = node.getLeft();
		node.setLeft(l.getRight());
		l.setRight(node);
		node.setHeight(Math.max(height(node.getLeft()), height(node.getRight())) + 1);
		l.setHeight(Math.max(height(l.getLeft()), height(l.getRight())) + 1);
		return l;

	}

	private int height(AVLNode<T> node) {
		if (node == null) {
			return 0;
		}
		return node.getHeight();
	}

}
