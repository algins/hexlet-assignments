# frozen_string_literal: true

class User < ApplicationRecord
  # BEGIN
  validates :name, presence: true

  has_many :tasks, dependent: :destroy
  # END
end
