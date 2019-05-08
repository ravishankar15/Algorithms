class JumpBehaviour
  def jump
    raise NotImplementedError
  end
end

class ShortJump < JumpBehaviour
  def jump
    puts "Short Jump"
  end
end

class LongJump < JumpBehaviour
  def jump
    puts "Long Jump"
  end
end

class RollBehaviour
  def roll
    raise NotImplementedError
  end
end

class SingleRoll < RollBehaviour
  def roll
    puts "Single Roll"
  end
end

class DoubleRoll < RollBehaviour
  def roll
    puts "Double Roll"
  end
end

class Fighter
  attr_accessor :jump_behaviour, :roll_behaviour

  def initialize(jump_behaviour, roll_behaviour)
    @jump_behaviour = jump_behaviour
    @roll_behaviour = roll_behaviour
  end

  def punch
    puts "Default Punch"
  end

  def kick
    puts "Default Kick"
  end

  def jump
    @jump_behaviour.jump
  end

  def roll
    @roll_behaviour.roll
  end
end

class Ryu < Fighter
  def display
    puts "Ryu"
  end
end

class Ken < Fighter
  def display
    puts "Ken"
  end
end

short_jump = ShortJump.new
long_jump = LongJump.new

single_roll = SingleRoll.new
double_roll = DoubleRoll.new

ken = Ken.new(short_jump, double_roll)
ken.display
ken.punch
ken.kick
ken.jump
ken.roll

ryu = Ryu.new(long_jump, single_roll)
ryu.display
ryu.punch
ryu.kick
ryu.jump
ryu.roll