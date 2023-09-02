import java.io.UncheckedIOException;

class Main {
    public static void main(String[] args) {
        String fileName = "operation.txt";
        String resultFileName = "resultFile.txt";
        try {
            FileOperations fileoperations = new FileOperations();
            fileoperations.fileOperationsProcessing(fileName, resultFileName);
        } catch (UncheckedIOException e) {
            System.err.println("Nie znaleziono pliku");
        }
    }
}
