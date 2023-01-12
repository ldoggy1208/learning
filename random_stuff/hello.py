print("addition, subtraction, multiplication, or division")
operation = input()
print("put two numbers in order")
a = int(input())
b = int(input())
if operation == "addition":
    print(f"{a} + {b} = {a + b}")
elif operation == "subtraction":
    print(f"{a} - {b} = {a - b}")
elif operation == "multiplication":
    print(f"{a} x {b} = {a * b}")
elif operation == "division":
    print(f"{a} / {b} = {a / b}")
else:
    print("invalid entry")
    



