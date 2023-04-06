package lv3.입국_심사

/**
 * 1. 찾아야 할 정답의 범위를 정하기
 * 2. 정답을 mid 값으로 간주한 후 정답이 유효한지 확인
 * 3. 2번 여부를 계속 확인하며 이분 탐색 진행
 * 4. 탐색 조건 left, right 를 벗어나면 종료
 */

fun solution(n: Int, times: IntArray): Long {
    var answer: Long = 0
    var left: Long = 0
    var right = times.max() * n.toLong()
    while (left <= right) {
        val mid = (left + right) / 2
        var complete = 0L
        for (time in times)
            complete += mid / time
        if (complete < n)
            left = mid + 1
        else {
            right = mid - 1
            answer = mid
        }
    }
    return answer
}