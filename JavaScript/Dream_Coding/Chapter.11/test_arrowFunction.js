'use strict';

let kkk = (a, b) => {
    a = 5, b = 1;
    return a + b;
}
// return 이 있으므로 값 반환함

let jjj = (a, b) => {
    a = 5, b = 1;
    a + b;
}
// return 이 없으므로 값 반환하지 않음 (= undefined 반환)

let mmm = (a, b) => {a = 5, b = 1, a + b;}
// return 이 없으므로 값 반환하지 않음 (= undefined 반환)

let nnn = (a = 5, b = 1) => a + b;
// 한 줄로 표현할 경우, 중괄호가 없을 경우, 자동적으로 표현값을 반환함

console.log(kkk());
console.log(jjj());
console.log(mmm());
console.log(nnn());