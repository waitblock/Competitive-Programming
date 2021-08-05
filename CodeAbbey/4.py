n = int(input())
inputs = []
for i in range(n):
    inputs.append(input().split(" "))

mins = []

for i in range(len(inputs)):
    mins.append(min(int(inputs[i][0]), int(inputs[i][1])))

for i in range(len(mins)):
    print(str(mins[i]),end=" ")
