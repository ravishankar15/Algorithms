# @param {Integer[]} nums
# @return {Integer}
def number_of_good_subsets(nums)
    @nums = []
    @primes = [2,3,5,7,11,13,17,19,23,29]
    @prod_mask = []
    @mod = (10**9) + 7
    @cache = {}
    one_count = nums.count(1)
    nums.uniq.each_with_index do |num, i|
        next if num == 1
        mask = get_num_mask(num)
        if mask != 0
            @nums << num
            @prod_mask << mask
        end
    end
    @len = @nums.size
    res = (count_subset(0, 0) + @mod) % @mod
    (res * (2**one_count)) % @mod
end

def count_subset(i, mask)
    return 1 if i >= @len

    key = "#{i}--#{mask}"

    return @cache[key] if !@cache[key].nil?

    ans = count_subset(i+1, mask) % @mod
    if mask & @prod_mask[i] == 0
        ans += count_subset(i+1, mask | @prod_mask[i]) % @mod
    end
    @cache[key] = ans % @mod
end

def get_num_mask(n)
    mask = 0
    for i in 0...@primes.size
        prime = @primes[i]
        count = 0
        while(n%prime == 0)
            count += 1
            n = n/prime
        end
        next if count == 0

        if count == 1
            mask |= (1 << (i+1))
        end

        return -1 if count >= 2
    end
    mask
end



# @param {Integer[]} nums1
# @param {Integer[]} nums2
# @return {Integer}
def minimum_xor_sum(nums1, nums2)
    @nums1 = nums1
    @nums2 = nums2
    @nlen = nums1.size
    @tmask = (1 << @nlen) - 1
    @cache = Array.new(@tmask)
    min_sum(0, 0)
end

def min_sum(i, mask)
    return 0 if i >= @nlen

    return @cache[mask] if !@cache[mask].nil?

    msum = 2**32
    for j in 0...@nlen
        next if is_set?(mask, j)
        
        msum = [msum, (@nums1[i]^@nums2[j]) + min_sum(i+1, set_bit(mask, j))].min
    end
    @cache[mask] = msum
end

def set_bit(mask, i)
    mask | (1 << i)
end

def is_set?(mask, i)
    (mask & (1 << i)) != 0
end

[-1, -4, 0, 2, -3, 3, 3, -1, -2, -2, 4, 3, 0, 2, 4, -3, 4, 2, 1, -4]


# @param {Integer[]} nums
# @return {Integer}
def minimum_difference(nums)
    @nums = nums
    @nlen = nums.size
    @tlen = @nlen/2
    @tsum = nums.reduce(:+)
    @min_diff = 2**32
    @nmask = (1<<@nlen)-1
    @cache = {}
    @curr_sum = 0
    min_diff(0, @nmask)
    @min_diff
end

def min_diff(ncount, mask)
    if ncount >= @tlen
        @min_diff = [@min_diff, ((@tsum-@curr_sum)-@curr_sum).abs].min
        return
    end

    return @cache[mask] if !@cache[mask].nil?

    for i in 0...@nlen
        next if is_set?(mask, i)
        
        @curr_sum += @nums[i]
        @cache[mask] = @curr_sum
        @cache[@nmask^mask] = @tsum - @curr_sum
        min_diff(ncount+1, set_bit(mask, i))
        @curr_sum -= @nums[i]
    end
end

def set_bit(mask, i)
    mask^(1<<i)
end

def is_set?(mask, i)
    (mask&(1<<i)) == 0
end



# @param {Integer[]} nums
# @return {Integer}
def minimum_difference(nums)
    @nums = nums
    @nlen = nums.size
    @tsum = nums.reduce(:+)
    @cache = {}
    min_diff(@nlen-1, @nlen/2, 0)
end

def min_diff(ni, k, sum)
    if ni == 0
        return (k==0) ? (2*sum-@tsum).abs : 2**32
    end

    return (2*sum-@tsum).abs if k == 0

    return @cache["#{ni};#{k}"] if !@cache["#{ni};#{k}"].nil?

    np = min_diff(ni-1, k, sum)
    pi = min_diff(ni-1, k-1, sum+@nums[ni])
    [np, pi].min 
