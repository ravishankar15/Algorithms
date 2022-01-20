class QuickFind
    attr_accessor :root, :size

    # TC: O(n)
    def initialize(size)
        @root = Array.new(size);
        @size = size
        for i in 0...size
            @root[i] = i
        end
    end

    # TC: O(1)
    def find(x)
        @root[x]
    end
    
    # TC: O(n)
    def union(x, y)
        rootx = find(x)
        rooty = find(y)

        if rootx != rooty
            for i in 0...@size
                if @root[i] == rooty
                    @root[i] = rootx
                end
            end
        end
    end

    # TC: O(1)
    def is_connected?(a, b)
        find(a) == find(b)
    end
end
uf = QuickFind.new(10)
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
