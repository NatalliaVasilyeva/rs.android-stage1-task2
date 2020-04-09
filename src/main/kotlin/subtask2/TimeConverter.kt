package subtask2

class TimeConverter {

    fun toTextFormat(hour: String, minute: String): String {

        val arrayOfTime = arrayOf("", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
        "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty",
            "twenty one", "twenty two", "twenty three", "twenty four", "twenty five", "twenty six", "twenty seven",
            "twenty eight", "twenty nine");

        var minute=minute.toInt();
        var hour = hour.toInt();

        if (minute<0 || minute>60 || hour<0 || hour>24) {
            return ""
        }

        return when (minute) {
            0 -> "${arrayOfTime[hour]} o' clock"
            1 -> "${arrayOfTime[minute]} minute past ${arrayOfTime[hour]}"
            15 -> "quarter past ${arrayOfTime[hour]}"
            30 -> "half past ${arrayOfTime[hour]}"
            45 -> "quarter to ${arrayOfTime[hour+1]}"
            59 -> "${arrayOfTime[60-minute]} minute to ${arrayOfTime[hour+1]}"
            in 1..29 ->"${arrayOfTime[minute]} minutes past ${arrayOfTime[hour]}"
            in 31..60 ->"${arrayOfTime[60-minute]} minutes to ${arrayOfTime[hour+1]}"
            else ->""
        }
    }
}
