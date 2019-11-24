package utils

import java.io.BufferedReader
import java.io.FileNotFoundException
import java.io.InputStream
import java.net.URL

class FileManager {

    fun loadFile() : InputStream {
        var inputStream : InputStream ?= null
        try{
             inputStream = javaClass.classLoader.getResourceAsStream("ArchivoPrueba.txt")
        }catch (e: Exception){
            throw FileNotFoundException() as Throwable
        }
        return inputStream
    }


}