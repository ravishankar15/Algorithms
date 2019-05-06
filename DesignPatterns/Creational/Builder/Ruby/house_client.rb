class House
  attr_accessor :basement, :structure, :roof, :interior

  def to_s
    "House spec \nBasement: #{self.basement} \nStructure: #{self.structure} \nRoof: #{self.roof} \nInterior: #{self.interior} \n"
  end
end

class HouseBuilder
  def build_basement
    raise NotImplementedError
  end

  def build_structure
    raise NotImplementedError
  end

  def build_roof
    raise NotImplementedError
  end

  def build_interior
    raise NotImplementedError
  end

  def fetch_house
    raise NotImplementedError
  end
end

class IglooHouseBuilder < HouseBuilder
  attr_accessor :house

  def initialize
    self.house = House.new
  end

  def build_basement
    house.basement = 'Ice Bars'
  end

  def build_structure
    house.structure = 'Ice Blocks'
  end

  def build_interior
    house.interior = 'Ice carvings'
  end

  def build_roof
    house.roof = 'Ice Dome'
  end

  def fetch_house
    self.house
  end
end

class TipiHouseBuilder < HouseBuilder
  attr_accessor :house

  def initialize
    self.house = House.new
  end

  def build_basement
    house.basement = 'Wooden Poles'
  end

  def build_structure
    house.structure = 'Wood and Ice'
  end

  def build_interior
    house.interior = 'Fire Wood'
  end

  def build_roof
    house.roof = 'Wood, caribou and seal skins'
  end

  def fetch_house
    self.house
  end
end

class CivilEngineer
  attr_accessor :house_builder

  def initialize(house_builder)
    self.house_builder = house_builder
  end

  def construct_house
    self.house_builder.build_basement
    self.house_builder.build_structure
    self.house_builder.build_interior
    self.house_builder.build_roof
  end

  def fetch_house
    self.house_builder.fetch_house
  end
end

hb = IglooHouseBuilder.new
e1 = CivilEngineer.new(hb);
e1.construct_house
puts e1.fetch_house