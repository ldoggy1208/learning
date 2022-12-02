def exponent(b, e):
    i = e
    ans = b
    for y in range(i):
        ans *= b
        i -= 1
        if i == 1:
            print(ans)
#base_input = int(input("input base number = "))
#exponent_input = int(input("input exponent number = "))
#exponent(base_input, exponent_input)

