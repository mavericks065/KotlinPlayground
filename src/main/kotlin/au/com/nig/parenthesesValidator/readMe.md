## exercise 

console.log(checkParentheses('(word)')); // true
console.log(checkParentheses('(foo(bar))')); // true
console.log(checkParentheses('()')); // true
console.log(checkParentheses('((word))')); // true
console.log(checkParentheses('(word')); // false
console.log(checkParentheses('((word)')); // false
console.log(checkParentheses('(foo(bar)')); // false
console.log(checkParentheses('(foo))(')); // false
console.log(checkParentheses(')(foo)')); // false
