'use strict';

let a = 0
function returnA () {
    setTimeout( () => a = 10, 2000);
}


function catch3(okSign, failSign) {
    return new Promise((resolve, reject) => {
        if(a === 10) {
            resolve(okSign);
        } else {
            reject(failSign);
        }
    }); 
}

returnA();
catch3('성공', '실패').then(console.log).catch(console.log);

// ~후에 특정 변수의 값을 변환하는(또는 콘솔에 특정 구문을 찍는) SetTimeout 수행문을 만듦
// 위의 수행이 제대로 완료된다면 완료를 로그에 찍기
// 수행이 실패한다면 실패를 로그에 찍기
