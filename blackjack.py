import random

ace = 0
dace = 0

def getcard(ace, total):
    n = random.randint(1, 13)
    if n > 10:
        n = 10
    elif n == 1 and total <= 10:
        n = 11
        ace += 1 
    return n, ace

total = 0
dtotal = 0
card = 0

total, ace = getcard(ace, total)
card, ace = getcard(ace, total)
total += card

dtotal, ace = getcard(ace, dtotal)

print(f">Player card total >{total}< \n\n>Dealer card total >{dtotal}<\n")

op =  input(">Hit or pass?\n>")
while op != "hit" and op != "pass":
    op = input(">Invalid.\n>Hit or pass?\n>")
if op == "hit":
    card, ace = getcard(ace, total)




card, dace = getcard(ace, dtotal)

total += card