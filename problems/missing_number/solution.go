func missingNumber(nums []int) int {
	for i := 0; i < len(nums); i++ {
		if nums[i] == -1 {
			continue
		}
		if nums[i] < len(nums) {
			if nums[i] == i {
				nums[i] = -1
			} else {
				temp := nums[nums[i]]
				nums[nums[i]] = -1
				nums[i] = temp
				i--
			}
		}
	}

	missing := len(nums)
	for i, num := range nums {
		if num >= 0 {
			missing = i
			break
		}
	}

	return missing
}