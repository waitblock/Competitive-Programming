import string
import math
import itertools


def convert_arr_int(arr):
    new_arr = []
    for e in arr:
        new_arr.append(int(e))
    return new_arr


def main():
    n = int(input())
    p = convert_arr_int(input().split(" "))
    x = 0
    y = 0
    avg = 0
    out = 0
    while x < n:
        while y < n:
            for i in range(x,y+1):
                avg += p[i]
            avg = avg / (y-x+1)
            for i in range(x, y+1):
                if p[i] == avg:
                    out += 1
                    break
            avg = 0
            y += 1
        x += 1
        y = x
    print(out)



if __name__ == "__main__":
    main()
