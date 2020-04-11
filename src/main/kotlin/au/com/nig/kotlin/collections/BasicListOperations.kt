package au.com.nig.kotlin.collections

object BasicListOperations {
    fun transformIntInStrings(myList: List<Int>): List<String> {
        return myList.map { it.toString() }
    }

    fun keepOnlyEvenNumbers(myList: List<Int>): List<Int> {
        return myList.filter { it % 2 == 0 }
    }

    fun transformInListOfChars(myList: List<String>): List<Char> {
        return myList.flatMap { str -> str.toCharArray().toList() }
    }

    fun keepOnlyNonNullNumbers(myList: List<Int?>): List<Int> {
        return myList.filterNotNull()
    }

    fun sumNumbers1(myList: List<Int>): Int {
        return myList.sum()
    }

    fun sumNumbers2(myList: List<Int>): Int {
        return myList.reduce { x, y -> x + y }
    }

    fun getNumber(myList: List<Int>, i: Int): Int {
        return myList[i]
    }

    fun getLastNumber(myList: List<Int>): Int {
        return myList.last()
    }

    fun getFirstNumber(myList: List<Int>): Int {
        return myList.first()
    }

    fun modify(myList: List<Int>): List<Int> {
        val newList = myList.toMutableList()
        newList.add(10)
        newList.removeAt(1)
//        newList.remove(1)
        return newList.toList()
    }

}