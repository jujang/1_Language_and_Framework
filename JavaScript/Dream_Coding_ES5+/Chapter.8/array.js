'use strict';

// Array

// 1. Declaration
const arr1 = new Array();
const arr2 = [1, 2];


// 2. Index position
const fruits = ['a', 'b'];
console.log(fruits);
console.log(fruits.length);
console.log(fruits[0]);
console.log(fruits[1]);
console.log(fruits[2]);
console.log(fruits[fruits.length - 1]);


// 3. Looping over an array
// print all fruits
// a. for
for(let i = 0; i < fruits.length; i++) {
    console.log(truits[i]);
}

// b. for of
for(let fruit of fruits) {
    console.log(fruit);
}

// c. forEach
fruits.forEach((fruit) => console.log(fruit));


// 4.Addition, deletion, copy
// push: add an item to the end
fruits.push('c', 'd');
console.log(fruits);

// pop: remove an tiem from the end
fruits.pop();
fruits.pop();
console.log(fruits);

// unshift: add an item to the beginning
fruits.unshift('e', 'f');
console.log(fruits);

// shift: remove an item from the beginning
fruits.shift();
fruits.shift();
console.log(fruits);

// note!! shift, unshift are slower than pop, push
// splice: remove an item by item position
fruits.push('g', 'h', 'i');
console.log(fruits);
fruits.splice(1, 1);
console.log(fruits);
fruits.splice(1, 1, 'j', 'k');
console.log(fruits);

// combine two arrays
const fruits2 = ['l', 'm'];
const newFruits = fruits.concat(fruits2);
console.log(newFruits);


// 5. Searching
// indexOf: find the index
console.log(fruits);
console.log(fruits.indexOf('a'));
console.log(fruits.indexOf('d'));
console.log(fruits.indexOf('x'));

// includes
console.log(fruits.includes('m'));
console.log(fruits.includes('x'));

// lastIndexOf
fruits.push('a');
console.log(fruits);
console.log(fruits.indexOf('a'));
console.log(fruits.lastIndexOf('a'));