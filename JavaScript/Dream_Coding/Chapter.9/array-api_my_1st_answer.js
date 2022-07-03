// Q1. make a string out of an array
{
    const fruits = ['apple', 'banana', 'orange'];
    let str = '';
    for (strfruit of fruits){
        str += strfruit;
        str += ' ';
    }
    console.log(str);
}


// Q2. make an array out of a string
{
    const fruits = '🍎, 🥝, 🍌, 🍒';
    let fr = [];

    for(fruit of fruits){
        if(fruit != ' ' && fruit != ','){
            fr.push(fruit);
        }
    }
    console.log(fr);
}


// Q3. make this array look like this: [5, 4, 3, 2, 1]
{
    const array = [1, 2, 3, 4, 5];
    let arr = array.sort((a, b) => b-a);
    console.log(arr);
}


// Q4. make new array without the first two elements
{
    const array = [1, 2, 3, 4, 5];
    array.shift();
    array.shift();
    console.log(array);
}


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

// Q5. find a student with the score 90
{
    for(stu of students) {
        if(stu.score == 90) {
            console.log(stu.name);
        }
    }
}
// 근데 왜 여기에서 stu[score]를 쓸 수가 없는거지...?? 
// stu 자체는 배열의 원소이고, stu[score]는 해당 배열(오브젝트)의 프로퍼티에 접근하는 거니까 [score]를 해도 되지 않나..??
// -> 왜냐하면 그건 내가 작은 따옴표를 안 썼기 때문입니다~....ㅠㅠ
// stu['score'] 이런 식으로 써야합니다~

// Q6. make an array of enrolled students
{
    let enroller = [];
    for(stu of students) {
        if(stu.enrolled == true) {
            enroller.push(stu);
        }
    }
    for(enroll of enroller) {
        console.log(enroll.name);
    }
}

// Q7. make an array containing only the students' scores
// result should be: [45, 80, 90, 66, 88]
{
    let scorer = [];
    for(stu of students) {
        scorer.push(stu.score);
    }
    console.log(scorer);
}

// Q8. check if there is a student with the score lower than 50
{
    for(stu of students) {
        if(stu.score < 50) {
            console.log(stu.name);
        }
    }
}

// Q9. compute students' average score
{
    let sum = 0;
    let scor = [];
    for(stu of students) {
        sum += stu.score;
        scor.push(stu.score);
    }
    let avg = sum/scor.length;
    console.log(avg);
}



// Q10. make a string containing all the scores
// result should be: '45, 80, 90, 66, 88'
{
    let scor = '';
    for(stu of students) {
        scor += stu.score;
        if(stu != students[students.length-1]){
            scor += ', ';
        }
    }
    console.log(scor);
}

// Bonus! do Q10 sorted in ascending order
// result should be: '45, 66, 80, 88, 90'
{
    let arr = [];
    for(stu of students){
        arr.push(stu.score);
    }
    arr.sort((a, b) => a-b);
    console.log(arr);
    let str = ' ';
    for(sco of arr) {
        str += sco;
        if(sco != arr[arr.length-1]){
            str += ', ';
        }
    }
    console.log(str);
}