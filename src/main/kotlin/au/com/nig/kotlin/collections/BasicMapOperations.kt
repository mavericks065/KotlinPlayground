package au.com.nig.kotlin.collections

object BasicMapOperations {

    fun filterOnKeysAndValuesAndToUpperCaseValues(myMap: Map<Int, String?>): Map<Int, String?> {
        return myMap
            .filterValues { value -> value != null }
            .filterKeys { key -> (key % 2) != 0 }
            .mapNotNull { (k, v) -> Pair(k, v?.toUpperCase()) }
            .toMap()
    }

    fun addElementsToMutableMap(myMap: MutableMap<Int, String>, pair: Pair<Int, String>): MutableMap<Int, String> {
//        return myMap.plus(pair)
        myMap[pair.first] = pair.second
        return myMap
    }

    fun addElementsToMap(myMap: Map<Int, String>, pair: Pair<Int, String>): Map<Int, String> {
        return myMap.plus(pair)
    }

    fun removeElementsFromMutableMap(myMap: MutableMap<Int, String>, key: Int): MutableMap<Int, String> {
        myMap.remove(key)
        return myMap
    }

    fun getCharacters(myMap: Map<Int, String>): List<Char> {
        return myMap.flatMap { it.value.toCharArray().toList() }
    }

    fun getKeys(myMap: Map<Int, String>): List<Int> {
        return myMap.keys.toList()
    }

    fun getValues(myMap: Map<Int, String>): List<String> {
        return myMap.values.toList()
    }

    fun setValue(myMap: MutableMap<Int, String>, key: Int, newValue: String): MutableMap<Int, String> {
        myMap[key] = newValue
        return myMap
    }
}
