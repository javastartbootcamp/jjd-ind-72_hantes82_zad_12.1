class Operation {
    double num1;
    String operator;
    double num2;
    double result;

    public Operation(double num1, String operator, double num2, double result) {

        this.num1 = num1;
        this.operator = operator;
        this.num2 = num2;
        this.result = getResult(num1, operator, num2);
    }

    public static double getResult(double num1, String operator, double num2) {
        double result = switch (operator) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> num1 / num2;
            default -> 0.0;
        };
        return result;
    }

    @Override
    public String toString() {
        return num1 + " " + operator + " " + num2 + " = " + result;

    }
}
