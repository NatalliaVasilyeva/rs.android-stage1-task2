package subtask1

import java.time.DateTimeException
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.*

class DateFormatter {

    fun toTextDay(day: String, month: String, year: String): String {
        var nDay = day.toInt();
        var nMonth = month.toInt();
        var nYear = year.toInt();
        return try {
            var nDate = LocalDate.of(nYear, nMonth, nDay);
            var formatter = DateTimeFormatter.ofPattern("dd MMMM")
            var formattedDate = nDate.format(formatter)

            var dayOfWeek = nDate.dayOfWeek.getDisplayName(
                TextStyle.FULL,
                Locale.getDefault(Locale.Category.FORMAT)
            )
            return "$formattedDate, $dayOfWeek"
        } catch (exception: DateTimeException) {
            "Такого дня не существует"
        }
    }
}
