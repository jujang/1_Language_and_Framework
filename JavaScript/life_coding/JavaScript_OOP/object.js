'use strict';
{
    let kim = {name:'kim', first:10, second:20};
    let lee = {name:'lee', first:10, second:10};
    function sum() {
        return this.first+this.second;
    }
    console.log('sum.call(kim) ', sum.call(kim));
    console.log('sum.call(lee) ', sum.call(lee));
}


{
    let kim = {name:'kim', first:10, second:20};
    let lee = {name:'lee', first:10, second:10};
    function sum(prefix) {
        return prefix + (this.first + this.second);
    }
    console.log('sum.call(kim)', sum.call(kim, '=> '));
    console.log('sum.call(lee)', sum.call(lee, ': '));
}

{
    let kim = {name:'kim', first:10, second:20};
    function sum(prefix) {
        return prefix + (this.first + this.second);
    }

    let kimSum = sum.bind(kim, '-> ');
    console.log('kimSum()', kimSum());
}






//class를 사용하여 상속을 구현한 code
{
    class Person{
        constructor(name, first, second) {
            this.name = name;
            this.first = first;
            this.second = second;
        }
        sum() {
            return this.first+this.second;
        }
    }
    class PersonPlus extends Person{
        constructor(name, first, second, third) {
            super(name, first, second);
            this.third = third;
        }
        sum() {
            return super.sum() + this.third;
        }
        avg() {
            return (this.first + this.second + this.third)/3;
        }
    }

    let kim = new PersonPlus('kim', 10, 20, 30);
    console.log('kim.sum()', kim.sum());
    console.log('kim.avg()', kim.avg());
}



// class를 사용하지 않고 상속을 사용한 code (__proto__ 사용)
{
    function Person(name, first, second) {
        this.name = name;
        this.first = first;
        this.second = second;
    }
    Person.prototype.sum = function() {
        return this.first + this.second;
    }

    function PersonPlus(name, first, second, third) {
        Person.call(this, name, first, second);
        this.third = third;
    }

    PersonPlus.prototype.__proto__ = Person.prototype;
    PersonPlus.prototype.sum = function () {
        return Person.prototype.sum.call(this)+this.third;
        };
    PersonPlus.prototype.avg = function() {
        return (this.first+this.second+this.third)/3;
    }

    let kim = new PersonPlus('kim', 10, 20, 30);
    console.log('kim.sum()', kim.sum());
    console.log('kim.avg()', kim.avg());
}


// class를 사용하지 않고 표준에 맞게 상속을 사용한 code
{
    function Person(name, first, second){
        this.name = name;
        this.first = first;
        this.second = second;
    }
    Person.prototype.sum = function(){
        return this.first + this.second;
    }
    
    function PersonPlus(name, first, second, third){
        Person.call(this, name,first,second);
        this.third = third;
    }
    
    PersonPlus.prototype = Object.create(Person.prototype);
    PersonPlus.prototype.constructor = PersonPlus;
    PersonPlus.prototype.sum = function () {
        return Person.prototype.sum.call(this)+this.third;
        };
    PersonPlus.prototype.avg = function(){
        return (this.first+this.second+this.third)/3;
    }
    
    var kim = new PersonPlus('kim', 10, 20, 30);
    console.log("kim.sum()", kim.sum());
    console.log("kim.avg()", kim.avg());
    console.log('kim.constructor', kim.constructor);
}