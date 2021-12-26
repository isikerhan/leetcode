type NumWithIndex struct {
	Num   int
	Index int
}

func twoSum(nums []int, target int) []int {
	numsWithIndexes := make([]NumWithIndex, 0)

	for index, num := range nums {
		numsWithIndexes = append(numsWithIndexes, NumWithIndex{Num: num, Index: index})
	}
	sort.Slice(numsWithIndexes, func(i, j int) bool { return numsWithIndexes[i].Num < numsWithIndexes[j].Num })

	left := 0
	right := len(numsWithIndexes) - 1

	for left < right {
		sum := numsWithIndexes[left].Num + numsWithIndexes[right].Num
		if sum == target {
			break
		} else if sum < target {
			left++
		} else {
			right--
		}
	}
	return []int{numsWithIndexes[left].Index, numsWithIndexes[right].Index}
}