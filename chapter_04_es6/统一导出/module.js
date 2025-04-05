 const  PI =3.14;  //属性


 function sum (num1,num2){//方法
    return num1+num2;}

//类

class  Person{
    constructor(name,age) {
        this.name = name;
        this.age = age;
    }


    get name() {
        return this.name;
    }

    set name(value) {
        this.name = value;
    }

    get age() {
        return this.age;
    }

    set age(value) {
        this.age = value;
    }
}
 export {PI,sum,Person}