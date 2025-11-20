package main

import (
	"container/heap"
	"fmt"
)

// IntHeap is a min-heap of ints.
type IntMinHeap []int

func (h IntMinHeap) Len() int           { return len(h) }
func (h IntMinHeap) Less(i, j int) bool { return h[i] < h[j] } // min-heap
func (h IntMinHeap) Swap(i, j int)      { h[i], h[j] = h[j], h[i] }

func (h *IntMinHeap) Push(x any) {
	*h = append(*h, x.(int))
}

func (h *IntMinHeap) Pop() any {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

// IntMaxHeap is a max-heap of ints.
type IntMaxHeap []int

func (h IntMaxHeap) Len() int           { return len(h) }
func (h IntMaxHeap) Less(i, j int) bool { return h[i] > h[j] } // reversed -> max-heap
func (h IntMaxHeap) Swap(i, j int)      { h[i], h[j] = h[j], h[i] }

// Peek returns the top element of the heap without removing it.
// It returns nil if the heap is empty.
func (h IntMaxHeap) Peek() int {
	return h[0]
}

func (h *IntMaxHeap) Push(x any) {
	*h = append(*h, x.(int))
}

func (h *IntMaxHeap) Pop() any {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[:n-1]
	return x
}

func main() {
	nums := []int{3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5}
	k := 3
	h := IntMinHeap(nums[:k])
	heap.Init(&h)

	for _, n := range nums[k:] {
		if n > h[0] {
			heap.Pop(&h)
			heap.Push(&h, n)
		}
	}

	fmt.Println(h[0])
}
