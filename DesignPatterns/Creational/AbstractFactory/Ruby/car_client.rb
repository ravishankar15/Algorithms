module CarConstants
  module Type
    MICRO = "MICRO".freeze
    LUXURY = "LUXURY".freeze
  end
  module Location
    USA = "USA".freeze
    INDIA = "INDIA".freeze
  end
end

class Car
  include CarConstants::Location
  include CarConstants::Type

  attr_accessor :model, :location

  def initialize(model, location)
    self.model = model
    self.location = location
  end

  def construct
    raise NotImplementedError
  end

  def to_s
    "CarModel - #{self.model} located in - #{self.location}"
  end
end

class LuxuryCar < Car
  def initialize(location)
    super(LUXURY, location)
    construct()
  end

  def construct
    puts 'Connecting to LuxuryCar'
  end
end

class MicroCar < Car
  def initialize(location)
    super(MICRO, location)
    construct();
  end

  def construct
    puts 'Connecting to MicroCar'
  end
end

class IndiaCarFactory
  def self.build_car(model)
    case model
    when CarConstants::Type::MICRO then MicroCar.new(CarConstants::Location::INDIA)
    when CarConstants::Type::LUXURY then LuxuryCar.new(CarConstants::Location::INDIA)
    end
  end
end

class UsaCarFactory
  def self.build_car(model)
    case model
    when CarConstants::Type::MICRO then MicroCar.new(CarConstants::Location::USA)
    when CarConstants::Type::LUXURY then LuxuryCar.new(CarConstants::Location::USA)
    end
  end
end

class CarFactory
  def self.build_car(model)
    location = CarConstants::Location::INDIA
    case location
    when CarConstants::Location::INDIA then IndiaCarFactory.build_car(model)
    when CarConstants::Location::USA then UsaCarFactory.build_car(model)
    end
  end
end

puts CarFactory.build_car(CarConstants::Type::MICRO)
puts CarFactory.build_car(CarConstants::Type::LUXURY)

