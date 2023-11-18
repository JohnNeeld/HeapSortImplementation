public class HeapSortImplementation {
   
    public static void heapSort(int[] array) {
        int n = array.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        // Extract elements from the heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Swap the root (maximum element) with the last element
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // Call max heapify on the reduced heap
            heapify(array, i, 0);
        }
    }

    // Heapify a subtree rooted with node i which is an index in array[]
    private static void heapify(int[] array, int n, int i) {
        int root = i; // Initialize largest as root
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        // If left child is larger than root
        if (leftChild < n && array[leftChild] > array[root]) {
            root = leftChild;
        }

        // If right child is larger than root so far
        if (rightChild < n && array[rightChild] > array[root]) {
            root = rightChild;
        }

        // If the largest is not the root
        if (root != i) {
            // Swap the root with the largest element
            int temp = array[i];
            array[i] = array[root];
            array[root] = temp;

            // Recursively heapify the affected sub-tree
            heapify(array, n, root);
        }
    }

    // Utility method to print an array
    private static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7};

        System.out.println("Original array:");
        printArray(array);

        heapSort(array);

        System.out.println("Sorted array:");
        printArray(array);
    }
}
