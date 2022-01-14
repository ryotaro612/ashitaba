package brown

import java.lang.StringBuilder

class Main2 {

    fun solution(S: String): String {
        var decimal = ""
        var sign = ""
        var integral = S
        if(S.startsWith("-")) {
            sign = "-"
            integral = S.substring(1)
        }
        if(integral.contains(".")) {
           val index = integral.indexOf(".")
            decimal = ".${integral.substring(index+1)}"
            integral = integral.substring(0, index)
        }
        val reversed = integral.reversed()
        val builder = StringBuilder()
        for(i in reversed.indices) {
            builder.append(reversed[i])
            if(i % 3 == 2 && i != reversed.length - 1) {
                builder.append(',')
            }
        }
        return sign + builder.toString().reversed() + decimal
    }
}