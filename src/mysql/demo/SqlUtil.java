package mysql.demo;

import jxl.Sheet;

public class SqlUtil {
    public static String getInsertSql(Sheet tableSheet) {
        String tableName = tableSheet.getName();
        StringBuilder result1 = new StringBuilder(tableName.substring(0, tableName.length() - 5));
        StringBuilder result2 = new StringBuilder("values");
        result1.append("(");
        result2.append("(");
        for (int i = 0; i < tableSheet.getColumns(); i++) {
            result1.append(tableSheet.getCell(i, 0).getContents());
            result1.append(",");
            result2.append("?,");
        }
        result1.replace(result1.length() - 1, result1.length(), ")");
        result2.replace(result2.length() - 1, result2.length(), ")");

        return "insert into" + " " + result1 + " " + result2;
    }
}