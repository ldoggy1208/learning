def exponent(b, e):
    i = e
    ans = b
    while i > 1:
        ans *= b
        i -= 1
        if i == 1:
            print(ans)
#base_input = int(input("input base number = "))
#exponent_input = int(input("input exponent number = "))
#exponent(base_input, exponent_input)

