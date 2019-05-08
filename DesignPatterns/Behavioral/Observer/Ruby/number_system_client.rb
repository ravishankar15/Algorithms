class Subject
  attr_reader :observers

  def initialize
    @observers = []
  end

  def register_observer(observer)
    @observers << observer
  end

  def unregister_observer(observer)
    @observers.delete_if { |obs| obs == observer }
  end
end

class NumberSystemSubject < Subject
  attr_reader :value

  def initialize(value)
    super()
    @value = value
  end

  def notify_observers
    @observers.each do |observer|
      observer.update(@value)
    end
  end
end

class Observer
  def update(value)
    raise NotImplementedError
  end
end

class HexObserver < Observer
  def update(value)
    puts " #{value.to_s(16)}"
  end
end

class OctObserver < Observer
  def update(value)
    puts " #{value.to_s(8)}"
  end
end

class BinObserver < Observer
  def update(value)
    puts " #{value.to_s(2)}"
  end
end

hex = HexObserver.new
oct = OctObserver.new
bin = BinObserver.new

subject = NumberSystemSubject.new(55)
subject.register_observer(hex)
subject.register_observer(oct)

subject.notify_observers

puts "*************"
subject.unregister_observer(oct)
subject.register_observer(bin)
subject.notify_observers