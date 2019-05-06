class Vehicle
  attr_accessor :produce, :assemble

  def initialize(produce, assemble)
    @produce = produce
    @assemble = assemble
  end

  def manufacture
    raise NotImplementedError
  end
end

class Bike < Vehicle
  def manufacture
    puts "Bike #{@produce.work} And #{@assemble.work}"
  end
end

class Car < Vehicle
  def manufacture
    puts "Car #{@produce.work} And #{@assemble.work}"
  end
end

class Workshop
  def work
    raise NotImplementedError
  end
end

class Produce < Workshop
  def work
    'Produced'
  end
end

class Assemble < Workshop
  def work
    'Assembled'
  end
end

car = Car.new(Produce.new, Assemble.new)
car.manufacture

bike = Bike.new(Produce.new, Assemble.new)
bike.manufacture