import java.io.File
import kotlinx.coroutines.*

const val wordsFilePath = "src/main/resources/words.txt"
const val pollFilePath = "src/main/resources/poll.txt"

class Game {

    private val words: List<String> = File(wordsFilePath).readLines()
    private var mainWord: String = ""
    private var score: Int = 0
    private var correctWords = ArrayList<String>()

    init {
        File(pollFilePath).printWriter().print("")
    }

    private val checks = arrayOf(
        { word -> word.toSet().all { it in mainWord } },
        { word: String -> word in words },
        { word: String -> word !in correctWords }
    )

    private fun getWord() : String {
        var word: String
        do {
            word = words.random()
        } while (word.length < 7)

        return word
    }

    private fun updateResults(word: String) {
        if (checks.all { it(word) }) {
            score += word.toSet().size
            correctWords.add(word)
            println("Score was updated. Current score: $score")
        }
    }

    private fun dumpInputEntry(word: String) {
        File(pollFilePath).appendText("$word\n")
    }

    fun start() {
        mainWord = getWord()
        println("Your word is: $mainWord")
        println("Construct new words from this:")

        generateSequence(::readLine).forEach {
            val word = it
            runBlocking {
                launch {
                    updateResults(word)
                    dumpInputEntry(word)
                }
            }
        }

        println("Game ended. Total score: $score, num of correct words: ${correctWords.size}")
    }
}