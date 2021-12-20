import (
	"fmt"
	"math"
	"sort"
)

func minimumAbsDifference(arr []int) [][]int {
	sort.Ints(arr)

	minAbs := math.MaxInt32
	pairs := [][]int{}

	for i := 0; i < len(arr)-1; i++ {
		diff := arr[i] - arr[i+1]
		abs := int(math.Abs(float64(diff)))
		if abs == minAbs {
			pairs = append(pairs, []int{arr[i], arr[i+1]})
		} else if abs < minAbs {
			pairs = [][]int{{arr[i], arr[i+1]}}
			minAbs = abs
		}
	}

	return pairs
}