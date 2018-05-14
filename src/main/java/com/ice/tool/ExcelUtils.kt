package com.ice.tool

import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.ss.usermodel.CellType
import java.io.InputStream

object ExcelUtils {

    /**
     * 读取excel数据
     * @param inputStream 文件流
     * @param startRowIndex 有用数据开始行数，从0开始
     */
    fun readData(inputStream: InputStream, startRowIndex: Int): List<List<Any>> {
        val workbook = HSSFWorkbook(inputStream)
        val sheet = workbook.getSheetAt(0)
        val list = ArrayList<List<Any>>()
        for ((i, row) in sheet.withIndex()) {
            if (i > startRowIndex - 1) {
                val array = ArrayList<Any>()
                for (cell in row) {
                    if(cell.cellTypeEnum== CellType.NUMERIC){
                        array.add(cell.numericCellValue)
                    }else{
                        array.add(cell.stringCellValue)
                    }
                }
                list.add(array)
            }
        }
        return list
    }
}