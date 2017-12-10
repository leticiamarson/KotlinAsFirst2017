@file:Suppress("UNUSED_PARAMETER")
package lesson5.task1

import com.sun.xml.internal.fastinfoset.util.StringArray
import java.util.*
import java.text.SimpleDateFormat
import java.text.DateFormat
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter


/**
 * Пример
 *
 * Время представлено строкой вида "11:34:45", содержащей часы, минуты и секунды, разделённые двоеточием.
 * Разобрать эту строку и рассчитать количество секунд, прошедшее с начала дня.
 */
fun timeStrToSeconds(str: String): Int {
    val parts = str.split(":")
    var result = 0
    for (part in parts) {
        val number = part.toInt()
        result = result * 60 + number
    }
    return result
}

/**
 * Пример
 *
 * Дано число n от 0 до 99.
 * Вернуть его же в виде двухсимвольной строки, от "00" до "99"
 */
fun twoDigitStr(n: Int) = if (n in 0..9) "0$n" else "$n"

/**
 * Пример
 *
 * Дано seconds -- время в секундах, прошедшее с начала дня.
 * Вернуть текущее время в виде строки в формате "ЧЧ:ММ:СС".
 */
fun timeSecondsToStr(seconds: Int): String {
    val hour = seconds / 3600
    val minute = (seconds % 3600) / 60
    val second = seconds % 60
    return String.format("%02d:%02d:%02d", hour, minute, second)
}

/**
 * Пример: консольный ввод
 */
fun main(args: Array<String>) {
    println("Введите время в формате ЧЧ:ММ:СС")
    val line = readLine()
    if (line != null) {
        val seconds = timeStrToSeconds(line)
        if (seconds == -1) {
            println("Введённая строка $line не соответствует формату ЧЧ:ММ:СС")
        }
        else {
            println("Прошло секунд с начала суток: $seconds")
        }
    }
    else {
        println("Достигнут <конец файла> в процессе чтения строки. Программа прервана")
    }
}

/**
 * Средняя
 *
 * Дата представлена строкой вида "15 июля 2016".
 * Перевести её в цифровой формат "15.07.2016".
 * День и месяц всегда представлять двумя цифрами, например: 03.04.2011.
 * При неверном формате входной строки вернуть пустую строку
 */
fun dateStrToDigit(str: String): String{
    var stringlist:String =""

    val parts:List<String> = str.split(" ")
    if(parts.size!=3) return ""
    try {
        when(parts[0]){
            "1" -> stringlist += "01."
            "2" -> stringlist += "02."
            "3" -> stringlist += "03."
            "4" -> stringlist += "04."
            "5" -> stringlist += "05."
            "6" -> stringlist += "06."
            "7" -> stringlist += "07."
            "8" -> stringlist += "08."
            "9" -> stringlist += "09."
            else -> stringlist += parts[0] + '.'
        }
        when(parts[1]){
            "января" -> stringlist+="01."
            "февраля" -> stringlist+="02."
            "марта" -> stringlist+="03."
            "апреля" -> stringlist+="04."
            "мая" -> stringlist+="05."
            "июня" -> stringlist+="06."
            "июля" -> stringlist+="07."
            "августа" -> stringlist+="08."
            "сентября" -> stringlist+="09."
            "октября" -> stringlist+="10."
            "ноября" -> stringlist+="11."
            "декабря" -> stringlist+="12."
            else -> return ""
        }
        stringlist+=parts[2]

        return stringlist
    }
    catch (e: NumberFormatException) {
        return ""
    }
}

/**
 * Средняя
 *
 * Дата представлена строкой вида "15.07.2016".
 * Перевести её в строковый формат вида "15 июля 2016".
 * При неверном формате входной строки вернуть пустую строку
 */
fun dateDigitToStr(digital: String): String{
    var stringlist:String =""
    val parts:List<String> = digital.split(".")
    if(parts.size!=3) return ""
    try {
        when(parts[0]){
            "01" -> stringlist += "1 "
            "02" -> stringlist += "2 "
            "03" -> stringlist += "3 "
            "04" -> stringlist += "4 "
            "05" -> stringlist += "5 "
            "06" -> stringlist += "6 "
            "07" -> stringlist += "7 "
            "08" -> stringlist += "8 "
            "09" -> stringlist += "9 "
            else -> stringlist += parts[0] + " "
        }
        when(parts[1]){
            "01" -> stringlist+="января "
            "02" -> stringlist+="февраля "
            "03" -> stringlist+="марта "
            "04" -> stringlist+="апреля "
            "05" -> stringlist+="мая "
            "06" -> stringlist+="июня "
            "07" -> stringlist+="июля "
            "08" -> stringlist+="августа "
            "09" -> stringlist+="сентября "
            "10" -> stringlist+="октября "
            "11" -> stringlist+="ноября "
            "12" -> stringlist+="декабря "
            else -> return ""
        }
        stringlist+=parts[2]

    return stringlist
    }
    catch (e: NumberFormatException) {
        return ""
    }
}

