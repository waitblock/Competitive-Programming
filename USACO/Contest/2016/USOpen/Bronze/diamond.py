import string
import math
import itertools
from sys import maxsize


def convert_arr_int(arr):
    return list(map(int, arr))


def main():
    with open("diamond.in", "r") as input_file:
        input_data = input_file.read().split("\n")
    n = int(input_data[0].split(" ")[0])
    k = int(input_data[0].split(" ")[1])

    diamonds = []

    for i in range(n):
        diamonds.append(int(input_data[1+i]))

    max_diamonds = -maxsize

    for i in range(n):
        count = 0
        for j in range(n):
            if diamonds[j] >= diamonds[i] and abs(diamonds[j] - diamonds[i]) <= k:
                count += 1
        max_diamonds = max(max_diamonds, count)

    print("Result:", str(max_diamonds))

    output_file = open("diamond.out", "w")
    output_file.write(str(max_diamonds))
    output_file.close()


if __name__ == "__main__":
    main()
