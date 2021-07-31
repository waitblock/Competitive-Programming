"""
ID: xuethan1
LANG: PYTHON3
TASK: beads
"""

import string
import math
import itertools
from sys import maxsize


def convert_arr_int(arr):
    return list(map(int, arr))

def check_start(iterable) -> bool:
    pass
    # TODO: create a function which checks if the ends of the beads array are equal so the program doesn't overcount; this should solve the problem

def convert_str_arr(s):
    new_arr = []
    for i in range(len(s)):
        new_arr.append(s[i])
    if check_start(new_arr) is True:
        return new_arr
    else:
        return new_arr*2

# so pos is the start of the left side of the split and pos+1 is the start of the right side of the split
def find_max_left(arr, pos) -> int:
    if len(arr) == 0:
        return 0
    if pos == -1:
        return 0
    color = arr[pos]
    count = 0
    position = pos
    color_set = False
    if color != "w":
        color_set = True
    for i in range(position,-1,-1):
        #print(arr[i])
        if color == "w":
            color = arr[i]
        if arr[i] != color and arr[i] != "w":
            break
        count += 1

    return count

# literally just the reverse of find_max_left
def find_max_right(arr, pos) -> int:
    if len(arr) == 0:
        return 0
    if pos == len(arr)-1:
        return 0
    color = arr[pos+1]
    count = 0
    position = pos+1
    color_set = False
    if color != "w":
        color_set = True
    for i in range(position,len(arr)):
        #print(arr[i])
        if color == "w":
            color = arr[i]
        if arr[i] != color and arr[i] != "w":
            break
        count += 1

    return count

def solve(arr) -> int:
    max_beads = -maxsize
    for i in range(-1,len(arr)):
        bead_sum = find_max_left(arr, i) + find_max_right(arr, i)
        max_beads = max(max_beads, bead_sum)
    return max_beads

def main():
    with open("beads.in", "r") as input_file:
        data = input_file.read()

    tot_beads = int(data.split("\n")[0])
    beads_str = data.split("\n")[1]
    beads = convert_str_arr(beads_str)

    with open("beads.out", "w") as output_file:
        output_file.write(str(solve(beads)) + "\n")


if __name__ == "__main__":
    main()
