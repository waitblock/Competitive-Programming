data_len = int(input())
datas = []
for i in range(data_len):
    datas.append(input().split(" "))
sums = []
for data in datas:
    sums.append(int(data[0])+int(data[1]))
out = ""
for i in range(len(sums)):
    if i == len(sums) -1:
        out += str(sums[i])
    else:
        out += (str(sums[i])+" ")
print(out)
