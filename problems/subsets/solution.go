func subsets(nums []int) [][]int {
	result := [][]int{}
	findSubsets(nums, []int{}, 0, &result)
	return result
}

func findSubsets(nums []int, current []int, index int, result *[][]int) {
	if index == len(nums)+1 {
		return
	}

	clone := make([]int, len(current))
	copy(clone, current)
	*result = append(*result, clone)

	for i := index; i < len(nums); i++ {
		current = append(current, nums[i])
		findSubsets(nums, current, i+1, result)
		current = current[:len(current)-1]
	}
}
