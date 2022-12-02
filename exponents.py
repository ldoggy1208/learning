def exponent(b, e):
    ans = 1
    for y in range(e):
        ans *= b
    return ans
base_input = int(input("input base number = "))
exponent_input = int(input("input exponent number = "))
print(f"{base_input} to the power of {exponent_input} is {exponent(base_input, exponent_input)}")