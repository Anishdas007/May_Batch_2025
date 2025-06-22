// const promise= new Promise((resolve, reject) => {
//   setTimeout(() => {
//     const success = false; // Simulate success or failure
//     if (success) {
//       resolve("Operation was successful!");
//     } else {
//       reject("Operation failed.");
//     }
//   }, 2000);
// });
// promise
//   .then((message) => {
//     console.log(message);
//   })
//   .catch((error) => {
//     console.error(error);
//   })
//   .finally(() => {
//     console.log("Promise has settled (either resolved or rejected).");
//   });

//   fetch('https://jsonplaceholder.typicode.com/users')
//       .then(response => response.json())
//       .then(data => {
//             console.log(data);
//       })
//       .catch(error => {
//         console.error('Error fetching users:', error);
//       });


// function greet(name) {
//   return function() {
//     console.log("Hello, " + name);
//   };
// }
// const sayHello = greet("Alice");
// sayHello();

// Array.prototype.cutomMap = function() {
//     const result = [];
//     for (let i = 0; i < this.length; i++) {
//         if(typeof this[i]=== 'number') {
//             result.push(this[i] ** 4);
//         }
//         else if (typeof this[i] === 'string') {
//             result.push(this[i].toUpperCase());
//         } else {
//             result.push(this[i]);
//         }
//     }
//     return result;
// }

// const arr = [3, 'hello', 5, 'world', true];
// const mappedArr = arr.cutomMap();
// console.log(mappedArr); // Output: [2, 'HELLO', 6, 'WORLD', true]

// let data;

// const fetchData=async ()=>{
//     try {
//         const response = await fetch('https://jsonplaceholder.typicode.com/users');
//         if (!response.ok) {
//             throw new Error('Network response was not ok');
//         }
//         data = await response.json();
//         console.log(data); 
//     } catch (error) {
//         console.error('Error fetching users:', error);
//     }
// }
// fetchData();

// const callBackhell = (callback) => {
//     setTimeout(() => {
//         console.log("Step 1 completed");
//         callback(() => {
//             setTimeout(() => {
//                 console.log("Step 2 completed");
//                 callback(() => {
//                     setTimeout(() => {
//                         console.log("Step 3 completed");
//                     }, 1000);
//                 });
//             }, 1000);
//         });
//     }, 1000);
// }
// callBackhell((nextStep) => {
//     nextStep();
// });



