require "test_helper"

class TasksControllerTest < ActionDispatch::IntegrationTest
  test '#index' do
    get tasks_url
    assert_response :success
  end

  test '#show' do
    task = Task.create(get_task_params)
    get task_url task
    assert_response :success
  end

  test '#new' do
    get new_task_url
    assert_response :success
  end

  test '#create' do
    task_params = get_task_params
    post tasks_url, params: { task: task_params }
    assert { Task.find_by(task_params) }
    assert_response :redirect
  end

  test '#edit' do
    task = Task.create(get_task_params)
    get edit_task_url task
    assert_response :success
  end

  test '#update' do
    task = Task.create(get_task_params)
    task_params = get_task_params
    patch task_url(task), params: { task: task_params }
    assert { Task.find_by(task_params) }
    assert_response :redirect
  end

  test '#destroy' do
    task_params = get_task_params
    task = Task.create(task_params)
    delete task_url(task)
    assert { !Task.find_by(task_params) }
    assert_response :redirect
  end

  private 

  def get_task_params
    {
      name: Faker::Lorem.sentence,
      description: Faker::Lorem.paragraph,
      status: 'new',
      creator: Faker::Name.name,
      performer: Faker::Name.name,
      completed: false,
    }
  end
end