end
# @param {Integer[]} nums
# @return {Integer}
def minimum_difference(nums)
    @nlen = nums.size
    @tsum = nums.reduce(:+)
    @alen = @nlen/2
    @arr1 = nums[0...(@nlen/2)]
    @arr2 = nums[(@nlen/2)...@nlen]

    a1_sum = {} # ele-count => [sum,sum]
    for mask in 0...(1<<@alen)
        sum = 0; count = 0
        for i in 0...@alen
            if is_set?(mask, i)
                count += 1
                sum += @arr1[i]
            end
        end
        a1_sum[count] = [] if a1_sum[count].nil?
        a1_sum[count] << sum
    end

    a2_sum = {} # ele-count => [sum,sum]
    for mask in 0...(1<<@alen)
        sum = 0; count = 0
        for i in 0...@alen
            if is_set?(mask, i)
                count += 1
                sum += @arr2[i]
            end
        end
        a2_sum[count] = [] if a2_sum[count].nil?
        a2_sum[count] << sum
    end

    puts "#{a1_sum.keys.inspect}"
    puts "#{a2_sum.keys.inspect}"

    min_diff = 2**32
    a1_sum.each do |count, a1sums|
        next if count == 0

        a1sums.each do |a1|
            if a2_sum[@nlen-count].nil?
                curr_sum = (a1).abs
                min_diff = [min_diff, curr_sum].min
            else
                a2_sum[@nlen-count-1].each do |a2|
                    curr_sum = (a1 + a2)
                    min_diff = [min_diff, ((@tsum-curr_sum)-curr_sum).abs].min
                end
            end
        end
        puts "#{count}; #{@nlen}; #{@nlen-count}"
    end
    min_diff
end



def set_bit(mask, i)
    mask^(1<<i)
end

def is_set?(mask, i)
    (mask&(1<<i)) != 0
end

# @param {Integer[]} nums
# @return {Integer}
def minimum_difference(nums)
    @nlen = nums.size
    @tsum = nums.reduce(:+)
    @alen = @nlen/2
    @arr1 = nums[0...(@nlen/2)]
    @arr2 = nums[(@nlen/2)...@nlen]

    a1_sum = {} # ele-count => [sum,sum]
    for mask in 0...(1<<@alen)
        sum = 0; count = 0
        for i in 0...@alen
            if is_set?(mask, i)
                count += 1
                sum += @arr1[i]
            end
        end
        a1_sum[count] = [] if a1_sum[count].nil?
        a1_sum[count] << sum
    end

    a2_sum = {} # ele-count => [sum,sum]
    for mask in 0...(1<<@alen)
        sum = 0; count = 0
        for i in 0...@alen
            if is_set?(mask, i)
                count += 1
                sum += @arr2[i]
            end
        end
        # a2_sum[count] = [] if a2_sum[count].nil?
        a2_sum[count] = [a2_sum[count], sum].max
    end

    min_diff = 2**32
    a1_sum.each do |count, a1sums|
        next if count == 0

        a1sums.each do |a1|
            a2_sum[@alen-count].each do |a2|
                curr_sum = (a1 + a2)
                min_diff = [min_diff, ((@tsum-curr_sum)-curr_sum).abs].min
            end
        end
    end
    min_diff
end



def set_bit(mask, i)
    mask^(1<<i)
end

def is_set?(mask, i)
    (mask&(1<<i)) != 0
end


[3,9,7,3]
[-36,36]
[2,-1,0,4,-2,-9]
[-1, -4, 0, 2, -3, 3, 3, -1, -2, -2, 4, 3, 0, 2, 4, -3, 4, 2]
[-26, -47, 17, -47, -18, 24, 76, 27, -77, -94, 48, -60, 46, 58, -84, 30, -78, 44, -97, 35]
[-93, -83, 14, 9, 25, -60, 40, -91, 62, -99, 54, 59, -70, -25, -29, 29, 76, 74, -71, 45, -66, -46, -53, -6, -20, -49, 71, 22, 32, 2]
[16, 23, 25, 3, 8, 19, 13, 1, 10, 4, 11, 5, 28, 24, 18, 26, 7, 17, 12, 15, 9, 22, 27, 14, 20, 21, 29, 2, 6, 0]
[6, 5, -3, 13, -8, 8, -6, 0, 6, -7, 2, 11, 14, -10, -11, 13, 10, -2, -2, 0, -4, 7, -13, 0, 1, 8, -5, -10, -6, 11]
[7772197,4460211,-7641449,-8856364,546755,-3673029,527497,-9392076,3130315,-5309187,-4781283,5919119,3093450,1132720,6380128,-3954678,-1651499,-7944388,-3056827,1610628,7711173,6595873,302974,7656726,-2572679,0,2121026,-5743797,-8897395,-9699694]

