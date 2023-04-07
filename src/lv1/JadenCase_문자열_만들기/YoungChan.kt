package lv1.JadenCase_문자열_만들기

fun solution(s: String): String {
    return s
        .split(" ")
        .joinToString(" ") { it.lowercase().replaceFirstChar(Char::titlecase) }
}