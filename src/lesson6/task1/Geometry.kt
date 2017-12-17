@file:Suppress("UNUSED_PARAMETER")
package lesson6.task1

import lesson1.task1.sqr

/**
 * Точка на плоскости
 */
data class Point(val x: Double, val y: Double) {
    /**
     * Пример
     *
     * Рассчитать (по известной формуле) расстояние между двумя точками
     */
    fun distance(other: Point): Double = Math.sqrt(sqr(x - other.x) + sqr(y - other.y))
}

/**
 * Треугольник, заданный тремя точками (a, b, c, см. constructor ниже).
 * Эти три точки хранятся в множестве points, их порядок не имеет значения.
 */
class Triangle private constructor(private val points: Set<Point>) {

    private val pointList = points.toList()

    val a: Point get() = pointList[0]

    val b: Point get() = pointList[1]

    val c: Point get() = pointList[2]

    constructor(a: Point, b: Point, c: Point): this(linkedSetOf(a, b, c))
    /**
     * Пример: полупериметр
     */
    fun halfPerimeter() = (a.distance(b) + b.distance(c) + c.distance(a)) / 2.0

    /**
     * Пример: площадь
     */
    fun area(): Double {
        val p = halfPerimeter()
        return Math.sqrt(p * (p - a.distance(b)) * (p - b.distance(c)) * (p - c.distance(a)))
    }

    /**
     * Пример: треугольник содержит точку
     */
    fun contains(p: Point): Boolean {
        val abp = Triangle(a, b, p)
        val bcp = Triangle(b, c, p)
        val cap = Triangle(c, a, p)
        return abp.area() + bcp.area() + cap.area() <= area()
    }

    override fun equals(other: Any?) = other is Triangle && points == other.points

    override fun hashCode() = points.hashCode()

    override fun toString() = "Triangle(a = $a, b = $b, c = $c)"
}

/**
 * Окружность с заданным центром и радиусом
 */
data class Circle(val center: Point, val radius: Double) {
    val x: Double = center.x
    val y: Double = center.y
    /**
     * Простая
     *
     * Рассчитать расстояние между двумя окружностями.
     * Расстояние между непересекающимися окружностями рассчитывается как
     * расстояние между их центрами минус сумма их радиусов.
     * Расстояние между пересекающимися окружностями считать равным 0.0.
     */
    fun distance(other: Circle): Double{
        val dist = Math.sqrt(sqr(x - other.x) + sqr(y - other.y))-(radius + other.radius)
        if(contains(center).equals(true) && dist!=-1.0) return dist
        else return 0.0
    }

    /**
     * Тривиальная
     *
     * Вернуть true, если и только если окружность содержит данную точку НА себе или ВНУТРИ себя
     */
    fun contains(p: Point): Boolean{
        val i:Double = p.x
        val j:Double = p.y
        return sqr(x - i) + sqr(y - j) <= sqr(radius)
    }
}

/**
 * Отрезок между двумя точками
 */
data class Segment(val begin: Point, val end: Point) {
    override fun equals(other: Any?) =
            other is Segment && (begin == other.begin && end == other.end || end == other.begin && begin == other.end)

    override fun hashCode() =
            begin.hashCode() + end.hashCode()
}

/**
 * Средняя
 *
 * Дано множество точек. Вернуть отрезок, соединяющий две наиболее удалённые из них.
 * Если в множестве менее двух точек, бросить IllegalArgumentException
 */
fun diameter(vararg points: Point): Segment{
    var j:Int=1
    var p1 = 0
    var p2 = 0
    var valuesy = 0
    var valuesx = 0
    var max:Double = points[0].x
    //var maxy:Double = points[0].y
    var min:Double = points[0].x
    //var miny:Double = points[0].y

    try {
        for(i in 0..points.size-1){
            j=0
            while(j<points.size){
                if(max<Math.sqrt(sqr(points[j].x - points[i].x)+sqr(points[j].y - points[i].y))) {
                    max= Math.sqrt(sqr(points[j].x - points[i].x)+sqr(points[j].y - points[i].y))
                    p1 = i
                }
                j++
            }
        }
        j=0
        while(j<points.size){
        if(min<Math.sqrt(sqr(points[j].x - points[p1].x)+sqr(points[j].y - points[p1].y))) {
            min= Math.sqrt(sqr(points[j].x - points[p1].x)+sqr(points[j].y - points[p1].y))
            p2 = j
        }
            j++
        }
        /*
        for(i in 0..valuesx.size-2){
            if(valuesx[i]==valuesx.max() || valuesy[i]==valuesy.max()) p1=i
            if(valuesy[i]==valuesy.min() || valuesx[i]==valuesx.min()) p2=i
        }
        */
        return Segment(points[p1], points[p2])
        /*
        while (i < points.size) {
            if (max < Math.abs(points[i].x - points[i].y)) {
                max = Math.abs(points[i].x - points[i].y)
                p1 = i
            }
            if (min >= Math.abs(points[i].x - points[i].y) && Math.abs(points[i].x - points[i].y) > 0) {
                min = Math.abs(points[i].x - points[i].y)
                p2 = i
            }
            i++
        }
        return Segment(points[p2], points[p1])
        */
    }
    catch (e: IndexOutOfBoundsException){
        return throw IllegalAccessError("cannot have less than 2 points")
    }
}

