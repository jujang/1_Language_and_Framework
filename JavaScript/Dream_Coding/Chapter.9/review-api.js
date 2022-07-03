'use strict';

// 이 파일은 array 부분에서 배운 각종 api를 내가 마음대로 사용해보면서 
// api의 의미와 반환값, 기존 배열에 끼친 영향들을 실험 및 정리한 것임


// class Student {
//     constructor(name, age, enrolled, score) {
//         this.name = name;
//         this.age = age;
//         this.enrolled = enrolled;
//         this.score = score;
//     }
// }
// const students = [
//     new Student('A', 29, true, 45),
//     new Student('B', 28, false, 80),
//     new Student('C', 30, true, 90),
//     new Student('D', 40, false, 66),
//     new Student('E', 18, true, 88),
// ];


// 'every'
// 채점결과: 맞음!!
// 기능: 전체 중에 맞는게 하나라도 있는지 확인함
// 반환값: 조건에 맞다면 true, 조건에 맞지 않다면 false
// 기존배열: 변화 없음
{
    class Student {
        constructor(name, age, enrolled, score) {
            this.name = name;
            this.age = age;
            this.enrolled = enrolled;
            this.score = score;
        }
    }
    const students = [
        new Student('A', 29, true, 45),
        new Student('B', 28, false, 80),
        new Student('C', 30, true, 90),
        new Student('D', 40, false, 66),
        new Student('E', 18, true, 88),
    ];

    const result = students.every((student) => student.enrolled == true); 
    // 내가 생각하는 함수의 의미 : 모든 학생의 등록 여부가 true인가?
    console.log(result);
    // 예상 출력1: false
    console.log(students);
    // 예상 출력2: 그대로

    let stud = ['A', 'B', 'C', 'D', 'E'];
    const result2 = stud.every((stud) => stud== 'A');
    console.log(result2);
    // 예상 출력: true
    console.log(stud);
    // 예상 출력: 그대로
}

// 'filter'
// 채점결과: 맞음!
// 기능: 인자로 콜백함수를 사용하는데 콜백함수의 조건에 맞는 것들을 묶어서 배열로 반환함
// 반환값: (조건에 맞는 원소들의) 배열
// 기존배열: 변화 없음
{
    class Student {
        constructor(name, age, enrolled, score) {
            this.name = name;
            this.age = age;
            this.enrolled = enrolled;
            this.score = score;
        }
    }
    const students = [
        new Student('A', 29, true, 45),
        new Student('B', 28, false, 80),
        new Student('C', 30, true, 90),
        new Student('D', 40, false, 66),
        new Student('E', 18, true, 88),
    ];

    const result = students.filter((student) => student.age < 30);
    // 내가 생각하는 함수의 의미 : 학생의 나이가 30보다 작은 원소들을 모두 배열로 묶어서 반환하시요
    console.log(result);
    // 예상 출력1: [Student, Student, Student]
    console.log(students);
    // 예상 출력2: 그대로

    let stud = ['A', 'B', 'C', 'D', 'E'];
    const result2 = stud.filter((stud) => stud == 'A');
    console.log(result2);
    // 예상 출력: ['A']
    console.log(stud);
    // 예상 출력: 그대로
}

// 'find'
// 채점결과: 맞음!
// 기능: 배열의 원소중 조건에 맞는 원소가 있는지 검색
// 반환값: (조건에 충족하는 첫번째) 원소 자체 or undefined
// 기존배열: 그대로
{
    class Student {
        constructor(name, age, enrolled, score) {
            this.name = name;
            this.age = age;
            this.enrolled = enrolled;
            this.score = score;
        }
    }
    const students = [
        new Student('A', 29, true, 45),
        new Student('B', 28, false, 80),
        new Student('C', 30, true, 90),
        new Student('D', 40, false, 66),
        new Student('E', 18, true, 88),
    ];

    const result = students.find((student) => student.enrolled === false);
    // 내가 생각하는 함수의 의미 : 배열의 원소중 enrolled의 값이 false인 것 중 첫번째 원소를 반환하시오
    console.log(result);
    // 예상 출력1: student ('B', ....);
    console.log(students);
    // 예상 출력2: 그대로

    let stud = ['A', 'B', 'C', 'D', 'E'];
    const result2 = stud.find((stud) => stud === 'A');
    console.log(result2);
    // 예상 출력: A
    console.log(stud);
    // 예상 출력: 그대로
}

