# class MinHeap
#     attr_accessor :harr, :capacity, :heap_size

#     def initialize(capacity)
#         @heap_size = 0
#         @capacity = capacity
#         @harr = Array.new(@capacity)
#     end

#     def insert(val)
#         raise 'Overflow' if @heap_size == @capacity

#         i = @heap_size
#         @heap_size += 1
#         @harr[i] = val

#         while(i != 0 && @harr[parent(i)][0] > @harr[i][0])
#             @harr[parent(i)], @harr[i] = @harr[i], @harr[parent(i)]
# 			i = parent(i);
# 		end
#     end

#     def get_min()
#         @harr[0]
#     end
    
#     def is_empty?()
#         @heap_size == 0
#     end

#     def extract_min()
#         # raise 'empty heap' if @heap_size == 0

#         if @heap_size == 1
#             @heap_size -= 1
#             return @harr[0]
#         end

#         min = @harr[0]
#         @harr[0] = @harr[@heap_size - 1]
#         @heap_size -= 1
#         min_heapify(0)
#         min
#     end

#     def min_heapify(i)
#         l = left(i); r = right(i)
#         smallest = i

#         smallest = l if (l < @heap_size && @harr[l][0] < @harr[i][0])
#         smallest = r if (r < @heap_size && @harr[r][0] < @harr[smallest][0])

#         if (smallest != i)
#             @harr[smallest], @harr[i] = @harr[i], @harr[smallest]
#             min_heapify(smallest)
#         end
#     end

#     private
#         def parent(i)
#             (i-1)/2
#         end

#         def left(i)
#             (2*i) + 1
#         end

#         def right(i)
#             (2*i) + 2
#         end
# end

# # @param {Integer[]} nums
# # @param {Integer} k
# # @return {Integer}
# def constrained_subset_sum(nums, k)
#     @len = nums.size
#     @max_diff = k
    
#     return nums.max if @max_diff == 1
    
#     msf = MinHeap.new(@len) # min so far
#     @pointers = Array.new(@len)
    
#     for i in 0...@len
#         @pointers[i] = [i-1, i+1]
#     end
    
#     @first_idx = 0
#     @last_idx = @len-1

#     sum = 0
#     for rp in 0...@len
#         msf.insert([nums[rp], rp])  if nums[rp] < 0
#         sum += nums[rp]
#     end
    
#     byebug

#     while(!msf.is_empty?)
#         min_val, min_idx = msf.extract_min()
#         byebug
#         if can_delete?(min_val, min_idx)
#             update_pointer(min_idx)
#             sum -= min_val 
#         end
#     end
    
#     sum
# end

# def can_delete?(min_val, min_idx)
#     return false if @pointers[min_idx].empty?

#     lp, rp = @pointers[min_idx]
#     return true if lp == @first_idx || rp == @last_idx
    
#     rp - lp <= @max_diff
# end

# def update_pointer(min_idx)
#     lp, rp = @pointers[min_idx]
    
#     @first_idx = rp if min_idx == @first_idx

#     @last_idx = lp if min_idx == @last_idx
    
#     @pointers[lp][1] = rp if lp >= 0
#     @pointers[rp][0] = lp if rp < @len
#     @pointers[min_idx] = []
# end

class MaxHeap
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

        while(i != 0 && @harr[i][0] > @harr[parent(i)][0])
            @harr[parent(i)], @harr[i] = @harr[i], @harr[parent(i)]
			i = parent(i);
		end
    end

    def get_max()
        @harr[0]
    end
    
    def is_empty?()
        @heap_size == 0
    end

    def extract_max()
        raise 'empty heap' if @heap_size == 0

        if @heap_size == 1
            @heap_size -= 1
            return @harr[0]
        end

        max = @harr[0]
        @harr[0] = @harr[@heap_size - 1]
        @heap_size -= 1
        max_heapify(0)
        max
    end

    def max_heapify(i)
        l = left(i); r = right(i)
        largest = i

        largest = l if (l < @heap_size && @harr[l][0] > @harr[i][0])
        largest = r if (r < @heap_size && @harr[r][0] > @harr[largest][0])

        if (largest != i)
            @harr[largest], @harr[i] = @harr[i], @harr[largest]
            max_heapify(largest)
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

# @param {Integer[]} nums
# @param {Integer} k
# @return {Integer}
def constrained_subset_sum(nums, k)
    len = nums.size
    msf = MaxHeap.new(len)
    dp = Array.new(len, 0)
    for i in 0...len
        while(!msf.is_empty? && i - msf.get_max()[1] <= k)
            msf.extract_max()
        end
        puts "#{i}"
        byebug
        dp[i] = nums[i] + [0, (msf.is_empty? ? 0 : msf.get_max()[0])].max
        msf.insert([dp[i], i])
    end
    puts dp.inspect
    dp[len-1]
end
puts constrained_subset_sum([10,2,-10,5,20], 2)