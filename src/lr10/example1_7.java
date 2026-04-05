package lr10;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class example1_7 {
    public static void main(String[] args) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(sheetname:"Товары");

        XSSFRow headerRow = sheet.createRow(rownum: 0);
        headerRow.createCell(0).setCellValue("Товар");
        headerRow.createCell(1).setCellValue("Характеристики");
        headerRow.createCell(2).setCellValue("Стоимость");

        Row dataRow1 = sheet.createRow(rownum: 1);
        dataRow1.createCell(0).setCellValue("Книга");
        dataRow1.createCell(1).setCellValue("Жанр: Фантастика, Автор: Иванов И.И.");
        dataRow1.createCell(2).setCellValue(500.0);

        Row dataRow2 = sheet.createRow(rownum: 2);
        dataRow2.createCell(0).setCellValue("Компьютер");
        dataRow2.createCell(1).setCellValue("Процессор: Intel Core i5, Операционная память: 25000.0");
        dataRow2.createCell(2).setCellValue(25000.0);

        String filePath = "/test/example3.xlsx";
        FileOutputStream outputStream = new FileOutputStream(filePath);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();

        System.out.println("Данные записаны в файл: " + filePath);
    }
}