/**
 * Простая
 *
 * Построить окружность по её диаметру, заданному двумя точками
 * Центр её должен находиться посередине между точками, а радиус составлять половину расстояния между ними
 */
fun circleByDiameter(diameter: Segment): Circle{
    val x1=diameter.begin.x
    val y1=diameter.begin.y
    val x2=diameter.end.x
    val y2=diameter.end.y
    var point = Point((x1+x2)/2,(y1+y2)/2)
    var raio = Math.sqrt(sqr((x1+x2)/2)+sqr((y1+y2)/2))
    return Circle(point,raio)
}

/**
 * Прямая, заданная точкой point и углом наклона angle (в радианах) по отношению к оси X.
 * Уравнение прямой: (y - point.y) * cos(angle) = (x - point.x) * sin(angle)
 * или: y * cos(angle) = x * sin(angle) + b, где b = point.y * cos(angle) - point.x * sin(angle).
 * Угол наклона обязан находиться в диапазоне от 0 (включительно) до PI (исключительно).
 */
class Line private constructor(val b: Double, val angle: Double) {
    init {
        assert(angle >= 0 && angle < Math.PI) { "Incorrect line angle: $angle" }
    }

    constructor(point: Point, angle: Double): this(point.y * Math.cos(angle) - point.x * Math.sin(angle), angle)
    /**
     * Средняя
     *
     * Найти точку пересечения с другой линией.
     * Для этого необходимо составить и решить систему из двух уравнений (каждое для своей прямой)
     */
    fun crossPoint(other: Line): Point= TODO()
        

    override fun equals(other: Any?) = other is Line && angle == other.angle && b == other.b

    override fun hashCode(): Int {
        var result = b.hashCode()
        result = 31 * result + angle.hashCode()
        return result
    }

    override fun toString() = "Line(${Math.cos(angle)} * y = ${Math.sin(angle)} * x + $b)"
}

/**
 * Средняя
 *
 * Построить прямую по отрезку
 */
fun lineBySegment(s: Segment): Line = Line(s.begin, (Math.atan((s.end.y - s.begin.y) / (s.end.x - s.begin.x))))

/**
 * Средняя
 *
 * Построить прямую по двум точкам
 */
fun lineByPoints(a: Point, b: Point): Line = lineBySegment(Segment(a, b))

/**
 * Сложная
 *
 * Построить серединный перпендикуляр по отрезку или по двум точкам
 */
fun bisectorByPoints(a: Point, b: Point): Line {
    val center = Point((a.x + b.x)/2, (a.y + b.y)/2)
    if (a.x == b.x) return Line(center, 0.0)
    return Line(center,  Math.PI/2)
}
/**
 * Средняя
 *
 * Задан список из n окружностей на плоскости. Найти пару наименее удалённых из них.
 * Если в списке менее двух окружностей, бросить IllegalArgumentException
 */
fun findNearestCirclePair(vararg circles: Circle): Pair<Circle, Circle> = TODO()

/**
 * Сложная
 *
 * Дано три различные точки. Построить окружность, проходящую через них
 * (все три точки должны лежать НА, а не ВНУТРИ, окружности).
 * Описание алгоритмов см. в Интернете
 * (построить окружность по трём точкам, или
 * построить окружность, описанную вокруг треугольника - эквивалентная задача).
 */
fun circleByThreePoints(a: Point, b: Point, c: Point): Circle = TODO()

/**
 * Очень сложная
 *
 * Дано множество точек на плоскости. Найти круг минимального радиуса,
 * содержащий все эти точки. Если множество пустое, бросить IllegalArgumentException.
 * Если множество содержит одну точку, вернуть круг нулевого радиуса с центром в данной точке.
 *
 * Примечание: в зависимости от ситуации, такая окружность может либо проходить через какие-либо
 * три точки данного множества, либо иметь своим диаметром отрезок,
 * соединяющий две самые удалённые точки в данном множестве.
 */
fun minContainingCircle(vararg points: Point): Circle = TODO()

