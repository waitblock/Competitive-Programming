"""
ID: xuethan1
LANG: PYTHON3
TASK: friday
"""

# Thirty days has September, April, June, and November, all the rest have 31 except for February which has 28 except in leap years when it has 29.


import string
import math
import itertools

month_days = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
count = [0,0,0,0,0,0,0]

def convert_arr_int(arr):
    new_arr = []
    for e in arr:
        new_arr.append(int(e))
    return new_arr


def is_leap(year):
    if year % 400 == 0:
        return True
    if year % 100 == 0:
        return False
    return year % 4 == 0


def convert_day(year, month, day):
    days = day-1+2
    for i in range(1900, year):
        days += 365 + int(is_leap(i))
    for j in range(1, month):
        if j == 2:
            days += 28 + int(is_leap(year))
        else:
            days += month_days[j]
    return days % 7


def main():
    with open("friday.in", "r") as input_file:
        input_data = input_file.read()
    n = int(input_data.split("\n")[0])

    for i in range(1900, 1900+n):
        for j in range(1, 13):
            # print(convert_day(i, j, 13))
            count[convert_day(i, j, 13)] += 1
    # print(count)


    output_file = open("friday.out", "w")
    s = ""
    for i in range(len(count)):
        if i == len(count)-1:
            s += str(count[i]) + "\n"
        else:
            s += str(count[i]) + " "
    output_file.write(s)
    output_file.close()


if __name__ == "__main__":
    main()
