package com.ice.tool

import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.ss.usermodel.CellType
import java.io.*
import java.util.LinkedHashMap

object ExcelUtils {

    /**
     * 读取excel数据xls
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

    @Suppress("unused")
            /**
     *
     * @param filePath 生成的excel文件路径和名称
     * @param maps 数据最好不要为null或者size为0,map的键值为excel的第一行标题
     * @return 成功或失败
     */
    fun toExcel(filePath: String, maps: List<LinkedHashMap<String, String>>): Boolean {
        @Suppress("SENSELESS_COMPARISON")
        if ("" == filePath) {
            return false
        }
        if (maps.isEmpty()) {
            return false
        }
        val workbook = HSSFWorkbook()
        val sheet = workbook.createSheet("Sheet1")
        val rowTitle = sheet.createRow(0)
        val mapTitle = maps[0]
        for ((cellTitleCount, s) in mapTitle.keys.withIndex()) {
            val cell = rowTitle.createCell(cellTitleCount)
            cell.setCellValue(s)
        }
        var rowNum = 1
        for (map in maps) {
            val row = sheet.createRow(rowNum++)
            for ((colNum, s) in map.values.withIndex()) {
                val cell = row.createCell(colNum)
                cell.setCellValue(s)
            }
        }
        try {
            val file = File(filePath)
            if (file.exists()) {
                file.delete()
            }
            file.parentFile.mkdirs()
            file.createNewFile()
            val outputStream = FileOutputStream(file)
            workbook.write(outputStream)
            workbook.close()
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return true
    }
}