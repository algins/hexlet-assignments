# frozen_string_literal: true

# BEGIN
def fizz_buzz(start, stop)
  result = []
  (start..stop).each do |num|
    result <<
      if (num % 3).zero? && (num % 5).zero?
        'FizzBuzz'
      elsif (num % 3).zero?
        'Fizz'
      elsif (num % 5).zero?
        'Buzz'
      else
        num
      end
  end
  result.join ' ' unless result.empty?
end
# END
