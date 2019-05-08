class Light
  def on
    puts "The light is on"
  end

  def off
    puts "The light is off"
  end
end

class Stereo
  def on
    puts "Stereo is on"
  end

  def off
    puts "Stereo is off"
  end

  def insert_cd
    puts 'Stereo is inserted with CD'
  end

  def insert_dvd
    puts 'Stereo is inserted with DVD'
  end

  def switch_to_radio
    puts 'Stereo is switched to radio'
  end

  def save_volume(volume)
    puts "Stereo is made to volume #{volume}"
  end
end

class Command
  attr_reader :item

  def initialize(item)
    @item = item
  end

  def execute
    raise NotImplementedError
  end

  def unexecute
    raise NotImplementedError
  end
end

class LightCommand < Command
  def execute
    @item.on
  end

  def unexecute
    @item.off
  end
end

class StereoCommand < Command
  def execute
    @item.on
    @item.insert_cd
    @item.save_volume(10)
  end

  def unexecute
    @item.off
  end
end


class RemoteControl
  attr_reader :command

  def assign_command(command)
    @command = command
  end

  def execute_button
    @command.execute
  end

  def unexecute_button
    @command.unexecute
  end
end

rc = RemoteControl.new
light = Light.new
stereo = Stereo.new

rc.assign_command(LightCommand.new(light))
rc.execute_button
rc.unexecute_button

rc.assign_command(StereoCommand.new(stereo))
rc.execute_button
rc.unexecute_button