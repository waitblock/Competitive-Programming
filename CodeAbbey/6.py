# Python's rounding module is annoying :/
# Take a look at the difference: https://ibb.co/0fHfyzX
# The main problem is that Python says that if there is a tie,
# then you round to the nearest even integer, which is problematic because
# if you have a number such as 8.5, then Python would round to 8.
# However, if you've taken math class, you probably know that 9 would be
# the correct number to round to. Anyway, that's my rant about Python's
# built-in rounding module.
# (Technically it's not their fault anyway because it is the standard method of rounding.
# See this link for more info: https://en.wikipedia.org/wiki/IEEE_754#Rounding_rules)

n = int(input())

inputs = []

for i in range(n):
    inputs.append(input().split(" "))

divs = []

for i in range(len(inputs)):
    divs.append(round(float(int(inputs[i][0])/int(inputs[i][1]))))

for i in range(len(divs)):
    print(divs[i], end=" ")
