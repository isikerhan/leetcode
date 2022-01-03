func findJudge(n int, trust [][]int) int {
	trustMap := map[int]int{}
	for i := 1; i <= n; i++ {
		trustMap[i] = 0
	}

	for _, t := range trust {
		trusting := t[0]
		trusted := t[1]
		delete(trustMap, trusting)

		if val, exists := trustMap[trusted]; exists {
			trustMap[trusted] = val + 1
		}
	}

	result := []int{}

	for key, val := range trustMap {
		if val == n-1 {
			result = append(result, key)
		}
	}

	if len(result) == 1 {
		return result[0]
	} else {
		return -1
	}
}
