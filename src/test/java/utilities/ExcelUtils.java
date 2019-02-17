package utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;

/**
 * Read data in an Excel spreadsheet and return it as a collection of objects.
 * This is designed to facilitate for parameterized tests in JUnit that
 * get data from an excel spreadsheet.
 *
 */
public class ExcelUtils {

    /**
     * The contents of the spreadsheet, in a form compatible with JUnit 4 parameterized tests.
     */
    private Collection<Object[]> data;

    public ExcelUtils(final InputStream excelInputStream) throws IOException {
        this.data = loadFromSpreadsheet(excelInputStream);
    }

    public Collection<Object[]> getData() {
        return data;
    }

    private Collection<Object[]> loadFromSpreadsheet(final InputStream excelFile)
            throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook(excelFile);

        data = new ArrayList<>();
        Sheet sheet = workbook.getSheetAt(0);

        int numberOfColumns = countNonEmptyColumns(sheet);
        List<Object[]> rows = new ArrayList<>();
        List<Object> rowData = new ArrayList<>();

        for (Row row : sheet) {
            if (isEmpty(row)) {
                break;
            } else {
                rowData.clear();
                for (int column = 0; column < numberOfColumns; column++) {
                    Cell cell = row.getCell(column);
                    rowData.add(objectFrom(cell));
                }
                rows.add(rowData.toArray());
            }
        }
        return rows;
    }

    private boolean isEmpty(final Row row) {
        Cell firstCell = row.getCell(0);
        return ((firstCell == null) || (firstCell.getCellType() == CellType.BLANK));
    }

    /**
     * Count the number of columns, using the number of non-empty cells in the
     * first row.
     */
    private int countNonEmptyColumns(final Sheet sheet) {
        Row firstRow = sheet.getRow(0);
        return firstEmptyCellPosition(firstRow);
    }

    private int firstEmptyCellPosition(final Row cells) {
        int columnCount = 0;
        for (Cell cell : cells) {
            if (cell.getCellType() == CellType.BLANK) {
                break;
            }
            columnCount++;
        }
        return columnCount;
    }

    private Object objectFrom(final Cell cell) {
        Object cellValue;
        cell.setCellType(CellType.STRING);
        cellValue = cell.getStringCellValue();
        return cellValue;
    }
}
