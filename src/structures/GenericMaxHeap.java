package structures;

public class GenericMaxHeap<T extends Comparable<T>> {

	private T[] heap;
	private int maxSize;
	private int heapSize;

	@SuppressWarnings("unchecked")
	public GenericMaxHeap(int size) {

		maxSize = size;
		heapSize = size;
		heap = (T[]) new Comparable[maxSize];

	}

	public GenericMaxHeap(T[] arr) {

		maxSize = arr.length;
		heapSize = maxSize;
		heap = arr;
		for (int i = heap.length / 2; i >= 0; i--) {
			maxHeapify(i);
		}

	}

	public void maxHeapify(int i) {

		int left = getLeft(i);
		int right = getRight(i);
		int largest = 0;
		if (left <= heapSize && heap[left].compareTo(heap[i]) > 0) {
			largest = left;
		} else {
			largest = i;
		}
		if (right <= heapSize && heap[right].compareTo(heap[largest]) > 0) {
			largest = right;
		}
		if (largest != i) {
			T temp = heap[i];
			heap[i] = heap[largest];
			heap[largest] = temp;
			maxHeapify(largest);
		}

	}

	public void heapSort() {

		for (int i = heap.length - 1; i >= 1; i--) {
			T temp = heap[1];
			heap[1] = heap[i];
			heap[i] = temp;
			maxHeapify(1);
		}

	}

	public int getLeft(int i) {
		return i * 2;
	}

	public int getRight(int i) {
		return (i * 2) + 1;
	}

}