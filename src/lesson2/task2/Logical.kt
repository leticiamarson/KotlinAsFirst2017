@file:Suppress("UNUSED_PARAMETER")
package lesson2.task2

import lesson1.task1.sqr

/**
 * Пример
 *
 * Лежит ли точка (x, y) внутри окружности с центром в (x0, y0) и радиусом r?
 */
fun pointInsideCircle(x: Double, y: Double, x0: Double, y0: Double, r: Double) =
        sqr(x - x0) + sqr(y - y0) <= sqr(r)

/**
 * Простая
 *
 * Четырехзначное число назовем счастливым, если сумма первых двух ее цифр равна сумме двух последних.
 * Определить, счастливое ли заданное число, вернуть true, если это так.
 */
fun isNumberHappy(number: Int): Boolean{
    var n = IntArray(4)
    n[3] = number%10
    n[2] = ((number%100) - n[3])/10
    n[1] = ((number%1000) - n[2])/100
    n[0] = ((number%10000) - n[1])/1000

    return (n[3]+n[2])==(n[1]+n[0])
}

/**
 * Простая
 *
 * На шахматной доске стоят два ферзя (ферзь бьет по вертикали, горизонтали и диагоналям).
 * Определить, угрожают ли они друг другу. Вернуть true, если угрожают.
 * Считать, что ферзи не могут загораживать друг друга.
 */
fun queenThreatens(x1: Int, y1: Int, x2: Int, y2: Int): Boolean{
    if(x1 == x2 || y1 == y2){
        return true
    }
    if(sqr((x1-x2).toDouble()) == sqr((y1-y2).toDouble())){
        return true
    }
    return false
}

/**
 * Средняя
 *
 * Проверить, лежит ли окружность с центром в (x1, y1) и радиусом r1 целиком внутри
 * окружности с центром в (x2, y2) и радиусом r2.
 * Вернуть true, если утверждение верно
 */
fun circleInside(x1: Double, y1: Double, r1: Double,
                 x2: Double, y2: Double, r2: Double): Boolean{
    if(r1<r2){
        return (sqr(x1 - x2) + sqr(y1 - y2) <= sqr(r2-r1))
    }
    else if(r1==r2 && x1==x2 && y1==y2){
        return true
    }
    else return false
}

/**
 * Средняя
 *
 * Определить, пройдет ли кирпич со сторонами а, b, c сквозь прямоугольное отверстие в стене со сторонами r и s.
 * Стороны отверстия должны быть параллельны граням кирпича.
 * Считать, что совпадения длин сторон достаточно для прохождения кирпича, т.е., например,
 * кирпич 4 х 4 х 4 пройдёт через отверстие 4 х 4.
 * Вернуть true, если кирпич пройдёт
 */
fun brickPasses(a: Int, b: Int, c: Int, r: Int, s: Int): Boolean{
    var a:Int = a
    var b:Int = b
    var c:Int = c
    var x:Int = 0

    if(c>a){
        x=c
        c=a
        a=x
        x=0
    }
    if(c>b){
        x=c
        c=b
        b=x
        x=0
    }
    if(b>a){
        x=b
        b=a
        a=x
        x=0
    }
    when{
        r>s && r>=b && s>=c -> return true
        r<=s && s>=b && r>=c -> return true
        else -> return false
    }
}
