import java.util.ArrayList;
import java.util.List;

class File {
  private String name;

  public File(String name) {
    this.name = name;
  }

  public void ls(){
    System.out.println(FileSystemClientB.compositeBuilder + name);
  }
}

class Directory {
  private String name;
  private ArrayList<Object> includedFiles = new ArrayList<Object>();

  public Directory(String name) {
    this.name = name;
  }

  public void add(Object obj) {
    includedFiles.add(obj);
  }

  public void ls() {
    System.out.println(FileSystemClientB.compositeBuilder + name);
    FileSystemClientB.compositeBuilder.append("   ");

    for(Object obj: includedFiles) {
      String name = obj.getClass().getSimpleName();
      if(name.equals("Directory")){
        ((Directory)obj).ls();
      } else {
        ((File)obj).ls();
      }
    }
    FileSystemClientB.compositeBuilder.setLength(FileSystemClientB.compositeBuilder.length() - 3);
  }
}

public class FileSystemClientB{
  public static StringBuilder compositeBuilder = new StringBuilder();

  public static void main(String[] args) {
    Directory music = new Directory("MUSIC");
    Directory scorpions = new Directory("SCORPIANS");
    Directory dio = new Directory("DIO");
    File track1 = new File("Don't wary, be happy.mp3");
    File track2 = new File("track2.m3u");
    File track3 = new File("Wind of change.mp3");
    File track4 = new File("Big city night.mp3");
    File track5 = new File("Rainbow in the dark.mp3");

    music.add(track1);
    music.add(scorpions);
    music.add(track2);
    scorpions.add(track3);
    scorpions.add(track4);
    scorpions.add(dio);
    dio.add(track5);
    music.ls();
  }
}