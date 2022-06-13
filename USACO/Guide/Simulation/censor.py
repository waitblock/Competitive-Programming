# well in some cases python IS faster than java :O

with open("censor.in") as input_file:
    lines = input_file.read().split("\n")
    s = lines[0]
    t = lines[1]

result = ""

for i in range(len(s)):
    result += s[i]
    if len(result) > len(t):
        if result[len(result)-len(t):] == t:
            result = result[:len(result)-len(t)]
print(result)
with open("censor.out", "w") as output_file:
    output_file.write(result)