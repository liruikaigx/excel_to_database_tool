package mysql.demo;

import java.io.File;
import java.io.IOException;
import java.sql.*;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class PushExcelToMysql {
    public static void main(String[] args) throws BiffException, IOException, SQLException {
        Workbook workbook;
        Sheet address, customer, customerAddress, product, productCategory, productDescription, productModel, pmpd, salesOrder;

        workbook = Workbook.getWorkbook(new File("/Users/ruikai.lithoughtworks.com/Documents/project/toMySQL/resourses/data.xls"));
        address = workbook.getSheet(0);
        customer = workbook.getSheet(1);
        customerAddress = workbook.getSheet(2);
        product = workbook.getSheet(3);
        productCategory = workbook.getSheet(4);
        productDescription = workbook.getSheet(5);
        productModel = workbook.getSheet(6);
        pmpd = workbook.getSheet(7);
        salesOrder = workbook.getSheet(8);

        PushData.pushData(salesOrder);
        System.out.println("ok");
    }
}
