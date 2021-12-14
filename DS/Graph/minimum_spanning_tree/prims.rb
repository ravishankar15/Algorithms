# 1. Create a min heap of size V (no of vertices). Every node in the min heap contains vertex and a key value
# 2. Initialize the first vertex key value as 0 and all the other nodes value to be infinity
# 3. while minheap is not empty
#       a. Extact the min value node (u)
#       b. For every adjacent vertex v of u check if v is in heap. If v is in heap and the value of v is more than
#           the value of u-v than update the value of v as weight of u-v 
class MinHeap
    attr_accessor :harr, :capacity, :heap_size, :idx_map

    def initialize(capacity)
        @heap_size = 0
        @capacity = capacity
        @harr = Array.new(@capacity)
        @idx_map = {}
    end

    def insert(val)
        raise 'Overflow' if @heap_size == @capacity

        i = @heap_size
        @heap_size += 1
        @harr[i] = val
        @idx_map[val.vertex] = i

        while(i != 0 && @harr[parent(i)].key > @harr[i].key)
            @idx_map[@harr[parent(i)].vertex], @idx_map[@harr[i].vertex] = i, parent(i)
            @harr[parent(i)], @harr[i] = @harr[i], @harr[parent(i)]
			i = parent(i);
		end
    end

    def get_min()
        @harr[0]
    end

    def get_node(node_id)
        @harr[@idx_map[node_id]]
    end

    def is_node_present?(node_id)
        !@idx_map[node_id].nil?
    end

    def decrese_key(node_id, new_val)
        i = @idx_map[node_id]
        @harr[i].key = new_val
        while (i != 0 && @harr[parent(i)].key > @harr[i].key)
            @idx_map[@harr[parent(i)].vertex], @idx_map[@harr[i].vertex] = i, parent(i)
            @harr[parent(i)], @harr[i] = @harr[i], @harr[parent(i)]
			i = parent(i);
        end
    end

    def extract_min()
        raise 'empty heap' if @heap_size == 0

        if @heap_size == 1
            @heap_size -= 1
            return @harr[0]
        end

        min = @harr[0]
        @harr[0] = @harr[@heap_size - 1]
        @idx_map[@harr[@heap_size - 1].vertex] = 0
        @heap_size -= 1
        min_heapify(0)
        @idx_map.delete(min.vertex)
        min
    end

    def min_heapify(i)
        l = left(i); r = right(i)
        smallest = i

        smallest = l if (l < @heap_size && @harr[l].key < @harr[i].key)
        smallest = r if (r < @heap_size && @harr[r].key < @harr[smallest].key)

        if (smallest != i)
            @idx_map[@harr[smallest].vertex], @idx_map[@harr[i].vertex] = i, smallest
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

class GraphNode
    attr_accessor :dest, :weight

    def initialize(dest, weight = 0)
        @dest = dest
        @weight = weight
    end
end

class Graph
    attr_accessor :no_vertices, :adj_list

    def initialize(no_vertices)
        @no_vertices = no_vertices
        @adj_list = {}
        for i in 0...no_vertices
            @adj_list[i] = []
        end
    end
end

class HeapNode
    attr_accessor :vertex, :key

    def initialize(vertex, key = 10**9)
        @vertex = vertex
        @key = key
    end
end

class PrimsMst
    attr_accessor :graph, :parent

    def initialize(graph)
        @graph = graph
        @parent = Array.new(graph.no_vertices, -1);
    end

    def mst()
        minheap = MinHeap.new(@graph.no_vertices)
        (0).upto(@graph.no_vertices-1) do |v|
            if v == 0
                minheap.insert(HeapNode.new(v, 0))
            else
                minheap.insert(HeapNode.new(v))
            end
        end

        while (minheap.heap_size > 0)
            min_node = minheap.extract_min
            @graph.adj_list[min_node.vertex].each do |graph_node|
                if minheap.is_node_present?(graph_node.dest) && minheap.get_node(graph_node.dest).key > graph_node.weight
                    minheap.decrese_key(graph_node.dest, graph_node.weight)
                    @parent[graph_node.dest] = min_node.vertex
                end
            end
        end

        (1).upto(@graph.no_vertices-1) do |vertex|
            puts "#{@parent[vertex]} - #{vertex}"
        end
    end
end

def add_edge(graph, src, dest, weight)
    graph.adj_list[src] << GraphNode.new(dest, weight)
    graph.adj_list[dest] << GraphNode.new(src, weight)
end

graph = Graph.new(9)
add_edge(graph, 0, 1, 4)
add_edge(graph, 0, 7, 8)
add_edge(graph, 1, 2, 8)
add_edge(graph, 1, 7, 11)
add_edge(graph, 2, 3, 7)
add_edge(graph, 2, 8, 2)
add_edge(graph, 2, 5, 4)
add_edge(graph, 3, 4, 9)
add_edge(graph, 3, 5, 14)
add_edge(graph, 4, 5, 10)
add_edge(graph, 5, 6, 2)
add_edge(graph, 6, 7, 1)
add_edge(graph, 6, 8, 6)
add_edge(graph, 7, 8, 7)

prim_mst = PrimsMst.new(graph)
prim_mst.mst