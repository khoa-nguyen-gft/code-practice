class Calculator {
    constructor(){
        this.value = 0;
        this.history = [];
    }

    executeCommand(command){
        this.value = command.execute(this.value);
        this.history.push(command);
    }

    undoCommand(){
        let command = this.history.pop();
        this.value = command.undo(this.value);
    }



    // add(valueToAdd){
    //     this.value += valueToAdd;
    //     console.log("value: " + this.value);
    // }

    // subtract(valueToSubtract){
    //     this.value -= valueToSubtract;
    //     console.log("value: " + this.value);

    // }

    // multiply(valueToMultiply){
    //     this.value  += valueToMultiply;
    //     console.log("value: " + this.value);

    // }

    // divide(valueToDivide){
    //     this.value /= valueToDivide;
    //     console.log("value: " + this.value);

    // }
}

class SubtractCommand{
    constructor(valueToSubtract){
        this.valueToSubtract = valueToSubtract;
    }

    execute(currentValue){
       return currentValue -= this.valueToSubtract;
    }

    undo(currentValue){
        return currentValue += this.valueToSubtract;
    }
}


class AddCommand{
    constructor(valueToAdd){
        this.valueToAdd = valueToAdd;
        console.log(this.valueToAdd)
    }

    execute(currentValue){
       return currentValue + this.valueToAdd;
    }

    undo(currentValue){
        return currentValue - this.valueToAdd;
    }
}

const calculator  = new Calculator();
const addCommand = new AddCommand(20);
const subtractCommand = new SubtractCommand(2);

calculator.executeCommand(addCommand);
console.log(calculator.value);

calculator.executeCommand(subtractCommand);
console.log(calculator.value);
// calculator.add(10);
// calculator.divide(2);

