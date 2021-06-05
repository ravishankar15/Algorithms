class RecursiveSegmentTree
    attr_accessor :arr, :tree, :len
    def initialize(arr)
        @arr = arr; @len = arr.size
        @tree = []
        build_tree(0, 0, @len-1)
    end

    def update(idx, val)
        update_helper(0, 0, @len-1, idx, val)
    end

    def sum_range(lt, rt)
        return sum_range_helper(0, 0, @len-1, lt, rt)
    end

    private
        def build_tree(tree_idx, lo, hi)
            if lo == hi
                @tree[tree_idx] = @arr[lo]
                return
            end

            mid = lo + (hi-lo)/2
            build_tree(left(tree_idx), lo, mid)
            build_tree(right(tree_idx), mid+1, hi)

            @tree[tree_idx] = @tree[left(tree_idx)] + @tree[right(tree_idx)]
        end

        def update_helper(tree_idx, lo, hi, idx, val)
            if lo == hi
                @tree[tree_idx] = val
                return
            end

            mid = lo + (hi-lo)/2
            if idx > mid
                update_helper(right(tree_idx), mid+1, hi, idx, val)
            else
                update_helper(left(tree_idx), lo, mid, idx, val)
            end

            @tree[tree_idx] = @tree[left(tree_idx)] + @tree[right(tree_idx)]
        end

        def sum_range_helper(tree_idx, lo, hi, lt, rt)
            return @tree[tree_idx] if lt <= lo && rt >= hi

            return 0 if rt < lo || lt > hi

            mid = lo + (hi-lo)/2
            return sum_range_helper(left(tree_idx), lo, mid, lt, rt) + sum_range_helper(right(tree_idx), mid+1, hi, lt, rt)

        end
        
        def left(i)
            (2*i) + 1
        end

        def right(i)
            (2*i) + 2
        end

        def parent(i)
            (i-1)/2
        end
end

rst = RecursiveSegmentTree.new([18, 17, 13, 19, 15, 11, 20, 12, 33, 25])
puts rst.sum_range(2, 3)
rst.update(2, 15)
puts rst.tree.inspect
puts rst.sum_range(2, 3)
