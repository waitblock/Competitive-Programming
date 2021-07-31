def sumOfLargest(a1, a2, a3):
    a1_ints = []
    for e in a1.split(" "):
        try:
            a1_ints.append(int(e))
        except:
            pass
    a2_ints = []
    for e in a2.split(" "):
        try:
            a2_ints.append(int(e))
        except:
            pass
    a3_ints = []
    for e in a3.split(" "):
        try:
            a3_ints.append(int(e))
        except:
            pass
    big_array = []

    total = 0

    for i in range(max(len(a1_ints),len(a2_ints),len(a3_ints))):
        array_to_add = []
        try:
            array_to_add.append(a1_ints[i])
        except IndexError:
            pass
        try:
            array_to_add.append(a2_ints[i])
        except IndexError:
            pass
        try:
            array_to_add.append(a3_ints[i])
        except IndexError:
            pass
        big_array.append(array_to_add)

    for e in big_array:
        total += max(e)

    return total


print(sumOfLargest("6 8 1 5 2 3 5 3 7 9", "7 6 2 9", "9 3 4 6 1 8 6 4 2 8 4"))