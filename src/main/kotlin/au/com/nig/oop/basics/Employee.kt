package au.com.nig.oop.basics

data class Employee(
    var firstName: String,
    val lastName: String
){

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
