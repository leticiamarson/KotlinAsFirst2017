@file:Suppress("UNUSED_PARAMETER")
package lesson2.task1

import lesson1.task1.discriminant

/**
 * Пример
 *
 * Найти наименьший корень биквадратного уравнения ax^4 + bx^2 + c = 0
 */
fun minBiRoot(a: Double, b: Double, c: Double): Double {
    // 1: в главной ветке if выполняется НЕСКОЛЬКО операторов
    if (a == 0.0) {
        if (b == 0.0) return Double.NaN // ... и ничего больше не делать
        val bc = -c / b
        if (bc < 0.0) return Double.NaN // ... и ничего больше не делать
        return -Math.sqrt(bc)
        // Дальше функция при a == 0.0 не идёт
    }
    val d = discriminant(a, b, c)   // 2
    if (d < 0.0) return Double.NaN  // 3
    // 4
    val y1 = (-b + Math.sqrt(d)) / (2 * a)
    val y2 = (-b - Math.sqrt(d)) / (2 * a)
    val y3 = Math.max(y1, y2)       // 5
    if (y3 < 0.0) return Double.NaN // 6
    return -Math.sqrt(y3)           // 7
}

/**
 * Простая
 *
 * Мой возраст. Для заданного 0 < n < 200, рассматриваемого как возраст человека,
 * вернуть строку вида: «21 год», «32 года», «12 лет».
 */
fun ageDescription(age: Int): String{
    var age:Int = age
    var message:String ="something wrong happened!"
    if(age>0 && age<100){
        if(age==1){
            message = "$age год"
        }
        else if(age>1 && age<=4){
            message = "$age года"
        }
        else if(age>=11 && age<20) {
            message = "$age лет"
        }
        else{
            if((age%10)==1){
                message = "$age год"
            }
            else if(age>1 && age<=4){
                message = "$age года"
            }
            else message = "$age лет"
        }
    }
    else if(age<200){
        age=age-100
        if((age%10)==1 && age<10){
            age=age+100
            message = "$age год"
        }
        else if(age>=11 && age<20) {
            age=age+100
            message = "$age лет"
        }
        else if(age%10>1 && age%10<=4){
            age=age+100
            message = "$age года"
        }
        else{
            age=age+100
            message = "$age лет"
        }
    }
    return message
}

/**
 * Простая
 *
 * Путник двигался t1 часов со скоростью v1 км/час, затем t2 часов — со скоростью v2 км/час
 * и t3 часов — со скоростью v3 км/час.
 * Определить, за какое время он одолел первую половину пути?
 */
fun timeForHalfWay(t1: Double, v1: Double,
                   t2: Double, v2: Double,
                   t3: Double, v3: Double): Double{
    var dt:Double =0.0
    var s1 = v1*t1
    var s2 = v2*t2
    var s3 = v3*t3
    var ds = (s1+s2+s3)/2
    if(ds<= s1){
        dt = ds / v1
    }
    else if(ds<=(s1+s2)) {
        dt = t1 +((ds-s1)/(v2))
    }
    else{
        dt = (t2+t1) +((ds-(s1+s2))/v3)
    }
    return dt
}

/**
 * Простая
 *
 * Нa шахматной доске стоят черный король и две белые ладьи (ладья бьет по горизонтали и вертикали).
 * Определить, не находится ли король под боем, а если есть угроза, то от кого именно.
 * Вернуть 0, если угрозы нет, 1, если угроза только от первой ладьи, 2, если только от второй ладьи,
 * и 3, если угроза от обеих ладей.
 * Считать, что ладьи не могут загораживать друг друга
 */
fun whichRookThreatens(kingX: Int, kingY: Int,
                       rookX1: Int, rookY1: Int,
                       rookX2: Int, rookY2: Int): Int{
    var i:Int = 5
    if(kingX == rookX1 || kingY == rookY1){
        i=1
        if(kingX == rookX2 || kingY == rookY2) {
            i=3
        }
    }
    else if(kingX == rookX2 || kingY == rookY2){
        i=2
        if(kingX == rookX1 || kingY == rookY1) {
            i=3
        }
    }
    else i=0
    return i
}

