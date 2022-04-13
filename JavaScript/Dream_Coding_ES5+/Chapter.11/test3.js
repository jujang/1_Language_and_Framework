'use strict';

let CCTV = false;
function catchingRob(a) {
    setTimeout(CCTV = true, a);
}

function cctvAct (time, x, y) {
    setInterval( new Promise((resolve, reject) => {
        if(CCTV === false) {
            resolve(x);
        } else {
            reject(y);
        }
    }), time);
}

catchingRob(5000);
cctvAct(2000, alert('완료'), '감시중').then(console.log).catch(console.log);