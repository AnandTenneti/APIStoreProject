package api.utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {
    @DataProvider(name = "Data")
    public String[][] getAllData() throws IOException {
        String path = System.getProperty("user.dir") + "//testData//UserData.xlsx";
        ExcelUtility excelUtility = new ExcelUtility(path);
        int rownum = excelUtility.getRowCount("Sheet1");
        int columnCount = excelUtility.getCellCount("Sheet1", 1);
        String apidata[][] = new String[rownum][columnCount];
        for (int i = 1; i <= rownum; i++) {
            for (int j = 0; j < columnCount; j++) {
                apidata[i - 1][j] = excelUtility.getCellData("Sheet1", i, j);
            }
        }
        return apidata;
    }

    @DataProvider(name = "UserNames")
    public String[] getUserNames() throws IOException {
        String path = System.getProperty("user.dir") + "//testData//UserData.xlsx";
        ExcelUtility excelUtility = new ExcelUtility(path);
        int rownum = excelUtility.getRowCount("Sheet1");

        String apidata[] = new String[rownum];
        for (int i = 1; i <= rownum; i++) {

            apidata[i - 1] = excelUtility.getCellData("Sheet1", i, 1);

        }
        return apidata;
    }
}