/**
 * Простая
 *
 * На шахматной доске стоят черный король и белые ладья и слон
 * (ладья бьет по горизонтали и вертикали, слон — по диагоналям).
 * Проверить, есть ли угроза королю и если есть, то от кого именно.
 * Вернуть 0, если угрозы нет, 1, если угроза только от ладьи, 2, если только от слона,
 * и 3, если угроза есть и от ладьи и от слона.
 * Считать, что ладья и слон не могут загораживать друг друга.
 */
fun rookOrBishopThreatens(kingX: Int, kingY: Int,
                          rookX: Int, rookY: Int,
                          bishopX: Int, bishopY: Int): Int{
    var i:Int = 0
    var x:Int = 1
    var y:Int = 1

    if(kingX == rookX || kingY == rookY){
        i=1
        x=bishopX
        y=bishopY
        while(x<=8 && y<=8){
            if(x==kingX && y==kingY){
                i=3
            }
            y++
            x++
        }
        x=bishopX
        y=bishopY
        while(x<=8 && y>=1){
            if(x==kingX && y==kingY){
                i=3
            }
            y--
            x++
        }
        x=bishopX
        y=bishopY
        while(x>=1 && y>=1){
            if(x==kingX && y==kingY){
                i=3
            }
            y--
            x--
        }
        x=bishopX
        y=bishopY
        while(x>=1 && y<=8){
            if(x==kingX && y==kingY){
                i=3
            }
            y++
            x--
        }
    }
    else if(i!=3 || i!=1) {
        x=bishopX
        y=bishopY
        while(x<=8 && y<=8){
            if(x==kingX && y==kingY){
                i=2
            }
            y++
            x++
        }
        x=bishopX
        y=bishopY
        while(x<=8 && y>=1){
            if(x==kingX && y==kingY){
                i=2
            }
            y--
            x++
        }
        x=bishopX
        y=bishopY
        while(x>=1 && y>=1){
            if(x==kingX && y==kingY){
                i=2
            }
            y--
            x--
        }
        x=bishopX
        y=bishopY
        while(x>=1 && y<=8){
            if(x==kingX && y==kingY){
                i=2
            }
            y++
            x--
        }
    }
    else i=0
    return i
}

/**
 * Простая
 *
 * Треугольник задан длинами своих сторон a, b, c.
 * Проверить, является ли данный треугольник остроугольным (вернуть 0),
 * прямоугольным (вернуть 1) или тупоугольным (вернуть 2).
 * Если такой треугольник не существует, вернуть -1.
 */
fun triangleKind(a: Double, b: Double, c: Double): Int{
    var a:Double = a
    var b:Double = b
    var c:Double = c
    var x:Double =0.0
    var answer:Int = -1
    if(c>b){
        x=c
        c=b
        b=x
        x=0.0
    }
    if(b>a){
        x=b
        b=a
        a=x
        x=0.0
    }
    if(c>a){
        x=c
        c=a
        a=x
        x=0.0
    }
    if(((b-c)<a && a<(b+c)) || ((a-c)<b && b<(a+c)) || ((a-b)<c && c<(a+b))){
        var i:Double = (b*b)+(c*c)
        var n:Double = (a*a)
        if(n==i){
            answer = 1
        }
        if(n<i){
            answer = 0
        }
        if(n>i){
            answer = 2
        }
    }
    else answer = -1
    return answer
}

/**
 * Средняя
 *
 * Даны четыре точки на одной прямой: A, B, C и D.
 * Координаты точек a, b, c, d соответственно, b >= a, d >= c.
 * Найти длину пересечения отрезков AB и CD.
 * Если пересечения нет, вернуть -1.
 */
fun segmentLength(a: Int, b: Int, c: Int, d: Int): Int{
    var i:Int =0

    if(c==a){
        if(d<=b) i= d-c
        else i=b-c
    }
    else if(c>a){
        if(d<=b) i= d-c
        else i= b-c
    }
    else if(c<a){
        if(d>a){
            if(d<b) i=d-a
            else i=b-a
        }
        else if(d==a) i=0
        else i=-1
    }
    else if(b<c) i=-1
    else if(b==c) i=0
    else i=2
    return i
}
