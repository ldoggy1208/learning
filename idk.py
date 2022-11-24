n = int(input("give a number\n>"))

def rangeinput(n):
    if n >= 1 and n <= 5:
        print("that number is between 1 and 5")
    else:
        print("that number is not between 1 and 5")

rangeinput(n)