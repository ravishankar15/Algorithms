class AbstractFile
  attr_reader :children, :name
  attr_accessor :parent

  def initialize(name)
    @name = name
    @children = []
  end

  def ls
    raise NotImplementedError
  end
end

class FileA < AbstractFile
  def ls
    puts "  #{self.name}"
  end
end


class Directory < AbstractFile
  def add_file(file)
    @children.push(file)
    file.parent = self
  end

  def ls
    puts @name
    @children.each do |child|
      child.ls
    end
  end
end

music = Directory.new("MUSIC")
scorpions = Directory.new("SCORPIANS")
dio = Directory.new("DIO")

track1 = FileA.new("Don't wary, be happy.mp3")
track2 = FileA.new("track2.m3u")
track3 = FileA.new("Wind of change.mp3")
track4 = FileA.new("Big city night.mp3")
track5 = FileA.new("Rainbow in the dark.mp3")

music.add_file(track1)
music.add_file(scorpions)
music.add_file(track2)

scorpions.add_file(track3);
scorpions.add_file(track4);
scorpions.add_file(dio);

dio.add_file(track5);
music.ls();