# frozen_string_literal: true

require 'test_helper'

class TasksControllerTest < ActionDispatch::IntegrationTest
  setup do
    @task = tasks(:one)
    @user = User.create(name: Faker::Name.unique.name)
    @status = Status.create(name: 'New')

    @attrs = {
      name: Faker::Lorem.word,
      description: Faker::Lorem.sentence,
      user_id: @user.id,
      status_id: @status.id
    }
  end

  test 'should get index' do
    get tasks_url
    assert_response :success
  end

  test 'should get new' do
    get new_task_url
    assert_response :success
  end

  test 'should create task' do
    post tasks_url, params: { task: @attrs }

    task = Task.find_by @attrs

    assert { task }
    assert_redirected_to task_url(task)
  end

  test 'should show task' do
    get task_url(@task)
    assert_response :success
  end

  test 'should get edit' do
    get edit_task_url(@task)
    assert_response :success
  end

  test 'should update task' do
    patch task_url(@task), params: { task: @attrs }

    @task.reload

    assert { @task.name == @attrs[:name] }
    assert { @task.description == @attrs[:description] }
    assert { @task.user_id == @attrs[:user_id] }
    assert { @task.status_id == @attrs[:status_id] }
    assert_redirected_to task_url(@task)
  end

  test 'should destroy task' do
    delete task_url(@task)

    assert { !Task.exists? @task.id }

    assert_redirected_to tasks_url
  end
end
