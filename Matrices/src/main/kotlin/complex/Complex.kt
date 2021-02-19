package complex

import kotlin.math.*


class Complex constructor(private var real: Double, private var img: Double) {

    operator fun plus(complexRight: Complex): Complex {
        return Complex(this.real + complexRight.real, this.img + complexRight.img)
    }

    operator fun times(complexRight: Complex): Complex {
        val resReal = this.real * complexRight.real - this.img * complexRight.img
        val resImg =  this.real * complexRight.img + this.img * complexRight.real
        return Complex(resReal, resImg)
    }

    fun printGeom(): String {
        val r = sqrt(this.real * this.real + this.img * this.img)
        val phi = acos(cos(this.real / r))

        val formatString = "%.2f(cos(%2$.2f)+isin(%2$.2f))"

        return String.format(formatString, r, phi);

    }

    override fun toString(): String {
        val formatString: String

        return if (this.img == 0.0){
            formatString = "%.2f"
            String.format(formatString, this.real);
        }else {
            formatString = "%.2f%+.2fi"
            String.format(formatString, this.real, this.img);
        }
    }
}