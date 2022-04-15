'use strict';

let moving = false;
setTimeout( () => {
    moving = true
    console.log('이동 시작!')

}, 5000);


let watchCCTV = () => {
    return new Promise((resolve, reject) => {
        if(moving === true) {
            resolve('발견!');
        } else {
            reject('특이사항 없음, 감시중...');
        }
    });
}


setInterval (() => watchCCTV().then(console.log).catch(console.log), 1000);
// setTimeout( () => watchCCTV().then(console.log).catch(console.log), 1000);
// setTimeout( () => watchCCTV().then(console.log).catch(console.log), 2000);
// setTimeout( () => watchCCTV().then(console.log).catch(console.log), 3000);
// setTimeout( () => watchCCTV().then(console.log).catch(console.log), 4000);
// setTimeout( () => watchCCTV().then(console.log).catch(console.log), 5000);


{
    let moving = false;
    setTimeout( () => {
        moving = true
        console.log('이동 시작!')
    }, 5000);


    let watchCCTV = () => {
        return new Promise((resolve, reject) => {
            console.log('히!');
            if(moving === true) {
                resolve('발견!');
            } else {
                reject('특이사항 없음, 감시중...');
            }
        });
    }

    setInterval (() => watchCCTV().then(console.log).catch(console.log), 1000);
}


{
    let moving = false;
    setTimeout( () => {
        moving = true
        console.log('이동 시작!')
    
    }, 5000);
    
    
    let watchCCTV2 = new Promise((resolve, reject) => {
        if(moving === true) {
            resolve('발견!');
        } else {
            reject('특이사항 없음, 감시중...');
        }
        console.log('히!');
    });
    


    // watchCCTV2.then(console.log).catch(console.log);
    // setInterval (watchCCTV2.then(console.log).catch(console.log), 1000);
    setTimeout(watchCCTV2.then(console.log).catch(console.log), 1000);
    setTimeout(watchCCTV2.then(console.log).catch(console.log), 2000);
    setTimeout(watchCCTV2.then(console.log).catch(console.log), 3000);
    setTimeout(watchCCTV2.then(console.log).catch(console.log), 4000);
    setTimeout(watchCCTV2.then(console.log).catch(console.log), 5000);
    setTimeout(watchCCTV2.then(console.log).catch(console.log), 6000);
    setTimeout(watchCCTV2.then(console.log).catch(console.log), 7000);
}




{
    function sayHi(who, phrase) {
        alert( who + ' 님, ' + phrase );
    }
    
    setTimeout(sayHi, 1000, "홍길동", "안녕하세요.");
    // 홍길동 님, 안녕하세요.    
}

{
    function sayHi(who, phrase) {
        alert( who + ' 님, ' + phrase );
    }
    
    setTimeout(() => sayHi, 1000, "홍길동", "안녕하세요.");
    // 홍길동 님, 안녕하세요.    
}
