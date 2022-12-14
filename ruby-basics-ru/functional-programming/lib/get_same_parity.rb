# frozen_string_literal: true

# BEGIN
def get_same_parity(coll)
  first_item = coll.first
  coll.filter { |item| item.odd? == first_item.odd? }
end
# END
