@file:Suppress("UNUSED_PARAMETER")
package lesson4.task1

import com.sun.xml.internal.fastinfoset.util.StringArray
import lesson1.task1.discriminant
import lesson3.task1.minDivisor


/**
 * Пример
 *
 * Найти все корни уравнения x^2 = y
 */
fun sqRoots(y: Double) =
        when {
            y < 0 -> listOf()
            y == 0.0 -> listOf(0.0)
            else -> {
                val root = Math.sqrt(y)
                // Результат!
                listOf(-root, root)
            }
        }

/**
 * Пример
 *
 * Найти все корни биквадратного уравнения ax^4 + bx^2 + c = 0.
 * Вернуть список корней (пустой, если корней нет)
 */
fun biRoots(a: Double, b: Double, c: Double): List<Double> {
    if (a == 0.0) {
        return if (b == 0.0) listOf()
        else sqRoots(-c / b)
    }
    val d = discriminant(a, b, c)
    if (d < 0.0) return listOf()
    if (d == 0.0) return sqRoots(-b / (2 * a))
    val y1 = (-b + Math.sqrt(d)) / (2 * a)
    val y2 = (-b - Math.sqrt(d)) / (2 * a)
    return sqRoots(y1) + sqRoots(y2)
}

/**
 * Пример
 *
 * Выделить в список отрицательные элементы из заданного списка
 */
fun negativeList(list: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (element in list) {
        if (element < 0) {
            result.add(element)
        }
    }
    return result
}

/**
 * Пример
 *
 * Изменить знак для всех положительных элементов списка
 */
fun invertPositives(list: MutableList<Int>) {
    for (i in 0 until list.size) {
        val element = list[i]
        if (element > 0) {
            list[i] = -element
        }
    }
}

/**
 * Пример
 *
 * Из имеющегося списка целых чисел, сформировать список их квадратов
 */
fun squares(list: List<Int>) = list.map { it * it }

/**
 * Пример
 *
 * По заданной строке str определить, является ли она палиндромом.
 * В палиндроме первый символ должен быть равен последнему, второй предпоследнему и т.д.
 * Одни и те же буквы в разном регистре следует считать равными с точки зрения данной задачи.
 * Пробелы не следует принимать во внимание при сравнении символов, например, строка
 * "А роза упала на лапу Азора" является палиндромом.
 */
fun isPalindrome(str: String): Boolean {
    val lowerCase = str.toLowerCase().filter { it != ' ' }
    for (i in 0..lowerCase.length / 2) {
        if (lowerCase[i] != lowerCase[lowerCase.length - i - 1]) return false
    }
    return true
}

/**
 * Пример
 *
 * По имеющемуся списку целых чисел, например [3, 6, 5, 4, 9], построить строку с примером их суммирования:
 * 3 + 6 + 5 + 4 + 9 = 27 в данном случае.
 */
fun buildSumExample(list: List<Int>) = list.joinToString(separator = " + ", postfix = " = ${list.sum()}")

/**
 * Простая
 *
 * Найти модуль заданного вектора, представленного в виде списка v,
 * по формуле abs = sqrt(a1^2 + a2^2 + ... + aN^2).
 * Модуль пустого вектора считать равным 0.0.
 */
fun abs(v: List<Double>): Double{
    var resposta:Double = 0.0
        for(i in 0..(v.size-1)){
            resposta += (Math.pow(v[i], 2.0))
        }
        resposta = Math.sqrt(resposta)
    return resposta
}

/**
 * Простая
 *
 * Рассчитать среднее арифметическое элементов списка list. Вернуть 0.0, если список пуст
 */
fun mean(list: List<Double>): Double{
    var resposta:Double = 0.0
    var i:Int= 0

    if(list.isEmpty() == true){
        resposta =0.0
    }
    else{
        while(i<(list.size)){
            resposta += (list[i])
            i++
        }
        resposta = resposta/(list.size)
    }
    return resposta
}

