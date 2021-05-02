# https://leetcode.com/problems/climbing-stairs/
def climb_stairs(n)
  dp = Array.new(n+1)
  dp[0] = 1
  dp[1] = 1
  for i in 2...n+1
    dp[i] = dp[i-1] + dp[i-2]
  end
  dp[n]
end
climb_stairs(3)

# https://leetcode.com/problems/unique-paths/
def unique_paths(m, n)
  dp = Array.new(m) { Array.new(n, 0) }

  for i in 0...m
    for j in 0...n
      if i == 0 || j == 0
        dp[i][j] = 1
      else
        dp[i][j] = dp[i][j-1] + dp[i-1][j]
      end
    end
  end
  dp[m-1][n-1]
end
unique_paths(3, 7)

# https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
def num_rolls_to_target(d, f, target)
  dp = Array.new(target+1, 0)
  dp[0] = 1
  for k in 0...d
    temp_dp = Array.new(target+1, 0)
    for i in 0...target+1
      for j in 1...f+1
        if i - j >= 0
          temp_dp[i] = temp_dp[i] + dp[i-j]
        end
      end
    end
    dp = temp_dp
  end
  puts dp.inspect
end
num_rolls_to_target(2, 6, 7)

# https://leetcode.com/problems/target-sum/solution/
def find_target_sum_ways(nums, s)
  dp = Array.new(2001, 0)
  dp[nums[0] + 1000] = 1
  dp[-nums[0] + 1000] += 1
  for i in 1...nums.length
    nxt = Array.new(2001, 0)
    for sum in -1000...1000+1
      if dp[sum + 1000] > 0
        nxt[sum + nums[i] + 1000] += dp[sum + 1000]
        nxt[sum - nums[i] + 1000] += dp[sum + 1000]
      end
    end
    dp = nxt
  end
  s > 1000 ? 0 : dp[s + 1000]
end
find_target_sum_ways([1, 1, 1, 1, 1], 3)
find_target_sum_ways([0,0,0,0,0,0,0,0,1], 1)
