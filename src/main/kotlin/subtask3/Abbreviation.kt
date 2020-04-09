package subtask3

class Abbreviation {

    fun abbreviationFromA(a: String, b: String): String {
        var result = "YES"
        var startIndex = 0;
        for (char in b) {
            val matchIndex = a.indexOf(char, startIndex+1, true)
            if (matchIndex <0) result="NO"
        }
        return result;
    }
}

