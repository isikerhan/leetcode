func isPowerOfTwo(n int) bool {
    if n < 0 {
        return false
    }
	bitCount := 0
	for i := 0; i < 32; i++ {
		bitCount += n & 1
		n = n >> 1
		if bitCount > 1 {
			break
		}
	}
	return bitCount == 1
}