import string
import math
import itertools

# sample input: 2 2 11 4 9 7 9

def convert_arr_int(arr):
    new_arr = []
    for e in arr:
        new_arr.append(int(e))
    return new_arr


def main():
    arr = convert_arr_int(input().split(" "))
    full = arr
    m = arr.pop(arr.index(max(arr)))
    p = itertools.permutations(arr, 3)
    valid = []
    for e in p:
        if sum(e) == m:
            valid.append(e)
    for s in valid:
        # print(s[0] <= s[1] and s[1] <= s[2])
        if s[0] <= s[1] and s[1] <= s[2]:
            print(f"{s[0]} {s[1]} {s[2]}")
            break

    # print(valid)



if __name__ == "__main__":
    main()
