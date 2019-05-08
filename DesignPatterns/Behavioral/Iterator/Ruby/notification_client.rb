class Notification
  attr_reader :notification

  def initialize(notification)
    @notification = notification
  end
end

class Iterator
  attr_reader :pos

  def initialize
    @pos = 0
  end
end

class NotificationIterator < Iterator
  attr_reader :notification_arr

  def initialize(notification_arr)
    super()
    @notification_arr = notification_arr.clone
  end

  def next
    value = @notification_arr[@pos]
    @pos += 1
    value
  end

  def has_next?
    @pos >= @notification_arr.length || @notification_arr[@pos].nil? ? false : true
  end
end

class Collection
  attr_reader :items, :total_items

  @@max_items = 6

  def initialize
    @items = []
    @total_items = 0
  end
end

class NotificationCollection < Collection
  def add_item(item)
    if @total_items > @@max_items
      puts 'Full'
    else
      notification = Notification.new(item)
      @items << notification
      @total_items += 1
    end
  end

  def create_iterator
    NotificationIterator.new(@items)
  end
end

notification_collection = NotificationCollection.new
notification_collection.add_item("Notification-1")
notification_collection.add_item("Notification-2")
notification_collection.add_item("Notification-3")

notification_iterator = notification_collection.create_iterator
while notification_iterator.has_next? do
  puts notification_iterator.next.notification
end