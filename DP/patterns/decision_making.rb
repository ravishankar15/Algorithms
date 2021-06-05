#https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
def max_profit(prices)
    n = prices.length
    max_profit = 0; curr_rit_max = prices[n-1]
    for i in (n-1).downto(0)
        max_profit = [max_profit, curr_rit_max - prices[i]].max
        curr_rit_max = [curr_rit_max, prices[i]].max
    end
    max_profit
end

#https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
def max_profit(prices)
    n = prices.length
    max_profit = 0
    for i in 1...n
        max_profit += prices[i] - prices[i-1] if prices[i] > prices[i-1]
    end
    max_profit
end

#https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
def max_profit(prices, fee)
    n = prices.length
    cash = 0; hold = -prices[i]
    for i in 1...n
        hold = [hold, cash - prices[i]].max
        cash = [cash, prices[i] + hold - fee].max
    end
    cash
end

#https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
# buy(dp[0]) you can go to sell
# sell(dp[1]) you can go to cool
# cool(dp[2]) you can go to buy
def max_profit(prices)
    len = prices.length
    dp = Array.new(3) { Array.new(2) }
    dp[0][0] = -prices[0]
    dp[1][0] = 0
    dp[2][0] = 0
    for i in 1...len
        dp[0][i%2] = [dp[0][(i-1)%2], dp[2][(i-1)%2]-prices[i]].max
        dp[1][i%2] = [dp[1][(i-1)%2], prices[i] + dp[0][(i-1)%2]].max
        dp[2][i%2] = [dp[2][(i-1)%2], dp[1][(i-1)%2]].max
    end
    [dp[0][(len-1)%2],dp[1][(len-1)%2],dp[2][(len-1)%2]].max
end