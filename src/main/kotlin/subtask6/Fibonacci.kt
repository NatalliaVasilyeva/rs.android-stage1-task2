package subtask6

class Fibonacci {

    // TODO: Complete the following function
    fun productFibonacciSequenceFor(n: Int): IntArray {
        var index = 0;
        while (getFibonacciNumber(index) * getFibonacciNumber(index+1)<n) {
            index++;
        }

        var firstNumber=getFibonacciNumber(index);
        var secondNumber=getFibonacciNumber(index+1);
        var result = firstNumber*secondNumber;

        return if (result == n){
            intArrayOf(firstNumber, secondNumber, 1);
        } else {
            intArrayOf(firstNumber, secondNumber, 0);
        }
    }

    fun getFibonacciNumber(n: Int): Int {
        var b = 1;
        var a = 0;
        var c: Int;
        if (n == 0)
            return a;
        if (n == 1)
            return b;
        for (number in 2..n) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}
