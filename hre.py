def sum_of_first_100_numbers():
  """Returns the sum of the first 100 numbers."""
  sum_100 = 0
  for i in range(1, 101):
    sum_100 += i
  return sum_100

print(sum_of_first_100_numbers())