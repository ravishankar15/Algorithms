class TrieNode
    attr_accessor :children, :is_word

    def intialize()
        @children = Array.new(26, nil)
        @is_word = false
    end
end

class WordSearch
    attr_accessor :root

    def intialize(words)
        @root = TrieNode.new
    end


    def insert(word)
        p_crawl = root
        for level in 0...word.size
            idx = get_index(word[level])
            p_crawl.children[idx] = TrieNode.new if p_crawl.children[idx].nil?

            p_crawl = p_crawl.children[idx]
        end
        p_crawl.is_word = true
    end

    def search(key)
        p_crawl = root
        level = 0
        while(level < key.size)
            idx = get_index(word[level])
            return [level, false] if p_crawl.children[idx].nil?

            p_crawl = p_crawl.children[idx]
            level += 1
        end
        [level, true]
    end

    private
        def get_index(ch)
            ch.ord - 'a'.ord
        end
end