/**
 * Средняя
 *
 * Номер телефона задан строкой вида "+7 (921) 123-45-67".
 * Префикс (+7) может отсутствовать, код города (в скобках) также может отсутствовать.
 * Может присутствовать неограниченное количество пробелов и чёрточек,
 * например, номер 12 --  34- 5 -- 67 -98 тоже следует считать легальным.
 * Перевести номер в формат без скобок, пробелов и чёрточек (но с +), например,
 * "+79211234567" или "123456789" для приведённых примеров.
 * Все символы в номере, кроме цифр, пробелов и +-(), считать недопустимыми.
 * При неверном формате вернуть пустую строку
 */
fun flattenPhoneNumber(phone: String): String{
    var number:String =""
    var size:Int = phone.length
    var i:Int=0

    try{
    if(phone[0]=='+'){
        number+=phone[0]
        i++
    }

    while(i<size){
        when(phone[i]){
            '1' -> number += phone[i]
            '2' -> number += phone[i]
            '3' -> number += phone[i]
            '4' -> number += phone[i]
            '5' -> number += phone[i]
            '6' -> number += phone[i]
            '7' -> number += phone[i]
            '8' -> number += phone[i]
            '9' -> number += phone[i]
            '0' -> number += phone[i]
            '-' -> number
            ' ' -> number
            '(' -> number
            ')' -> number
            else -> return ""
        }
        i++
    }
    return number
    }
    catch (e: NumberFormatException) {
        return ""
    }
}

/**
 * Средняя
 *
 * Результаты спортсмена на соревнованиях в прыжках в длину представлены строкой вида
 * "706 - % 717 % 703".
 * В строке могут присутствовать числа, черточки - и знаки процента %, разделённые пробелами;
 * число соответствует удачному прыжку, - пропущенной попытке, % заступу.
 * Прочитать строку и вернуть максимальное присутствующее в ней число (717 в примере).
 * При нарушении формата входной строки или при отсутствии в ней чисел, вернуть -1.
 */
fun bestLongJump(jumps: String): Int{
    var stringlist:String =jumps
    var number:MutableList<Int> = mutableListOf()
    var i=0

    try{
        stringlist = jumps.replace("%", "")
        stringlist = stringlist.replace("-", "")
        stringlist = stringlist.replace("+", "")
    val bigger:List<String> = stringlist.split(" ")
        while(i<bigger.size){
            if(bigger[i]!="") number.add(bigger[i].toInt())
            i++
        }
        var equal=0
        i=0
        for (i in 0..number.size -2)
        {
            if ( number[i] == number[i+1])
            {
                equal++
            }
        }
        if(equal+1==number.size) return -1
        return Collections.max(number)
    }
    catch (e: NoSuchElementException) {
        return -1
    }
}

/**
 * Сложная
 *
 * Результаты спортсмена на соревнованиях в прыжках в высоту представлены строкой вида
 * "220 + 224 %+ 228 %- 230 + 232 %%- 234 %".
 * "220.+.224..+.228..-.230.+.232...-.234.."
 * Здесь + соответствует удачной попытке, % неудачной, - пропущенной.
 * Высота и соответствующие ей попытки разделяются пробелом.
 * Прочитать строку и вернуть максимальную взятую высоту (230 в примере).
 * При нарушении формата входной строки вернуть -1.
 */
fun bestHighJump(jumps: String): Int{
    var stringlist:String =jumps
    var value= ""
    var number:MutableList<Int> = mutableListOf()
    var i=0

    try{
        stringlist = jumps.replace("%", " ")
        val bigger:List<String> = stringlist.split(" ")
        while(i<bigger.size){
            if(bigger[i]=="+"){
                number.add(value.toInt())
                value=""
            }
            else if(bigger[i]=="-" || bigger[i]=="%" ) value=""
            else value+=bigger[i]
            i++
        }
        if(number.size==1) return number[0]
        return Collections.max(number)
    }
    catch (e: NoSuchElementException) {
        return -1
    }
}

