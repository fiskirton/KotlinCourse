import complex.Complex
import complex.Matrix

fun main() {

    /*Complex complex = new Complex(1, 2);
    Complex complex1 = new Complex(2, 3);
    System.out.println(complex.sum(complex1));
    System.out.println(complex.mul(complex1));
    System.out.println(complex.printGeom());*/
    val test = Array(3) { Array(3) { Complex(0.0, 0.0) } }
    val test1 = Array(3) { Array(3) { Complex(0.0, 0.0) } }
    for (i in 0..2) {
        for (j in 0..2) {
            test[i][j] = Complex((i + j).toDouble(), 1.0)
            test1[i][j] = Complex((i + j).toDouble(), 1.0)
        }
    }
    val matrix = Matrix(test)
    val matrix1 = Matrix(test1)
    val sum = matrix.sum(matrix1)
    val mul = matrix.mul(matrix1)
    val transp = matrix.transp()
    println(matrix)
    println(matrix1)
    println(sum)
    println(mul)
    println(transp)
}