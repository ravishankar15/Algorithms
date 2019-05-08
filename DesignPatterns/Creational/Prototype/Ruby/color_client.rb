module Constants
  BLUE = "blue".freeze
  BLACK = "black".freeze
end
class Color
  attr_reader :name

  def initialize(name)
    @name = name
  end

  def add_color
    raise NotImplementedError
  end
end

class BlueColor < Color
  def add_color
    puts "Blue color added"
  end
end

class BlackColor < Color
  def add_color
    puts "Black color added"
  end
end

class ColorStore
  @@color_map = {}
  @@color_map[Constants::BLUE] = BlueColor.new(Constants::BLUE)
  @@color_map[Constants::BLACK] = BlackColor.new(Constants::BLACK)

  def self.fetch_instance(color)
    @@color_map[color].clone()
  end
end

puts ColorStore.fetch_instance(Constants::BLUE)
ColorStore.fetch_instance(Constants::BLUE).add_color

puts ColorStore.fetch_instance(Constants::BLACK)
ColorStore.fetch_instance(Constants::BLACK).add_color

puts ColorStore.fetch_instance(Constants::BLUE)
ColorStore.fetch_instance(Constants::BLUE).add_color