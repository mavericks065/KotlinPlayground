

example of input: 
```
val dataSample = [ 
    "metric.name=1|host:hostA;role:web;availability-zone:ap-south-east-2a",
    "metric.name=1|host:hostB;role:db;availability-zone:ap-south-east-2a"
    "metric.name=1|host:hostC;role:db;availability-zone:ap-south-east-2b"
    "metric.name=1|host:hostD;role:db;availability-zone:ap-south-east-2b"
]
```

function that needs to be implemented: 
```kotlin 
fun getRelatedTag(stream: List<String>, tags: List<String>): List<String> {
    TODO();
}
```

Example of expected results: 
```kotlin
println(getRelatedTag(dataSample, ["host:hostA"]))
// ["role:web", "availability-zone:ap-south-east-2a"]
println(getRelatedTag(dataSample, ["role:db"]))
// ["host:hostB", "host:hostC", "host:hostD", "availability-zone:ap-south-east-2a", "availability-zone:ap-south-east-2b"]
println(getRelatedTag(dataSample, ["role:db", "availability-zone:ap-south-east-2b"]))
// ["host:hostD", "host:hostC"]
```
