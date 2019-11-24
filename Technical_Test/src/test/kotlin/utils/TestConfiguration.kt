package utils

import common.WC_PROPERTIES
import java.io.FileNotFoundException
import java.util.*

class TestConfiguration {
    fun loadWordCounterProperties(): Properties {
        val properties = Properties()
        try {
            val inputStream = this.javaClass.classLoader.getResource(WC_PROPERTIES)?.openStream()
            properties.load(inputStream)
        }catch (e :Exception){
            throw FileNotFoundException()
        }
        return properties
    }
}