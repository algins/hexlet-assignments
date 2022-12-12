# frozen_string_literal: true

# BEGIN
def fibonacci(num)
    first = 0
    second = 1
    return first if num == 0
    return second if num == 1
    result = nil
    (num - 1).times do
        result = first + second
        first = second
        second = result
    end
    result 
end
# END