/**
 * Средняя
 *
 * Центрировать заданный список list, уменьшив каждый элемент на среднее арифметическое всех элементов.
 * Если список пуст, не делать ничего. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun center(list: MutableList<Double>): MutableList<Double>{
    var media: Double = mean(list)
        for (i in 0..(list.size-1)) {
            list[i] = list[i] - media
        }
    return list
}

/**
 * Средняя
 *
 * Найти скалярное произведение двух векторов равной размерности,
 * представленные в виде списков a и b. Скалярное произведение считать по формуле:
 * C = a1b1 + a2b2 + ... + aNbN. Произведение пустых векторов считать равным 0.0.
 */
fun times(a: List<Double>, b: List<Double>): Double{
    var resposta = 0.0

    for(i in 0..a.size-1){
        resposta += a[i]*b[i]
    }
    return resposta
}

/**
 * Средняя
 *
 * Рассчитать значение многочлена при заданном x:
 * p(x) = p0 + p1*x + p2*x^2 + p3*x^3 + ... + pN*x^N.
 * Коэффициенты многочлена заданы списком p: (p0, p1, p2, p3, ..., pN).
 * Значение пустого многочлена равно 0.0 при любом x.
 */
fun polynom(p: List<Double>, x: Double): Double{
    var resposta:Double =0.0
    var i:Int=1
    var j:Double=1.0

    if(p.isEmpty() == true){
        resposta = 0.0
    }
    else if(p.size ==1){
        resposta = p[0]
    }
    else{
        resposta += p[0]
        while(i<p.size){
            resposta += p[i]*(Math.pow(x, j))
            j++
            i++
        }

    }
    return resposta
}

/**
 * Средняя
 *
 * В заданном списке list каждый элемент, кроме первого, заменить
 * суммой данного элемента и всех предыдущих.
 * Например: 1, 2, 3, 4 -> 1, 3, 6, 10.
 * Пустой список не следует изменять. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun accumulate(list: MutableList<Double>): MutableList<Double>{
    var i:Int =1

    while(i<list.size){
        list[i] += list[i-1]
        i++
    }

    return list
}

/**
 * Средняя
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде списка множителей, например 75 -> (3, 5, 5).
 * Множители в списке должны располагаться по возрастанию.
 */
fun factorize(n: Int): List<Int>{
    var arr:MutableList<Int> = mutableListOf()
    var number:Int=n

    while (number > 1) {
        arr.add(minDivisor(number))
        number /= minDivisor(number)
    }
    return arr
}

/**
 * Сложная
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде строки, например 75 -> 3*5*5
 */
fun factorizeToString(n: Int): String{
    var result:String=""
    var number:Int=n
    if(n== Int.MAX_VALUE) return (Int.MAX_VALUE).toString()
    while (number > 1) {
        result+=minDivisor(number)
        result+="*"
        number /= minDivisor(number)
    }
    if(result.last()=='*') result = result.substring(0,result.length-1)
    return result
}

/**
 * Средняя
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием base > 1.
 * Результат перевода вернуть в виде списка цифр в base-ичной системе от старшей к младшей,
 * например: n = 100, base = 4 -> (1, 2, 1, 0) или n = 250, base = 14 -> (1, 3, 12)
 */
fun convert(n: Int, base: Int): List<Int>{
    var resto:MutableList<Int> = mutableListOf()
    var number:Int=n
    while(number>=base){
        resto.add(number%base)
        number = number/base
    }
    resto.add(number)
    return resto.reversed()
}

/**
 * Сложная
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием 1 < base < 37.
 * Результат перевода вернуть в виде строки, цифры более 9 представлять латинскими
 * строчными буквами: 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: n = 100, base = 4 -> 1210, n = 250, base = 14 -> 13c
 */
fun convertToString(n: Int, base: Int): String{
    var stringlist = StringBuilder()
    var number: Int = n

    while (number >= base) {
        if ((number % base) < 10) {
            stringlist.append(number % base).toString()
        } else {
            stringlist.append('a' + ((number % base) - 10))
        }
        number = number / base
    }
    if (number < 10)
        stringlist.append(number)
    else {
        stringlist.append('a' + ((number % base) - 10))
    }

    return stringlist.toString().reversed()
}

/**
 * Средняя
 *
 * Перевести число, представленное списком цифр digits от старшей к младшей,
 * из системы счисления с основанием base в десятичную.
 * Например: digits = (1, 3, 12), base = 14 -> 250
 */
