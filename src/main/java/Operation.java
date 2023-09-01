class Operation {
    private double num1;
    private String operator;
    private double num2;
    private double result;

    public Operation(double num1, String operator, double num2) {

        this.num1 = num1;
        this.operator = operator;
        this.num2 = num2;
        this.result = getResult();
    }

    private double getResult() {
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
