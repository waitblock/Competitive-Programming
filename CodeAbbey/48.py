input()
nums = input().split(" ")

for i in range(len(nums)):
    nums[i] = int(nums[i])

# print(nums)

arr = []

for n in nums:
    count = 0
    while n != 1:
        count += 1
        if n % 2 == 0:
            n/=2
        elif n % 2 == 1:
            n = n*3+1
    arr.append(count)

# print(arr)

out = str(arr[0])

for i in range(1,len(arr)):
    out += f" {arr[i]}"

print(out)
