class IterativeSegmentTree
    attr_accessor :arr, :tree, :len

    def initialize(arr)
        @arr = arr
        @len = @arr.size
        @tree = Array.new(@len*2, 0)

        i=@len; j=0
        while (i<2*@len)
            @tree[i] = @arr[j]
            i += 1
            j += 1
        end

        (@len-1).downto(1) do |i|
            @tree[i] = @tree[i*2] + @tree[i*2+1]
        end
    end

    def update(pos, val)
        pos += @len
        @tree[pos] = val
        while (pos > 0)
            l = pos; r = pos
            if (pos%2 == 0)
                r = pos + 1
            else
                l = pos - 1
            end
            @tree[pos/2] = @tree[l] + @tree[r]
            pos /= 2
        end
    end

    def sum_range(l, r)
        l += @len; r += @len
        sum = 0
        while (l <= r)
            if (l%2 == 1)
                sum += @tree[l]
                l += 1
            end

            if (r%2 == 0)
                sum += @tree[r]
                r -= 1
            end
            l /= 2
            r /= 2
        end
        sum
    end
end
ist = IterativeSegmentTree.new([1, 3, 5])
puts ist.sum_range(0,2)
ist.update(1,2)
puts ist.sum_range(0,2)