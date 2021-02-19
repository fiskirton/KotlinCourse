package complex

class Matrix constructor(private var matrix: Array<Array<Complex>>) {
    private var cols: Int = 0
    private var rows: Int = 0

    private fun Array<Array<Complex>>.copy() = Array(size) { get(it).clone() }

    init {
        this.rows = matrix[0].size
        this.cols = matrix.size

        this.matrix = matrix.copy()
    }

    fun sum(rightOperand: Matrix): Matrix? {
        if (this.cols != rightOperand.rows){
            System.out.println("Unavailable sizes");
            return null;
        }

        val sumMatrix = Array(rows) { Array(cols) { Complex(0.0, 0.0) } }
        this.matrix.forEachIndexed { i, row ->
            row.forEachIndexed { j, col ->
                sumMatrix[i][j] = col + rightOperand.matrix[i][j]
            }
        }

        return Matrix(sumMatrix);
    }

    fun mul(rightOperand: Matrix): Matrix? {

        if (this.cols != rightOperand.rows){
            System.out.println("Unavailable sizes");
            return null;
        }

        val mulMatrix = Array(rows) { Array(cols) { Complex(0.0, 0.0) } }

        this.matrix.forEachIndexed { i, row ->
            rightOperand.matrix.forEachIndexed { j, _ ->
                row.forEachIndexed { k, _ ->
                    mulMatrix[i][j] = mulMatrix[i][j] + (this.matrix[i][k] * rightOperand.matrix[k][j])
                }
            }
        }

        return Matrix(mulMatrix)
    }

    fun transp(): Matrix {

        val transpMatrix = Array(rows) { Array(cols) { Complex(0.0, 0.0) } }
        this.matrix.forEachIndexed { i, row ->
            row.forEachIndexed { j, col ->
                transpMatrix[j][i] = col
            }
        }

        return Matrix(transpMatrix);

    }

    override fun toString(): String {
        var res: String = ""
        this.matrix.forEach { row ->
            row.forEach{ col ->
                res += col
                res += " "
            }
            res += "\n"
        }
        return res
    }
}