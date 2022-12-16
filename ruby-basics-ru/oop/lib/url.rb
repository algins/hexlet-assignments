# frozen_string_literal: true

# BEGIN
class Url
  attr_reader :uri

  extend Forwardable
  include Comparable

  def_delegator :@uri, :scheme
  def_delegator :@uri, :host

  def ==(other)
    @uri == other.uri
  end

  def initialize(uri)
    @uri = URI(uri)
  end

  def query_params
    query = @uri.query ||= ''
    query.split('&').each_with_object({}) do |pair, acc|
      key, value = pair.split('=')
      acc[key.to_sym] = value
    end
  end

  def query_param(key, default = nil)
    query_params.fetch(key, default)
  end
end
# END
