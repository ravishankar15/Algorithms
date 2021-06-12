class MaxHeap
    attr_accessor :harr, :capacity, :heap_size

    def initialize(capacity)
        @heap_size = 0
        @capacity = capacity
        @harr = Array.new(@capacity)
    end

    def insert(val)
        raise 'Overflow' if @heap_size == @capacity

        i = @heap_size
        @heap_size += 1
        @harr[i] = val

        while(i != 0 && @harr[i] > @harr[parent(i)])
            @harr[parent(i)], @harr[i] = @harr[i], @harr[parent(i)]
			i = parent(i);
		end
    end

    def get_max()
        @harr[0]
    end

    def extract_max()
        raise 'empty heap' if @heap_size == 0

        if @heap_size == 1
            @heap_size -= 1
            return @harr[0]
        end

        max = @harr[0]
        @harr[0] = @harr[@heap_size - 1]
        @heap_size -= 1
        max_heapify(0)
        max
    end

    def max_heapify(i)
        l = left(i); r = right(i)
        largest = i

        largest = l if (l < @heap_size && @harr[l] > @harr[i])
        largest = r if (r < @heap_size && @harr[r] > @harr[largest])

        if (largest != i)
            @harr[largest], @harr[i] = @harr[i], @harr[largest]
            max_heapify(largest)
        end
    end

    private
        def parent(i)
            (i-1)/2
        end

        def left(i)
            (2*i) + 1
        end

        def right(i)
            (2*i) + 2
        end
end
mh = MaxHeap.new(5)
mh.insert(2)
mh.insert(7)
mh.insert(2)
mh.insert(16)
puts mh.extract_max
mh.insert(4)
puts mh.extract_max
puts mh.extract_max
puts mh.extract_max
puts mh.extract_max