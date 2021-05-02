def longest_common_subsequence(a, b)
  m = a.length
  n = b.length
  dp = Array.new(m+1) { Array.new(n+1, 0) }

  for i in 0..m
    for j in 0..n
      if i == 0 || j == 0
        dp[i][j] = 0
      elsif a[i-1] == b[j-1]
        dp[i][j] = dp[i-1][j-1] + 1
      else
        dp[i][j] = [dp[i-1][j], dp[i][j-1]].max
      end
    end
  end
  dp[m][n]
end
longest_common_subsequence('AGGTAB', 'GXTXAYB')
