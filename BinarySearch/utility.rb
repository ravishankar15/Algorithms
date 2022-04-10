def search(arr, x)
    lo = 0
    hi = arr.size - 1
    while(lo <= hi)
        mid = lo + (hi - lo)/2
        return mid if arr[mid] == x

        if arr[mid] < x
            lo = mid + 1
        else
            hi = mid - 1
        end
    end
    -1
end

# Find the smallest element greater then or equal of x
# (or) Find the first occurence of the element
# Eg., [1,2,3,5,7], 4 -> 5
def search_start(arr, x)
    lo = 0
    hi = arr.size-1
    ceil = -1
    while(lo <= hi)
        mid = lo + (hi-lo)/2

        if arr[mid] < x
            lo = mid + 1
        else
            ceil = mid
            hi = mid - 1
        end
    end

    ceil
end

# Find the largest element smaller then or equal of x
# (or) Find the last occurence of the element
# Eg., [1,2,3,5,7], 4 -> 3
def search_last(arr, x)
    lo = 0
    hi = arr.size-1
    floor = -1
    while(lo <= hi)
        mid = lo + (hi-lo)/2

        if arr[mid] <= x
            floor = mid
            lo = mid + 1
        else
            hi = mid - 1
        end
    end
    floor
end

# For reference
def find_peak_element(nums)
    lo = 0
    hi = nums.size-1
    
    while(lo < hi)
        mid = lo + (hi-lo)/2

        if nums[mid] < nums[mid+1]
            lo = mid + 1
        else
            hi = mid
        end
    end
    
    lo
end

def find_last_occurence(arr, low, high, x, len)
    if high >= low
        mid = low + (high - low)/2
        if ((mid == len-1 || x < arr[mid+1]) && arr[mid] == x)
            return mid;
        elsif (x < arr[mid])
            return find_last_occurence(arr, low, mid-1, x, len)
        else
            return find_last_occurence(arr, mid+1, high, x, len)
        end
    end
    -1
end

def find_first_occurence(arr, low, high, x, len)
    if high >= low
        mid = low + (high - low)/2
        if ((mid == 0 || x > arr[mid-1]) && arr[mid] == x)
            return mid;
        elsif (x > arr[mid])
            return find_first_occurence(arr, mid+1, high, x, len)
        else
            return find_first_occurence(arr, low, mid-1, x, len)
        end
    end
    -1
end

def fetch_ceiling(arr, low, high, x)
    return low if x <= arr[low]

    return -1 if x >= arr[high]

    mid = low + (high - low)/2

    if arr[mid] == x
        return arr[mid]
    elsif x > arr[mid]
        if (mid+1 <= high &&  x <= arr[mid+1])
            return mid+1
        else
            return fetch_ceiling(arr, mid+1, high, x)
        end
    else
        if (mid-1 >= low && x > arr[mid-1])
            return mid
        else
            return fetch_ceiling(arr, low, mid-1, x)
        end
    end
end