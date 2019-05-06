class Color
  def fill
    raise NotImplementedError
  end
end

class Red < Color
  def fill
    puts 'Inside Red::fill() method'
  end
end

class Green < Color
  def fill
    puts 'Inside Green::fill() method'
  end
end

class Blue < Color
  def fill
    puts 'Inside Blue::fill() method'
  end
end


class Shape
  def draw
    raise NotImplementedError
  end
end

class Square < Shape
  def draw
    puts 'Inside Square::draw() method'
  end
end

class Rectangle < Shape
  def draw
    puts 'Inside Rectangle::draw() method'
  end
end

class Circle < Shape
  def draw
    puts 'Inside Circle::draw() method'
  end
end

class AbstractFactory
  def create_color
    raise NotImplementedError
  end

  def create_shape
    raise NotImplementedError
  end
end

class RedCircleFactory < AbstractFactory
  def create_color
    Red.new
  end

  def create_shape
    Circle.new
  end
end

class GreenSquareFactory < AbstractFactory
  def create_color
    Green.new
  end

  def create_shape
    Square.new
  end
end

class BlueRectangleFactory < AbstractFactory
  def create_color
    Blue.new
  end

  def create_shape
    Rectangle.new
  end
end

class ColouredShapeFactory
  def fetch_factory(factory_type)
    if %w[RedCircle GreenSquare BlueRectangle].include? factory_type
      self.class.const_get("#{factory_type}Factory").new
    end
  end
end

csf = ColouredShapeFactory.new

rcf = csf.fetch_factory('RedCircle')
puts 'Red Circle Factory'
rcf.create_shape.draw
rcf.create_color.fill
puts 

gsf = csf.fetch_factory('GreenSquare')
puts 'Green Square Factory'
gsf.create_shape.draw
gsf.create_color.fill
puts 

brf = csf.fetch_factory('BlueRectangle')
puts 'Blue Rectangle Factory'
brf.create_shape.draw
brf.create_color.fill