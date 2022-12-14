# frozen_string_literal: true

# BEGIN
def count_by_years(users)
  users
    .filter { |user| user[:gender] == 'male' }
    .map { |user| user[:birthday][0, 4] }
    .each_with_object({}) { |year, acc| acc[year] = acc.fetch(year, 0) + 1 }
end
# END
