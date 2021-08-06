from statistics import median

def convert_string_int_arr(iterable):
    return list(map(int, iterable))

n = int(input())

lines = []

for i in range(n):
    lines.append(convert_string_int_arr(input().split(" ")))

for i in range(len(lines)):
    print(median(lines[i]), end=" ")
