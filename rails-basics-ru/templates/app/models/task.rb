# frozen_string_literal: true

class Task < ApplicationRecord
    validates :name, presence: true
    validates :status, presence: true
    validates :creator, presence: true
  
    attribute :status, default: -> { 'now' }
    attribute :completed, default: -> { false }
  end