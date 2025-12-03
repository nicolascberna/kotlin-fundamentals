package sorting.mergesort

fun mergeSortingAlgorithm() {

    val initialList: ArrayList<Int> = arrayListOf(4,6,13,2,8,7,29,1)
    val listOfArrays: MutableList<ArrayList<Int>> = mutableListOf()

    initialList.forEach { value ->
        listOfArrays.add(arrayListOf(value))
    }

}

fun main() {
    mergeSortingAlgorithm()
}