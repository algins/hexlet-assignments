# frozen_string_literal: true

class ExecutionTimer
  def initialize(app)
    @app = app
  end

  def call(env)
    # BEGIN
    start_time = Time.now
    status, headers, body = @app.call(env)
    end_time = Time.now
    execution_time = start_time.to_f - end_time.to_f
    puts "Execution time: #{execution_time}"
    [status, headers, body]
    # END
  end
end
