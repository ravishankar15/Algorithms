# @param {Integer} n
# @param {Integer[][]} flights
# @param {Integer} src
# @param {Integer} dst
# @param {Integer} k
# @return {Integer}
def find_cheapest_price(n, flights, src, dst, k)
    int_max = 2**31
    prev_stage = Array.new(n, int_max)
    prev_stage[src] = 0
    
    for i in 0..k
        curr_stage = Array.new(n, int_max)
        for j in 0...flights.size
            u = flights[j][0]
            v = flights[j][1]
            w = flights[j][2]
            
            if prev_stage[u] != int_max && prev_stage[u] + w < curr_stage[v]
                curr_stage[v] = prev_stage[u] + w
            end
        end
        puts prev_stage.inspect
        puts curr_stage.inspect
        byebug
        prev_stage = curr_stage.dup
    end
    return -1 if curr_stage[dst] >= int_max

    curr_stage[dst]
end
puts find_cheapest_price(3, [[0,1,100],[1,2,100],[0,2,500]], 0, 2, 1)