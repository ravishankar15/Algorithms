class HeapNode:
    def __init__(self, word, freq):
        self.word = word
        self.freq = freq

class Heap:
    def __init__(self, capacity):
        self.harr = [0] * capacity
        self.capacity = capacity
        self.heapSize = 0
    
    def insert(self, val):
        if self.heapSize >= self.capacity:
            raise "Overflow"
        
        i = self.heapSize
        self.heapSize += 1
        self.harr[i] = val

        while(i != 0 and self._compare(self.harr[i], self.harr[self._parent(i)]) > 0):
            self.harr[self._parent(i)], self.harr[i] = self.harr[i], self.harr[self._parent(i)]
            i = self._parent(i)
        
    def getMax(self):
        return self.harr[0]
    
    def isFull(self):
        return self.heapSize == self.capacity
    
    def isEmpty(self):
        return self.heapSize == 0
    
    def extract(self):
        if self.heapSize == 0:
            raise "Empty"
        
        if self.heapSize == 1:
            self.heapSize -= 1
            return self.harr[0]
        
        max = self.harr[0]
        self.harr[0] = self.harr[self.heapSize - 1]
        self.heapSize -= 1
        self._heapify(0)
        return max


    def _heapify(self, i):
        l = self._left(i)
        r = self._right(i)
        largest = i

        if l < self.heapSize and self._compare(self.harr[l], self.harr[i]) > 0:
            largest = l
        if r < self.heapSize and self._compare(self.harr[r], self.harr[largest]) > 0:
            largest = r
        
        if i != largest:
            self.harr[i], self.harr[largest] = self.harr[largest], self.harr[i]
            self._heapify(largest)

    def _compare(self, aNode, bNode):
        if aNode.freq > bNode.freq:
            return 1
        
        if aNode.freq < bNode.freq:
            return -1
        
        if aNode.freq == bNode.freq:
            return 1 if aNode.word < bNode.word else -1

    def _parent(self, i):
        return (i-1) // 2
    
    def _left(self, i):
        return (2 * i) + 1
    
    def _right(self, i):
        return (2 * i) + 2
