class Bird
  def fly
    raise NotImplementedError
  end

  def make_sound
    raise NotImplementedError
  end
end

class Sparrow < Bird
  def fly
    puts 'Sparrow Flying'
  end

  def make_sound
    puts 'Sparrow speaking Chirp Chirp'
  end
end

class ToyDuck
  def squeak
    raise NotImplementedError
  end
end

class PlasticToyDuck < ToyDuck
  def squeak
    puts 'Squeak'
  end
end

class BirdAdapter < ToyDuck
  attr_accessor :bird

  def initialize(bird)
    self.bird = bird
  end

  def squeak
    self.bird.make_sound
  end
end

sparrow = Sparrow.new
plastic_toy_duck = PlasticToyDuck.new
bird_adapter = BirdAdapter.new(sparrow)

puts 'Sparrow ....'
sparrow.fly
sparrow.make_sound

puts 'PlasticToyDuck ....'
plastic_toy_duck.squeak

puts 'BirdAdapter .....'
bird_adapter.squeak