# https://leetcode.com/problems/min-cost-climbing-stairs/
def min_cost_climbing_stairs(cost)
  cost_length = cost.count
  dp = Array.new(cost_length, 0)
  dp[0] = cost[0]
  dp[1] = cost[1]

  for i in 2...cost_length+1
    dp[i] = [dp[i-1], dp[i-2]].min + (i==cost_length ? 0 : cost[i])
  end
  dp[cost_length]
end
min_cost_climbing_stairs([1, 100, 1, 1, 1, 100, 1, 1, 100, 1])
min_cost_climbing_stairs([10, 15, 20])

# https://leetcode.com/problems/minimum-path-sum/
def min_path_sum(grid)
  m = grid.length
  n = grid.first.length
  dp = Array.new(m) { Array.new(n, 0) }

  for i in 0...m
    for j in 0...n
      if i == 0 && j > 0
        dp[i][j] = dp[i][j-1] + grid[i][j]
      elsif j == 0 && i > 0
        dp[i][j] = dp[i-1][j] + grid[i][j]
      else
        dp[i][j] = [dp[i-1][j], dp[i][j-1]].min + grid[i][j]
      end
    end
  end
  dp[m-1][n-1]
end
min_path_sum([[1,3,1],[1,5,1],[4,2,1]])
min_path_sum([[1,2,3],[4,5,6]])

# https://leetcode.com/problems/coin-change/
def coin_change(coins, amount)
  dp = Array.new(amount+1, (2**(0.size * 8 -2) -1))
  dp[0] = 0
  coins.each do |coin|
    for i in coin...amount+1
      dp[i] = [dp[i], dp[i-coin] + 1].min
    end
  end
  dp[amount] == (2**(0.size * 8 -2) -1) ? -1 : dp[amount]
end
coin_change([1,2,5], 11)
coin_change([2], 3)

# https://leetcode.com/problems/minimum-falling-path-sum/
def min_falling_path_sum(a)
  m = a.length
  n = a.first.length
  dp = Array.new(m) { Array.new(n, 0) }
  for i in 0...m
    for j in 0...n
      if i == 0
        dp[i][j] = a[i][j]
      else
        temp = []
        temp << dp[i-1][j] + a[i][j]
        temp << dp[i-1][j-1] + a[i][j] if j > 0
        temp << dp[i-1][j+1] + a[i][j] if j < n-1
        dp[i][j] = temp.min
      end
    end
  end
  dp.last.min
end
min_falling_path_sum([[1,2,3],[4,5,6],[7,8,9]])
