# frozen_string_literal: true

def make_censored(text, stop_words)
  # BEGIN
  placeholder = '$#%!'
  text
    .split
    .map { |word| stop_words.include?(word) ? placeholder : word }
    .join(' ')
  # END
end