(((-10...10).to_a*20).shuffle)[0...20]


# @param {String} s
# @return {Integer}
def max_product(s)
    len = s.size
    schars = s.chars
    count_mask = {}
    tcm = []
    max_prod = 0
    for mask in (1<<len)...((1<<len+1))
        count = 0; str = ''
        for i in 0...len
            if is_set?(mask, i)
                count += 1
                str += schars[i]
            end
        end

        if str == str.reverse
            puts "#{str}" if mask == 1048 || mask == 2051
            if count_mask[count].nil? || count_mask[count].empty?
                count_mask[count] = []
                count_mask[count] << mask
            else
                if (count_mask[count].last & mask == 0)
                    puts "#{str}; #{mask}; #{count_mask[count].last}"
                    max_prod = [max_prod, (count*count)].max
                end
            end

            if tcm.empty?
                tcm << [count, mask]
            elsif tcm.size == 1
                if mask & tcm.first[1] == 0
                    tcm << [count, mask]
                end
            else
                tcm.sort!
                if mask & tcm.last[1] == 0
                    if count > tcm.last[0] && mask & tcm.first[1] == 0
                        tcm[1] = [count, mask]
                    else
                        if mask & tcm.first[1] == 0
                            if count > tcm.first[0]
                                tcm[0] = [count, mask]
                            end
                        end
                    end
                end
            end
        end
    end

    puts tcm.inspect
    # max_prod = [max_prod, tcm[0][0]*tcm[1][0]].max
    max_prod
end

def is_set?(mask, i)
    (mask&(1<<i)) != 0
end




# @param {String} s
# @return {Integer}
def max_product(s)
    len = s.size
    schars = s.chars
    bmask = (2**len)-1
    lps_mask = {}
    max_prod = 0
    for mask in 0...(2**len)
        count = 0; str = ''
        for i in 0...len
            if is_set?(mask, i)
                str += schars[i]
            end
        end
        lps_mask[mask] = lps(str.chars, 0, str.size-1, {})
    end

    for mask in 0...(2**len)
        puts "#{mask.to_s(2)}; #{bmask.to_s(2)}; #{(mask^bmask).to_s(2)}; ==> (#{lps_mask[mask]}; #{lps_mask[mask^bmask]})"
        max_prod = [max_prod, lps_mask[mask^bmask]].max
    end
    max_prod
end

def lps(schars, i, j, cache)
    key = "#{i};#{j}"

    return cache[key] if !cache[key].nil?

    return 0 if i > j

    return 1 if i == j

    mlen = -2**32
    if schars[i] == schars[j]
        mlen = [mlen, 2 + lps(schars, i+1, j-1, cache)].max
    else
        mlen = [mlen, lps(schars, i+1, j, cache), lps(schars, i, j-1, cache)].max
    end
    cache[key] = mlen
end

def is_set?(mask, i)
    (mask&(1<<i)) != 0
end

# ccgdtwnnhcdc

# @param {Integer[]} rods
# @return {Integer}
def tallest_billboard(rods)
    @rods = rods
    @rsize = rods.size
    @bmask = (2**@rsize)
    @sum_mask = {}
    @vsum = {}
    @max_ht = 0
    for mask in (2**@rsize)...(2**(@rsize+1))
      sum = 0
      for i in 0...@rsize
        if (mask & (1<<i)) != 0
          sum += @rods[i].nil? ? 0 : @rods[i]
        end
      end
      if @vsum[sum].nil?
        (@sum_mask[sum] || []).each do |smask|
          if (mask & smask) == @bmask
            @vsum[sum] = true
            @max_ht = [@max_ht, sum].max
          end 
        end
  
        @sum_mask[sum] = [] if @sum_mask[sum].nil?
        @sum_mask[sum] << mask
      end
    end
    @max_ht
  end


  # @param {Integer[]} nums
# @return {Boolean}
def split_array_same_average(nums)
    nlen = nums.size
    hlen = nlen/2
    nsum = nums.reduce(:+)
    for mask in 0...(2**(hlen))
        osum = 0; ocount = 0
        zsum = 0; zcount = 0
        for i in 0...nlen
            if (mask & (1<<i)) != 0
                osum += nums[i]
                ocount += 1
            else
                zsum += nums[i]
                zcount += 1
            end
        end
        oavg = osum/(ocount*1.0)
        zavg = zsum/(zcount*1.0)

        return true if oavg == zavg
    end
    false
