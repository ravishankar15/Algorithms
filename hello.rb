# @param {String} s
# @param {String[]} word_dict
# @return {String[]}
def word_break(s, word_dict)
    all_sentences = Set.new
    dict = {}
    word_dict.each { |w| dict[w] = true }
    
    schars = s.chars
    len = schars.size
    substring = Array.new(len) { Array.new(len) }
    for i in 0...len
        for j in i...len
            substring[i][j] = schars[i..j].join
        end
    end
    
    
    find_sentences(s.chars, 0, s.size, dict, [], substring, all_sentences)
    all_sentences.to_a
end

def find_sentences(s, st, ed, word_dict, curr, substring, all_sentences)
    if st == ed
        all_sentences << curr.join(' ')
        return
    end
    
    for i in st...ed
        wrd = s[st..i].join
        if word_dict[wrd]
            curr << wrd
            find_sentences(s, i+1, ed, word_dict, curr, substring, all_sentences)
            curr.pop
        end
    end
end