/**
 * Сложная
 *
 * В строке представлено выражение вида "2 + 31 - 40 + 13",
 * использующее целые положительные числа, плюсы и минусы, разделённые пробелами.
 * Наличие двух знаков подряд "13 + + 10" или двух чисел подряд "1 2" не допускается.
 * Вернуть значение выражения (6 для примера).
 * Про нарушении формата входной строки бросить исключение IllegalArgumentException
 */
fun plusMinus(expression: String): Int{
    var stringlist:String = expression
    //var number:MutableList<Int> = mutableListOf()
    var i=1
    val bigger:List<String> = stringlist.split(" ")
    var value=bigger[0].toInt()

    try{
        while(i<bigger.size-1){
            if(bigger[i]=="+"){
                value+=bigger[i+1].toInt()
            }
            else if(bigger[i]=="-"){
                value -= bigger[i+1].toInt()
            }
            i++
        }
        return value
    }
    catch (e: ExceptionInInitializerError) {
        return throw IllegalArgumentException(Integer.toString(value))
    }
}

/**
 * Сложная
 *
 * Строка состоит из набора слов, отделённых друг от друга одним пробелом.
 * Определить, имеются ли в строке повторяющиеся слова, идущие друг за другом.
 * Слова, отличающиеся только регистром, считать совпадающими.
 * Вернуть индекс начала первого повторяющегося слова, или -1, если повторов нет.
 * Пример: "Он пошёл в в школу" => результат 9 (индекс первого 'в')
 */
fun firstDuplicateIndex(str: String): Int{
    var words:MutableList<String> = mutableListOf<String>()
    var letters:MutableList<Int> = mutableListOf()
    //val convertbig:List<Char> = listOf('А','Б','В','Г','Д','Е','Ё','Ж','З','И','Й','К','Л','М','Н','О','П','Р','С','Т','У','Ф','Х','Ц','Ч','Ш','Щ','Ъ','Ы','Ь','Э','Ю','Я')
    //val convertsmall:List<Char> = listOf('а','б','в','г','д','е','ё','ж','з','и','й','к','л','м','н','о','п','р','с','т','у','ф','х','ц','ч','ш','щ','ъ','ы','ь','э','ю','я')
    var word:String = ""
    var index:Int=0
    var letter:Int=0
    var space:Int=0
    var i:Int=0
    var j:Int=0

    while(i<str.length){
        if(str[i]==' '){
            letters.add(letter)
            words.add(word)
            word=""
            letter=0
            space++
        }
        else{
            letter++
            word+=str[i].toLowerCase()
        }
        i++
    }
    words.add(word)
    letters.add(letter)
    i=0
    while(i<words.size-1){
        if(words[i]==words[i+1]){
            index=i
            while(i>0){
                index+=letters[i-1]
                i--
            }
            return index
        }
        i++
    }

    return -1
}

/**
 * Сложная
 *
 * Строка содержит названия товаров и цены на них в формате вида
 * "Хлеб 39.9; Молоко 62.5; Курица 184.0; Конфеты 89.9".
 * То есть, название товара отделено от цены пробелом,
 * а цена отделена от названия следующего товара точкой с запятой и пробелом.
 * Вернуть название самого дорогого товара в списке (в примере это Курица),
 * или пустую строку при нарушении формата строки.
 * Все цены должны быть положительными
 */
fun mostExpensive(description: String): String{
    var number:String = ""
    var word:String = ""
    var space:Int=0
    var product:MutableList<String> = mutableListOf()
    var value:MutableList<Double> = mutableListOf()
    var i:Int=0

    if(description.isEmpty()) return ""
    while(i<description.length){
        if(space%2==0){
            while(description[i]!=' '){
                word+=description[i]
                i++
            }
            product.add(word)
            word=""
        }
        else{
            while(i<description.length && description[i]!=';'){
                number+=description[i]
                i++
            }
            value.add(number.toDouble())
            number=""
            i++
        }
        space++
        i++
    }
    i=0
    while(i<product.size){
        if(value[i]==value.max()){
            return product[i]
        }
        i++
    }
    return ""
}