fun decimal(digits: List<Int>, base: Int): Int{
    var result: Double = 0.0
    var i: Int = digits.size - 1
    var j: Int = 0
    if (digits.size == 1 && digits[0] < base) return digits[0]
    else {
        while (i >= 0) {
            result += digits[j] * Math.pow((base).toDouble(), i.toDouble())
            i--
            j++
        }
    }
    return result.toInt()
}

/**
 * Сложная
 *
 * Перевести число, представленное цифровой строкой str,
 * из системы счисления с основанием base в десятичную.
 * Цифры более 9 представляются латинскими строчными буквами:
 * 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: str = "13c", base = 14 -> 250
 */
fun decimalFromString(str: String, base: Int): Int{
    var word: String = "abcdefghijklmnopqrstuvwxyz"
    var result: Int = 0
    var i: Int = 0
    var str: String = str.reversed()
    result = str.map {
        (if (word.contains(it)) word.indexOf(it) + 10
        else it.toString().toInt()) * Math.pow(base.toDouble(), i++.toDouble()).toInt()
    }.sum()
    return result
}

/**
 * Сложная
 *
 * Перевести натуральное число n > 0 в римскую систему.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: 23 = XXIII, 44 = XLIV, 100 = C
 */
fun roman(n: Int): String{
    var num:String = n.toString()
    var i:Int= 1
    var j:Int= num.toString().length-1
    var contzero:Int=1
    var result:MutableList<String> = mutableListOf()
    var resultado:String=""

    while(i<=num.toString().length){
        if(i==1){
        when(num[j]){
            '1'-> result.add("I")
            '2'-> result.add("II")
            '3'-> result.add("III")
            '4'-> result.add("IV")
            '5'-> result.add("V")
            '6'-> result.add("VI")
            '7'-> result.add("VII")
            '8'-> result.add("VIII")
            '9'-> result.add("IX")
            '0' -> contzero++
        }
            j--
        }
        else if(i==2){
            when(num[j]){
                '1'-> result.add("X")
                '2'-> result.add("XX")
                '3'-> result.add("XXX")
                '4'-> result.add("XL")
                '5'-> result.add("L")
                '6'-> result.add("LX")
                '7'-> result.add("LXX")
                '8'-> result.add("LXXX")
                '9'-> result.add("XC")
                '0' -> contzero++
            }
            j--
        }
        else if(i==3){
            when(num[j]){
                '1'-> result.add("C")
                '2'-> result.add("CC")
                '3'-> result.add("CCC")
                '4'-> result.add("CD")
                '5'-> result.add("D")
                '6'-> result.add("DC")
                '7'-> result.add("DCC")
                '8'-> result.add("DCCC")
                '9'-> result.add("CM")
                '0' -> contzero++
            }
            j--
        }
        else if(i==4){
            when(num[j]){
                '1'-> result.add("M")
                '2'-> result.add("MM")
                '3'-> result.add("MMM")
                '4'-> result.add("MMMM")
                '5'-> result.add("MMMMM")
                '6'-> result.add("MMMMMM")
                '7'-> result.add("MMMMMMM")
                '8'-> result.add("MMMMMMMM")
                '9'-> result.add("MMMMMMMMM")
                '0' -> contzero++
            }
            j--
        }
        else if(i==5){
            when(num[j]){
                '1'-> result.add("MMMMMMMMMM")
                '2'-> result.add("MMMMMMMMMMMMMMMMMMMM")
                '3'-> result.add("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMM")
                '4'-> result.add("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM")
                '5'-> result.add("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM")
                '6'-> result.add("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM")
                '7'-> result.add("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM")
                '8'-> result.add("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM")
                '9'-> result.add("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM")
                '0' -> contzero++
            }
            j--
        }
        i++

    }
    if(num.toString().length==1){
        resultado+=result[0]
    }
    /*else if(n%10==0 || n%100==0 || n%1000==0) {
        resultado += result[0]
    }*/
    else{
    i=num.toString().length-contzero
    while(i>=0){
        resultado+=result[i]
        i--
    }
    }
    return resultado
}

/**
 * Очень сложная
 *
 * Записать заданное натуральное число 1..999999 прописью по-русски.
 * Например, 375 = "триста семьдесят пять",
 * 23964 = "двадцать три тысячи девятьсот шестьдесят четыре"
 */
