class Pizza
  attr_accessor :dough, :sauce, :topping

  def to_s
    "Pizza with : #{self.dough} * #{self.sauce} * #{self.topping}"
  end
end

class PizzaBuilder
  attr_accessor :pizza
  
  def initialize
    self.pizza = Pizza.new
  end

  def build_dough
    raise NotImplementedError
  end

  def build_sauce
    raise NotImplementedError
  end

  def build_topping
    raise NotImplementedError
  end

  def fetch_pizza
    return self.pizza
  end
end

class HawaiianPizzaBuilder < PizzaBuilder
  def build_dough
    pizza.dough = 'cross'
  end

  def build_sauce
    pizza.sauce = 'mild'
  end

  def build_topping
    pizza.topping = 'ham+pineapple'
  end
end

class SpicyPizzaBuilder < PizzaBuilder
  def build_dough
    pizza.dough = 'pan baked'
  end

  def build_sauce
    pizza.sauce = 'hot'
  end

  def build_topping
    pizza.topping = 'pepperoni+salami'
  end
end

class Waiter
  attr_accessor :pizza_builder

  def initialize(pizza_builder)
    self.pizza_builder = pizza_builder
  end

  def build_pizza
    self.pizza_builder.build_dough
    self.pizza_builder.build_sauce
    self.pizza_builder.build_topping
  end

  def fetch_pizza
    self.pizza_builder.fetch_pizza
  end
end

hp = HawaiianPizzaBuilder.new
sp = SpicyPizzaBuilder.new
w1 = Waiter.new(hp);
w2 = Waiter.new(sp);

w1.build_pizza
w2.build_pizza

puts w1.fetch_pizza
puts w2.fetch_pizza