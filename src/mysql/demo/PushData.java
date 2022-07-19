package mysql.demo;

import jxl.Cell;
import jxl.Sheet;

import java.io.FileNotFoundException;
import java.sql.*;

public class PushData {
    public static void pushData(Sheet tableSheet) throws SQLException, FileNotFoundException {

        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (Exception e){
            e.printStackTrace();
        }

        Connection c = ConnectToDatabase.getConnection();
        Cell[][] cells = new Cell[tableSheet.getRows()][tableSheet.getColumns()];

        try {
            for (int i=0; i<tableSheet.getRows(); i++) {
                for (int j=0; j<tableSheet.getColumns(); j++) {
                    cells[i][j] = tableSheet.getCell(j,i);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        String insertSql = SqlUtil.getInsertSql(tableSheet);
        PreparedStatement ps = c.prepareStatement(insertSql);
        for (int i=1; i<tableSheet.getRows(); i++) {
            for (int j=0; j<tableSheet.getColumns(); j++) {
                if (cells[i][j].getContents().equals("NULL")) {
                    ps.setNull(j+1,Types.INTEGER);
                } else {
                    ps.setString(j+1, cells[i][j].getContents());
                }
            }
            ps.execute();
        }
    }
}
