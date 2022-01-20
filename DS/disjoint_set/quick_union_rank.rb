# Optimization of union operation of QuickUnion
class QuickUnionRank
    attr_accessor :root, :rank, :size

    # TC: O(n)
    def initialize(size)
        @root = Array.new(size)
        @rank = Array.new(size)
        @size = size
        for i in 0...size
            @root[i] = i
            @rank[i] = 1
        end
    end

    # TC: O(log N)
    def find(x)
        return x if x == root[x]

        find(root[x])
    end

    # TC: O(log N)
    def union(x, y)
        rootx = find(x)
        rooty = find(y)

        if rootx != rooty
            if rank[rootx] > rank[rooty]
                root[rooty] = rootx
            elsif rank[rootx] < rank[rooty]
                root[rootx] = rooty
            else
                root[rooty] = rootx
                rank[rootx] += 1
            end
        end
    end

    # TC: O(log N)
    def is_connected?(a, b)
        find(a) == find(b)
    end
end
uf = QuickUnionRank.new(10)
# 1-2-5-6-7 3-8-9 4
uf.union(1, 2)
uf.union(2, 5)
uf.union(5, 6)
uf.union(6, 7)
uf.union(3, 8)
uf.union(8, 9)

puts uf.is_connected?(1, 5) # true
puts uf.is_connected?(5, 7) # true
puts uf.is_connected?(4, 9) # false

# 1-2-5-6-7 3-8-9-4
uf.union(9, 4)
puts uf.is_connected?(4, 9) # true
