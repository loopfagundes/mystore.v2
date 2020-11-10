package support;

import org.testng.annotations.DataProvider;

import java.io.File;
import java.util.Iterator;

public class DataClass {
    private FileOperations fileOperations = new FileOperations();
    private static final String csvFile = "src" + File.separator + "main" + File.separator + "resources" + File.separator + "data.csv";

    @DataProvider(name="loginCsv")
    public Iterator<Object[]> loginCsv() {
        return fileOperations.parseCsvData(csvFile);
    }
}