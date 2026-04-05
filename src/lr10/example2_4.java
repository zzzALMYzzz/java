package lr10;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class example2_4{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean success = false;

        while (!success) {
            System.out.print("Введите путь к Excel-файлу (или 'exit' для выхода): ");
            String filePath = scanner.nextLine();

            if (filePath.equalsIgnoreCase("exit")) {
                break;
            }

            File file = new File(filePath);

            if (!file.exists()) {
                System.err.println("Ошибка: Файл не найден. Убедитесь, что путь указан верно.");
                continue;
            }
            if (!filePath.endsWith(".xlsx")) {
                System.err.println("Ошибка: Неправильный формат файла. Требуется файл с расширением .xlsx");
                continue;
            }

            try (FileInputStream inputStream = new FileInputStream(file); XSSFWorkbook workbook = new XSSFWorkbook(inputStream)) {
                System.out.print("Введите название листа (например, 'Товары'): ");
                String sheetName = scanner.nextLine();
                XSSFSheet sheet = workbook.getSheet(sheetName);

                if (sheet == null) {
                    System.err.println("Ошибка: Лист '" + sheetName + "' не найден в файле.");
                    System.out.println("Доступные листы:");
                    for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                        System.out.println("- " + workbook.getSheetName(i));
                    }
                    continue;
                }

                System.out.println("\nЧтение данных с листа '" + sheetName + "':\n");
                for (Row row : sheet) {
                    for (Cell cell : row) {
                        System.out.print(cell.toString() + "\t");
                    }
                    System.out.println();
                }
                success = true;

            } catch (FileNotFoundException e) {
                System.err.println("Ошибка доступа: Файл занят другим процессом или нет прав на чтение.");
            } catch (IOException e) {
                System.err.println("Ошибка ввода-вывода при чтении файла: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Критическая ошибка при обработке Excel: " + e.getMessage());
            }
        }
        scanner.close();
    }
}