package Miscellaneous;

import java.io.IOException;

/**
 * An interface designed to support classes which may create some data the user
 * wants to export to a .csv file for use in excel.
 */
public interface CsvExportable {

    /**
     * exportObjects creates a .csv file from a list of objects and their associated fields.
     * Assume the method throws an IOException due to the use of fileReader or BufferedReader.
     * @return a message informing the user if the file was created.
     */
    String exportObjects(String fileName, String header) throws IOException;
}
