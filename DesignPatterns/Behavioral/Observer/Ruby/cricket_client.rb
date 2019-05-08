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

class CricketData < Subject
  attr_reader :runs, :wickets, :overs

  def notify_observers
    @observers.each do |observer|
      observer.update(@runs, @wickets, @overs)
    end
  end

  def fetch_latest_runs
    99
  end

  def fetch_latest_wickets
    3
  end

  def fetch_latest_overs
    33.4
  end

  def data_changed
    @runs = fetch_latest_runs
    @wickets = fetch_latest_wickets
    @overs = fetch_latest_overs
    notify_observers
  end
end

class Observer
  def update
    raise NotImplementedError
  end
end

class AverageScoreDisplay < Observer
  attr_reader :run_rate, :predicted_score

  def update(runs, wickets, overs)
    @run_rate = (runs/overs)
    @predicted_score = (@run_rate * 50).to_i
    puts "The Average score - Runrate - #{@run_rate} - Predicted_score - #{@predicted_score}"
  end
end

class CurrentScoreDisplay < Observer
  attr_reader :runs, :wickets, :overs

  def update(runs, wickets, overs)
    @runs = runs
    @wickets = wickets
    @overs = overs
    puts "The current score is Runs - #{@runs}, Wickets - #{@wickets} - Overs - #{@overs}"
  end
end

average_score = AverageScoreDisplay.new
current_score = CurrentScoreDisplay.new

cricket_data = CricketData.new
cricket_data.register_observer(average_score)
cricket_data.data_changed
puts "*********"
cricket_data.register_observer(current_score)
cricket_data.unregister_observer(average_score)
cricket_data.data_changed