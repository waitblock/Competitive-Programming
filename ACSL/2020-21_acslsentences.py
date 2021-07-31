# Works for 11/13 testcases. Testcase 11 and 12 don't work.

#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'generateSentences' function below.
#
# The function is expected to return a STRING.
# The function accepts following parameters:
#  1. STRING_ARRAY dictionary
#  2. STRING sentences
#

pos = []
words = []
words_counter = []
sentences = None


def convert_str_arr(s):
    arr = []
    for e in s:
        arr.append(e)
    return arr


def getNextWord(posi, inc):
    print(words_counter[pos.index(posi)])
    if words_counter[pos.index(posi)] == len(words[pos.index(posi)]):
        words_counter[pos.index(posi)] = 0
    next_word = words[pos.index(posi)][words_counter[pos.index(posi)]]
    if inc == True:
        words_counter[pos.index(posi)] += 1
    return next_word


def generateSentences(dictionary, sentences):
    output = ""
    sentences = sentences.split(" ")
    for i in range(len(dictionary)):
        term = dictionary[i].split(" ")
        pos.append(term[0])
        words.append(term[1:len(term)])
    for i in range(len(words)):
        words_counter.append(0)
    print(pos)
    print(words)
    print(sentences)
    for i in range(len(sentences)):
        sentence_type = sentences[i][0]
        sentence_words = convert_str_arr(sentences[i][1:len(sentences[i])])
        print(sentence_words)
        if sentence_type == "Q":
            output += "What "
        for j in range(len(sentence_words)):
            print(output)
            next_word = sentence_words[j]
            if next_word == "T":
                if j == 0 and sentence_type != "Q":
                    output += "The "
                    continue
                output += "the "
                continue
            if next_word == "A":
                nw = getNextWord(sentence_words[j + 1], False)
                toAdd = ""
                if nw[0] in ["a", "e", "i", "o", "u"]:
                    toAdd = "an "
                else:
                    toAdd = "a "
                if j == 0 and sentence_type != "Q":
                    toAdd = toAdd.capitalize()
                output += toAdd
                continue
            if j == len(sentence_words) - 1:
                output += getNextWord(next_word, True)
                if sentence_type == "D" or sentence_type == "I":
                    output += ". "
                if sentence_type == "Q":
                    output += "? "
                if sentence_type == "E":
                    output += "! "

            else:
                if j == 0 and sentence_type != "Q":
                    output += (getNextWord(next_word, True).capitalize() + " ")
                    continue
                output += (getNextWord(next_word, True) + " ")
    return output


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    dictionary_count = int(input().strip())

    dictionary = []

    for _ in range(dictionary_count):
        dictionary_item = input()
        dictionary.append(dictionary_item)

    sentences = input()

    result = generateSentences(dictionary, sentences)

    fptr.write(result + '\n')

    fptr.close()