end

[1,2,3,6]
[1,2,3,4,5,6]
[1,2]
[3,13,17]
[3, 2, 4, 1, 3, 1, 2, 5, 5, 4]
[3, 1, 1, 5, 4, 5, 2, 5, 3, 1, 2, 2, 4, 4, 3]
[2, 5, 5, 5, 4, 1, 4, 4, 1, 3, 2, 2, 1, 3, 3, 3, 2, 1, 4, 5]


[1,2,3,4,5,6,7,8]
[3,1]
[13, 1, 2, 3, 4, 2, 4, 2, 5, 3, 5, 1, 1, 2, 5, 1, 5, 4, 2, 4, 2, 5, 1, 3, 4, 4, 5, 3, 10]
[1392, 1053, 1527, 1765, 1001, 1125, 1883, 1379, 1772, 1444, 1866, 1620, 1007, 1402, 1770, 1014, 1382, 1079, 1424, 1418, 1859, 1917, 1296, 1115, 1490, 1735, 1117, 1735, 1688, 1440]
[1319, 1471, 1587, 1816, 1785, 1521, 1926, 1499, 1880, 1470, 1712, 1437, 1365, 1492, 1513, 1148, 1637, 1312, 1953, 1504, 1201, 1256, 1812, 1997, 1457, 1941, 1959, 1078, 1575, 1653]


# @param {Integer[]} start_time
# @param {Integer[]} end_time
# @param {Integer[]} profit
# @return {Integer}
def job_scheduling(start_time, end_time, profit)
    jobs = []
    n = start_time.size
    for i in 0...n
        jobs << [start_time[i], end_time[i], profit[i]]
    end

    sjobs = jobs.sort {|a,b| a[1] <=> b[1]}
    puts sjobs.inspect
    cjobs = []
    max_pf = 0
    for i in 0...n
        st, ed, pf = sjobs[i]

        pi = search_last(cjobs, st)
        npf = (pi == -1 ? 0 : cjobs[pi][2])+pf
        while(!cjobs.empty? && st < cjobs.last[1] && npf > cjobs.last[2])
            cjobs.pop
        end
        if cjobs.empty? || npf >= cjobs.last[2] || st >= cjobs.last[1]
            cjobs << [st, ed, npf]
            max_pf = [max_pf, npf].max
        end
    end
    max_pf
end

def search_last(arr, x)
    lo = 0
    hi = arr.size-1
    floor = -1
    while(lo <= hi)
        mid = lo + (hi-lo)/2

        if arr[mid][1] <= x
            floor = mid
            lo = mid + 1
        else
            hi = mid - 1
        end
    end
    floor
end


def generate(size)
    start = ((10..20).to_a*size).shuffle[0...size].shuffle
    jobs = []
    start.each do |st|
        ed = 0
        while(ed <= st)
            ed = rand(10..30)
        end
        jobs << [st, ed, rand(20..30)]
    end
    puts jobs.inspect
end
((10..20).to_a*2).shuffle
((10..20).to_a*2).shuffle

[1,2,3,3]
[3,4,5,6]
[50,10,40,70]
[1,2,3,4,6]
[3,5,10,6,9]
[20,20,100,70,60]
[1,1,1]
[2,3,4]
[5,6,4]
[11, 12, 18, 15]
[16, 18, 19, 20]
[26, 22, 21, 30]
[11, 13, 17, 10, 17, 17, 16, 16, 17, 16]
[16, 16, 20, 19, 18, 20, 18, 18, 18, 18]
[29, 20, 25, 21, 24, 20, 25, 27, 20, 24]
[20, 11, 10, 19, 18, 18, 20, 19, 15]
[30, 17, 15, 20, 23, 21, 26, 26, 22]
[28, 20, 20, 28, 25, 30, 27, 28, 24]
[10, 20, 20, 15, 19, 11, 14, 15, 19, 14, 17, 19, 14, 14, 19]
[26, 25, 24, 30, 28, 30, 29, 23, 25, 30, 27, 21, 28, 19, 25]
[30, 21, 22, 26, 28, 30, 30, 30, 23, 24, 28, 30, 27, 24, 25]

[14,19,24]
[[20, 25, 21], [20, 24, 22], [19, 28, 28], [19, 25, 28], [19, 25, 28], [19, 21, 30], [17, 27, 30], [15, 30, 30], [15, 23, 30], [14, 30, 30], [14, 29, 30], [14, 28, 30]]

[]