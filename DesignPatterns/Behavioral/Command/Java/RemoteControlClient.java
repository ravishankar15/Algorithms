interface Command {
  public void execute();
}

//Light classes and its commands
class Light {

  public void on() {
    System.out.println("The light is on");
  }

  public void off() {
    System.out.println("The light is off");
  }
}

class LightOnCommand implements Command {
  private Light light;
  
  public LightOnCommand(Light light){
    this.light = light;
  }

  public void execute(){
    this.light.on();
  }
}

class LightOffCommand implements Command {
  private Light light;

  public LightOffCommand(Light light) {
    this.light = light;
  }

  public void execute() {
    this.light.off();
  }
}

//Stereo classes and its commands
class Stereo {
  
  public void on(){
    System.out.println("Stereo is on");
  }

  public void off(){
    System.out.println("Stereo is off");
  }

  public void setCD(){
    System.out.println("Stereo is set for the CD");
  }

  public void setDVD(){
    System.out.println("Stereo is set for the DVD");
  }

  public void setRadio(){
    System.out.println("Stereo is set for the radio");
  }

  public void setVolume(int volume){
    System.out.println("Stereo is set for the volume " + volume);
  }
}

class StereoOffCommand implements Command {

  private Stereo stereo;

  public StereoOffCommand(Stereo stereo){
    this.stereo = stereo;
  }

  public void execute(){
    this.stereo.off();
  }
}

class StereoOnWithCDCommand implements Command {
  private Stereo stereo;

  public StereoOnWithCDCommand(Stereo stereo) {
    this.stereo = stereo;
  }

  public void execute(){
    this.stereo.on();
    this.stereo.setCD();
    this.stereo.setVolume(11);
  }
}

class RemoteControl {

  private Command command;

  public void setCommand(Command command) {
    this.command = command;
  }

  public void buttonWasPressed(){
    this.command.execute();
  }
}


public class RemoteControlClient{
  public static void main(String[] args) {
    RemoteControl rc = new RemoteControl();
    Light light = new Light();
    Stereo stereo = new Stereo();

    rc.setCommand(new LightOnCommand(light));
    rc.buttonWasPressed();

    rc.setCommand(new StereoOnWithCDCommand(stereo));
    rc.buttonWasPressed();

    rc.setCommand(new StereoOffCommand(stereo));
    rc.buttonWasPressed();
  }
}

