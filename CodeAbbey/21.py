def convert_string_int_arr(iterable):
    return list(map(int, iterable))

line1 = input().split(" ")

n = int(line1[0])
m = int(line1[1])

counter = [0] * m

nums = convert_string_int_arr(input().split(" "))

for i in range(n):
    counter[nums[i] - 1] += 1

for i in range(len(counter)):
    print(counter[i], end=" ")
