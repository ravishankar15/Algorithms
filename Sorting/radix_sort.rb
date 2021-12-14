# If the elements are in the range of 1 to n^2 we can't use counting sort
#   because counting sort will take O(n^2) which is worse than comparison sort
#   to sort such an array we can use radix sort

# The idea is to do digit by digit sort starting from LSB to MSB

def radix_sort(arr)
    len = arr.size
    max = arr.max

    exp = 1
    while ((max/exp) > 0)
        count_sort(arr, len, exp)
        exp *= 10
    end

    arr
end

def count_sort(arr, len, exp)
    count = Array.new(10, 0)
    output = Array.new(len, 0)

    for i in 0...len
        count[(arr[i]/exp) % 10] += 1
    end

    for i in 1...10
        count[i] += count[i-1]
    end

    (len-1).downto(0) do |i|
        output[count[(arr[i]/exp) % 10] - 1] = arr[i]
        count[(arr[i]/exp) % 10] -= 1
    end

    for i in 0...len
        arr[i] = output[i]
    end
end
puts radix_sort([170, 45, 75, 90, 802, 24, 2, 66]).inspect