import java.io.*;
import java.util.*;

class FileOperations {

    private List<Operation> readFile(String fileName) {
        List<Operation> operations = new ArrayList<>();
        try (
                var file = new FileReader(fileName);
                var scan = new Scanner(file);
            ) {
            while (scan.hasNextLine()) {
                String nextLine = scan.nextLine();
                String[] operation = nextLine.split(" ");
                double num1 = Double.parseDouble(operation[0]);
                double num2 = Double.parseDouble(operation[2]);
                String operator = operation[1];
                double result = Operation.getResult(num1, operator, num2);
                operations.add(new Operation(num1, operator, num2, result));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return operations;
    }

    private void displayResults(List<Operation> results) {
        for (Operation result : results) {
            System.out.println(result);
        }
    }

    private void writeResultsToFile(List<Operation> results, String resultFileName) {
        try (
                var file = new FileWriter(resultFileName);
                var writer = new BufferedWriter(file);
        ) {
            for (int i = 0; i < results.size(); i++) {
                writer.write(results.get(i).toString());
                if (i < results.size() - 1) {
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void fileOperationsProcessing(String fileName, String resultFileName) throws IOException {
        List<Operation> operations = readFile(fileName);
        displayResults(operations);
        writeResultsToFile(operations, resultFileName);
    }

}

