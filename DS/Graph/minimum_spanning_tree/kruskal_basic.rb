# Refer: https://leetcode.com/submissions/detail/625901247/
class UnionFind
    attr_accessor :root, :rank, :size
    
    def initialize(size)
        @root = Array.new(size)
        @rank = Array.new(size)
        
        for i in 0...size
            @root[i] = i
            @rank[i] = 1
        end
    end
    
    def find(x)
        return x if x == root[x]
        
        root[x] = find(root[x])
    end
    
    def union(x, y, rx, ry)
        if rank[rx] < rank[ry]
            root[rx] = ry
        elsif rank[rx] > rank[ry]
            root[ry] = rx
        else
            root[rx] = ry
            rank[ry] += 1
        end
    end
end

def kruskal(edges, n)
    # heap can be used to build the edges and extract inside while loop
    edges.sort! { |x, y| x[2] <=> y[2] }

    uf = UnionFind.new(n)
    min_cost = 0; cv = 0; i = 0
    while (cv < n-1)
        edge = edges[i]
        i += 1

        rx = uf.find(edge[0])
        ry = uf.find(edge[1])

        if rx != ry
            uf.union(edge[0], edge[1], rx, ry)
            cv += 1
            min_cost += edge[2]
        end
    end

    min_cost
end
puts kruskal([[0,1,0.5],[0,4,1],[1,4,1.5],[4,3,2],[1,3,3],[1,2,4]], 5) # 7.5