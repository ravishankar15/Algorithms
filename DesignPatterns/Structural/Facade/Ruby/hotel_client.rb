class Menu
  def food_items
    raise NotImplementedError
  end
end

class VegMenu < Menu
  def food_items
    'This is a VegMenu'
  end
end

class NonVegMenu < Menu
  def food_items
    'This is a NonVegMenu'
  end
end

class VegNonVegMenu < Menu
  def food_items
    'This is a VegNonVegMenu'
  end
end

class Restaurant
  def fetch_menu
    raise NotImplementedError
  end
end

class VegRestaurant < Restaurant
  def fetch_menu
    VegMenu.new
  end
end

class NonVegRestaurant < Restaurant
  def fetch_menu
    NonVegMenu.new
  end
end

class VegNonVegRestaurant < Restaurant
  def fetch_menu
    VegNonVegMenu.new
  end
end


class HotelKeeper
  def fetch_veg_menu
    VegRestaurant.new.fetch_menu
  end

  def fetch_nonveg_menu
    NonVegRestaurant.new.fetch_menu
  end

  def fetch_vegnonveg_menu
    VegNonVegRestaurant.new.fetch_menu
  end
end


hk = HotelKeeper.new
puts hk.fetch_veg_menu.food_items
puts hk.fetch_nonveg_menu.food_items
puts hk.fetch_vegnonveg_menu.food_items