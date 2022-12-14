# frozen_string_literal: true

# BEGIN
def anagramm_filter(word, words)
  anagram = word.chars.sort.join
  words.filter { |w| w.chars.sort.join == anagram }
end
# END
