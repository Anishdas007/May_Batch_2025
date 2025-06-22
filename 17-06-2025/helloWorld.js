// // // let a=30;
// // // let b=20;
// // // let c = a + b;
// // // console.log("Hello World");
// // // console.log("The sum of a and b is: " + c);
// // // //String 
// // // let name = "John";
// // // let age = 25;
// // // // Boolean
// // // let isStudent = true;
// // // // Array
// // // let fruits = ["apple", "banana", "cherry"];
// // // // Object
// // // let person = {
// // //     name: "John",
// // //     age: 25,
// // //     isStudent: true
// // // };
// // // // Function
// // // function greet() {
// // //     console.log("Hello, " + name);
// // // }       
// // // greet();
// // // // Conditional statement
// // // if (isStudent) {
// // //     console.log(name + " is a student.");
// // // }
// // // // Loop
// // // for (let i = 0; i < fruits.length; i++) {
// // //     console.log("Fruit: " + fruits[i]);
// // // }
// // // // Using the object
// // // console.log("Person's name is: " + person.name);
// // // // Using the function
// // // greet();
// // // // Using the conditional statement
// // // if (person.age > 18) {
// // //     console.log(person.name + " is an adult.");
// // // }
// // // // Using the loop
// // // for (let i = 0; i < 5; i++) {
// // //     console.log("Count: " + i);
// // // }
// // // const x = [1, 2, 3, 4, 5];
// // // const y= x;
// // // console.log("Array x: " + x);
// // // console.log("Array y: " + y);
// // // // Modifying y will also modify x
// // // y[0] = 10;
// // // y.push(6);
// // // console.log("After modifying y:");
// // // console.log("Array y: " + y);
// // // console.log("Array x: " + x);

// // // const square = (num) => {
// // //     return num * num;
// // // }
// // // console.log("Square of 5 is: " + square(5));
// // // const add = (a, b) => {
// // //     return a + b;
// // // }
// // // console.log("Sum of 10 and 20 is: " + add(10, 20));
// // // const multiply = (a, b) => {    
// // //     return a * b;
// // // }
// // // console.log("Product of 10 and 20 is: " + multiply(10, 20));
// // // const ConcatenateOrMultiply = (a, b) => {
// // //     if (typeof a === 'string' || typeof b === 'string') {
// // //         return a.toString() + b.toString();
// // //     } else {
// // //         return a * b;
// // //     }
// // // }
// // // console.log("Concatenation of 'Hello' and 'World': " + ConcatenateOrMultiply("Hello", "World"));
// // // console.log("Multiplication of 10 and 20: " + ConcatenateOrMultiply(10, 20));

// // // // forof and forin loops
// // // const numbers = [1, 2, 3, 4, 5];    
// // // for (const number of numbers) {
// // //     console.log("Number: " + number);
// // // }
// // // const personDetails = {
// // //     name: "Alice",
// // //     age: 30,
// // //     city: "New York"
// // // };
// // // console.log("Person Details:" +Object.keys(personDetails)+" are the keys of the object "+Object.values(personDetails)+" are the values of the object " +Object.entries(personDetails)+" are the entries of the object");

// // // for (const key in personDetails) {
// // //     console.log(key + ": " + personDetails[key]);
// // // }
// // // // Using a switch statement
// // // const day = 3;
// // // switch (day) {
// // //     case 1:
// // //         console.log("Monday");
// // //         break;
// // //     case 2:
// // //         console.log("Tuesday");
// // //         break;
// // //     case 3:
// // //         console.log("Wednesday");
// // //         break;
// // //     case 4:
// // //         console.log("Thursday");
// // //         break;
// // //     case 5:
// // //         console.log("Friday");
// // //         break;
// // //     case 6:
// // //         console.log("Saturday");
// // //         break;
// // //     case 7:
// // //         console.log("Sunday");
// // //         break;
// // //     default:
// // //         console.log("Invalid day");
// // // }
// // // // Using a try-catch block
// // // try {
// // //     let result = 10 / 0; // This will not throw an error, but let's simulate an error
// // //     if (result === Infinity) {
// // //         throw new Error("Division by zero is not allowed.");
// // //     }
// // // } catch (error) {
// // //     console.error("An error occurred: " + error.message);
// // // }
// // // // for each loop
// // // const colors = ["red", "green", "blue"];
// // // colors.forEach((color) => {
// // //     console.log("Color: " + color);
// // // });

