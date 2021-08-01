def binary_search_ceil(arr, low, high, x)
    ceil = -1
    while (low <= high)
        mid = low + (high - low)/2
        if x == arr[mid]
            return mid
        elsif x < arr[mid]
            ceil = mid
            high = mid - 1
        else
            low = mid + 1
        end
    end
    ceil
end

def binary_search_floor(arr, low, high, x)
    floor = -1
    while (low <= high)
        mid = low + (high - low)/2
        if x == arr[mid]
            return mid
        elsif x < arr[mid]
            high = mid - 1
        else
            floor = mid
            low = mid + 1
        end
    end
    floor
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