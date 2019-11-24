package counter

import utils.FileManager
import java.util.*
import kotlin.collections.HashMap

class WordCounter {
    fun processText(){
        val frequency = getWordsFrequency()
        val numberOfCharacters = getNumberOfCharacters()
        val numberOfWords = getNumberOfWords(frequency)
        val sortedFrequency = frequency.toList().sortedByDescending { (_, value) -> value}.toMap()
        println("$numberOfWords words")
        println("$numberOfCharacters characters")
        for((key,value) in sortedFrequency){
            println("$key = $value")
        }
    }

    private fun getNumberOfCharacters(): Int {
        val textLines = FileManager().loadFile().bufferedReader().readLines()
        var characters = 0
        for(lines in textLines ){
            characters += lines.length
        }
        return characters
    }

    private fun getWordsFrequency():HashMap<String,Int>{
        val file = FileManager().loadFile().bufferedReader().readText().replace("\r\n"," ")
        val frequency = HashMap<String,Int>()
        val scanner = Scanner(file)
        var word : String
        scanner.useDelimiter(" +")
        while(scanner.hasNext()){
            word = scanner.next()
            if(!frequency.containsKey(word)){
                frequency[word] = 1
            }else{
                frequency[word] = frequency.getValue(word)+1
            }
        }
        return frequency
    }

    private fun getNumberOfWords(frequency: java.util.HashMap<String, Int>): Int {
        var count = 0
        for((word,apparitions) in frequency){
            count += apparitions
        }
        return count
    }
}