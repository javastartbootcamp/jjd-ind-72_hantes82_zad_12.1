import java.io.IOException;
import java.util.List;

class Main {
    public static void main(String[] args) throws IOException {
        String fileName = "/Users/konrad/Downloads/testFile.txt";
        String resultFileName = "/Users/konrad/Downloads/resultFile.txt";
        FileOperations fileoperations = new FileOperations();
        fileoperations.fileOperationsProcessing(fileName, resultFileName);
    }
}