// // // difference between forEach and for loop and for of loop and for in loop
// // // forEach loop is used for arrays and does not return a value, while for loop and for of loop can be used with any iterable object and can return values. For in loop is specifically used for iterating over object properties.
// // // forEach is generally used for side effects, while for loop and for of loop are more versatile and can be used for both side effects and returning values. For in loop is used for iterating over object properties, while forEach is used for arrays.
// // // forEach is not suitable for breaking out of the loop, while for loop and for of loop can use break and continue statements. For in loop is also not suitable for breaking out of the loop, as it iterates over object properties.
// // // forEach is not suitable for asynchronous operations, while for loop and for of loop can be used with async/await. For in loop is also not suitable for asynchronous operations, as it iterates over object properties synchronously.
// // // forEach is not suitable for modifying the original array, while for loop and for of loop can modify the original array. For in loop is not suitable for modifying the original object, as it iterates over object properties synchronously.
// // // forEach is not suitable for returning values, while for loop and for of loop can return values. For in loop is not suitable for returning values, as it iterates over object properties synchronously.
// // //let vs var vs const
// // // let is block-scoped and can be reassigned, var is function-scoped and can be reassigned, and const is block-scoped and cannot be reassigned.
// // let x1 = 10;
// // var y1 = 20;
// // const z1 = 30;
// // console.log("Using let: " + x1);
// // console.log("Using var: " + y1);
// // console.log("Using const: " + z1);
// // // Arrow functions
// // const addNumbers = (a, b) => {
// //     return a + b;
// // };  
// // console.log("Sum using arrow function: " + addNumbers(5, 10));
// // // Template literals    
// // const name1 = "Alice";
// // const greeting = `Hello, ${name1}!`;
// // console.log(greeting);
// // // Destructuring assignment
// // const person1 = {
// //     firstName: "John",
// //     lastName: "Doe",
// //     age: 30
// // };
// // const { firstName, lastName, age } = person1;
// // console.log(`Name: ${firstName} ${lastName}, Age: ${age}`);
// // // Spread operator
// // const array1 = [1, 2, 3];
// // const array2 = [...array1, 4, 5];
// // console.log("Array after spreading: " + array2);
// // // Rest operator
// // const sum = (...numbers) => {
// //     return numbers.reduce((acc, num) => acc + num, 0);
// // }
// // console.log("Sum of numbers: " + sum(1, 2, 3, 4, 5));
// // // Default parameters
// // const multiplie = (a, b = 1) => {
// //     return a * b;
// // }

// // console.log("Multiplication with default parameter: " + multiplie(5)); // b defaults to 1
// // console.log("Multiplication with provided parameter: " + multiplie(5, 2)); // b is provided as 2
// // // Optional chaining    
// // const user = {
// //     name: "Alice",  
// //     address: {
// //         city: "New York"
// //     }
// // };
// // console.log("User's city: " + user.address?.city); // Safe access, will return undefined if address is not defined

// // //temprel deadzone
// // let tempVar;
// // try {   
// //     console.log(tempVar); // This will throw a ReferenceError because tempVar is not initialized
// // } catch (error) {
// //     console.error("Error: " + error.message);
// // }   
// // tempVar = "Initialized now";
// // console.log("TempVar after initialization: " + tempVar); // Now it will log the initialized value
// console.log("Sum of 10 and 20 is: " + sum(10, 20));
// // cannot access sum before its declaration due to temporal dead zone
// // const sum=(a, b) => {
// //     return a + b;
// // }
// //sum is not a function
// // var sum = (a, b) => {
// //     return a + b;
// // }
// function sum(a, b) {
//     return a + b;
// }


// const sum = (a, b) => {
//     return a + b;
// }
// const minus = (a, b) => {
//     return a - b;
// }
// const multiply = (a, b) => {
//     return a * b;
// }
// const divide = (a, b) => {
//     if (b === 0) {
//         throw new Error("Division by zero is not allowed.");
//     }
//     return a / b;
// }
// const callBackFunction = (callback, a, b) => {
//     return callback(a, b);
// }
// console.log("Sum of 10 and 20 is: " + callBackFunction(sum, 10, 20));
// console.log("Difference of 20 and 10 is: " + callBackFunction(minus, 20, 10));
// console.log("Product of 10 and 20 is: " + callBackFunction(multiply, 10, 20));
// console.log("Division of 20 by 10 is: " + callBackFunction(divide, 20, 10));
// This code defines a function `sum` that takes two parameters and returns their sum.
// Using the callback function to call sum