fun russian(n: Int): String{
    var string: String = n.toString().reversed()
    val matrix = arrayOf(arrayOf("ноль", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"),
            arrayOf("ноль", "десять", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят", "девяносто"),
            arrayOf("ноль", "сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот"),
            arrayOf("ноль", "одна тысяча", "две тысячи", "три тысячи", "четыре тысячи", "пять тысяч", "шесть тысяч", "семь тысяч", "восемь тысяч", "девять тысяч"),
            arrayOf("ноль", "десять тысяч", "двадцать тысяч", "тридцать тысяч", "сорок тысяч", "пятьдесят тысяч", "шестьдесят тысяч", "семьдесят тысяч", "восемьдесят тысяч", "девяносто тысяч"),
            arrayOf("ноль", "сто тысяч", "двести тысяч", "триста тысяч", "четыреста тысяч", "пятьсот тысяч", "шестьсот тысяч", "семьсот тысяч", "восемьсот тысяч", "девятьсот тысяч"))
    val otharray = arrayOf(arrayOf("одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать"),
            arrayOf("одиннадцать тысяч", "двенадцать тысяч", "тринадцать тысяч", "четырнадцать тысяч", "пятнадцать тысяч", "шестнадцать тысяч", "семнадцать тысяч", "восемнадцать тысяч", "девятнадцать тысяч"))
    var result: MutableList<String> = mutableListOf()
    var resp = StringBuilder()
    var i: Int = 0
    var cont0: Int = 1

    if (string.length == 1 && string[0] == '0') return "ноль"
    while (i < string.length) {
        if (i == 0) {
            if (string.length > 1) {
                if (string[1] == '1') {
                    when (string[i]) {
                        '0' -> result.add(matrix[i + 1][1])
                        '1' -> result.add(otharray[i][0])
                        '2' -> result.add(otharray[i][1])
                        '3' -> result.add(otharray[i][2])
                        '4' -> result.add(otharray[i][3])
                        '5' -> result.add(otharray[i][4])
                        '6' -> result.add(otharray[i][5])
                        '7' -> result.add(otharray[i][6])
                        '8' -> result.add(otharray[i][7])
                        '9' -> result.add(otharray[i][8])
                    }
                    cont0++
                    i++
                } else {
                    when (string[i]) {
                        '0' -> cont0++
                        '1' -> result.add(matrix[i][1])
                        '2' -> result.add(matrix[i][2])
                        '3' -> result.add(matrix[i][3])
                        '4' -> result.add(matrix[i][4])
                        '5' -> result.add(matrix[i][5])
                        '6' -> result.add(matrix[i][6])
                        '7' -> result.add(matrix[i][7])
                        '8' -> result.add(matrix[i][8])
                        '9' -> result.add(matrix[i][9])
                    }
                }
            } else {
                when (string[i]) {
                    '0' -> cont0++
                    '1' -> result.add(matrix[i][1])
                    '2' -> result.add(matrix[i][2])
                    '3' -> result.add(matrix[i][3])
                    '4' -> result.add(matrix[i][4])
                    '5' -> result.add(matrix[i][5])
                    '6' -> result.add(matrix[i][6])
                    '7' -> result.add(matrix[i][7])
                    '8' -> result.add(matrix[i][8])
                    '9' -> result.add(matrix[i][9])
                }
            }
        }
        if (i == 1) {
            when (string[i]) {
                '0' -> cont0++
                '2' -> result.add(matrix[i][2])
                '3' -> result.add(matrix[i][3])
                '4' -> result.add(matrix[i][4])
                '5' -> result.add(matrix[i][5])
                '6' -> result.add(matrix[i][6])
                '7' -> result.add(matrix[i][7])
                '8' -> result.add(matrix[i][8])
                '9' -> result.add(matrix[i][9])
            }
        }
        if (i == 2) {
            when (string[i]) {
                '0' -> cont0++
                '1' -> result.add(matrix[i][1])
                '2' -> result.add(matrix[i][2])
                '3' -> result.add(matrix[i][3])
                '4' -> result.add(matrix[i][4])
                '5' -> result.add(matrix[i][5])
                '6' -> result.add(matrix[i][6])
                '7' -> result.add(matrix[i][7])
                '8' -> result.add(matrix[i][8])
                '9' -> result.add(matrix[i][9])
            }
        }
        if (i == 3) {
            if (string.length > 4) {
                if (string[4] == '1') {
                    when (string[i]) {
                        '0' -> result.add(matrix[1][1])
                        '0' -> cont0++
                        '1' -> result.add(otharray[1][0])
                        '2' -> result.add(otharray[1][1])
                        '3' -> result.add(otharray[1][2])
                        '4' -> result.add(otharray[1][3])
                        '5' -> result.add(otharray[1][4])
                        '6' -> result.add(otharray[1][5])
                        '7' -> result.add(otharray[1][6])
                        '8' -> result.add(otharray[1][7])
                        '9' -> result.add(otharray[1][8])
                    }
                    cont0++
                    i++
                } else {
                    when (string[i]) {
                        '0' -> cont0++
                        '1' -> result.add(matrix[i][1])
                        '2' -> result.add(matrix[i][2])
                        '3' -> result.add(matrix[i][3])
                        '4' -> result.add(matrix[i][4])
                        '5' -> result.add(matrix[i][5])
                        '6' -> result.add(matrix[i][6])
                        '7' -> result.add(matrix[i][7])
                        '8' -> result.add(matrix[i][8])
                        '9' -> result.add(matrix[i][9])
                    }
                }
            } else {
                when (string[i]) {
                    '0' -> cont0++
                    '1' -> result.add(matrix[i][1])
                    '2' -> result.add(matrix[i][2])
                    '3' -> result.add(matrix[i][3])
                    '4' -> result.add(matrix[i][4])
                    '5' -> result.add(matrix[i][5])
                    '6' -> result.add(matrix[i][6])
                    '7' -> result.add(matrix[i][7])
                    '8' -> result.add(matrix[i][8])
                    '9' -> result.add(matrix[i][9])
                }
            }
        }
        if (i == 4) {
            if (string[i - 1] == '0') {
                when (string[i]) {
                    '0' -> cont0++
                    '2' -> result.add(matrix[i][2])
                    '3' -> result.add(matrix[i][3])
                    '4' -> result.add(matrix[i][4])
                    '5' -> result.add(matrix[i][5])
                    '6' -> result.add(matrix[i][6])
                    '7' -> result.add(matrix[i][7])
                    '8' -> result.add(matrix[i][8])
                    '9' -> result.add(matrix[i][9])
                }
            } else {
                when (string[i]) {
                    '0' -> cont0++
                    '2' -> result.add(matrix[1][2])
                    '3' -> result.add(matrix[1][3])
                    '4' -> result.add(matrix[1][4])
                    '5' -> result.add(matrix[1][5])
                    '6' -> result.add(matrix[1][6])
                    '7' -> result.add(matrix[1][7])
                    '8' -> result.add(matrix[1][8])
                    '9' -> result.add(matrix[1][9])
                }
            }
        }
        if (i == 5) {
            if (string[3] == '0' && string[4] == '0') {
                when (string[i]) {
                    '0' -> cont0++
                    '1' -> result.add(matrix[i][1])
                    '2' -> result.add(matrix[i][2])
                    '3' -> result.add(matrix[i][3])
                    '4' -> result.add(matrix[i][4])
                    '5' -> result.add(matrix[i][5])
                    '6' -> result.add(matrix[i][6])
                    '7' -> result.add(matrix[i][7])
                    '8' -> result.add(matrix[i][8])
                    '9' -> result.add(matrix[i][9])
                }
            } else {
                when (string[i]) {
                    '0' -> cont0++
                    '1' -> result.add(matrix[2][1])
                    '2' -> result.add(matrix[2][2])
                    '3' -> result.add(matrix[2][3])
                    '4' -> result.add(matrix[2][4])
                    '5' -> result.add(matrix[2][5])
                    '6' -> result.add(matrix[2][6])
                    '7' -> result.add(matrix[2][7])
                    '8' -> result.add(matrix[2][8])
                    '9' -> result.add(matrix[2][9])
                }
            }
        }

        i++
    }
    i = i - cont0
    while (i >= 0) {
        resp.append(result[i])
        if (i != 0) resp.append(" ")
        i--
    }

    return resp.toString()
}
