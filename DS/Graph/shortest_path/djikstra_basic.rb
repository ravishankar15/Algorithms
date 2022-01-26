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

        while(i != 0 && @harr[parent(i)][1] > @harr[i][1])
            @harr[parent(i)], @harr[i] = @harr[i], @harr[parent(i)]
			i = parent(i);
		end
    end

    def get_min()
        @harr[0]
    end

    def empty?
        @heap_size == 0
    end

    def poll()
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

        smallest = l if (l < @heap_size && @harr[l][1] < @harr[i][1])
        smallest = r if (r < @heap_size && @harr[r][1] < @harr[smallest][1])

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

def dijikstra(edges, src, n)
    graph = {}; int_max = 2**32
    edges.each do |edge|
        graph[edge[0]] = [] if graph[edge[0]].nil?
        graph[edge[0]] << [edge[1], edge[2]]
    end

    heap = MinHeap.new(n*n)
    heap.insert([src, 0])
    dist = {}

    while(!heap.empty?)
        edge = heap.poll()
        node = edge[0]; d = edge[1]
        
        if dist[node].nil? # alternate for seen array
            dist[node] = d
            if !graph[node].nil?
                graph[node].each do |nxt_edge|
                    nxt_node = nxt_edge[0]; nxt_d = nxt_edge[1]
                    if dist[nxt_node].nil?
                        heap.insert([nxt_node, d+nxt_d])
                    end
                end
            end
        end
    end

    dist
end
puts dijikstra([[2,1,1],[2,3,1],[3,4,1]], 2, 4).inspect # {2=>0, 1=>1, 3=>1, 4=>2}
puts dijikstra([[1,2,1],[2,1,3]], 2, 2).inspect # {2=>0, 1=>3}