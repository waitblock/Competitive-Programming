from string import ascii_lowercase

def addString(list):
    added = []
    toAdd = []
    for i in range(len(list)):
        if list[i] not in added:
            toAdd.append(list[i])
            added.append(list[i])

    return toAdd

def deleteNextTo(s):
    if len(s) == 1:
        return s
    if s[0] == s[1]:
        return deleteNextTo(s[1:])
    else:
        return s[0] + deleteNextTo(s[1:])

def rearrangedString(s):
    new = []
    s = s.lower()
    s_list = list(s)
    for i in range(len(s_list)):
        if s_list[i] not in ascii_lowercase:
            s_list[i] = ""

    while len(s_list) > 0:
        toAdd = sorted(addString(s_list))
        toAdd_s = ""
        for i in range(len(toAdd)):
            toAdd_s += toAdd[i]
        new.append(toAdd_s)
        for c in toAdd:
            s_list.remove(c)

    s = ""

    for c in new:
        s += c


    return deleteNextTo(s)




print(rearrangedString("A good sorting algorithm."))

"""
s_list = list(s)
    new = []
    rest = []
    # get rid of special characters
    for i in range(len(s_list)):
        s_list[i] = s_list[i].lower()
        if s_list[i] in non:
            s_list[i] = ""

    for c in s_list:
        rest.append(c)

    while len(rest) > 0:
        curr_str = ''
        for i in range(len(s_list)):
            curr_str = curr_str + s_list[i]
            if i != len(s_list) - 1:
                curr_str += ' '
        temp = sorted(curr_str.split())
        del s_list[:]
        for i in range(len(temp)):
            if temp[i] not in s_list:
                new.append(temp[i])
            elif temp[i] in s_list:
                s_list.append(temp[i])

    out = ""
    for i in range(len(new)):
        out += new[i]
    return out
"""