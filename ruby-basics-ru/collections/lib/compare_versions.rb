# frozen_string_literal: true

# BEGIN
def compare_versions(vers1, vers2)
  vers1_major, vers1_minor = vers1.split('.')
  vers2_major, vers2_minor = vers2.split('.')
  major_comparison_result = vers1_major.to_i <=> vers2_major.to_i
  minor_comparison_result = vers1_minor.to_i <=> vers2_minor.to_i
  major_comparison_result.zero? ? minor_comparison_result : major_comparison_result
end
# END
