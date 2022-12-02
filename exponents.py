def exponent(b, e):
    ans = b
    for y in range(e):
        ans *= b
    ans/=b
    print(f"{b} to the power of {e} is {int(ans)}")
base_input = int(input("input base number = "))
exponent_input = int(input("input exponent number = "))
exponent(base_input, exponent_input)

