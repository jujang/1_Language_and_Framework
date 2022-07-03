'use strict';

let repeatfunc1 = () => {
    return new Promise((resolve, reject) => {
        resolve('성공!');
    });
}
console.log(repeatfunc1);

// 그냥 변수를 출력하면 할당시킨 함수 자체가 출력됨
// ()를 넣고 출력하면 함수가 수행되고 promise 객체가 출력됨



let repeatfunc4 = () => {
    return new Promise((resolve, reject) => {
        console.log('하하하');
        resolve('성공!');
    });
}
// 함수 수행 시에 '하하하' 출력됨





let repeatfunc2 = new Promise((resolve, reject) => {
    resolve('성공!');
});

console.log(repeatfunc2);

// 그냥 변수를 출력하면 promise 객체가 출력됨
// ()를 넣으면 'not a function'이라는 에러구문이 뜸



let repeatfunc3 = new Promise((resolve, reject) => {
    console.log('호호호');
    resolve('성공!');
});
// repeatfunc3에 promise객체 할당과 동시에 '호호호'가 출력됨