type CacheNode struct {
	Key  int
	Val  int
	Prev *CacheNode
	Next *CacheNode
}

type LRUCache struct {
	Capacity int
	Count    int
	Cache    map[int]*CacheNode
	Head     *CacheNode
	Tail     *CacheNode
}

func Constructor(capacity int) LRUCache {
	return LRUCache{Capacity: capacity, Count: 0, Cache: make(map[int]*CacheNode)}
}

func (this *LRUCache) Get(key int) int {
	if val, exists := this.Cache[key]; exists {
		this.RemoveNode(val)
		this.AddFirst(val)
		return val.Val
	}
	return -1
}

func (this *LRUCache) Put(key int, value int) {
	newNode := &CacheNode{Key: key, Val: value}
	if existingNode, exists := this.Cache[key]; exists {
		this.RemoveNode(existingNode)
		delete(this.Cache, key)
		this.Count--
	}

	this.Cache[key] = newNode
	this.AddFirst(newNode)
	this.Count++

	if this.Count > this.Capacity {
		tail := this.Tail
		this.RemoveNode(tail)
		delete(this.Cache, tail.Key)
		this.Count--
	}
}

func (this *LRUCache) AddFirst(node *CacheNode) {
	node.Prev = nil
	node.Next = this.Head
	if this.Head != nil {
		this.Head.Prev = node
	} else {
		this.Tail = node
	}
	this.Head = node
}

func (this *LRUCache) AddLast(node *CacheNode) {
	node.Prev = this.Tail
	node.Next = nil
	if this.Tail != nil {
		this.Tail.Next = node
	} else {
		this.Head = node
	}
	this.Tail = node
}

func (this *LRUCache) RemoveNode(node *CacheNode) {
	if node.Prev != nil {
		node.Prev.Next = node.Next
	}
	if node.Next != nil {
		node.Next.Prev = node.Prev
	}
	if this.Head == node {
		this.Head = node.Next
	}
	if this.Tail == node {
		this.Tail = node.Prev
	}
	node.Next = nil
	node.Prev = nil
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * obj := Constructor(capacity);
 * param_1 := obj.Get(key);
 * obj.Put(key,value);
 */