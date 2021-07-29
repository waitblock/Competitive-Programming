"""
ID: xuethan1
LANG: PYTHON3
TASK: ride
"""

import string
import math
import itertools


def convert_arr_int(arr):
    new_arr = []
    for e in arr:
        new_arr.append(int(e))
    return new_arr


def find_letter(l) -> int:
    alpha = list(string.ascii_uppercase)
    for i in range(26):
        if alpha[i] == l:
            return i+1
    return -1


def main():
    with open("ride.in", "r") as input_file:
        input_data = input_file.read()
    line1 = input_data.split("\n")[0]
    line2 = input_data.split("\n")[1]

    line1_total = 1
    line2_total = 1

    for i in range(len(line1)):
        print(find_letter(line1[i]))
        line1_total *= find_letter(line1[i])
    for i in range(len(line2)):
        print(find_letter(line2[i]))
        line2_total *= find_letter(line2[i])

    print(line1_total)
    print(line2_total)

    output_file = open("ride.out", "w")
    if line1_total % 27 == line2_total % 27:
        output_file.write("GO")
    else:
        output_file.write("STAY")
    output_file.close()


if __name__ == "__main__":
    main()
