# frozen_string_literal: true

# BEGIN
def reverse(str)
  reversed_str = ''
  str.each_char do |c|
    reversed_str = "#{c}#{reversed_str}"
  end
  reversed_str
end
# END
