import (
	"math"
	"sort"
)

func merge(intervals [][]int) [][]int {

	sort.Slice(intervals, func(i, j int) bool {
		return intervals[i][0] < intervals[j][0]
	})

	merged := [][]int{intervals[0]}

	for i := 1; i < len(intervals); i++ {
		current := intervals[i]
		lastMerged := merged[len(merged)-1]
		if current[0] <= lastMerged[1] {
			lastMerged[1] = int(math.Max(float64(lastMerged[1]), float64(current[1])))
		} else {
			merged = append(merged, current)
		}
	}

	return merged
}