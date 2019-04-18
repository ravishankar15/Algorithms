import java.util.ArrayList; 
import java.util.List;

interface Internet {
  public void connectTo(String serverHost) throws Exception;
}

class RealInternet implements Internet {

  public void connectTo(String serverHost) {
    System.out.println("Connecting to " + serverHost);
  }
}

class ProxyInternet implements Internet {

  private Internet internet = new RealInternet();
  private static List<String> bannedSites;

  static {
    bannedSites = new ArrayList<String>();
    bannedSites.add("abc.com");
    bannedSites.add("def.com");
    bannedSites.add("ghi.com");
    bannedSites.add("jkl.com");
  }

  public void connectTo(String serverHost) throws Exception {
    if(bannedSites.contains(serverHost.toLowerCase())){
      throw new Exception("Access Denied");
    }
    internet.connectTo(serverHost);
  }
}

public class StudentInternet{
  public static void main(String[] args) {
    Internet internet = new ProxyInternet();
    try {
      internet.connectTo("gotIt.com");
      internet.connectTo("abc.com");
    } catch(Exception e){
      System.out.println(e.getMessage());
    }
  }
}