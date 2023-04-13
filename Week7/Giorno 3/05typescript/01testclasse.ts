class Employee {
    name: string;
    age: number;
  
    constructor(name: string, age: number) {
      this.name = name;
      this.age = age;
    }
  
    hello() {
      return `Ciao, sono ${this.name} e ho ${this.age} anni.`;
    }
}
  
let marco = new Employee("Mario", 35);
console.log(marco.hello());

let age: number | string = 8;
age = "otto";

let person: [string, number] = ["Test", 1];

type Person = {
    name: string,
    age: number
};

function getPerson(): Person {
    return { name: "Giovanni Pace", age: 36 };
}

// Dichiarazione di una funzione utilizzando la sintassi delle funzioni di JavaScript
function hello(name: string): string {
  return `Ciao, ${name}!`;
}

// Dichiarazione di una funzione utilizzando la sintassi delle frecce
const add = (num1: number, num2: number): number => {
  return num1 + num2;
}


function greet(name: string, title?: string): string {
  if (title) {
    return `Ciao, ${title} ${name}!`;
  } else {
    return `Ciao, ${name}!`;
  }
}

console.log(greet("Giovanni Pace")); // Ciao, Giovanni Pace!
console.log(greet("Mario", "Sig.")); // Ciao, Sig. Mario!


function greet2(name: string, title: string = "Sig."): string {
  return `Ciao, ${title} ${name}!`;
}

console.log(greet2("Giovanni Pace")); // Ciao, Sig. Giovanni Pace!
console.log(greet2("Mario", "Dott.")); // Ciao, Dott. Mario!