package subtask4

class Pangram {

    val arrayOfVowels = listOf('a', 'e', 'i', 'o', 'u', 'y')

    fun getResult(inputString: String): String {
        return if (isPangram(createCharSet(inputString))) {
            takeRusultIsPangramSentence(inputString).joinToString(" ")
        } else
            takeRusultIsNotPangramSentence(inputString).joinToString(" ")
    }


    private fun isPangram(set: Set<Char>): Boolean {
        return set.size == 26
    }

    private fun createCharSet(sentences: String): Set<Char> {
        return sentences.toLowerCase()
            .replace("[^a-zA-Z]".toRegex(), "")
            .toSet()
    }

    private fun splitString(inputString: String): List<String> {
        return inputString.split(" ")
            .filter { it.isNotBlank() }
    }

    private fun takeRusultIsPangramSentence(sentence: String): List<String> {
        val splittedArrayOfWords = splitString(sentence);
        val listOfWords = mutableListOf<String>()
        for (eachWord in splittedArrayOfWords) {
            var numberOfVoweInWord = 0;
            var newWord = "";
            for (eachChar in eachWord) {
                newWord += if (eachChar.isLetter() && (arrayOfVowels.contains(eachChar)
                            || (arrayOfVowels.contains(eachChar.toLowerCase())))
                ) {
                    numberOfVoweInWord++;
                    eachChar.toUpperCase();
                } else {
                    eachChar;
                }
            }
            listOfWords.add("$numberOfVoweInWord" + newWord);
        }
        return listOfWords.sortedBy { it[0] }
    }

    private fun takeRusultIsNotPangramSentence(sentence: String): List<String> {
        val splittedArrayOfWords = splitString(sentence);
        val listOfWords = mutableListOf<String>()
        for (eachWord in splittedArrayOfWords) {
            var numberOfConsonantsInWord = 0;
            var newWord = "";
            for (eachChar in eachWord) {
                newWord += if (eachChar.isLetter() && !(arrayOfVowels.contains(eachChar) || (arrayOfVowels.contains(
                        eachChar.toLowerCase()
                    )))
                ) {
                    numberOfConsonantsInWord++;
                    eachChar.toUpperCase();
                } else {
                    eachChar;
                }
            }
            listOfWords.add("$numberOfConsonantsInWord" + newWord);
        }
        return listOfWords.sortedBy { it[0] }
    }
}
