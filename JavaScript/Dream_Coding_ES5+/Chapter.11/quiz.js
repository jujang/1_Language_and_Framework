'use strict';

// 1. id & password 입력받기
// 2. 입력된 값으로 판단하여 로그인 처리하기
// 3. roles..?? 수행하기
// 4. ...???


class UserStorage {
    loginUser(id, password, onSuccess, onError) {
        setTimeout( () => {
            if(
                (id === 'ellie' && password === 'dream') || (id === 'coder' && password === 'academy')
            ) {
                onSuccess(id);
            } else {
                onError(new Error('not found'));
            }
        }, 2000);
    }

    getRoles(user, onSuccess, onError){
        setTimeout(() => {
            if(user === 'ellie') {
                onSuccess({name: 'ellie', role: '3 min'});
            } else {
                onError(new Error('no access'));
            }
        }, 1000);
    }
}

const userStorage = new UserStorage();
const id = prompt('enter your id');
const password = prompt('enter your password');
userStorage.loginUser(
    id, 
    password, 
    user => {
        userStorage.getRoles(
            user,
            userWithRole => {
                alert(`Hello ${userWithRole.name}, you have a ${userWithRole.role} role`);
            },
            error => {
                console.log(error);
            }
        );
    },
    error => {
        console.log(error);
    }
);