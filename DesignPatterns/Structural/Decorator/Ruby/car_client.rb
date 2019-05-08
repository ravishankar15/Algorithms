class BasicCar
  def assemble
    puts 'Basic car...'
  end
end

class CarDecorator < BasicCar
  attr_accessor :car

  def initialize(car)
    @car = car
  end

  def assemble
    @car.assemble
  end
end

class SportsCar < CarDecorator
  def assemble
    super
    puts 'Adding sports car features'
  end
end

class LuxuryCar < CarDecorator
  def assemble
    super
    puts 'Adding luxury car features'
  end
end

sports_car = SportsCar.new(BasicCar.new)
sports_car.assemble

sports_luxury_car = SportsCar.new(LuxuryCar.new(BasicCar.new))
sports_luxury_car.assemble
