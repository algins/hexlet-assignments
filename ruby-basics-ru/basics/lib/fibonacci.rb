# frozen_string_literal: true

# BEGIN
def fibonacci(num)
  return 0 if num.zero?
  return 1 if num == 1

  result = nil
  first = 0
  second = 1
  (num - 1).times do
    result = first + second
    first = second
    second = result
  end
  result
end
# END
