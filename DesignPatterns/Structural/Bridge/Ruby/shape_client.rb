class RedColor
  def apply_color
    'Red.'
  end
end

class GreenColor
  def apply_color
    'Green.'
  end
end

class Shape
  attr_accessor :color

  def initialize(color)
    self.color = color
  end

  def create_shape
    raise NotImplementedError
  end
end

class Triangle < Shape
  def create_shape
    puts "Triangle filled with color #{@color.apply_color}"
  end
end

class Pentagon < Shape
  def create_shape
    puts "Pentagon filled with color #{@color.apply_color}"
  end
end

triangle = Triangle.new(RedColor.new)
triangle.create_shape
pentagon = Pentagon.new(GreenColor.new)
pentagon.create_shape