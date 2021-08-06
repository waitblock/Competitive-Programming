# Underweight     -           BMI < 18.5
# Normal weight   -   18.5 <= BMI < 25.0
# Overweight      -   25.0 <= BMI < 30.0
# Obesity         -   30.0 <= BMI

# BMI = weight / height^2

n = int(input())

def check_int(n):
    try:
        int(n)
        return True
    except ValueError:
        return False

def convert_arr(iterable):
    out = []
    for i in range(len(iterable)):
        if check_int(iterable[i]) is True:
            out.append(int(iterable[i]))
        else:
            out.append(float(iterable[i]))
    return out

lines = []

for i in range(n):
    lines.append(convert_arr(input().split(" ")))

for i in range(len(lines)):
    bmi = float(lines[i][0]/lines[i][1]**2)
    if bmi < 18.5:
        print("under", end=" ")
    if bmi >= 18.5 and bmi < 25.0:
        print("normal", end=" ")
    if bmi >= 25.0 and bmi < 30.0:
        print("over", end=" ")
    if bmi >= 30.0:
        print("obese", end=" ")
