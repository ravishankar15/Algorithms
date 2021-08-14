class Edge
    attr_accessor :src, :dest
end

class Graph
    attr_accessor :no_edges, :no_vertices, :edges

    def initialize(no_edges, no_vertices)
        @no_edges = no_edges
        @no_vertices = no_vertices
        @edges = Array.new(@no_edges, Edge.new)
    end
end

class SubSet
    attr_accessor :parent, :rank

    def initialize(parent, rank = 0)
        @parent = parent
        @rank = rank
    end
end

class UnionFind
    attr_accessor :graph

    def initialize
        @graph = Graph.new(3, 3)
        @graph.edges[0].src = 0
        @graph.edges[0].dest = 1

        @graph.edges[1].src = 1
        @graph.edges[1].dest = 2

        @graph.edges[2].src = 0
        @graph.edges[2].dest = 2
    end

    def is_cycle?
        parent = Array.new(@graph.no_vertices, -1)

        for i in 0...@graph.no_edges
            x = find(parent, @graph.edges[i].src)
            y = find(parent, @graph.edges[i].dest)

            return true if x == y

            union(parent, x, y)
        end
        false
    end

    private

        def find(parent, i)
            return i if parent[i] == -1

            find(parent, parent[i])
        end

        def union(parent, x, y)
            parent[x] = y
        end
end



class UnionFindRank
    attr_accessor :graph

    def initialize
        @graph = Graph.new(3, 3)
        @graph.edges[0].src = 0
        @graph.edges[0].dest = 1

        @graph.edges[1].src = 1
        @graph.edges[1].dest = 2

        @graph.edges[2].src = 0
        @graph.edges[2].dest = 2
    end

    def is_cycle?
        subsets = Array.new(@graph.no_vertices)

        for i in 0...@graph.no_vertices
            subsets[i] = SubSet.new(i)
        end

        for i in 0...@graph.no_edges
            x = find(subsets, @graph.edges[i].src)
            y = find(subsets, @graph.edges[i].dest)

            return true if x == y

            union(subsets, x, y)
        end
        false
    end

    private

        def find(subsets, i)
            return subsets[i].parent if subsets[i].parent == i

            subsets[i].parent = find(subsets, subsets[i].parent)
        end

        def union(subsets, x, y)
            xroot = find(subsets, x)
            yroot = find(subsets, y)

            if subsets[xroot].rank < subsets[yroot].rank
                subsets[xroot].parent = yroot
            elsif subsets[xroot].rank > subsets[yroot].rank
                subsets[yroot].parent = xroot
            else
                subsets[xroot].parent = yroot
                subsets[yroot].rank += 1
            end
        end
end


graph = UnionFind.new
puts graph.is_cycle?

graph = UnionFindRank.new
puts graph.is_cycle?