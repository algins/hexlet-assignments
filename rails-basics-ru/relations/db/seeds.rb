# frozen_string_literal: true

Status.create([{ name: 'New' }, { name: 'In Progress' }, { name: 'Done' }])

5.times { |i| User.create(name: Faker::Name.unique.name) }