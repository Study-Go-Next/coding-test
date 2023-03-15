package lv1.바탕화면_정리

fun main() {

    // 문제 정의
    // 최소 거리로 드래그할 수 있는 방법을 찾는 것

    // 접근 방식
    // 드래그는 직사각형으로만 가능하기 때문에 주어진 데이터에서
    // 가장 작은 값 (상, 좌)
    // 가장 큰 값 (하, 우)

    val arrayOf1 = arrayOf(".#...", "..#..", "...#.")
    val arrayOf2 = arrayOf("..........", ".....#....", "......##..", "...##.....", "....#.....")
    val arrayOf3 = arrayOf(".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#....")
    val arrayOf4 = arrayOf("..", "#.")
    println(solution(arrayOf1).joinToString(","))
    println(solution(arrayOf2).joinToString(","))
    println(solution(arrayOf3).joinToString(","))
    println(solution(arrayOf4).joinToString(","))

}

fun solution(wallpaper: Array<String>): IntArray {

    var lux = 50
    var luy = 50
    var rdx = 0
    var rdy = 0

    for(y in wallpaper.indices) {
        val s = wallpaper[y]
        for(x in s.indices) {
            if(s[x] == '#') {
                if(x < lux) lux = x
                if(y < luy) luy = y
                if(x+1 > rdx) rdx = x+1
                if(y+1 > rdy) rdy = y+1
            }
        }
    }

    return intArrayOf(luy, lux, rdy, rdx)
}