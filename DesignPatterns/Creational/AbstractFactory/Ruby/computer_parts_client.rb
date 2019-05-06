module Constants
  ENGINOLA = "ENGINOLA".freeze
  EMBER = "EMBER".freeze
end

class CPU
  def display_cpu
    raise NotImplementedError
  end
end

class EmberCPU < CPU
  def display_cpu
    puts 'Ember CPU is been built'
  end
end

class EnginolaCPU < CPU
  def display_cpu
    puts 'Enginola CPU is been build'
  end
end

class MMU
  def display_mmu
    raise NotImplementedError
  end
end

class EmberMMU < MMU
  def display_mmu
    puts 'Ember MMU is been built'
  end
end

class EnginolaMMU < MMU
  def display_mmu
    puts 'Enginola MMU is been built'
  end
end

class AbstractFactory
  def create_cpu
    raise NotImplementedError
  end

  def create_mmu
    raise NotImplementedError
  end
end

class EmberToolkit < AbstractFactory
  def create_cpu
    EmberCPU.new
  end

  def create_mmu
    EmberMMU.new
  end
end

class EnginolaToolkit < AbstractFactory
  def create_cpu
    EnginolaCPU.new
  end

  def create_mmu
    EnginolaMMU.new
  end
end


class ToolKitFactory
  @@ember_toolkit = EmberToolkit.new
  @@enginola_tookit = EnginolaToolkit.new

  def self.fetch_factory(architecture)
    case architecture
    when Constants::EMBER then @@ember_toolkit
    when Constants::ENGINOLA then @@enginola_tookit
    end
  end
end

tf = ToolKitFactory.fetch_factory(Constants::EMBER)
tf.create_cpu.display_cpu
tf.create_mmu.display_mmu