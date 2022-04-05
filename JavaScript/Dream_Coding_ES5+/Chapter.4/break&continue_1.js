'use strict';
let i = 0;
while (i <= 10) {
    if(1 === (i%2)) {
        i++;
        continue;
    }
    console.log(`${i++} \n`);
}