import math

def round_int(n):
    if n >= math.floor(n) + 0.5:
        return math.ceil(n)
    return math.floor(n)

n = int(input())

inputs = []

for i in range(n):
    inputs.append(input().split(" "))

divs = []

for i in range(len(inputs)):
    divs.append(round_int(float(int(inputs[i][0])/int(inputs[i][1]))))

for i in range(len(divs)):
    print(divs[i], end=" ")
