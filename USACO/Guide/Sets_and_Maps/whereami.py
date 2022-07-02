with open("whereami.in") as file:
    raw = file.read().split("\n")
    n = int(raw[0])
    mailboxes = raw[1]
result = 0
for i in range(1,n+1):
    seqs = []
    unique = True
    for j in range(n-i+1):
        current = mailboxes[j:j+i]
        if current in seqs:
            unique = False
            break
        seqs.append(current)
    if unique:
        result = i
        break
print(result)
with open("whereami.out", "w") as out:
    out.write(str(result))
