[1,nil, 3,4,nil,5,2].sort{ |a,b| a && b ? a <=> b : a ? -1 : 1 }

def check(a, b)
  return 0 if a == b || a.nil? || b.nil?

  return 1 if a > b

  return -1 if a < b
end