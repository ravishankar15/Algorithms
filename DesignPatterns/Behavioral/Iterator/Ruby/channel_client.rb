module Constants
  ENGLISH = "ENGLISH".freeze
  TAMIL = "TAMIL".freeze
  HINDI = "HINDI".freeze
  ALL = "ALL".freeze
end

class Channel
  attr_reader :freq, :type

  def initialize(freq, type)
    @freq = freq
    @type = type
  end

  def to_s
    "Frequency = #{@freq}, Type = #{@type}"
  end
end

class Iterator
  attr_reader :pos

  def initialize
    @pos = 0
  end
end

class ChannelIterator < Iterator
  attr_reader :channels, :type

  def initialize(channels, type)
    super()
    @channels = channels.clone
    @type = type
  end

  def next
    value = @channels[@pos]
    @pos += 1
    value
  end

  def has_next?
    while @pos < @channels.length
      value = @channels[@pos]
      if @type == Constants::ALL || value.type == @type
        return true
      else
        @pos += 1
      end
    end
    return false
  end
end

class Collection
  attr_reader :items, :total_items

  def initialize
    @items = []
    @total_items = 0
  end
end

class ChannelCollection < Collection
  def add_item(item)
    @items << item
  end

  def create_iterator(type)
    ChannelIterator.new(@items, type)
  end
end

cc = ChannelCollection.new
cc.add_item(Channel.new(98.5, Constants::ENGLISH))
cc.add_item(Channel.new(99.5, Constants::TAMIL))
cc.add_item(Channel.new(101.5, Constants::ENGLISH))
cc.add_item(Channel.new(103.5, Constants::HINDI))
cc.add_item(Channel.new(96.5, Constants::TAMIL))
cc.add_item(Channel.new(106.5, Constants::HINDI))

eng_iterator = cc.create_iterator(Constants::ENGLISH)
while eng_iterator.has_next? do
  puts eng_iterator.next
end

puts "*********"

all_iterator = cc.create_iterator(Constants::ALL)
while all_iterator.has_next? do
  puts all_iterator.next
end
