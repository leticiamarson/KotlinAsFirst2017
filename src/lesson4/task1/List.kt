@file:Suppress("UNUSED_PARAMETER")
package lesson4.task1

import com.sun.xml.internal.fastinfoset.util.StringArray
import lesson1.task1.discriminant


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
    //var lista:List<Double> = v
    var i:Int= 0

    if(v.isEmpty() == true){
        resposta =0.0
    }
    else{
        while(i<(v.size)){
            resposta += (Math.pow(v[i], 2.0))
            i++
        }
        resposta = Math.sqrt(resposta)
    }
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
    var media: Double = 0.0
    var i: Int = 0
    if (list.size == 1) {
        list[0] = 0.0
    }
    else {
        while(i<(list.size)){
            media += (list[i])
            i++
        }
        media = media/(list.size)
        i = 0
        while (i < (list.size)) {
            list[i] = list[i] - media
            i++
        }
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
    var resposta:Double = 0.0
    var i:Int =0

    if(a.isEmpty() == true || b.isEmpty()==true){
        resposta =0.0
    }
    while(i<a.size){
        resposta += a[i]*b[i]
        i++
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
    var i:Int=2
    var j:Int=0
    var primo:Boolean
    if(n==2){
        arr.add(2)
    }
    else{
    while(i<=n) {
        if(n%i==0){
            primo=true
            j=2
            while(j<=(i/2)){
                if((i%j)==0){
                primo=false
                break
                }
                j++
            }
            if(primo==true){
                arr.add(i)
                number/=i
            }
        }
        if(number%i!=0) i++
    }
    }
    val intlist: List<Int> = arr
    return intlist
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
    var i:Int=2
    var j:Int=0
    var primo:Boolean
    if(n==2){
        result+="2"
        return result
    }
    else if(n== Int.MAX_VALUE) return (Int.MAX_VALUE).toString()
    else{
        while(i<=n) {
            if(n%i==0){
                primo=true
                j=2
                while(j<=(i/2)){
                    if((i%j)==0){
                        primo=false
                        break
                    }
                    j++
                }
                if(primo==true){
                    result += i
                    result += "*"
                    number/=i
                }
            }
            if(number%i!=0) i++
        }
    }
    if(result.last()=='*')
    result = result.substring(0,result.length-1)
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
    if(number>base){
        do{
            resto.add(number%base)
            number = number/base
        }while(number>base)
        resto.add(number)
    }
    else resto.add(n)
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
    var stringlist:String =""
    var number:Int=n
    //if(number>base){
    while(number>base){
            if((number%base)<10){
                stringlist += (number%base).toString()
            }
            else{
                when((number%base)-10){
                    0 -> stringlist+="a"
                    1 -> stringlist+="b"
                    2 -> stringlist+="c"
                    3 -> stringlist+="d"
                    4 -> stringlist+="e"
                    5 -> stringlist+="f"
                    6 -> stringlist+="g"
                    7 -> stringlist+="h"
                    8 -> stringlist+="i"
                    9 -> stringlist+="j"
                    10 -> stringlist+="k"
                    11 -> stringlist+="l"
                    12 -> stringlist+="m"
                    13 -> stringlist+="n"
                    14 -> stringlist+="o"
                    15 -> stringlist+="p"
                    16 -> stringlist+="q"
                    17 -> stringlist+="r"
                    18 -> stringlist+="s"
                    19 -> stringlist+="t"
                    20 -> stringlist+="u"
                    21 -> stringlist+="v"
                    22 -> stringlist+="w"
                    23 -> stringlist+="x"
                    24 -> stringlist+="y"
                    25 -> stringlist+="z"
                }
            }
            number = number/base
        }
    if(number<10)
        stringlist+=number
    else{
        when((number%base)-10){
            0 -> stringlist+="a"
            1 -> stringlist+="b"
            2 -> stringlist+="c"
            3 -> stringlist+="d"
            4 -> stringlist+="e"
            5 -> stringlist+="f"
            6 -> stringlist+="g"
            7 -> stringlist+="h"
            8 -> stringlist+="i"
            9 -> stringlist+="j"
            10 -> stringlist+="k"
            11 -> stringlist+="l"
            12 -> stringlist+="m"
            13 -> stringlist+="n"
            14 -> stringlist+="o"
            15 -> stringlist+="p"
            16 -> stringlist+="q"
            17 -> stringlist+="r"
            18 -> stringlist+="s"
            19 -> stringlist+="t"
            20 -> stringlist+="u"
            21 -> stringlist+="v"
            22 -> stringlist+="w"
            23 -> stringlist+="x"
            24 -> stringlist+="y"
            25 -> stringlist+="z"
        }
    }

    return stringlist.reversed()
}

/**
 * Средняя
 *
 * Перевести число, представленное списком цифр digits от старшей к младшей,
 * из системы счисления с основанием base в десятичную.
 * Например: digits = (1, 3, 12), base = 14 -> 250
 */
fun n(digits: List<Int>, base: Int): Int{
    var result:Double=0.0
    var i:Int=digits.size-1
    var j:Int=0
    if(digits.size==1 && digits[0]<base) return digits[0]
    else{
    while(i>=0){
        result+=digits[j]*Math.pow((base).toDouble(),i.toDouble())
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
    var word:String="abcdefghijklmnopqrstuvwxyz"
    var result:Int=0
    var i: Int = 0
    var str:String=str.reversed()
    result=str.map {
        (if (word.contains(it)) word.indexOf(it)+10
    else it.toString().toInt())*Math.pow(base.toDouble(),i++.toDouble()).toInt()
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
            }
            j--
        }
        else if(i==4){
            when(num[j]){
                '1'-> result.add("M")
                '2'-> result.add("MM")
                '3'-> result.add("MMM")
            }
            j--
        }
        i++

    }
    if(num.toString().length==1){
        resultado+="I"
    }
    else if(n%10==0 || n%100==0 || n%1000==0) {
        resultado += result[0]
    }
    else{
    i=num.toString().length-1
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
    var cont:Int=0
    var cont0:Int=0
    var num:Int=n
    var listnum:MutableList<String> = mutableListOf()
    var result:String=""

    while(num>0){
        if(cont==0){
            if(num%100>9 && num%100<20){
                when(num%100){
                    10 -> listnum.add("десять")
                    11 -> listnum.add("одиннадцать")
                    12 -> listnum.add("двенадцать")
                    13 -> listnum.add("тринадцать")
                    14 -> listnum.add("четырнадцать")
                    15 -> listnum.add("пятнадцать")
                    16 -> listnum.add("шестнадцать")
                    17 -> listnum.add("семнадцать")
                    18 -> listnum.add("восемнадцать")
                    19 -> listnum.add("девятнадцать")
                }
                if(num%10==0) cont0=cont0+2
                num/=100
            }
            else{
            when(num%10){
                1 -> listnum.add("один")
                2 -> listnum.add("два")
                3 -> listnum.add("три")
                4 -> listnum.add("четыре")
                5 -> listnum.add("пять")
                6 -> listnum.add("шесть")
                7 -> listnum.add("семь")
                8 -> listnum.add("восемь")
                9 -> listnum.add("девять")
            }
                if(num%10==0) cont0++
                num/=10
            }
        }
        else if(cont==1){
            when(num%10){
                2 -> listnum.add("двадцать")
                3 -> listnum.add("тридцать")
                4 -> listnum.add("сорок")
                5 -> listnum.add("пятьдесят")
                6 -> listnum.add("шестьдесят")
                7 -> listnum.add("семьдесят")
                8 -> listnum.add("восемьдесят")
                9 -> listnum.add("девяносто")
            }
            if(num%10==0) cont0++
            num/=10
        }
        else if(cont==2){
            when(num%10){
                1 -> listnum.add("сто")
                2 -> listnum.add("двести")
                3 -> listnum.add("триста")
                4 -> listnum.add("четыреста")
                5 -> listnum.add("пятьсот")
                6 -> listnum.add("шестьсот")
                7 -> listnum.add("семьсот")
                8 -> listnum.add("восемьсот")
                9 -> listnum.add("девятьсот")
            }
            if(num%10==0) cont0++
            num/=10
        }
        else if(cont==3){
            if(num%100>9 && num%100<20){
                when(num%100){
                    10 -> listnum.add("десять тысяч")
                    11 -> listnum.add("одиннадцать тысяч")
                    12 -> listnum.add("двенадцать тысяч")
                    13 -> listnum.add("тринадцать тысяч")
                    14 -> listnum.add("четырнадцать тысяч")
                    15 -> listnum.add("пятнадцать тысяч")
                    16 -> listnum.add("шестнадцать тысяч")
                    17 -> listnum.add("семнадцать тысяч")
                    18 -> listnum.add("восемнадцать тысяч")
                    19 -> listnum.add("девятнадцать тысяч")
                }
                if(num%10==0) cont0=cont0+2
                num/=100
            }
            else {
                when (num % 10) {
                    //0 -> listnum.add("тысяч")
                    1 -> listnum.add("тысяча")
                    2 -> listnum.add("две тысячи")
                    3 -> listnum.add("три тысячи")
                    4 -> listnum.add("четыре тысячи")
                    5 -> listnum.add("пять тысяч")
                    6 -> listnum.add("шесть тысяч")
                    7 -> listnum.add("семь тысяч")
                    8 -> listnum.add("восемь тысяч")
                    9 -> listnum.add("девять тысяч")
                }
                if(num%10==0) cont0++
                num /= 10
            }
        }
        else if(cont==4){
            when(num%10){
                1 -> listnum.add("сто")
                2 -> listnum.add("двадцать")
                3 -> listnum.add("тридцать")
                4 -> listnum.add("сорок")
                5 -> listnum.add("пятьдесят")
                6 -> listnum.add("шестьдесят")
                7 -> listnum.add("семьдесят")
                8 -> listnum.add("восемьдесят")
                9 -> listnum.add("девяносто")
            }
            if(num%10==0) cont0++
            num/=10
        }
        else{
            when(num%10){
                1 -> listnum.add("сто тысяча")
                2 -> listnum.add("двести тысяч")
                3 -> listnum.add("триста тысяч")
                4 -> listnum.add("четыреста тысяч")
                5 -> listnum.add("пятьсот тысяч")
                6 -> listnum.add("шестьсот тысяч")
                7 -> listnum.add("семьсот тысяч")
                8 -> listnum.add("восемьсот тысяч")
                9 -> listnum.add("девятьсот тысяч")
            }
            if(num%10==0) cont0++
            num/=10
        }
        cont++
    }
    cont=cont-cont0-1
    while(cont>=0){
        result+=listnum[cont]
        if(cont>0){
            result+= " "
        }
        cont--
    }
    return result
}
