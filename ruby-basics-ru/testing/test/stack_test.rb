# frozen_string_literal: true

require_relative 'test_helper'
require_relative '../lib/stack'

class StackTest < Minitest::Test
  # BEGIN
  def setup
    @stack = Stack.new([1, 2])
  end

  def test_pop!
    assert { @stack.pop! == 2 }
    assert { @stack.pop! == 1 }
    assert { @stack.pop!.nil? }
  end

  def test_push!
    assert { @stack.push!(3) == [1, 2, 3] }
  end

  def test_empty?
    assert { @stack.empty? == false }
    assert { Stack.new.empty? == true }
  end

  def test_to_a
    assert { @stack.to_a == [1, 2] }
    assert { Stack.new.to_a == [] }
  end

  def test_clear!
    assert { @stack.clear! == [] }
  end

  def test_size
    assert { @stack.size == 2 }
  end
  # END
end

test_methods = StackTest.new({}).methods.select { |method| method.start_with? 'test_' }
raise 'StackTest has not tests!' if test_methods.empty?
