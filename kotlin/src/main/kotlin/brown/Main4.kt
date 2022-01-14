package brown

class Main4 {

    fun solution(A: IntArray): Int {
        if(A.size < 3)
            return -1
        val sortedA = A.sorted()
        val size = A.size
        var res = sortedA[size-1] * sortedA[size-2] * sortedA[size-3]
        res = maxOf(res, sortedA[0] * sortedA[1] * sortedA[size-1])
       return res

    }

}