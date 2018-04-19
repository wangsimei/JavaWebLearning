package com.kittycoder.easydemo;

import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by shucheng on 2018/4/19.
 * 06 单元格样式
 */
public class CellStyle {

    public static void main(String[] args) throws Exception {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadsheet = workbook.createSheet("cellstyle");

        XSSFRow row = spreadsheet.createRow(1);
        row.setHeight((short) 800);

        XSSFCell cell = (XSSFCell) row.createCell((short)1);
        cell.setCellValue("test of merging"); // 测试单元格合并
        spreadsheet.addMergedRegion(new CellRangeAddress(
                1, // 起始行
                1, // 结束行
                1, // 起始列
                4 // 结束列
        )); // 从2行2列至2行5列（即2B至2）的区域做合并操作

        // 设置行高
        row = spreadsheet.createRow(5); // 创建第6行
        cell = row.createCell(0); // 创建第6行A列
        row.setHeight((short)800); // 设置行高为800

        // 单元格对齐（top left alignment）
        // XSSFCellStyle style1 = workbook.createCellStyle();
        // spreadsheet.setColumnWidth(0, 8000); // 将电子表格A列的宽度设置为8000

        // 将数据通过文件流写入硬盘
        FileOutputStream out = new FileOutputStream(new File("cellstyle.xlsx"));
        workbook.write(out);
        out.close();
        System.out.println("文件写入成功！");

    }
}
