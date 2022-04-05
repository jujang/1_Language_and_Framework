'use strict';
let calcul = function calculate(command, a, b) {
    if(command === 'add'){
        return console.log(a + b);
    } else if (command === 'subtract') {
        return console.log(a - b);
    } else if (command === 'divide') {
        return console.log(a / b);
    } else if (command === 'multiply') {
        return console.log(a * b);
    } else if (command === 'remainder') {
        return console.log(a % b);
    } else {
        return console.log('wrong command!');
    }
}