# Counting sort is a technique based on the keys between specific range
# Works by counting the number of distinct key values and calculating the output position

# Algorithm
## Create a count array to store the count of each unique objects
## Modify count array such that each element at each index stores the sum of previous counts

# Points to remember
# 1. Counting sort is efficient if the range of input data is not significantly 
#    greater than the number of objects to be sorted
# 2. Its not based on comparison so the TC is O(n) and SC is the range of numbers
# 3. It is often used as a subroutine to another sorting algorithm like radix sort


def counting_sort_charecters(arr)
    len = arr.size
    output = Array.new(len, 0)
    count = Array.new(256, 0)

    # store the count of each charecter
    for i in 0...len
        count[arr[i].ord] += 1
    end

    # change count[i] so that count[i] now contains
    # actual position of the charecter
    for i in 1...256
        count[i] += count[i-1]
    end

    (len-1).downto(0) do |i|
        output[count[arr[i].ord] - 1] = arr[i]
        count[arr[i].ord] -= 1 
    end

    output
end


def count_sort_numbers(arr)
    len = arr.size
    max = arr.max
    min = arr.min
    range = max - min + 1
    count = Array.new(range, 0)
    output = Array.new(len, 0)

    # store the count of each charecter
    for i in 0...len
        count[arr[i] - min] += 1
    end

    # change count[i] so that count[i] now contains
    # actual position of the charecter
    for i in 1...range
        count[i] += count[i-1]
    end

    (len-1).downto(0) do |i|
        output[count[arr[i] - min] - 1] = arr[i]
        count[arr[i]-min] -= 1
    end

    output
end

puts counting_sort_charecters('geekforgeeks'.chars).inspect
puts count_sort_numbers([-5, -10, 0, -3, 8, 5, -1, 10]).inspect