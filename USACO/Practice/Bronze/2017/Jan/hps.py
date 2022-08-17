with open("hps.in", "r") as input_file:
    input_data = input_file.read().split("\n")

store = []

for i in range(4):
    store.append([0]*4)

print(store)

n = int(input_data[0])

for i in range(n):
    line = input_data[1+i].split(" ")
    num1 = int(line[0])
    num2 = int(line[1])
    print(num1, num2)
    store[num1][num2] += 1

result = store[1][2] + store[3][1] + store[2][3];
if store[1][3] + store[3][2] + store[2][1] > result:
    result = store[2][1] + store[1][3] + store[3][2]

with open("hps.out", "w") as output_file:
    output_file.write(str(result))
