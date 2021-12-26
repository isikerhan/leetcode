func kClosest(points [][]int, k int) [][]int {
	sort.Slice(points, func(i, j int) bool { return dist(points[i]) < dist(points[j]) })
	return points[:k]
}

func dist(point []int) int {
	return point[0]*point[0] + point[1]*point[1]
}