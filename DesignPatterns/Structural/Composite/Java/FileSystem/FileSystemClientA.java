import java.util.ArrayList;
import java.util.List;

interface AbstractFile {
  public void ls();
}

class FileA implements AbstractFile {
  private String name;

  public FileA(String name) {
    this.name = name;
  }

  public void ls() {
    System.out.println(FileSystemClientA.compositeBuilder + name);
  }
}

class DirectoryA implements AbstractFile {
  private String name;
  private ArrayList<Object> includedFiles = new ArrayList<Object>();

  public DirectoryA(String name){
    this.name = name;
  }

  public void add(Object obj) {
    includedFiles.add(obj);
  }

  public void ls() {
    System.out.println(FileSystemClientA.compositeBuilder + name);
    FileSystemClientA.compositeBuilder.append("   ");

    for(Object includedFile: includedFiles) {
      AbstractFile abf = (AbstractFile) includedFile;
      abf.ls();
    }
    FileSystemClientA.compositeBuilder.setLength(FileSystemClientA.compositeBuilder.length() - 3);
  }
}

public class FileSystemClientA{
  public static StringBuilder compositeBuilder = new StringBuilder();

  public static void main(String[] args) {
    DirectoryA music = new DirectoryA("MUSIC");
    DirectoryA scorpions = new DirectoryA("SCORPIANS");
    DirectoryA dio = new DirectoryA("DIO");
    FileA track1 = new FileA("Don't wary, be happy.mp3");
    FileA track2 = new FileA("track2.m3u");
    FileA track3 = new FileA("Wind of change.mp3");
    FileA track4 = new FileA("Big city night.mp3");
    FileA track5 = new FileA("Rainbow in the dark.mp3");

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