func mostWordsFound(sentences []string) int {
	max := 0

	for _, sentence := range sentences {
		wordCount := wordCount(sentence)
		if wordCount > max {
			max = wordCount
		}
	}
	return max
}

func wordCount(sentence string) int {
	spaceCount := 0

	for _, char := range sentence {
		if char == ' ' {
			spaceCount++
		}
	}

	return spaceCount + 1
}