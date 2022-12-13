# frozen_string_literal: true

# BEGIN
def build_query_string(params)
  params
    .sort
    .reduce([]) { |acc, (key, value)| acc << "#{key}=#{value}" }
    .join('&')
end
# END
