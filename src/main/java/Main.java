import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        String fileName = "operations.txt";
        String resultFileName = "resultFile.txt";
        FileOperations fileoperations = new FileOperations();
        fileoperations.fileOperationsProcessing(fileName, resultFileName);
        }
}
