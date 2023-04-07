package lv1.최댓값과_최솟값

fun solution(s: String): String {
    return s
        .split(" ")
        .map(String::toInt)
        .run { "${max()} ${min()}" }
}