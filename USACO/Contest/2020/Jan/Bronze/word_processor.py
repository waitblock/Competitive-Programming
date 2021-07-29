import string
import math
import itertools


def convert_arr_int(arr):
    new_arr = []
    for e in arr:
        new_arr.append(int(e))
    return new_arr


def main():
    with open("word.in", "r") as words_file:
        words_input = words_file.read().split("\n")
    words_info = words_input[0].split(" ")
    # n: total number of words
    n = int(words_info[0])
    # k: the greatest number of words on a line
    k = int(words_info[1])
    words = words_input[1].split(" ")
    current_line = ""
    lines = ""
    for word in words:
        if len((current_line + word).replace(" ", "")) > k:
            lines +=(current_line[0:len(current_line)-1]+"\n")
            current_line = ""
        current_line += (word+" ")
    lines += current_line[0:len(current_line)-1]
    output_file = open("word.out", "w")
    output_file.write(lines)
    output_file.close()


if __name__ == "__main__":
    main()
