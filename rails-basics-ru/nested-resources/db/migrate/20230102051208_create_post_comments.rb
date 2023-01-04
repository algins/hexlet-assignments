class CreatePostComments < ActiveRecord::Migration[7.0]
  def change
    create_table :post_comments do |t|
      t.string :content, null: false
      t.timestamps
    end
  end
end