// 'forEach'
// 채점결과: 맞음!
// 기능: 인자로 콜백함수를 사용하는 for문, 콜백함수 원소별로 특정한 수행을 함
// 반환값: undefined
// 기존배열: 변화 없음
{
    class Student {
        constructor(name, age, enrolled, score) {
            this.name = name;
            this.age = age;
            this.enrolled = enrolled;
            this.score = score;
        }
    }
    const students = [
        new Student('A', 29, true, 45),
        new Student('B', 28, false, 80),
        new Student('C', 30, true, 90),
        new Student('D', 40, false, 66),
        new Student('E', 18, true, 88),
    ];

    const result = students.forEach((student) => console.log(student));
    // 내가 생각하는 함수의 의미 : 배열의 원소들을 전부 돌아가면서 출력하시오
    console.log(result);
    // 예상 출력1: undefined
    console.log(students);
    // 예상 출력2: 그대로

    let stud = ['A', 'B', 'C', 'D', 'E'];
    const result2 = stud.forEach((stud) => console.log(stud));
    console.log(result2);
    // 예상 출력: undefined
    console.log(stud);
    // 예상 출력: 그대로

}

// 'join'
// 채점결과: 조금 틀림ㅠ
// 몰랐던 부분: 괄호의 역할
// 기능: 배열의 원소들을 합쳐서 하나의 문자열을 만듦 (괄호안에 들어가는 것으로 각각의 원소를 구분함, default값은 쉼표임)
// 반환값: 문자열
// 기존배열: 변화 없음
{
    let stud = ['A', 'B', 'C', 'D', 'E'];
    const result2 = stud.join(' ');
    // 내가 생각하는 함수의 의미 : 배열의 원소들을 합침 (원소 사이에 ' '(공백)을 넣어줌)
    console.log(result2);
    // 예상 출력: 'A B C D E'
    console.log(stud);
    // 예상 출력: 그대로
}

// 'map'
// 채점결과: 맞음!
// 기능: 배열의 원소들을 특정 연산에 따라 변화된 새로운 배열을 만들어서 반환함
// 반환값: (연산된) 배열
// 기존배열: 변화 없음
{
    class Student {
        constructor(name, age, enrolled, score) {
            this.name = name;
            this.age = age;
            this.enrolled = enrolled;
            this.score = score;
        }
    }
    const students = [
        new Student('A', 29, true, 45),
        new Student('B', 28, false, 80),
        new Student('C', 30, true, 90),
        new Student('D', 40, false, 66),
        new Student('E', 18, true, 88),
    ];

    const result = students.map((students) => students.score);
    // 내가 생각하는 함수의 의미 : 기존 배열에서 score값 만을 갖는 배열을 만듦
    console.log(result);
    // 예상 출력1: [45, 80, 90, 66, 88]
    console.log(students);
    // 예상 출력2: 그대로

}

// 'pop'
// 채점결과: 조금 틀림
// 틀린 부분: 반환된 원소는 배열이 아니라 그냥 원소 자체로 반환이 됨
// 잘 몰랐던 부분: const인 경우에도 원소를 제거하거나 추가는 가능함. 그저 재정의가 불가능할 뿐임
// 기능: 배열의 가장 끝 원소를 제거하고 해당 원소를 반환함
// 반환값: (배열이 아닌) 원소 자체
// 기존배열: (해당 원소가 제거되고 남은) 배열
{
    class Student {
        constructor(name, age, enrolled, score) {
            this.name = name;
            this.age = age;
            this.enrolled = enrolled;
            this.score = score;
        }
    }
    const students = [
        new Student('A', 29, true, 45),
        new Student('B', 28, false, 80),
        new Student('C', 30, true, 90),
        new Student('D', 40, false, 66),
        new Student('E', 18, true, 88),
    ];

    const result = students.pop();
    // 내가 생각하는 함수의 의미: 기존 배열에서 맨 뒤의 원소를 제거함 
    console.log(result);
    // 예상 출력1: Student { ~ }; //얘는 E인 Student임~
    console.log(students);
    // 예상 출력2: [Student, Student, Student, Student]  // E빼고 나머지~

}

