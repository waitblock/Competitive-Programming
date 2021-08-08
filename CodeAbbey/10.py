import math

def round_int(n):
    if n >= math.floor(n) + 0.5:
        return math.ceil(n)
    return math.floor(n)

def convert_string_int_arr(iterable):
    return list(map(int, iterable))

def solve(x1, y1, x2, y2):
    coef = (y2-y1)/(x2-x1)
    intercept = y1-x1*coef
    return [coef, intercept]

n = int(input())

lines = []

for i in range(n):
    lines.append(convert_string_int_arr(input().split(" ")))

for i in range(len(lines)):
    line = lines[i]
    arr = solve(line[0], line[1], line[2], line[3])
    print(f"({int(arr[0])} {int(arr[1])})", end=" ")
