class Calculator {
    constructor(){
        this.value = 0;
    }

    add(valueToAdd){
        this.value += valueToAdd;
        console.log("value: " + this.value);
    }

    subtract(valueToSubtract){
        this.value -= valueToSubtract;
        console.log("value: " + this.value);

    }

    multiply(valueToMultiply){
        this.value  += valueToMultiply;
        console.log("value: " + this.value);

    }

    divide(valueToDivide){
        this.value /= valueToDivide;
        console.log("value: " + this.value);

    }
}


const calculator  = new Calculator();
calculator.add(10);
calculator.divide(2);