// 'push'
// 채점결과: 틀림!
// 틀린 이유: push함수의 반환값을 잘못 알고 있었음...(undefined라고 생각하고 있었음)
// 기능: 배열의 끝에 새로운 원소를 추가함
// 반환값: 변경된 배열의 전체 길이
// 기존배열: 새로운 원소가 기존 배열에 추가됨
{
    class Student {
        constructor(name, age, enrolled, score) {
            this.name = name;
            this.age = age;
            this.enrolled = enrolled;
            this.score = score;
        }
    }
    const students = [
        new Student('A', 29, true, 45),
        new Student('B', 28, false, 80),
        new Student('C', 30, true, 90),
        new Student('D', 40, false, 66),
        new Student('E', 18, true, 88),
    ];


    const result = students.push(new Student('F', 30, false, 77));
    // 내가 생각하는 함수의 의미 : push안에 넣은 값을 student 배열의 맨 뒤에 원소로서 추가함
    console.log(result);
    // 예상 출력1: 6 
    console.log(students);
    // 예상 출력2: [Student, Student, Student, Student, Student, Student]  // F가 합쳐진 결과~

}

// 'reduce'
// 채점결과: 맞음!
// 기능: 특정 조건에 따라 각 원소들을 순회하면서 연산함, 특징으로 이전값을 가지고 있으면서 현재값을 연산에 사용할 수 있음
// 반환값: 콜백함수에 의한 연산 결과
// 기존배열: 변화 없음
{
    class Student {
        constructor(name, age, enrolled, score) {
            this.name = name;
            this.age = age;
            this.enrolled = enrolled;
            this.score = score;
        }
    }
    const students = [
        new Student('A', 29, true, 45),
        new Student('B', 28, false, 80),
        new Student('C', 30, true, 90),
        new Student('D', 40, false, 66),
        new Student('E', 18, true, 88),
    ];

    const result = students.reduce((prev, curr) => prev + curr.score, 0);
    // 내가 생각하는 함수의 의미 : 0을 초가겂으로 하여, 배열의 원소들을 모두 다 차례대로 조건에 따라 연산(score값을 합산함)하여 최종 결과를 반환함
    console.log(result);
    // 예상 출력1: 369
    console.log(students);
    // 예상 출력2: 그대로 

}

// 'reduceRight'
// 채점결과: 맞음!
// 기능: reduce와 같은 동작을 하지만 연산을 끝에서부터 반대 순서로 진행함
// 반환값: 콜백함수에 의한 연산 결과
// 기존배열: 변화 없음
{
    class Student {
        constructor(name, age, enrolled, score) {
            this.name = name;
            this.age = age;
            this.enrolled = enrolled;
            this.score = score;
        }
    }
    const students = [
        new Student('A', 29, true, 45),
        new Student('B', 28, false, 80),
        new Student('C', 30, true, 90),
        new Student('D', 40, false, 66),
        new Student('E', 18, true, 88),
    ];

    const result = students.reduceRight((prev, curr) => prev - curr.age, -10);
    // 내가 생각하는 함수의 의미 : -10을 초기값으로 갖고, 맨 끝 원소부터 첫 인덱스까지 (거꾸로) 차례대로 조건에 따라 연산(나이값 빼기)하고 결과값을 반환함
    console.log(result);
    // 예상 출력1: -155
    console.log(students);
    // 예상 출력2: 그대로 

}

// 'reverse'
// 채점결과: 툴림!
// 틀린 이유: 반환값이 어떻게 되는지 몰랐음 (undefined인 줄 알았음..;;)
// 기능: 배열을 뒤집음
// 반환값: (함수 수행 결과물인) 배열
// 기존배열: (수행 결과에 따라 뒤집힌) 배열
{
    let stud = ['A', 'B', 'C', 'D', 'E'];
    const result = stud.reverse();
    // 내가 생각하는 함수의 의미: 원본배열의 순서를 뒤집음  
    console.log(result);
    // 예상 출력1: ['E', 'D', 'C', 'B', 'A']
    console.log(stud);
    // 예상 출력2: ['E', 'D', 'C', 'B', 'A'] (원본 배열이 뒤집힘) 
}

