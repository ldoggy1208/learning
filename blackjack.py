import random

ace = 0
dace = 0
play = True

def getcard(ace, total):
    n = random.randint(1, 13)
    if n >= 2 and n <= 10:
        face = n
    elif n == 1:
        face = "ace"
    elif n == 11:
        face = "jack"
    elif n == 12:
        face = "queen"
    else:
        face = "king"

    suit_value = random.randint(0, 3)
    suit = ["hearts", "diamonds", "clubs", "spades"][suit_value]

    if n > 10:
        n = 10
    elif n == 1 and total <= 10:
        n = 11
        ace += 1 

    return n, ace, face, suit

while play:
    total = 0
    dtotal = 0
    card = 0
    fvalue = 0
    total, ace, face, suit = getcard(ace, total)
    print(f"\n>You flipped the {face} of {suit}" )
    card, ace, face, suit = getcard(ace, total)
    print(f"\n>You flipped the {face} of {suit}" )
    total += card

    dtotal, dace, face, suit = getcard(dace, dtotal)
    print(f"\n>The dealer flipped the {face} of {suit}")
    while total < 21 and dtotal < 21 and fvalue != "win":
        print(f">Player card total >{total}< \n\n>Dealer card total >{dtotal}<\n")

        op =  input(">Hit or pass?\n>")
        options = ["hit", "pass"]
        while op not in options:
            op = input(">Invalid.\n>Hit or pass?\n>")
        
        if op == "pass" and dtotal < total: 
            while op == "pass":
                dcard, dace, face, suit, = getcard(ace, dtotal)
                print(f"\n>The dealer flipped the {face} of {suit}\n\n>Dealer total >{dtotal}<")
                dtotal += dcard 
                if dtotal > total:
                    op = "done"
        
        elif op == "hit":
            card, ace, face, suit = getcard(ace, total)
            print(f"\n>You flipped the {face} of {suit}" )
            total += card
        if dtotal > total:
            fvalue = "win"

        if total > 21 and ace > 0:
            ace -= 1
            total -= 10
        if dtotal > 21 and dace > 0:
            dace -= 1
            dtotal -= 10

        end = True
        
        if total > 21:
            print(f"\n\n>You bust over 21 with {total}. You lose")
        elif dtotal > 21 and total < 21:
            print(f"\n\n>The dealer busts over 21 with {dtotal} while you have {total}. You win")
        elif dtotal == 21:
            print(f"\n\n>The dealer wins with a total of {dtotal} while you have {total}. You lose")
        elif total == 21:
            print("\n\n>You hit exactly 21. You win.")
        elif dtotal > total:
            print(f"\n\n>The dealer's hand of {dtotal} is greater than your hand of {total} You lose")
        else:
            end = False

        if end:
            play_input = input("\n\n>Play again? (yes or no)\n>")
            play = play_input == "yes"