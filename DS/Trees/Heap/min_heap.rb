class MinHeap
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

        while(i != 0 && @harr[parent(i)] > @harr[i])
            @harr[parent(i)], @harr[i] = @harr[i], @harr[parent(i)]
			i = parent(i);
		end
    end

    def get_min()
        @harr[0]
    end

    def extract_min()
        raise 'empty heap' if @heap_size == 0

        if @heap_size == 1
            @heap_size -= 1
            return @harr[0]
        end

        min = @harr[0]
        @harr[0] = @harr[@heap_size - 1]
        @heap_size -= 1
        min_heapify(0)
        min
    end

    def min_heapify(i)
        l = left(i); r = right(i)
        smallest = i

        smallest = l if (l < @heap_size && @harr[l] < @harr[i])
        smallest = r if (r < @heap_size && @harr[r] < @harr[smallest])

        if (smallest != i)
            @harr[smallest], @harr[i] = @harr[i], @harr[smallest]
            min_heapify(smallest)
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
mh = MinHeap.new(5)
mh.insert(2)
mh.insert(7)
mh.insert(13)
mh.insert(16)
puts mh.extract_min
mh.insert(4)
puts mh.extract_min
mh.insert(16)
puts mh.extract_min
mh.insert(14)
puts mh.extract_min