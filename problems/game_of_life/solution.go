func gameOfLife(board [][]int) {
	for i, row := range board {
		for j, val := range row {
			numLiveNeighbors := numberOfLiveNeighbors(i, j, board)
			var live bool
			if val == 1 && numLiveNeighbors < 2 {
				live = false
			} else if val == 1 && numLiveNeighbors < 4 {
				live = true
			} else if val == 1 {
				live = false
			} else if numLiveNeighbors == 3 {
				live = true
			} else {
				live = false
			}
			if live {
				board[i][j] += 10
			}
		}
	}

	for i, row := range board {
		for j, val := range row {
			if val >= 10 {
				board[i][j] = 1
			} else {
				board[i][j] = 0
			}
		}
	}
}

func numberOfLiveNeighbors(i int, j int, board [][]int) int {
	numNeighbors := 0
	neighbors := [][]int{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}}

	for _, neighbor := range neighbors {
		row, col := i+neighbor[0], j+neighbor[1]
		if row >= 0 && row < len(board) && col >= 0 && col < len(board[row]) && board[row][col]%10 == 1 {
			numNeighbors++
		}
	}

	return numNeighbors
}
