class ChainProcessor
  attr_reader :next_handler

  def set_next_handler(next_handler)
    @next_handler = next_handler
  end

  def process(number)
    raise NotImplementedError
  end
end

class NegativeProcesssor < ChainProcessor
  def process(number)
    if number < 0
      puts "Handled by negative processor" 
    else
      @next_handler.process(number)
    end
  end
end

class PositiveProcessor < ChainProcessor
  def process(number)
    if number > 0
      puts "Handled by positive processor"
    else
      @next_handler.process(number)
    end
  end
end

class ZeroProcessor < ChainProcessor
  def process(number)
    if number == 0
      puts "Handled by zero processor"
    else
      @next_handler.process(number) 
    end
  end
end

np = NegativeProcesssor.new
pp = PositiveProcessor.new
zp = ZeroProcessor.new

np.set_next_handler(pp)
pp.set_next_handler(zp)
zp.set_next_handler(np)

np.process(90)
np.process(-90)
np.process(0)
