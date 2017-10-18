@file:Suppress("UNUSED_PARAMETER")
package lesson3.task1

import java.lang.Math.pow

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
    var y = n.toString()
    var tamanho:Int = y.length
    if(n<0){
        tamanho = y.length -1
    }
    return tamanho
}

/**
 * Простая
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int{
    var i:Int= 2
    var j:Int = 0
    var vetor = IntArray(200)
    vetor[0] = 1
    vetor[1] = 1
    while(i<200){
        j=1
        if(i==2){
            while(j<=i){
                vetor[i]= vetor[i] + vetor[i-j]
                j++
            }
        }
        else{
            while(j<=2){
                vetor[i]= vetor[i] + vetor[i-j]
                j++
            }
        }
        i++
    }
    return vetor[n-1]
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
    result = (m*n)/x
    return result
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int{
    var resto:Int = 5
    var i:Int=1
    if(n==1){
        i=1
    }
    else {
        while (resto != 0) {
            i++
            resto = n % i
        }
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
    if(n==1){
        i=1
    }
    else {
        while (resto != 0) {
            i--
            resto = n % i
        }
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
    var result:Boolean = false
    var cont:Int=0
    if(n>m){
        var i:Int= n-1
        while(i>0){
            if(n%i==0){
                if(m%i==0){
                    cont++
                }
            }
            i--
        }
    }
    else if(n==1 && m==1){
        cont=1
    }
    else{
        var i:Int= m-1
        while(i>0){
            if(m%i==0){
                if(n%i==0){
                    cont++
                }
            }
            i--
        }
    }
    if(cont==1){
        result = true
    }
    return result
}

/**
 * Простая
 *
 * Для заданных чисел m и n, m <= n, определить, имеется ли хотя бы один точный квадрат между m и n,
 * то есть, существует ли такое целое k, что m <= k*k <= n.
 * Например, для интервала 21..28 21 <= 5*5 <= 28, а для интервала 51..61 квадрата не существует.
 */
fun squareBetweenExists(m: Int, n: Int): Boolean{
    var result:Boolean = false
    var i:Int = 1

    for(i in 1..n){
        if((i*i)>=m){
            if((i*i)<=n)
                result = true
        }
    }
    if(n==0 && m==0){
        result = true
    }
    if(n== Int.MAX_VALUE){
        result = false
    }
    return result
}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
/*
fun fatorial(x:Int):Double{
    if(x>1){
        return x * factorial(x-1)
    }
    else {
        return 1.0
    }
}
*/
fun sin(x: Double, eps: Double): Double= TODO()
  /*  var result:Double = x
    var i:Int = 1
    var radiano:Double = 0.0
    var oto:Double = 0.0

    radiano = (x/180.0)* Math.PI

    while((pow(x,i.toDouble())/ fatorial(i))>0.001){
        result += oto*(pow(radiano,i.toDouble())/ fatorial(i))
        i+=2
        oto *= -1
    }

    return result
    */


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
    var resposta:String=""
    var y:Int=0
    var multiplica:Int=0
    while(y<10000){
        multiplica = (y + 1) * (y + 1)
        resposta += multiplica
        y++
        multiplica =0
        }
    val result = IntArray(n*10)
    var index = 0
    val newLength = result.size
    while (index < newLength) {
        val numberRaw = resposta.get(index)
        val parsedNumber = Integer.parseInt((numberRaw).toString())
        result[index] = parsedNumber
        ++index
    }
    return result[n-1]
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
    var proximo:Int=0
    var i:Int= 2
    arr+= 1
    while(i<10000){
        proximo=y+z
        y=z
        z=proximo
        arr+= proximo
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
