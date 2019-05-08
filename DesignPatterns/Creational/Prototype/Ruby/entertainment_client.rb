module Constants
  MOVIE = "Movie".freeze
  ALBUM = "Album".freeze
  SHOW = "Show".freeze
end

class Entertainment
  attr_reader :name

  def initialize(name)
    @name = name
  end

  def fetch
    raise NotImplementedError
  end
end

class Movie < Entertainment
  def fetch
    puts "#{@name} movie is added"
  end
end

class Album < Entertainment
  def fetch
    puts "#{@name} album is added"
  end
end

class Show < Entertainment
  def fetch
    puts "#{@name} show is added"
  end
end

class EntertainmentFactory
  @@registry = {}
  @@registry[Constants::MOVIE] = Movie.new("End Game")
  @@registry[Constants::ALBUM] = Movie.new("Petta")
  @@registry[Constants::SHOW] = Movie.new("Black Sheep")

  def self.fetch_instance(key)
    @@registry[key].clone()
  end
end

puts EntertainmentFactory.fetch_instance(Constants::MOVIE)
EntertainmentFactory.fetch_instance(Constants::MOVIE).fetch

puts EntertainmentFactory.fetch_instance(Constants::MOVIE)
EntertainmentFactory.fetch_instance(Constants::MOVIE).fetch