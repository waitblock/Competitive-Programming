import string
import math
import itertools
from sys import maxsize


def convert_arr_int(arr):
    return list(map(int, arr))


def main():
    with open("speeding.in", "r") as input_file:
        input_data = input_file.read().split("\n")

    n = int(input_data[0].split(" ")[0])
    m = int(input_data[0].split(" ")[1])

    speed_limits = []
    bessie_speeds = []

    for i in range(n):
        distance = int(input_data[1+i].split(" ")[0])
        speed_limit = int(input_data[1+i].split(" ")[1])
        for j in range(distance):
            speed_limits.append(speed_limit)

    for i in range(m):
        distance = int(input_data[1+n+i].split(" ")[0])
        bessie_speed = int(input_data[1+n+i].split(" ")[1])
        for j in range(distance):
            bessie_speeds.append(bessie_speed)

    max_over_limit = 0

    for i in range(100):
        max_over_limit = max(max_over_limit, bessie_speeds[i]-speed_limits[i])

    output_file = open("speeding.out", "w")
    output_file.write(str(max_over_limit))
    output_file.close()


if __name__ == "__main__":
    main()
