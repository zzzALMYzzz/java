package lr10;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class example1_8 {
    public static void main(String[] args) throws IOException {
        String filePath = "/test/example3.xlsx";
        FileInputStream inputStream = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        var sheet = workbook.getSheet(name:"Товары");
        
        for(var row : sheet) {
            for(var cell : row) {
                System.out.print(cell.toString() + "\t");
            }
            System.out.println();
        }
        
        workbook.close();
        inputStream.close();
    }
}
