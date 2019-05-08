class Pizza
  def fetch_cost
    puts "Basic Pizza Cost..."
    100
  end
end

class PeppyPannerPizza < Pizza
  def fetch_cost
    puts "Peppy Panner Pizza cost ...."
    200
  end
end

class PizzaDecorator < Pizza
  attr_accessor :pizza

  def initialize(pizza)
    @pizza = pizza
  end

  def fetch_cost
    @pizza.fetch_cost
  end
end

class Panner < PizzaDecorator
  def fetch_cost
    @pizza.fetch_cost + 10
  end
end

class Cheese < PizzaDecorator
  def fetch_cost
    @pizza.fetch_cost + 20
  end
end

basic_pizza = Panner.new(Pizza.new)
puts basic_pizza.fetch_cost

special_pizza = Cheese.new(Panner.new(PeppyPannerPizza.new))
puts special_pizza.fetch_cost