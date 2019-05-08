class AbstractAlphabet
  def do_it
    raise NotImplementedError
  end
end

class A < AbstractAlphabet
  def do_it
    'A'
  end
end

class D < AbstractAlphabet
  attr_accessor :charecter

  def initialize(charecter)
    @charecter = charecter
  end

  def do_it
    @charecter.do_it
  end
end

class X < D
  def do_it
    super + 'X'
  end
end

class Y < D
  def do_it
    super + 'Y'
  end
end

class Z < D
  def do_it
    super + 'Z'
  end
end

a = [X.new(A.new), Y.new(X.new(A.new)), Z.new(Y.new(A.new))]
a.each do |alphabet|
  puts alphabet.do_it
end