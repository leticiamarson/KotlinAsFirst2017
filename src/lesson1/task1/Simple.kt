@file:Suppress("UNUSED_PARAMETER")
package lesson1.task1

import java.lang.Math.*

/**
 * Пример
 *
 * Вычисление квадрата вещественного числа
 */
fun sqr(x: Double) = x * x

/**
 * Пример
 *
 * Вычисление дискриминанта квадратного уравнения
 */
fun discriminant(a: Double, b: Double, c: Double) = sqr(b) - 4 * a * c

/**
 * Пример
 *
 * Поиск одного из корней квадратного уравнения
 */
fun sqRoot(a: Double, b: Double, c: Double) = (-b + sqrt(discriminant(a, b, c))) / (2 * a)

/**
 * Пример
 *
 * Поиск произведения корней квадратного уравнения
 */
fun quadraticRootProduct(a: Double, b: Double, c: Double): Double {
    val sd = sqrt(discriminant(a, b, c))
    val x1 = (-b + sd) / (2 * a)
    val x2 = (-b - sd) / (2 * a)
    return x1 * x2 // Результат
}

/**
 * Пример главной функции
 */
fun main(args: Array<String>) {
    // Решаем x^2 - 3*x + 2 = 0
    val x1x2 = quadraticRootProduct(1.0, -3.0, 2.0)
    println("Root product: $x1x2")
}

/**
 * Тривиальная
 *
 * Пользователь задает время в часах, минутах и секундах, например, 8:20:35.
 * Рассчитать время в секундах, прошедшее с начала суток (30035 в данном случае).
 */
fun seconds(hours: Int, minutes: Int, seconds: Int): Int{
    val h:Int = hours*3600
    val m:Int = minutes*60
    val s:Int = seconds

    var stot:Int = h+m+s
    return stot
}

/**
 * Тривиальная
 *
 * Пользователь задает длину отрезка в саженях, аршинах и вершках (например, 8 саженей 2 аршина 11 вершков).
 * Определить длину того же отрезка в метрах (в данном случае 18.98).
 * 1 сажень = 3 аршина = 48 вершков, 1 вершок = 4.445 см.
 */
fun lengthInMeters(sagenes: Int, arshins: Int, vershoks: Int): Double{
    val s:Int = sagenes
    val a:Int = arshins
    val v:Int = vershoks

    var vv:Double = v*0.04445
    var aa:Double = a*0.7112
    var ss:Double = s*2.1336
    var metros:Double = vv+aa+ss
    return metros
}

/**
 * Тривиальная
 *
 * Пользователь задает угол в градусах, минутах и секундах (например, 36 градусов 14 минут 35 секунд).
 * Вывести значение того же угла в радианах (например, 0.63256).
 */
fun angleInRadian(grad: Int, min: Int, sec: Int): Double{
    val g:Double = (grad.toDouble())*0.0174533
    val m:Double = (min.toDouble())*0.000290888
    val s:Double = (sec.toDouble())*4.8481e-6
    var rad:Double = g+m+s
    return rad
}

/**
 * Тривиальная
 *
 * Найти длину отрезка, соединяющего точки на плоскости с координатами (x1, y1) и (x2, y2).
 * Например, расстояние между (3, 0) и (0, 4) равно 5
 */
fun trackLength(x1: Double, y1: Double, x2: Double, y2: Double): Double{
    var x1:Double = x1
    var x2:Double = x2
    var y1:Double = y1
    var y2:Double = y2
    var c:Double = 0.0
    var b:Double = 0.0

    if(x1>x2){
        c= x1-x2
    }
    else{
        c= x2-x1
    }
    if(y1>y2){
        b= y1-y2
    }
    else{
        b= y2-y1
    }
    var a:Double = sqrt((b*b)+(c*c))
    return a
}

/**
 * Простая
 *
 * Пользователь задает целое число, большее 100 (например, 3801).
 * Определить третью цифру справа в этом числе (в данном случае 8).
 */
fun thirdDigit(number: Int): Int{
    var x = number
    var n1:Int =0
    var n2:Int =0
    var n3:Int =0
    n1 = x%1000
    n2 = x%100
    n3 = (n1-n2)/100

    return n3
}

/**
 * Простая
 *
 * Поезд вышел со станции отправления в h1 часов m1 минут (например в 9:25) и
 * прибыл на станцию назначения в h2 часов m2 минут того же дня (например в 13:01).
 * Определите время поезда в пути в минутах (в данном случае 216).
 */
fun travelMinutes(hoursDepart: Int, minutesDepart: Int, hoursArrive: Int, minutesArrive: Int): Int{
    var hd:Int = hoursDepart
    var md:Int = minutesDepart
    var ha:Int = hoursArrive
    var ma:Int = minutesArrive
    var result:Int
    result = ((ha*60)+ma) - ((hd*60)+md)
    return result
}

/**
 * Простая
 *
 * Человек положил в банк сумму в s рублей под p% годовых (проценты начисляются в конце года).
 * Сколько денег будет на счету через 3 года (с учётом сложных процентов)?
 * Например, 100 рублей под 10% годовых превратятся в 133.1 рубля
 */
fun accountInThreeYears(initial: Int, percent: Int): Double{
    var ini = initial.toDouble()
    var per = percent.toDouble()
    var renda = DoubleArray(3)
    var i:Int =1
    renda[0]= ((ini*percent)/100)+ini

    while(i<3){
        renda[i]= ((renda[i-1]*percent)/100)+renda[i-1]
        i++
    }
    return renda[2]
}

/**
 * Простая
 *
 * Пользователь задает целое трехзначное число (например, 478).
 *Необходимо вывести число, полученное из заданного перестановкой цифр в обратном порядке (например, 874).
 */
fun numberRevert(number: Int): Int{
    var x:Int = number
    var ar = IntArray(3)
    var resposta:Int

    ar[0] = x%10
    ar[1] = (x%100) - ar[0]
    ar[2] = (x%1000) - (ar[1]+ar[0])
    resposta = (ar[0]*100) + ar[1] + (ar[2]/100)
    return resposta
}
