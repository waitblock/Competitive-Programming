import string
import math
import itertools


def convert_string_arr(s):
    arr = []
    for i in range(len(s)):
        arr.append(s[i])
    return arr


def find_place(l, alpha):
    for i in range(len(alpha)):
        if alpha[i] == l:
            return i
    return -1


def main():

    alpha = input()

    input_string = input()

    last_index = 27
    calls = 0

    for i in range(len(input_string)):
        curr_index = find_place(input_string[i], alpha)
        if curr_index <= last_index:
            calls += 1
        last_index = curr_index

    print(calls)


if __name__ == "__main__":
    main()
