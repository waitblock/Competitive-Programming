n = int(input())

lines = []

for i in range(n):
    lines.append(input())

for i in range(n):
    count = 0
    for j in range(len(lines[i])):
        if lines[i][j] in ['a','e','i','o','u', 'y']:
            count += 1
    print(count, end=" ")
