// 과제
// promise와 setInterval(와 그 형제들)을 사용해서 CCTV가 주기적 감시(및 이상 없음 알림)를 하다가 
// n초 후에 발견하고 경고 표시를 뛰워주고 알림이 멈추는 기능을 구현해 볼 것

'use strict';
{
    let variable = false;
    let timerId1 = setTimeout( () => variable = true, 5000);
    
    let watchCCTV = () => {
        return new Promise((resolve, reject) => {
            if(variable === true) {
                console.log('발견! 비상사태!!!');
                resolve();
            } else {
                reject('이상없음... 감시 중');
            }
        });
    }
    
    let timerId2 = setInterval( () => watchCCTV().then(() => clearInterval(timerId2)).catch(console.log), 1000);
    
    // setTimeout(clearTimeout, 10000, timerId1);
    // setTimeout(clearInterval, 10000, timerId2);

    setTimeout( () => clearTimeout(timerId1), 10000);
    setTimeout( () => clearInterval(timerId2), 10000);
}

