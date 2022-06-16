class Solution {
    fun longestPalindrome(s: String): String {
        var longest = ""
        for (i in s.indices) {
            val current = longest(
                palindrome(s, i, i),
                if (s[i] == s.getOrNull(i + 1))
                    palindrome(s, i, i + 1)
                else ""
            )
            if (current.length > longest.length)
                longest = current
        }
        return longest
    }

    fun longest(s1: String, s2: String): String {
        if (s1.length >= s2.length)
            return s1
        return s2
    }

    fun palindrome(s: String, left: Int, right: Int): String {
        var l = left
        var r = right

        while (l >= 0 && r < s.length && s[l] == s[r]) {
            l--
            r++
        }

        return s.substring(l + 1 until r)
    }
}