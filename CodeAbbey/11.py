n = int(input())

lines = []

for i in range(n):
    lines.append(input().split(" "))

for i in range(n):
    line = lines[i]
    # print(line[2])
    a = int(line[0])
    b = int(line[1])
    c = int(line[2])
    num = str(a*b+c)
    count = 0
    for j in range(len(num)):
        count += int(num[j])
    print(count, end=" ")
