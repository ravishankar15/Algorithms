class Item
  attr_reader :upc_code, :price

  def initialize(upc_code, price)
    @upc_code = upc_code
    @price = price
  end
end

class ShoppingCart
  def initialize
    @cart_items = []
  end

  def add_item(item)
    @cart_items << item
  end

  def remove_item(item)
    @cart_items.delete_if { |it| it == item }
  end

  def calculate_total
    total = 0
    @cart_items.each do |item|
      total += item.price
    end
    total
  end

  def pay(stratergy)
    amount = calculate_total
    stratergy.pay(amount)
  end
end

class Stratergy
  def pay(amount)
    raise NotImplementedError
  end
end

class CreditCardStratergy < Stratergy
  attr_reader :name, :card_number, :cvv, :date_of_expiry

  def initialize(name, card_number, cvv, date_of_expiry)
    @name = name
    @card_number = card_number
    @cvv = cvv
    @date_of_expiry = date_of_expiry
  end

  def pay(amount)
    puts "#{amount} paid with credit/debit card of name - #{@name}"
  end
end

class PaytmStratergy < Stratergy
  attr_reader :email, :password

  def initialize(email, password)
    @email = email
    @password = password
  end

  def pay(amount)
    puts "#{amount} paid with paytm of email - #{@email}"
  end
end

shopping_cart = ShoppingCart.new
item1 = Item.new("1234", 10)
item2 = Item.new("5678", 40)

shopping_cart.add_item(item1)
shopping_cart.add_item(item2)

shopping_cart.pay(PaytmStratergy.new("ravi@gmail.com", "pass1234"))
shopping_cart.pay(CreditCardStratergy.new("Ravi", "123456781234","786", "12/15"))