// 'shift'
// 채점결과: 조금 틀림!
// 틀린 이유: 반환값이 어떤지 제대로 모름
// 기능: 첫번째(맨 왼쪽) 원소를 배열에서 제거하고 해당 원소를 반환함
// 반환값: (제거된) 원소 자체 or (제거할 원소가 없었다면) undefined
// 기존배열: (제거하고 남은) 배열
{
    class Student {
        constructor(name, age, enrolled, score) {
            this.name = name;
            this.age = age;
            this.enrolled = enrolled;
            this.score = score;
        }
    }
    const students = [
        new Student('A', 29, true, 45),
        new Student('B', 28, false, 80),
        new Student('C', 30, true, 90),
        new Student('D', 40, false, 66),
        new Student('E', 18, true, 88),
    ];

    let stud = ['A', 'B', 'C', 'D', 'E'];
    const result = stud.shift();
    // 내가 생각하는 함수의 의미: 첫번째(맨 왼쪽) 원소를 배열에서 제거하고 해당 원소를 반환함
    console.log(result);
    // 예상 출력1: A
    console.log(stud);
    // 예상 출력2: ['B', 'C', 'D', 'E'] 
}

{
    let stud = [];
    const result = stud.shift();
    console.log(result);
    console.log(stud);
}

// 'slice'
// 채점결과: 틀림!
// 틀린 이유: 원본 배열이 어떻게 되는지 제대로 몰랐음 (지정한 해당 범위가 제거된다고 알고있었음..ㅠ)
// 기능: 배열에서 지정 범위의 원소들을 복사하여 따로 배열을 만듦
// 반환값: (지정한 범위의 원소로 이루어진) 배열
// 기존배열: 변화 없음
{
    class Student {
        constructor(name, age, enrolled, score) {
            this.name = name;
            this.age = age;
            this.enrolled = enrolled;
            this.score = score;
        }
    }
    const students = [
        new Student('A', 29, true, 45),
        new Student('B', 28, false, 80),
        new Student('C', 30, true, 90),
        new Student('D', 40, false, 66),
        new Student('E', 18, true, 88),
    ];

    let stud = ['A', 'B', 'C', 'D', 'E'];
    const result = stud.slice(1, 3);
    // 내가 생각하는 함수의 의미 : 배열의 인덱스 값으로 1부터 3전 까지의 원소들을 복사하여 따로 배열을 만듦
    console.log(result);
    // 예상 출력1: ['B', 'C']
    console.log(stud);
    // 예상 출력2: ['A', 'B', 'C', 'D', 'E']

}

// 'some'
// 채점결과: 맞음!
// 기능: 기존 배열에서 콜백함수에서 조건에 충족하는 원소를 검색
// 반환값: 하나라도 있다면 true, 없다면 false
// 기존배열: 변화 없음
{
    class Student {
        constructor(name, age, enrolled, score) {
            this.name = name;
            this.age = age;
            this.enrolled = enrolled;
            this.score = score;
        }
    }
    const students = [
        new Student('A', 29, true, 45),
        new Student('B', 28, false, 80),
        new Student('C', 30, true, 90),
        new Student('D', 40, false, 66),
        new Student('E', 18, true, 88),
    ];

    const result = students.some((student) => student.age === 30);
    // 내가 생각하는 함수의 의미 : 기존 배열에서 학생의 나이가 30인 원소가 하나라도 있다면 true를 반환, 없다면 false를 반환
    console.log(result);
    // 예상 출력1: true
    console.log(students);
    // 예상 출력2: 그대로

}

// 'sort'
// 채점결과: 맞음!
// 기능: 기존의 배열을 콜백함수에서 정한 기준으로 정렬함 (default 기준은 문자 순서)
// 반환값: (정렬된) 배열
// 기존배열: (정렬된) 배열
{
    class Student {
        constructor(name, age, enrolled, score) {
            this.name = name;
            this.age = age;
            this.enrolled = enrolled;
            this.score = score;
        }
    }
    const students = [
        new Student('A', 29, true, 45),
        new Student('B', 28, false, 80),
        new Student('C', 30, true, 90),
        new Student('D', 40, false, 66),
        new Student('E', 18, true, 88),
    ];

    let stud = [45, 80, 90, 66, 88];
    const result = stud.sort((a, b) => a - b);
    // 내가 생각하는 함수의 의미 : 기존의 배열을 숫자값 기준으로 오름차순으로 정렬함
    console.log(result);
    // 예상 출력1: [45, 66, 80, 88, 90]
    console.log(stud);
    // 예상 출력2: [45, 66, 80, 88, 90] 
}

