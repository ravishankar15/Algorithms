class Graph
    attr_accessor :num_vertices, :adj_list
    def initialize(num_vertices)
        @num_vertices = num_vertices
        @adj_list = {}
        (0...@num_vertices).each { |v| @adj_list[v] = Array.new }
    end

    def add_edge(v, w)
        @adj_list[v] << w
    end

    def add_undirected_edge(v, w)
        @adj_list[v] << w
        @adj_list[w] << v
    end
end

# Sort based on count if count is 6 nodes would be 0...6
class TopologicalSortDirected
    attr_accessor :graph, :count, :stack, :visited
    def initialize(count)
        @count = count
        build_graph(count)
        @stack = []
        @visited = Array.new(count, false)
    end

    def sort
        for i in 0...@count
            if (!@visited[i])
                sort_helper(i)
            end
        end
        @stack
    end

    private
        def sort_helper(vertex)
            @visited[vertex] = true
            neighbours = @graph.adj_list[vertex]
            neighbours.each do |neighbour|
                if (!@visited[neighbour])
                    sort_helper(neighbour)
                end
            end
            @stack << vertex
        end

        def build_graph(count)
            @graph = Graph.new(count)
            @graph.add_edge(5,2)
            @graph.add_edge(5,0)
            @graph.add_edge(4,0)
            @graph.add_edge(4,1)
            @graph.add_edge(2,3)
            @graph.add_edge(3,1)
        end
end

# Sort based on count if count is 6 nodes would be 0...6
# it does with BFS by taking all the leaf nodes followed by next level
# Refer: https://leetcode.com/problems/minimum-height-trees/solution/
class TopologicalSortUnDirected
    attr_accessor :graph, :count, :stack, :visited
    def initialize(count)
        @count = count
        build_graph(count)
        @stack = []
    end

    def sort
        if @count < 2
            return [0, 1]
        end

        leaves = Array.new
        for i in 0...@count
            leaves << i if @graph.adj_list[i].size == 1
        end

        remaining_nodes = @count
        @stack << leaves
        while (remaining_nodes > 2)
            remaining_nodes -= leaves.size
            new_leaves = Array.new

            leaves.each do |leaf|
                neighbour = @graph.adj_list[leaf].pop
                @graph.adj_list[neighbour].delete(leaf)
                new_leaves << neighbour if @graph.adj_list[neighbour].size == 1
            end
            @stack << new_leaves
            leaves = new_leaves
        end
        @stack
    end

    private
        def build_graph(count)
            @graph = Graph.new(count)
            @graph.add_undirected_edge(0,1)
            @graph.add_undirected_edge(1,2)
            @graph.add_undirected_edge(1,3)
            @graph.add_undirected_edge(3,4)
        end
end

tsd = TopologicalSortDirected.new(6)
puts tsd.sort.inspect

tsud = TopologicalSortUnDirected.new(5)
puts tsud.sort.inspect