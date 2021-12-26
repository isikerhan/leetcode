type TrieNode struct {
	Terminal bool
	Children map[byte]*TrieNode
}

type Trie struct {
	Root *TrieNode
}

func (trie Trie) Insert(word string) {

	node := trie.Root
	for _, char := range word {
		if val, exists := node.Children[byte(char)]; exists {
			node = val
		} else {
			newNode := TrieNode{Terminal: false, Children: make(map[byte]*TrieNode)}
			node.Children[byte(char)] = &newNode
			node = &newNode
		}
	}
	node.Terminal = true
}

func (trie Trie) Remove(word string) {
	node := trie.Root
	lastTerminal := node
	lastTerminalIndex := -1

	for i, char := range word {
		child, exists := node.Children[byte(char)]
		if !exists {
			return
		}
		node = child
		if (node.Terminal || len(node.Children) > 1) && i != len(word)-1 {
			lastTerminal = node
			lastTerminalIndex = i
		}
	}
	node.Terminal = false
	if len(node.Children) == 0 {
		delete(lastTerminal.Children, word[lastTerminalIndex+1])
	}
}

func findWords(board [][]byte, words []string) []string {
	trie := Trie{Root: &TrieNode{Terminal: false, Children: make(map[byte]*TrieNode)}}
	for _, word := range words {
		trie.Insert(word)
	}
	result := make([]string, 0)

	for i := range board {
		for j := range board[i] {
			char := board[i][j]
			if val, exists := trie.Root.Children[char]; exists {
				subresult := make([]string, 0)
				search(board, i, j, *val, string(char), &subresult, [][]int{}, len(words))
				for _, item := range subresult {
					trie.Remove(item)
					if !containsStr(result, item) {
						result = append(result, item)
					}
				}
			}
		}
	}

	return result
}

func search(board [][]byte, i int, j int, node TrieNode, currWord string, result *[]string, history [][]int, numWords int) {

	if len(*result) == numWords {
		return
	}

	if containsIntSlice(history, []int{i, j}) {
		return
	}

	if node.Terminal && !containsStr(*result, currWord) {
		*result = append(*result, currWord)
	}

	neighbors := [][]int{{i - 1, j}, {i, j - 1}, {i, j + 1}, {i + 1, j}}

	for _, neighbor := range neighbors {
		row, col := neighbor[0], neighbor[1]
		if row < 0 || row >= len(board) || col < 0 || col >= len(board[row]) {
			continue
		}
		char := board[row][col]
		if val, exists := node.Children[char]; exists {
			search(board, row, col, *val, currWord+string(char), result, append(history, []int{i, j}), numWords)
		}
	}
}

func containsStr(s []string, e string) bool {
	for _, a := range s {
		if a == e {
			return true
		}
	}
	return false
}

func containsIntSlice(s [][]int, e []int) bool {
	for _, a := range s {
		if reflect.DeepEqual(a, e) {
			return true
		}
	}
	return false
}