n = int(input())

inputs = []

for i in range(n):
    inputs.append(input().split(" "))

out = []

for i in range(len(inputs)):
    sum = 0
    a = int(inputs[i][0])
    b = int(inputs[i][1])
    n = int(inputs[i][2])
    for j in range(n):
        sum += (a+(b*j))
    out.append(sum)

for i in range(len(out)):
    print(out[i], end=" ")
