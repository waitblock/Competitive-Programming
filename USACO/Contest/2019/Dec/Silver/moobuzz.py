# Credit: EZLiang (Github)

l=[8,7,14,13,4,11,2,1]
i=int(open("moobuzz.in").read())
j=(15*i-l[i%8])//8
open("moobuzz.out","w").write(str(j))
