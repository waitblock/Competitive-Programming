def triangle_built(a,b,c) -> bool:
    if a+b > c and b+c > a and a+c > b:
        return True
    return False

n = int(input())

triangles = []

for i in range(n):
    triangles.append(input().split(" "))

for i in range(len(triangles)):
    a = int(triangles[i][0])
    b = int(triangles[i][1])
    c = int(triangles[i][2])
    if triangle_built(a,b,c) is True:
        print("1",end="")
    else:
        print("0",end="")
    if i != len(triangles)-1:
        print(" ",end="")
