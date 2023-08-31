import java.io.*;
import java.util.*;

class FileOperations {

    public List<String> readFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scan = new Scanner(file);
        List<String> operations = new ArrayList<>();
        while (scan.hasNextLine()) {
            operations.add(scan.nextLine());
        }
        return operations;
    }

    public List<String> calculateOperations(List<String> operations) {
        List<String> results = new ArrayList<>();
        for (int i = 0; i < operations.size(); i++) {
            String[] operation = operations.get(i).split(" ");
            double num1 = Double.parseDouble(operation[0]);
            String operator = operation[1];
            double num2 = Double.parseDouble(operation[2]);
            double result = switch (operator) {
                case "+" -> num1 + num2;
                case "-" -> num1 - num2;
                case "*" -> num1 * num2;
                case "/" -> num1 / num2;
                default -> 0.0;
            };
            results.add(String.format("%.1f %s %.1f = %.1f", num1, operator, num2, result));
        }
        return results;
    }

    public void displayResults(List<String> results) {
        for (String result : results) {
            System.out.println(result);
        }
    }

    public void writeResultsToFile(List<String> results, String resultFileName) throws IOException {
        FileWriter file = new FileWriter(resultFileName);
        BufferedWriter writer = new BufferedWriter(file);
        for (int i = 0; i < results.size(); i++) {
            writer.write(results.get(i));
            if (i < results.size() - 1) {
                writer.newLine();
            }
        }
    }

    public void fileOperationsProcessing(String fileName, String resultFileName) throws IOException {
        List<String> calculationsList = calculateOperations(readFile(fileName));
        displayResults(calculationsList);
        writeResultsToFile(calculationsList, resultFileName);
    }

}

