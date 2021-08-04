import string
import math
import itertools
from sys import maxsize


def convert_arr_int(arr):
    return list(map(int, arr))


def main():
    with open("paint.in", "r") as input_file:
        input_data = input_file.read().split("\n")

    a = int(input_data[0].split(" ")[0]) # range 1 start
    b = int(input_data[0].split(" ")[1]) # range 1 end
    c = int(input_data[1].split(" ")[0]) # range 2 start
    d = int(input_data[1].split(" ")[1]) # range 2 end

    fence = [False]*101

    for i in range(a, b):
        fence[i] = True

    for i in range(c, d):
        fence[i] = True

    print(fence[0:20])

    count = 0

    for i in range(101):
        if fence[i] == True:
            count += 1

    output_file = open("paint.out", "w")
    output_file.write(str(count))
    output_file.close()


if __name__ == "__main__":
    main()
