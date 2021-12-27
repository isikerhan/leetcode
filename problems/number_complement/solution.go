func findComplement(num int) int {
	return int(^num & (0xFFFFFFFF >> bits.LeadingZeros32(uint32(num))))
}