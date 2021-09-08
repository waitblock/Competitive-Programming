# FizzBuzz problem cheese generator
# Uses the approach I used to generate my cheese
from math import gcd

fizz = int(input()) # this is the new 3
buzz = int(input()) # this is the new 5

period = fizz * buzz // gcd(fizz, buzz)
coprime = sum([1 for i in range(period) if gcd(i, period) == 1])

values = [i for i in range(-1, period - 1) if gcd(i, period) == 1]
lookup = [(period * i) - (coprime * values[i]) for i in range(coprime)] # WHY do I like listcomp so much

print(f"l = {repr(lookup)}\ni = int(open(\"moobuzz.in\").read())\nj = ({period}*i - l[i % {coprime}]) // {coprime}\nopen(\"moobuzz.out\", \"w\").write(str(j))")
