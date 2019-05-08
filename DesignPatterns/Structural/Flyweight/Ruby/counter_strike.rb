class Player
  attr_reader :task, :weapon

  def initialize(task)
    @task = task
  end

  def assign_weapon(weapon)
    raise NotImplementedError
  end

  def mission
    raise NotImplementedError
  end
end

class Terrorist < Player
  def initialize
    super('Plant a Bomb')
  end

  def assign_weapon(weapon)
    @weapon = weapon
  end

  def mission
    puts "Terrorist with weapon #{@weapon} | task is #{@task}"
  end
end

class CounterTerrorist < Player
  def initialize
    super('Diffuse the bomb')
  end
  def assign_weapon(weapon)
    @weapon = weapon
  end

  def mission
    puts "CounterTerrorist with weapon #{@weapon} | task is #{@task}"
  end
end

module Constants
  TERRORIST = "TERRORIST".freeze
  COUNTER_TERRORIST = "COUNTER_TERRORIST".freeze
end

class PlayerFactory
  @@pool = {}

  def self.fetch_player(type)
    if @@pool.has_key?(type)
      @@pool[type]
    else
      case type
      when Constants::TERRORIST then @@pool[type] = Terrorist.new
      when Constants::COUNTER_TERRORIST then @@pool[type] = CounterTerrorist.new
      end
    end
  end
end

p1 = PlayerFactory.fetch_player(Constants::TERRORIST)
puts p1
p1.assign_weapon('AK-47')
p1.mission

p2 = PlayerFactory.fetch_player(Constants::COUNTER_TERRORIST)
puts p2
p2.assign_weapon('Maverick')
p2.mission

p3 = PlayerFactory.fetch_player(Constants::TERRORIST)
puts p3
p3.assign_weapon('Gut Knife')
p3.mission