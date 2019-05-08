import java.util.ArrayList;
import java.util.List;

enum ChannelType {
  ENGLISH, HINDI, TAMIL, ALL;
}

class Channel {
  private double freq;
  private ChannelType type;

  public Channel(double freq, ChannelType type) {
    this.freq = freq;
    this.type = type;
  }

  public double getFreq() {
    return this.freq;
  }

  public ChannelType getType() {
    return this.type;
  }

  public String toString() {
    return "Frequency = " + this.freq + ", Type = " + this.type;
  }
}

interface ChannelCollection {
  public void addChannel(Channel c);
  public void removeChannel(Channel c);
  public ChannelIterator createIterator(ChannelType type);
}

interface ChannelIterator {
  public boolean hasNext();
  public Channel next();
}

class ChannelCollectionImpl implements ChannelCollection {
  private List<Channel> channelList;

  public ChannelCollectionImpl(){
    channelList = new ArrayList<Channel>();
  }

  public void addChannel(Channel c) {
    this.channelList.add(c);
  }

  public void removeChannel(Channel c) {
    this.channelList.remove(c);
  }

  public ChannelIterator createIterator(ChannelType type) {
    return new ChannelIteratorImpl(type, this.channelList);
  }
  //The inner class implementation of iterator prevents the channel iterator to be used by any other collections
  private class ChannelIteratorImpl implements ChannelIterator {
    private ChannelType type;
    private List<Channel> channels;
    private int position;

    public ChannelIteratorImpl(ChannelType type, List<Channel> channelList) {
      this.type = type;
      this.channels = channelList;
    }

    public boolean hasNext() {
      while(position < channels.size()){
        Channel c = channels.get(position);
        if (c.getType().equals(type) || type.equals(ChannelType.ALL)) {
          return true;
        } else {
          position++;
        }
      }
      return false;
    }

    public Channel next() {
      Channel c = channels.get(position);
      position++;
      return c;
    }

  }
}

public class ChannelClient {
  public static void main(String[] args) {
    ChannelCollection cc = populateChannels();
    ChannelIterator ciAll = cc.createIterator(ChannelType.ALL);
    while(ciAll.hasNext()) {
      System.out.println(ciAll.next());
    }
    System.out.println("****************");
    ChannelIterator ciEng = cc.createIterator(ChannelType.ENGLISH);
    while(ciEng.hasNext()){
      System.out.println(ciEng.next());
    }
  }

  private static ChannelCollection populateChannels() {
    ChannelCollection cc = new ChannelCollectionImpl();
    cc.addChannel(new Channel(98.5, ChannelType.ENGLISH));
    cc.addChannel(new Channel(99.5, ChannelType.HINDI));
    cc.addChannel(new Channel(100.5, ChannelType.TAMIL));
    cc.addChannel(new Channel(101.5, ChannelType.ENGLISH));
    cc.addChannel(new Channel(102.5, ChannelType.HINDI));
    cc.addChannel(new Channel(103.5, ChannelType.TAMIL));
    cc.addChannel(new Channel(104.5, ChannelType.ENGLISH));
    cc.addChannel(new Channel(105.5, ChannelType.HINDI));
    cc.addChannel(new Channel(106.5, ChannelType.TAMIL));
    return cc;
  }
}