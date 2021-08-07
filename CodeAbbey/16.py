from statistics import mean
import math

def round_int(n):
    if n >= math.floor(n) + 0.5:
        return math.ceil(n)
    return math.floor(n)

def convert_string_int_arr(iterable):
    return list(map(int, iterable))

n = int(input())

lines = []

for i in range(n):
    lines.append(convert_string_int_arr(input().split(" ")))

for i in range(len(lines)):
    print(round_int(mean(lines[i][0:len(lines[i])-1])), end=" ")
