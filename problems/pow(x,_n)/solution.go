func myPow(x float64, n int) float64 {
	if n == 0 {
		return 1.0
	}

	if n == 1 {
		return x
	}

	if n == -1 {
		return 1 / x
	}
	powHalf := myPow(x, n/2)
	return myPow(x, n%2) * powHalf * powHalf
}