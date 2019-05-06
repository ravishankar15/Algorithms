class Shape
  def draw
    raise NotImplementedError
  end
end

class Square < Shape
  def draw
    puts 'Inside Square::draw() method.'
  end
end

class Circle < Shape
  def draw
    puts 'Inside Circle::draw() method.'
  end
end

class Rectangle < Shape
  def draw
    puts 'Inside Rectangle::draw() method.'
  end
end

class ShapeFactory
  def fetch_shape(type)
    case type
    when 'Circle' then Circle.new
    when 'Rectangle' then Rectangle.new
    when 'Square' then Square.new
    end        
  end
end

sf = ShapeFactory.new
circle = sf.fetch_shape('Circle')
circle.draw;

rectangle = sf.fetch_shape('Rectangle')
rectangle.draw

square = sf.fetch_shape('Square')
square.draw