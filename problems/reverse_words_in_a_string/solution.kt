class Solution {
    fun reverseWords(s: String): String = s.split(" +".toRegex()).filter(String::isNotEmpty).reversed().joinToString(" ")
}