// 'splice'
// 채점결과: 완전히 틀림!
// 틀린 이유1: 원본 배열에 영향이 없다고 생각했음
// 틀린 이유2: 두번째 인자가 원소의 직후 범위라고 생각했음..; (그게 아니라 지정한 첫 원소로부터의 갯수임!)
// 기능: 배열의 지정한 범위부터 지정한 갯수의 원소들을 기존 배열에서 제거하고 따로 배열을 만듦
// 반환값: (지정한 범위의 원소들로 이루어진) 배열
// 기존배열: (지정한 범위의 원소들이 제거된) 배열
{
    class Student {
        constructor(name, age, enrolled, score) {
            this.name = name;
            this.age = age;
            this.enrolled = enrolled;
            this.score = score;
        }
    }
    const students = [
        new Student('A', 29, true, 45),
        new Student('B', 28, false, 80),
        new Student('C', 30, true, 90),
        new Student('D', 40, false, 66),
        new Student('E', 18, true, 88),
    ];

    let stud = ['A', 'B', 'C', 'D', 'E'];
    const result = stud.splice(1, 3);
    // 내가 생각하는 함수의 의미 : 배열의 인덱스 값으로 1부터 3개 까지의 원소들을 기존 배열에서 제거하고 따로 배열을 만듦
    console.log(result);
    // 예상 출력1: ['B', 'C', 'D']
    console.log(stud);
    // 예상 출력2: ['A', 'E']
}

// 'split'
// 채점결과: 맞음!
// 기능: 문자열을 괄호안에 넣어준 것을 기준으로 분리하여 각각을 원소로 하는 배열을 생성함
// 반환값: 배열
// 기존배열: (기존) 문자열
{
    class Student {
        constructor(name, age, enrolled, score) {
            this.name = name;
            this.age = age;
            this.enrolled = enrolled;
            this.score = score;
        }
    }
    const students = [
        new Student('A', 29, true, 45),
        new Student('B', 28, false, 80),
        new Student('C', 30, true, 90),
        new Student('D', 40, false, 66),
        new Student('E', 18, true, 88),
    ];

    let stud = 'A, B, C, D, E';
    const result = stud.split(', ');
    // 내가 생각하는 함수의 의미: 문자열을 ', '을 기준으로 분리하여 각각을 원소로 하는 배열을 생성함
    console.log(result);
    // 예상 출력1: ['A', 'B', 'C', 'D', 'E']
    console.log(stud);
    // 예상 출력2: 그대로~
}

// 'unshift'
// 채점결과: 틀림!
// 틀린 이유: 함수의 반환값을 잘 못 알았음 (undefined라고 생각했음)
// 기능: 괄호 안에 있는 것을 기존 배열의 첫번째 원소로 하고 나머지는 하나씩 인덱스를 높게 밀어버림
// 반환값: (수행 결과물인) 배열의 길이
// 기존배열: (원소가 추가된) 배열
{
    class Student {
        constructor(name, age, enrolled, score) {
            this.name = name;
            this.age = age;
            this.enrolled = enrolled;
            this.score = score;
        }
    }
    const students = [
        new Student('A', 29, true, 45),
        new Student('B', 28, false, 80),
        new Student('C', 30, true, 90),
        new Student('D', 40, false, 66),
        new Student('E', 18, true, 88),
    ];

    let stud = ['A', 'B', 'C', 'D', 'E'];
    const result = stud.unshift('Z');
    // 내가 생각하는 함수의 의미 : 괄호 안에 있는 것을 기존 배열의 첫번째 원소로 하고 나머지는 하나씩 인덱스를 높게 밀어버림
    console.log(result);
    // 예상 출력1: 6
    console.log(stud);
    // 예상 출력2: ['Z', 'A', 'B', 'C', 'D', 'E']
}
