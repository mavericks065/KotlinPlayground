package au.com.nig.oop.basics

import java.time.Instant
import java.util.Calendar




data class Employee(
    var firstName: String,
    val lastName: String,
    var dateOfBirth: Instant? = null
) {
    fun getAge(): Int {
        val currentCallendar = Calendar.getInstance()
        val birthCallendar = Calendar.getInstance()
        currentCallendar.timeInMillis = Instant.now().toEpochMilli()
        birthCallendar.timeInMillis = dateOfBirth!!.toEpochMilli()
        val currentYear = currentCallendar[Calendar.YEAR]
        val birthYear = birthCallendar[Calendar.YEAR]
        return currentYear - birthYear
    }
}

class Employee2 {
    val firstName: String
    val lastName: String

    constructor() {
        this.firstName = ""
        this.lastName = ""
    }

    constructor(firstName: String, lastName: String) {
        this.firstName = firstName
        this.lastName = lastName
    }
}
