'use strict';

{
    let variable = 0;
    let watchCCTV = new Promise((resolve, reject) => {
        console.log('히!');
        if(variable >= 10) {
            resolve('발견 성공');
        } else {
            reject('특이사항 없음, 아직 감시중...');
        }
    });
    
    let timerId1 = setInterval( () => variable++, 500);
    let timerId2 = setInterval( () => watchCCTV.then(console.log).catch(console.log), 1000);
    setTimeout(clearInterval, 10000, timerId1);
    setTimeout(clearInterval, 10000, timerId2);

    // 이 방법은 나쁜 방식임, 왜냐하면 기본적으로 watchCCTV에 할당을 줄 때에 이미 promise객체가 생성되면서 내부 구현이 한 번 수행되기 때문임!
}

// 1단계
{
    let variable = 0;
    let watchCCTV = () => {
        return new Promise((resolve, reject) => {
            if(variable >= 10) {
                resolve('발견 성공');
            } else {
                reject('특이사항 없음, 아직 감시중...');
            }
        });
    }
    
    let timerId1 = setInterval( () => variable++, 500);
    let timerId2 = setInterval( () => watchCCTV().then(console.log).catch(console.log), 1000);
    setTimeout(clearInterval, 10000, timerId1);
    setTimeout(clearInterval, 10000, timerId2);

}

// 2단계
{
    let variable = 0;
    let watchCCTV = (sig) => {
        return new Promise((resolve, reject) => {
            console.log(sig);
            if(sig >= 10) {
                resolve('발견 성공');
            } else {
                reject('특이사항 없음, 아직 감시중...');
            }
        });
    }
    
    let timerId1 = setInterval( () => variable++, 500);
    let timerId2 = setInterval( (a) => watchCCTV(a).then(console.log).catch(console.log), 1000, variable);
    setTimeout(clearInterval, 10000, timerId1);
    setTimeout(clearInterval, 10000, timerId2);

    // 원했던 방식: setInterval에서 내가 check하고 싶은 변수값을 직접 지정해주고 그 값을 넘겨줘서 확인하게 할 것
    // 문제점이 꽤나 발생했었지만 한 개 뺴고 모두 해결했음!!
    // 마지막 남은 문제점은 실제 코드를 수행해보면 setInterval 함수는 인자의 값이 가변적이지 않고 코드가 작성된 시점의 값을 고정한 채로 x초 후에 넘겨주고 있음...
    // 이 부분은 지금까지 내가 배운 바로는 인자를 넘겨 주는 방법 중에서는 다른 방법이 없는 것으로 보임...
    // 일단은 1단계에서 직접 기술해주는 방식을 통해 우회해줘야겠음...
}

// 3단계
{
    let variable = 0;
    let watchCCTV = () => {
        return new Promise((resolve, reject) => {
            if(variable >= 10) {
                console.log('발견 성공');
                resolve();
            } else {
                reject('특이사항 없음, 아직 감시중...');
            }
        });
    }
    
    let timerId1 = setInterval( () => variable++, 500);
    let timerId2 = setInterval( () => watchCCTV().then(() => clearInterval(timerId2)).catch(console.log), 1000);
    setTimeout(clearInterval, 10000, timerId1);
    setTimeout(clearInterval, 10000, timerId2);

    // 1단계와 비교해서 개선하려고 하는 부분: 발견을 성공한 후(=resolve가 수행된 후),
    // 이후에는 setInterval을 수행하고 싶지 않음

    // 결과: 성공!
    // 의견: 될까 안 될까 엄청 걱정됐는데 되긴 되네...???
    // LValue보다 RValue가 먼저 쓰이는 상황인데 이거 자체는 JS에서는 문제가 되지 않나보다...;;
    // 그리고 then, catch에서도 읽자마다 수행이 아니고 나중 수행을 위해서는 arrow function을 사용하면 되는 것으로 보임
}