// class Calculator {
//     num1;
//     num2;
//     constructor(num1, num2) {
//         this.num1 = num1;
//         this.num2 = num2;
//     }
//     add() {
//         return this.num1 + this.num2;
//     }
//     subtract() {
//         return this.num1 - this.num2;
//     }
//     multiply() {
//         return this.num1 * this.num2;
//     }
//     divide() {
//         if (this.num2 === 0) {
//             throw new Error("Division by zero is not allowed.");
//         }
//         return this.num1 / this.num2;
//     }
//     callBackFunction(callback) {
//         return callback(this.num1, this.num2);
//     }
//     static staticMethod() {
//         console.log("This is a static method.");
//     }
//     static staticSum(a, b) {
//         return a + b;
//     }
//     static staticMinus(a, b) {
//         return a - b;
//     }
//     static staticMultiply(a, b) {
//         return a * b;
//     }
//     static staticDivide(a, b) {
//         if (b === 0) {
//             throw new Error("Division by zero is not allowed.");
//         }
//         return a / b;
//     }
//     static staticCallBackFunction(callback, a, b) {
//         return callback(a, b);
//     }
// }
// const calc = new Calculator(10, 20);
// console.log("Sum using class method: " + calc.add());
// console.log("Difference using class method: " + calc.subtract());
// console.log("Product using class method: " + calc.multiply());
// console.log("Division using class method: " + calc.divide());
// console.log("Sum using static method: " + Calculator.staticSum(10, 20));
// console.log("Difference using static method: " + Calculator.staticMinus(20, 10));
// console.log("Product using static method: " + Calculator.staticMultiply(10, 20));
// console.log("Division using static method: " + Calculator.staticDivide(20, 10));
// console.log("Sum using static callback function: " + Calculator.staticCallBackFunction(Calculator.staticSum, 10, 20));
// console.log("Difference using static callback function: " + Calculator.staticCallBackFunction(Calculator.staticMinus, 20, 10));
// console.log("Product using static callback function: " + Calculator.staticCallBackFunction(Calculator.staticMultiply, 10, 20));
// console.log("Division using static callback function: " + Calculator.staticCallBackFunction(Calculator.staticDivide, 20, 10));



// //splice and slice
// const array = [1, 2, 3, 4, 5];
// // Using splice to remove elements
// const removedElements = array.splice(1, 2); // Removes 2 elements starting from index 1
// console.log("Array after splice: " + array); // [1, 4, 5]
// console.log("Removed elements: " + removedElements); // [2, 3]
// // Using slice to create a new array
// const slicedArray = array.slice(1, 3); // Creates a new array from index
// console.log("Sliced array: " + slicedArray); // [4, 5]
// // Original array remains unchanged
// console.log("Original array after slice: " + array); // [1, 4, 5]
// // Using splice to add elements
// array.splice(1, 0, 2, 3); // Adds 2 and 3 at index 1
// console.log("Array after adding elements with splice: " + array); // [1, 2, 3, 4, 5]

// const sum=(...args)=>{
//     return args.reduce((acc, num) => acc + num, 0);
// }
// console.log("Sum of 1, 2, 3, 4, 5 is: " + sum(1, 2, true, 4, 5, "6")); // Will treat true as 1 and "6" as 6, resulting in 1 + 2 + 1 + 4 + 5 + 6 = 19

// const ar=args.filter(num=>num%2);
// const ar1=args.map(num=>num%2);
// console.log(ar1+" "+typeof ar1);
// console.log(ar + " " + typeof ar);
// console.log(args + " " + typeof args);

args = [1, 2, 3, 4, 5];
// Using filter to get odd numbers
const oddNumbers = args.filter(num => num % 2 !== 0);
console.log("Odd numbers: " + oddNumbers); // [1, 3, 5]
// Using map to create a new array with the square of each number
const squaredNumbers = args.map(num => num * num);
console.log("Squared numbers: " + squaredNumbers); // [1, 4, 9, 16, 25]
// Using reduce to calculate the sum of all numbers
const sumOfNumbers = args.reduce((acc, num) => acc * num, 1);
console.log("Sum of numbers: " + sumOfNumbers); // 15
// Using find to get the first even number
const firstEvenNumber = args.find(num => num % 2 === 0);
console.log("First even number: " + firstEvenNumber); // 2
// Using some to check if there are any even numbers
const hasEvenNumbers = args.some(num => num % 2 === 0);
console.log("Has even numbers: " + hasEvenNumbers); // true



console.log(args.reduce((acc,num)=>acc+num,0)); // 15