/**
 * Сложная
 *
 * Перевести число roman, заданное в римской системе счисления,
 * в десятичную систему и вернуть как результат.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: XXIII = 23, XLIV = 44, C = 100
 *
 * Вернуть -1, если roman не является корректным римским числом
 */
fun fromRoman(roman: String): Int{
    var i:Int=0
    var v:Int=0
    var no:String=""

    if(roman.length==1){
        when(roman[0]){
            'I'-> return 1
            'V'-> return 5
            'X'-> return 10
            'L'-> return 50
            'C'-> return 100
            'D'-> return 500
            'M'-> return 1000
            else-> return -1
        }
    }
    else if(roman.isEmpty()) return -1

    while(i<roman.length-1){
        if(roman[i]=='I') {
            if(roman[i+1]=='V'){
                v+=4
                i++
            }
            else if(roman[i+1]=='X') {
                v+=9
                i++
            }
            else v+=1
        }
        else if(roman[i]=='X'){
            if(roman[i+1]=='L'){
                v+=40
                i++
            }
            else if(roman[i+1]=='C') {
                v+=90
                i++
            }
            else v+=10
        }
        else if(roman[i]=='C'){
            if(roman[i+1]=='D'){
                v+=400
                i++
            }
            else if(roman[i+1]=='M') {
                v+=900
                i++
            }
            else v+=100
        }
        else{
            when(roman[i]){
                'V'-> v+=5
                'L'-> v+=50
                'D'-> v+=500
                'M'-> v+=1000
                else-> return -1
            }
        }
        i++
    }
    no+=roman[roman.length-2]
    no+=roman[roman.length-1]
    if(no!="IV" && no!="IX" && no!="XL" && no!="XC" && no!="CD" && no!="CM"){
    when(roman[roman.length-1]){
        'I'-> v+=1
        'V'-> v+=5
        'X'-> v+=10
        'L'-> v+=50
        'C'-> v+=100
        'D'-> v+=500
        'M'-> v+=1000
    }
    }
    return v
}

/**
 * Очень сложная
 *
 * Имеется специальное устройство, представляющее собой
 * конвейер из cells ячеек (нумеруются от 0 до cells - 1 слева направо) и датчик, двигающийся над этим конвейером.
 * Строка commands содержит последовательность команд, выполняемых данным устройством, например +>+>+>+>+
 * Каждая команда кодируется одним специальным символом:
 *	> - сдвиг датчика вправо на 1 ячейку;
 *  < - сдвиг датчика влево на 1 ячейку;
 *	+ - увеличение значения в ячейке под датчиком на 1 ед.;
 *	- - уменьшение значения в ячейке под датчиком на 1 ед.;
 *	[ - если значение под датчиком равно 0, в качестве следующей команды следует воспринимать
 *  	не следующую по порядку, а идущую за соответствующей следующей командой ']' (с учётом вложенности);
 *	] - если значение под датчиком не равно 0, в качестве следующей команды следует воспринимать
 *  	не следующую по порядку, а идущую за соответствующей предыдущей командой '[' (с учётом вложенности);
 *      (комбинация [] имитирует цикл)
 *  пробел - пустая команда
 *
 * Изначально все ячейки заполнены значением 0 и датчик стоит на ячейке с номером N/2 (округлять вниз)
 *
 * После выполнения limit команд или всех команд из commands следует прекратить выполнение последовательности команд.
 * Учитываются все команды, в том числе несостоявшиеся переходы ("[" при значении под датчиком не равном 0 и "]" при
 * значении под датчиком равном 0) и пробелы.
 *
 * Вернуть список размера cells, содержащий элементы ячеек устройства после завершения выполнения последовательности.
 * Например, для 10 ячеек и командной строки +>+>+>+>+ результат должен быть 0,0,0,0,0,1,1,1,1,1
 *
 * Все прочие символы следует считать ошибочными и формировать исключение IllegalArgumentException.
 * То же исключение формируется, если у символов [ ] не оказывается пары.
 * Выход за границу конвейера также следует считать ошибкой и формировать исключение IllegalStateException.
 * Считать, что ошибочные символы и непарные скобки являются более приоритетной ошибкой чем выход за границу ленты,
 * то есть если в программе присутствует некорректный символ или непарная скобка, то должно быть выброшено
 * IllegalArgumentException.
 * IllegalArgumentException должен бросаться даже если ошибочная команда не была достигнута в ходе выполнения.
 *
 */
fun computeDeviceCells(cells: Int, commands: String, limit: Int): List<Int> = TODO()
