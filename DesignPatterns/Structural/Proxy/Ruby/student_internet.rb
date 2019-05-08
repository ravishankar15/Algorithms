class Internet
  def connect_to(host)
    puts "Connecting #{host}"
  end
end

class ProxyInternet
  attr_reader :internet
  def initialize(internet)
    @internet = internet
  end
  
  def connect_to(host)
    check_site(host)
    @internet.connect_to(host)
  end

  def check_site(host)
    if %w[abc.com def.com ghi.com jkl.com].include?(host)
      raise "Access Denied"
    end
  end
end


internet = Internet.new
internet.connect_to('abc.com')

proxy_internet = ProxyInternet.new(internet)
proxy_internet.connect_to('xyz.com')
proxy_internet.connect_to('abc.com')
