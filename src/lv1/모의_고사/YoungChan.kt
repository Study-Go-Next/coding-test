package lv1.모의_고사

fun solution(answers: IntArray): IntArray {

    val p1 = intArrayOf(1,2,3,4,5)
    val p2 = intArrayOf(2,1,2,3,2,4,2,5)
    val p3 = intArrayOf(3,3,1,1,2,2,4,4,5,5)

    return listOf(p1, p2, p3)
        .mapIndexed { idx, value ->
            (idx + 1) to getHitCount(answers, value)
        }
        .run {
            val maxHit = this.maxOf { it.second }
            this
                .filter { it.second == maxHit }
                .map { it.first }
                .toIntArray()
        }
}

fun getHitCount(answers: IntArray, p: IntArray): Int {
    var count = 0
    for(i in answers.indices) {
        val pVal = p[i % p.size]
        if(pVal == answers[i])
            count++
    }
    return count
}