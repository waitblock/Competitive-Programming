input()

nums = input().split(" ")

for i in range(len(nums)):
    count = 0
    for j in range(len(nums[i])):
        count += (j+1)*int(nums[i][j])
    print(count, end=" ")
