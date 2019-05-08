require 'etc'

class BankAccount
  attr_reader :balance

  def initialize(starting_balance = 0)
    @balance = starting_balance
  end

  def deposit(amount)
    @balance += amount
  end

  def withdraw(amount)
    @balance -= amount
  end

  def balance
    @balance
  end
end

class BankAccountProxy
  def initialize(real_object)
    @real_object = real_object
  end

  def deposit(amount)
    @real_object.deposit(amount)
  end

  def withdraw(amount)
    @real_object.withdraw(amount)
  end
end

class AccountProtectionProxy
  def initialize(real_object, owner_name)
    @subject = real_object
    @owner_name = owner_name
  end

  def deposit(amount)
    check_access
    @subject.deposit(amount)
  end

  def withdraw(amount)
    check_access
    @subject.withdraw(amount)
  end

  def balance
    check_access
    @subject.balance
  end

  def check_access
    if Etc.getlogin != @owner_name
      raise "Illegal access: #{Etc.getlogin} cannot access account."
    end
  end
end

class VirtualAccountProxy
  def initialize(&creation_block)
    @creation_block = creation_block
  end

  def deposit(amount)
    subject.deposit(amount)
  end

  def withdraw(amount)
    subject.deposit(amount)
  end

  def balance
    subject.balance
  end

  def subject
    @subject ||= @creation_block.call
  end
end

account = BankAccount.new(100)
account.deposit(50)
account.withdraw(40)
puts account.balance

protection_proxy = AccountProtectionProxy.new(BankAccount.new(100), "ravishankarg")
protection_proxy.deposit(40)
protection_proxy.withdraw(50)
puts protection_proxy.balance

virtual_proxy = VirtualAccountProxy.new{ BankAccount.new(100) }
virtual_proxy.deposit(40)
virtual_proxy.withdraw(50)
puts virtual_proxy.balance