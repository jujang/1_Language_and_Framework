'use strict';

const arr = ['ugi-', 'uni-', 'CmGh', 'Sang-yeop'];
const str = 'ugi- meets uni- yesterday';

let json = JSON.stringify(arr);
console.log(json);

let json2 = JSON.stringify(str);
console.log(json2);

// 1. 클래스 선언하는 법을 모름...;;
// 2. 클래스의 객체 생성하는 법은..??


// 3. 그럼 그냥 일반 객체 생성하는 법은..?? ㅅㅂ... 이것도 모르겠음...ㅠ

// 최초 시도 버전
// let human  = {
//     this.name = 'ugi',
//     this.age = ''
// }

let hum = {
    name: 'ugi',
    age: '29',
    personality: 'lazy',
    behavior: function shoutOut() {
        console.log('hey!');
    }
}

console.log(hum);
let jsonHum = JSON.stringify(hum);
console.log(jsonHum);



{
    class Person {
        constructor(name, age, personality) {
            this.name = name;
            this.age = age;
            this.personality = personality;
        }
        shoutOut(someOne) {
            console.log(`Hey, ${someOne}! `);
        }
    
        // get age() {
        //     return this.age;
        // }
        // set age(value) {
        //     if(value < 0) {
        //         console.log('you type wrong age!');
        //         this._age = 0;
        //     } else {
        //         this._age = value;
        //     }
        // }
        // getter, setter를 사용하면 기존의 key값으로는 접근할 수 없는 경우들이 있기에 일단은 getter&setter을 주석처리함
        // 게다가 잘 생각해보면 굳이 getter&setter 사용하지 않아도 key의 value 조정이 가능한 거 같은데..?
    }
    
    let npc1 = new Person('jujang', 30, 'lazy');
    console.log(npc1);
    npc1.shoutOut('Go-woon');


    let npc1toJSample = JSON.stringify(npc1);
    console.log(npc1toJSample);

    let npc1back = JSON.parse(npc1toJSample);
    console.log(npc1back);


    let npc1toJ = JSON.stringify(npc1, (key, value) => {
        return key === 'age' ? value = 1 : value;
    });
    console.log(npc1toJ);

    let npc1toJback = JSON.parse(npc1toJ);
    console.log(npc1toJback);

    let npc1toJbackwrevive = JSON.parse(npc1toJ, );
    console.log(npc1toJbackwrevive);

    // let npc2 = new Person('Go-woon', -2, 'cheerful');
    // console.log(npc2);
    // npc2.shoutOut('jujang');

    // // let npc2toJ = JSON.stringify(npc2, (person) => person.age -= 1);
    // let npc2toJ = JSON.stringify(npc2);
    // console.log(npc2toJ);

    // let npc2back = JSON.parse(npc2toJ);
    // console.log(npc2back);
}

{
    let human = {name: 'jujang', age: 30, personality: 'lazy'};
    console.log(human);
    let human2json = JSON.stringify(human, (key, value) => {
        return key === 'age' ? value = 1 : value;
    });
    console.log(human2json);

    let humanback = JSON.parse(human2json, (key, value) => {
        return key === 'age' ? value = 10 : value;
    });
    console.log(humanback);
}



