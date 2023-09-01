import java.io.*;
import java.util.*;

class FileOperations {

    public List<String> readFile(String fileName) {
        List<String> operations = new ArrayList<>();
        try (
                var file = new FileReader(fileName);
                var scan = new Scanner(file);
            ) {
            while (scan.hasNextLine()) {
                operations.add(scan.nextLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return operations;
    }

    private List<String> calculateOperations(List<String> operations) {
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
            results.add(String.format("%.2f %s %.2f = %.2f", num1, operator, num2, result));
        }
        return results;
    }

    private void displayResults(List<String> results) {
        for (String result : results) {
            System.out.println(result);
        }
    }

    private void writeResultsToFile(List<String> results, String resultFileName) {
        try (
                var file = new FileWriter(resultFileName);
                var writer = new BufferedWriter(file);
        ) {
            for (int i = 0; i < results.size(); i++) {
                writer.write(results.get(i));
                if (i < results.size() - 1) {
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void fileOperationsProcessing(String fileName, String resultFileName) throws IOException {
        List<String> operations = readFile(fileName);
        List<String> calculationsList = calculateOperations(operations);
        displayResults(calculationsList);
        writeResultsToFile(calculationsList, resultFileName);
    }

}

