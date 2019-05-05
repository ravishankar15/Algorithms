/*
Problems:
  - CricketData holds references to concret display element objects even though it needs to call only the update method of their objects. 
      It has access to too much additional information than it requires.
  - The statement "currentScoreDisplay.update(runs,wickets,overs);" violates one of the most important design principle 
      "Program to interfaces, not implementations" as we are using the concrete objects to share data rather than abstract interfaces
  - CricketData and display elements are tightly coupled
  - If in future another requirement comes in and we need another display element to be added we need to make changes to the non-varying
      part of our code(CricketData). This is definitely not a good design practice and application might not be able to handle changes and
      not easy to maintain
*/
class CricketData {
  private int runs, wickets;
  private float overs;
  private CurrentScoreDisplay currentScoreDisplay;
  private AverageScoreDisplay averageScoreDisplay;

  public CricketData(CurrentScoreDisplay currentScoreDisplay, AverageScoreDisplay averageScoreDisplay) {
    this.currentScoreDisplay = currentScoreDisplay;
    this.averageScoreDisplay = averageScoreDisplay;
  }

  //Returning sample data just for simplicity
  private int getLatestRuns() {
    return 90;
  }

  private int getLatestWickets() {
    return 2;
  }

  private float getLatestOvers() {
    return (float)10.2;
  }


  public void dataChanged() {
    runs = getLatestRuns();
    wickets = getLatestWickets();
    overs = getLatestOvers();

    currentScoreDisplay.update(runs, wickets, overs);
    averageScoreDisplay.update(runs, wickets, overs);
  }

}


class AverageScoreDisplay {
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


class CurrentScoreDisplay {
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


public class CricketClientB {
  public static void main(String[] args) {
    AverageScoreDisplay averageScoreDisplay = new AverageScoreDisplay();
    CurrentScoreDisplay currentScoreDisplay = new CurrentScoreDisplay();

    CricketData cricketData = new CricketData(currentScoreDisplay, averageScoreDisplay);
    cricketData.dataChanged();
  }
}