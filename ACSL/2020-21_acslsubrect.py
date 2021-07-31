import sys


def convert_str_int(arr):
    new_arr = []
    for e in arr:
        new_arr.append(int(e))
    return new_arr


def find_max_sum_of_subrect(values):
    values = values.split(" ")
    matrix = []
    r = int(values.pop(0))
    c = int(values.pop(0))
    values = convert_str_int(values)
    for i in range(r):
        to_add = []
        for j in range(c):
            to_add.append(values[j+c*i])
        matrix.append(to_add)
    for i in range(r):
        for j in range(c):
            if i > 0:
                matrix[i][j] += matrix[i - 1][j]
            if j > 0:
                matrix[i][j] += matrix[i][j - 1]
            if i > 0 and j > 0:
                matrix[i][j] -= matrix[i - 1][j - 1]
    max_sum = -sys.maxsize
    for i in range(r):
        for j in range(c):
            for k in range(i, r):
                for l in range(j, c):
                    s = matrix[k][l]
                    if i > 0:
                        s -= matrix[i - 1][l]
                    if j > 0:
                        s -= matrix[k][j - 1]
                    if i > 0 and j > 0:
                        s += matrix[i - 1][j - 1]
                    max_sum = max(max_sum, s)
    return max_sum

val = input()
print(find_max_sum_of_subrect(val))
