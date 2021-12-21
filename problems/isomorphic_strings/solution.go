func isIsomorphic(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}

	charMapping := make(map[int32]int32)
	reverseMapping := make(map[int32]int32)
	tr := []rune(t)

	for i, char := range s {
		if mappedChar, ok := charMapping[char]; ok {
			if tr[i] != mappedChar {
				return false
			}
		} else if mappedChar, ok := reverseMapping[tr[i]]; ok {
			if char != mappedChar {
				return false
			}
		} else {
			charMapping[char] = tr[i]
			reverseMapping[tr[i]] = char
		}
	}
	return true
}