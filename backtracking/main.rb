# https://leetcode.com/problems/generate-parentheses/solution/
class GenerateParanthesis
  def generate(n)
    ans = []
    backtrack(ans, [], 0, 0, n)
    ans
  end

  private
    def backtrack(ans, curr_char, op_count, cl_count, max)
      if (curr_char.size == max*2)
        ans << curr_char.join
        return
      end

      if op_count < max
        curr_char << '('
        backtrack(ans, curr_char, op_count+1, cl_count, max)
        curr_char.pop
      end

      if cl_count < op_count
        curr_char << ')'
        backtrack(ans, curr_char, op_count, cl_count+1, max)
        curr_char.pop
      end
    end
end
# puts GenerateParanthesis.new.generate(3).inspect


# https://leetcode.com/problems/letter-combinations-of-a-phone-number/
class LetterCombinations
  def combinations(digits)
    ans = []
    return ans if digits.empty?

    data = {
        '2' => ['a','b','c'],
        '3' => ['d','e','f'],
        '4' => ['g','h','i'],
        '5' => ['j','k','l'],
        '6' => ['m','n','o'],
        '7' => ['p','q','r','s'],
        '8' => ['t','u','v'],
        '9' => ['w','x','y','z']
    }
    backtrack(ans, data, digits.chars, [], 0)
    ans
  end

  private
    def backtrack(ans, data, digits, curr_char, pos)
      if curr_char.size == digits.size
        ans << curr_char.join
        return
      end

      return if pos >= digits.size

      data[digits[pos]].each do |ch|
        curr_char << ch
        backtrack(ans, data, digits, curr_char, pos+1)
        curr_char.pop
      end
    end
end
# puts LetterCombinations.new.combinations().inspect
# puts LetterCombinations.new.combinations("23").inspect

# https://leetcode.com/problems/combination-sum/
class CombinationSum
  def combination_sum(candidates, target)
    ans = []
    backtrack_cs(ans, candidates, 0, [], target)
    ans
  end

  private
    def backtrack_cs(ans, candidates, pos, curr_candidates, target)
      if target == 0
        ans << curr_candidates.dup
        return
      end

      return if target < 0

      for i in pos...candidates.size
        curr_candidates << candidates[i]
        backtrack_cs(ans, candidates, i, curr_candidates, target-candidates[i])
        curr_candidates.pop
      end
    end
end
# puts CombinationSum.new.combination_sum([2,3,6,7], 7).inspect
# puts CombinationSum.new.combination_sum([2,3,5], 8).inspect
# puts CombinationSum.new.combination_sum([2], 1).inspect
# puts CombinationSum.new.combination_sum([1], 1).inspect
# puts CombinationSum.new.combination_sum([1], 2).inspect