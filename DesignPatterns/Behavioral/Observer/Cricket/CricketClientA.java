import java.util.ArrayList;
import java.util.Iterator;
// Implemented by Cricket data to communicate with observers
interface Subject {
  public void registerObserver(Observer o);
  public void unregisterObserver(Observer o);
  public void notifyObservers();
}

class CricketData implements Subject {
  private int runs;
  private int wickets;
  private float overs;
  private ArrayList<Observer> observerList;

  public CricketData() {
    observerList = new ArrayList<Observer>();
  }

  public void registerObserver(Observer o) {
    observerList.add(o);
  }

  public void unregisterObserver(Observer o) {
    observerList.remove(observerList.indexOf(o));
  }

  public void notifyObservers() {
    for(Iterator<Observer> it = observerList.iterator(); it.hasNext();) {
      Observer o = it.next();
      o.update(runs, wickets, overs);
    }
  }

  private int getLatestRuns() { 
      return 90; 
  } 

  // get latest wickets from stadium 
  private int getLatestWickets() { 
    return 2; 
  } 

  // get latest overs from stadium 
  private float getLatestOvers() { 
    return (float)10.2; 
  }
  // This method is used update displays when data changes 
  public void dataChanged() { 
    //get latest data 
    runs = getLatestRuns(); 
    wickets = getLatestWickets(); 
    overs = getLatestOvers(); 

    notifyObservers(); 
  } 
}


interface Observer {
  public void update(int runs, int wickets, float overs);
}

class AverageScoreDisplay implements Observer {
  private float runRate;
  private int predictedScore;

  public void update(int runs, int wickets, float overs) {
    this.runRate = (float) runs/overs;
    this.predictedScore = (int) (this.runRate * 50);
    display();
  }

  private void display() {
    System.out.println("Average Score Display: \n" +  "Run Rate: " + runRate + "\nPredicted Score: " + predictedScore);
  }
}

class CurrentScoreDisplay implements Observer {
  private int runs, wickets;
  private float overs;

  public void update(int runs, int wickets, float overs) {
    this.runs = runs;
    this.wickets = wickets;
    this.overs = overs;
    display();
  }

  private void display() {
    System.out.println("Current Score Display: \n" +  "Runs: " + runs + "\nWickets: " + wickets + "\nOvers: " + overs);
  }
}

public class CricketClientA {
  public static void main(String[] args) {
    AverageScoreDisplay averageScoreDisplay = new AverageScoreDisplay();
    CurrentScoreDisplay currentScoreDisplay = new CurrentScoreDisplay();

    CricketData cricketData = new CricketData();
    cricketData.registerObserver(averageScoreDisplay);
    cricketData.registerObserver(currentScoreDisplay);

    cricketData.dataChanged();

    cricketData.unregisterObserver(averageScoreDisplay);

    cricketData.dataChanged();
  }
}

