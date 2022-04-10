1st
def find_floor(nums, target)
    lo = 0
    hi = nums.size-1
    floor = -1
    while(lo <= hi)
        mid = lo + (hi-lo)/2
        
        if nums[mid] < target
            lo = mid + 1
        else
            floor = mid
            hi = mid - 1
        end
    end
    
    floor
end

def find_ceil(nums, target)
    lo = 0
    hi = nums.size-1
    ceil = -1
    while(lo <= hi)
        mid = lo + (hi-lo)/2
        
        if nums[mid] <= target
            ceil = mid
            lo = mid + 1
        else
            hi = mid - 1
        end
    end
    ceil
end
puts "#{find_floor([5,8,8,8,8,10], 8)} => #{find_ceil([5,8,8,8,8,10], 8)}"
puts "#{find_floor([5,8,8,8,8,9,9,9,9,10], 9)} => #{find_ceil([5,8,8,8,8,9,9,9,9,10], 9)}"
puts "#{find_floor([5,8,8,8,8,10], 9)} => #{find_ceil([5,8,8,8,8,10], 9)}"