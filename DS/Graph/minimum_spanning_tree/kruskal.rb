# 1. Sort all the edges in non decreasing order of their weight
# 2. Pick the smallest edge. Check if it forms a cycle with the spanning tree formed so far.
#     If cycle is not formed include this edge, Else discard it. (Union and Find)
# 3. Repeat step 2 until there are (V-1) edges in the spanning tree

class Edge
    attr_accessor :src, :dest, :weight

    def initialize(src = nil, dest = nil, weight = 0)
        @src = src
        @dest = dest
        @weight = weight
    end
end

class Graph
    attr_accessor :no_vertices, :no_edges, :edges

    def initialize(no_vertices, no_edges)
        @no_vertices = no_vertices
        @no_edges = no_edges
        @edges = Array.new(no_edges)
        for i in 0...no_edges
            @edges[i] = Edge.new
        end
    end
end

class Subset
    attr_accessor :parent, :rank

    def initialize(parent, rank = 0)
        @parent = parent
        @rank = rank
    end
end

class UnionFind
    attr_accessor :graph, :subsets
    
    def initialize(graph)
        @graph = graph
        @subsets = Array.new(@graph.no_vertices)
        for i in 0...@graph.no_vertices
            @subsets[i] = Subset.new(i) #Assuming vertices from 0 -- n
        end
    end

    def find(i)
        return @subsets[i].parent if @subsets[i].parent == i

        @subsets[i].parent = find(@subsets[i].parent)
    end

    def union(x, y)
        xroot = find(x)
        yroot = find(y)

        if @subsets[xroot].rank < @subsets[yroot].rank
            @subsets[xroot].parent = yroot
        elsif @subsets[xroot].rank > @subsets[yroot].rank
            @subsets[yroot].parent = xroot
        else
            @subsets[xroot].parent = yroot
            @subsets[yroot].rank += 1
        end
    end
end

class KruskalMST
    attr_accessor :graph, :result_mst, :res_idx, :union_find

    def initialize(graph)
        @graph = graph
        @result_mst = Array.new(graph.no_vertices)
        @res_idx = 0
        @union_find = UnionFind.new(graph)
    end

    def mst
        @graph.edges = @graph.edges.sort { |x, y| x.weight <=> y.weight }

        i = 0
        while (@res_idx < @graph.no_vertices - 1)
            nxt_edge = @graph.edges[i]
            i += 1

            x = @union_find.find(nxt_edge.src)
            y = @union_find.find(nxt_edge.dest)

            if x != y
                @result_mst[@res_idx] = nxt_edge
                @union_find.union(x, y)
                @res_idx += 1
            end
        end
        print_mst
    end

    def print_mst
        minimum_cost = 0
        for i in 0...@res_idx
            puts "#{@result_mst[i].src} -- #{@result_mst[i].dest} -- #{@result_mst[i].weight}"
            minimum_cost += @result_mst[i].weight
        end
        puts "Minimum cost of MST ----> #{minimum_cost}"
    end
end

graph = Graph.new(4, 5)
graph.edges[0].src = 0
graph.edges[0].dest = 1
graph.edges[0].weight = 10

graph.edges[1].src = 0
graph.edges[1].dest = 2
graph.edges[1].weight = 6

graph.edges[2].src = 0;
graph.edges[2].dest = 3;
graph.edges[2].weight = 5;

graph.edges[3].src = 1;
graph.edges[3].dest = 3;
graph.edges[3].weight = 15;

graph.edges[4].src = 2;
graph.edges[4].dest = 3;
graph.edges[4].weight = 4;

kruskal_mst = KruskalMST.new(graph)
kruskal_mst.mst
