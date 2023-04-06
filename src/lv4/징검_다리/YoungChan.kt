package lv4.징검_다리

fun solution(distance: Int, rocks: IntArray, n: Int): Int {
    var answer = 0
    rocks.sort()
    var left = 0
    var right = distance
    while (left <= right) {
        val mid = (left + right) / 2
        var removed = 0
        var prev = 0
        for (rock in rocks) {
            if (rock - prev < mid) {
                removed++
            } else {
                prev = rock
            }
        }
        if (distance - prev < mid) {
            removed++
        }
        if (removed <= n) {
            answer = mid
            left = mid + 1
        } else {
            right = mid - 1
        }
    }
    return answer
}