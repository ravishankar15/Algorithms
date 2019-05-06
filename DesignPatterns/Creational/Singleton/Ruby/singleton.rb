# Simple singlton implementation
class Logger
  attr_reader :log

  @@instance = new
  
  def initialize
    @log = File.open('logger.txt', 'a')
  end

  def self.instance
    @@instance
  end

  private_class_method :new
end

require 'singleton'
class SimpleLogger
  include Singleton

  attr_accessor :level

  ERROR = 1
  WARNING = 2
  INFO = 3

  def initialize
    @log = File.open('simple_logger.txt', 'w')
    @level = WARNING
  end

  ## the Singleton module overrides the following code
  # @@instance = self.new
  #
  # def self.instance
  #   @@instance
  # end
  #
  # private_class_method :new

  def error(msg)
    @log.puts(msg)
    @log.flush
  end

  def warning(msg)
    @log.puts(msg) if @level >= WARNING
    @log.flush
  end

  def info(msg)
    @log.puts(msg) if @level >= INFO
    @log.flush
  end
end


logger = SimpleLogger.instance
puts logger.level
SimpleLogger.instance.info('Computer wins chess game.')
SimpleLogger.instance.warning('AE-35 hardware failure predicted.')
SimpleLogger.instance.error('HAL-9000 malfunction, take emergency action!')