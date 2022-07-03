'use strict';
{
    function fetchUser() {
        return new Promise((resolve, reject) => {
            //~~
            resolve('ellie');
        });
    }
    
    const user = fetchUser();
    user.then(console.log);
    console.log(user);
}

// 1. async
{
    async function fetchUser() {
        //~~
        return 'ellie';
    }

    const user = fetchUser();
    user.then(console.log);
    console.log(user);
}

// 2. await
{
    function delay(ms) {
        return new Promise(resolve => setTimeout(resolve, ms));
    }

    async function getApple() {
        await delay(3000);
        return 'apple';
    }
    async function getBanana() {
        await delay(3000);
        return 'banana';
    }
    function getBanana() {
        return delay(3000)
        .then(() => 'banana');
    }

    function pickFruits() {
        return getApple().then(apple => {
            return getBanana().then(banana => `${apple} + ${banana}`);
        });
    }
    pickFruits().then(console.log);


    async function pickFruits() {
        await getApple();
        return apple;
        /// 이 이후는 아직 잘 모르겠음..;;;
    }
}

function delay(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
}

async function getApple() {
    await delay(3000);
    return 1;
}
async function getBanana() {
    await delay(3000);
    return 'banana';
}

function pickFruits() {
    return getApple().then(apple => {
        apple++;
        return getBanana().then(banana => `${apple} + ${banana}`);
    });
}
pickFruits().then(console.log);




{
    let apple = 0;
    let tempFunc = function() {
        console.log(apple);
        return () => {
            apple++;
            console.log(apple);
            return () => {
                apple += 2;
                console.log(apple);
            }
        }
    }
    tempFunc()()();

    // 예상 출력
    // 0
    // 1
    // 3
    // 결과: 맞음!
}

{
    let apple = 0;
    // let step = 1;
    let tempFunc = function() {
        console.log(apple);
        return (step) => {
            // apple++;
            console.log(apple + step);
            return () => {
                // apple += 2;
                step++;
                console.log('step: '+ step);
                console.log(apple + step);
            }
        }
    }
    tempFunc()(0)();

}


//내가 헷갈리는 것
// abcde(console.log)
// 라는 함수가 존재할 때에
// ()안에 있는 것이
// 1.parameter인지
// 2.arrow function인데 나머지 다 생략되고 남은 구문인지 
// 헷갈림......

// pickFruits().then(console.log);
// pickFruits().then( () => console.log() );

// 내가 내린 결론: 전체가 파라미터인데 그 중에 콜백함수의 인자로 쓰이는 부분이 쓸데없이 중복되기에 생략된 것!