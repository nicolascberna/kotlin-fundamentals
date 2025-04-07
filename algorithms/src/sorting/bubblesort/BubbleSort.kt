package sorting.bubblesort

/**
 * Time Complexity: O(n²)
 */
internal fun bubbleSort(array: IntArray): IntArray {
    val n = array.size
    for (i in 0..<n - 1) {
        for (j in 0..<n - i - 1) {
            if (array[j] > array[j + 1]) {
                val temp = array[j]
                array[j] = array[j + 1]
                array[j + 1] = temp
            }
        }
    }
    return array
}
