@file:Suppress("UNUSED_PARAMETER")
package lesson3.task1

import java.lang.Math.pow
import java.lang.Math.sqrt

/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result = result * i // Please do not fix in master
    }
    return result
}

/**
 * Пример
 *
 * Проверка числа на простоту -- результат true, если число простое
 */
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    for (m in 2..Math.sqrt(n.toDouble()).toInt()) {
        if (n % m == 0) return false
    }
    return true
}

/**
 * Пример
 *
 * Проверка числа на совершенность -- результат true, если число совершенное
 */
fun isPerfect(n: Int): Boolean {
    var sum = 1
    for (m in 2..n/2) {
        if (n % m > 0) continue
        sum += m
        if (sum > n) break
    }
    return sum == n
}

/**
 * Пример
 *
 * Найти число вхождений цифры m в число n
 */
fun digitCountInNumber(n: Int, m: Int): Int =
        when {
            n == m -> 1
            n < 10 -> 0
            else -> digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)
        }

/**
 * Тривиальная
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 */
fun digitNumber(n: Int): Int{
    var size:Int=0
    var n:Int=n
    if(n==0){
        return 1
    }
    else {
        while (n != 0) {
            n = n / 10
            size++
        }
        return size
    }
}

/**
 * Простая
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int{
    var last_number:Int=0
    var next_number:Int=0
    var number_now:Int=1
    var i:Int=1
    while(i<=n){
        if(i==2){
            number_now=1
            last_number=1
        }
        else {
            next_number = last_number + number_now
            last_number = number_now
            number_now = next_number
        }
        i++
    }
    return number_now
}

/**
 * Простая
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun lcm(m: Int, n: Int): Int{
    var x = m
    var y = n
    var result:Int = 0
    do{
        result = x%y
        x=y
        y=result
    }while(result!=0)
    result = (m/x)*n
    return result
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int{
    var resto:Int=5
    var i:Int=1
    while (resto!=0) {
        i++
        resto=n%i
        if(i==(n/2)) return n
    }
    return i
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int{
    var resto:Int = 5
    var i:Int=n
    while (resto != 0) {
        i--
        resto=n%i
    }
    return i
}

/**
 * Простая
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean{
    var temp: Int
    var m:Int= m
    var n:Int=n

    while (true) {
        temp = m % n
        if (temp == 0){
            if(n==1) return true
            else return false
        }
        m = n
        n = temp
    }
}

/**
 * Простая
 *
 * Для заданных чисел m и n, m <= n, определить, имеется ли хотя бы один точный квадрат между m и n,
 * то есть, существует ли такое целое k, что m <= k*k <= n.
 * Например, для интервала 21..28 21 <= 5*5 <= 28, а для интервала 51..61 квадрата не существует.
 */
fun squareBetweenExists(m: Int, n: Int): Boolean{
    var i:Double = m.toDouble()
    while(i<=n){
        if((sqrt(i)%1)==0.0) return true
        i++
    }
    return false
}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */

fun sin(x: Double, eps: Double): Double=TODO()


/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun cos(x: Double, eps: Double): Double = TODO()

/**
 * Средняя
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 * Не использовать строки при решении задачи.
 */
fun revert(n: Int): Int{
    var x:Int = n
    var cont:Int = 0
    var result:Int=0
    var variable:Int=n
    if(n==0){
        result=0
    }
    else{
        while(x>0){
            x /= 10
            cont++
        }
        var arra = IntArray(cont)
        x=0
        arra[0] = n%10
        while(x<cont){
            arra[x] = variable%10
            variable/=10

            x++
        }
        var j:Int=0
        x=cont-1
        while(x>=0) {
            arra[j] *= (pow(10.0, x.toDouble())).toInt()
            x--
            j++
        }

        x=0
        while(x<cont){
            result += arra[x]
            x++
        }
    }
    return result
}

/**
 * Средняя
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 */
fun isPalindrome(n: Int): Boolean{
    var result:Boolean=false
    val y = n.toString()
    val tamanho:Int = y.length
    val vetor = IntArray(tamanho)
    var x:Int=0
    var variav:Int = n

    if(n<10){
        result = true
    }

    while(x<tamanho){
        vetor[x] = variav%10
        variav/=10

        x++
    }
    variav = tamanho-1
    x= 0
    var cont:Int=0
    while(x<tamanho-1){
        if(vetor[x]==vetor[(variav)]){
            cont++
            variav--
        }
        x++
    }

    if(cont>=tamanho-1){
        result = true
    }

    return result
}

/**
 * Средняя
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 */
fun hasDifferentDigits(n: Int): Boolean{
    var result:Boolean=false
    val y = n.toString()
    val tamanho:Int = y.length
    val vetor = IntArray(tamanho)
    var x:Int=0
    var variav:Int = n
    var cont:Int=0
    while(x<tamanho){
        vetor[x] = variav%10
        variav/=10

        x++
    }
    if(n==0){
        result = false
    }
    else if(n<10){
        result = false
    }
    else if(n>99){
        x= 0
        while(x<tamanho-2){
            if(vetor[x]!=vetor[x+1]){
                //result += vetor[x]
                cont++
            }
            x++
        }
        if(cont>0){
            result = true
        }
    }
    else{
        if(vetor[0]!=vetor[1]){
            result = true
        }
    }
    return result
}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 */
fun squareSequenceDigit(n: Int): Int{
    var s:Int=0
    var i:Int=0
    var b:Int=0
    var a:Int=0
    var c:Int=0
    var nn:Int=0
    while(s<n){
        i++
        b=i*i
        c=1
        nn=10
        while((b/nn)!=0){
            nn*=10
            c++
        }
        s+=c
    }
    s-=c
    nn=nn/10
    do{
        a=(b/nn)%10
        nn/=10
        s++
    }while(s!=n)
    return a
}


/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 */
fun fibSequenceDigit(n: Int): Int{
    var arr:String=""
    var y:Int=0
    var z:Int=1
    var next_num:Int=0
    var i:Int= 2
    arr+= 1
    while(i<10000){
        next_num=y+z
        y=z
        z=next_num
        arr+= next_num
        i++
    }
    val result = IntArray(n)
    var index = 0
    val newLength = result.size
    while (index < newLength) {
        val numberRaw = arr.get(index)
        val parsedNumber = Integer.parseInt((numberRaw).toString())
        result[index] = parsedNumber
        ++index
    }
    return result[n-1]
}
