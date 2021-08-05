import math

def round_int(n):
    if n >= math.floor(n) + 0.5:
        return math.ceil(n)
    return math.floor(n)

temps = list(map(int, input().split(" ")))

for i in range(1,len(temps)):
    print(round_int((temps[i]-32)*(5/9)), end=" ")
