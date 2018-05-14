package com.ice.tool

import java.io.File
import java.io.FileInputStream

fun main(args:Array<String>){
    print(GsonUtil.toJson(ExcelUtils.readData(FileInputStream(File("F:\\a.xls")),2)))
}