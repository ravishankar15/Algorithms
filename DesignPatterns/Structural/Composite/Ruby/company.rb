class Employee
  attr_reader :children
  attr_accessor :parent

  def initialize
    @children = []
  end

  def add_employee(employee)
    @children.push(employee)
    employee.parent = self
  end

  def show_employee
    raise NotImplementedError
  end
end

class Manager < Employee
  attr_accessor :emp_id, :name, :position

  def initialize(emp_id, name, position)
    super()
    @emp_id = emp_id
    @name = name
    @position = position
  end

  def show_employee
    puts "#{self.emp_id} - #{self.name} - #{self.position}"
  end
end

class Developer < Employee

  attr_accessor :emp_id, :name, :position

  def initialize(emp_id, name, position)
    super()
    @emp_id = emp_id
    @name = name
    @position = position
  end

  def show_employee
    puts "#{self.emp_id} - #{self.name} - #{self.position}"
  end
end

class CompanyDirectory < Employee
  attr_accessor :name

  def initialize(name)
    super()
    @name = name
  end

  def show_employee
    puts "#{self.name}: "
    @children.each do |child|
      child.show_employee
    end
  end
end

d1 = Developer.new(100, "Ravi", "Frontend developer")
d2 = Developer.new(101, "Hari", "Backend developer")
eng_cd  = CompanyDirectory.new("Engineering")
eng_cd.add_employee(d1)
eng_cd.add_employee(d2)

mg1 = Manager.new(200, "Deepak", "Manager")
mg2 = Manager.new(201, "Mani", "Senior Manager")
acc_cd = CompanyDirectory.new("Account")
acc_cd.add_employee(mg1)
acc_cd.add_employee(mg2)

cd = CompanyDirectory.new("CompanyDirectory")
cd.add_employee(eng_cd)
cd.add_employee(acc_cd)
cd.show_employee
