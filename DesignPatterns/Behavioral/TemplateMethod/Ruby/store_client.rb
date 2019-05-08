class OrderProcessTemplate
  def isGift
    raise NotImplementedError
  end

  def do_select
    raise NotImplementedError
  end

  def do_payment
    raise NotImplementedError
  end

  def gift_wrap
    puts "Giftwrap successfull"
  rescue
    puts "Giftwrap unsuccessfull"
  end

  def do_delivery
    raise NotImplementedError
  end

  def process_order(gift)
    do_select
    do_payment
    gift_wrap if gift
    do_delivery
  end
end

class NetOrder < OrderProcessTemplate
  def do_select
    puts "Item added to online shopping cart"
    puts "Get giftWrap preference"
    puts "Get delivery address"
  end

  def do_payment
    puts "Online payment through Netbanking, card or paytm"
  end

  def do_delivery
    puts "Ship the item through post to delivery address"
  end
end

class StoreOrder < OrderProcessTemplate
  def do_select
    puts 'Customer chooses the item from the shelf'
  end

  def do_payment
    puts 'Pays at counter through cash/POS'
  end

  def do_delivery
    puts 'Item deliverd to in delivery counter'
  end
end

net_order = NetOrder.new
net_order.process_order(true)
puts "********"
store_order = StoreOrder.new
store_order.process_order(false)