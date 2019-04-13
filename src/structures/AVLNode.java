package structures;

public class AVLNode<T extends Comparable<T>> {

	private T data;
	private AVLNode<T> left;
	private AVLNode<T> right;
	private AVLNode<T> parent;
	public int level;
	private int depth;

	public AVLNode(T data, AVLNode<T> left, AVLNode<T> right, AVLNode<T> parent) {

		this.data = data;
		this.left = left;
		this.right = right;
		this.parent = parent;
		if (left == null && right == null) {
			setDepth(1);
		} else if (left == null) {
			setDepth(right.getDepth() + 1);
		} else if (right == null) {
			setDepth(left.getDepth() + 1);
		} else {
			setDepth(Math.max(left.getDepth(), right.getDepth()) + 1);
		}

	}

	public AVLNode(T data) {
		this(data, null, null, null);
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public AVLNode<T> getParent() {
		return parent;
	}

	public void setParent(AVLNode<T> parent) {
		this.parent = parent;
	}

	public AVLNode<T> getLeft() {
		return left;
	}

	public void setLeft(AVLNode<T> left) {
		this.left = left;
	}

	public AVLNode<T> getRight() {
		return right;
	}

	public void setRight(AVLNode<T> right) {
		this.left = right;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	private int getDepth() {
		return depth;
	}

	public int compareTo(AVLNode<T> o) {
		return this.data.compareTo(o.getData());
	}

}
