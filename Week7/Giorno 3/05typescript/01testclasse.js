var Employee = /** @class */ (function () {
    function Employee(name, age) {
        this.name = name;
        this.age = age;
    }
    Employee.prototype.hello = function () {
        return "Ciao, sono ".concat(this.name, " e ho ").concat(this.age, " anni.");
    };
    return Employee;
}());
var marco = new Employee("Mario", 35);
console.log(marco.hello());
var age = 8;
age = "otto";
var person = ["Test", 1];
function getPerson() {
    return { name: "Giovanni Pace", age: 36 };
}
