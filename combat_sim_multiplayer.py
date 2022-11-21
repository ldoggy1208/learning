import random

play = True
crit2 = 0
crit1 = 0
while play:
    hp1 = random.randint(20,50)
    hp2 = random.randint(20,50)
    name1 = input("\n>player 1 input name\n\n>")
    name2 = input("\n>player 2 input name\n\n>")
    print(f"\n>{name1} hp:{hp1} vs. {name2} hp:{hp2}\n\n")

    foc1 = 0
    foc2 = 0
    op1 = 0
    op2 = 0

    while hp1 > 0 and hp2 > 0:
        atk1 = 0
        atk2 = 0
        dn1 = 0
        dn2 = 0
        miss1 = 0
        miss2 = 0
        hl1 = 0
        hl2 = 0

        order = random.randint(1,2)

        if op1 == "def":
            m1 -= 0.2
        elif op1 != "def":
            m1 = 1

        if op2 == "def":
            m2 -= 0.2
        elif op2 != "def":
            m2 = 1

        if order == 1:
            op1 = input(f"\n>{name1} choose atk, def or foc\n>")
            while op1 != "atk" and op1 != "def" and op1 != "foc":
                print(f">{name1} invalid input")
                op1 = input(f"\n>{name1} choose atk, def or foc\n>")
            op2 = input(f"\n>{name2} choose atk, def or foc\n>")
            while op2 != "atk" and op2 != "def" and op2 != "foc":
                print(f">{name2} invalid input")
                op2 = input(f"\n>{name2} choose atk, def or foc\n>")
        

        if order == 2:
            op2 = input(f"\n>{name2} choose atk, def or foc\n>")
            while op2 != "atk" and op2 != "def" and op2 != "foc":
                print(f">{name2} invalid input")
                op2 = input(f"\n>{name2} choose atk, def or foc\n>")
            op1 = input(f"\n>{name1} choose atk, def or foc\n>")
            while op1 != "atk" and op1 != "def" and op1 != "foc":
                print(f">{name1} invalid input")
                op1 = input(f"\n>{name1} choose atk, def or foc\n>")

        if op1 == "atk":
            atk1 = random.randint(1,10)
            miss1 = random.randint(1,10)
            if miss1 != 10:
                crit1 = random.randint(1,8)
                if crit1 == 8:
                    atk1 = 2*(atk1+foc1)
            if miss1 == 10:
                atk1 = 0
        if op1 == "def":
            dn1 = 20
        if op1 == "foc":
            foc1 += 1
            dn1 = random.randint(0,3)

        if op2 == "atk":
            atk2 = random.randint(1,10)
            miss2 = random.randint(1,10)
            if miss2 != 10:
                crit2 = random.randint(1,8)
                if crit2 == 8:
                    atk2 *= 2*(atk2+foc2)     
            if miss2 == 10:
                atk2 = 0
        elif op2 == "def":
            dn2 = 20
        elif op2 == "foc":
            foc2 += 1
            dn2 = random.randint(0,3)

        if dn1 > atk2:
            dn1 = atk2
        if dn2 > atk1:
            dn2 = atk1
         
        if op2 == "atk":            
            if crit2 == 8 and op1 == "def":
                atk1 = (atk2 / 2)
                atk2 = 0
        
        if op1 == "atk":
            if crit1 == 8 and op2 == "def":
                atk2 = (atk1 / 2)
                atk1 = 0

        if op1 == "atk" and atk1 != 0:
            hp2 -= (atk1 + foc1)-(dn2 * m2) 
        if op2 == "atk" and atk2 != 0:
            hp1 -= (atk2 + foc2)-(dn1 * m1)

        if op1 == "def":
            hl1 += random.randint(1,3)
        if op2 == "def":
            hl2 += random.randint(1,3)
        hp1 += hl1 + foc1
        hp2 += hl2 + foc2

        print("\n")
        if miss1 == 10:
            print(f">{name1} missed their attack")
        if miss2 == 10:
            print(f">{name2} missed their attack")

        if op1 == "atk":
            if atk1 != 0:
                if crit1 != 8:
                    print(f">{name1} dealt {atk1 + foc1} damage")
                else:
                    if op2 != "def":
                        print(f">{name1} crit for {atk1} damage")
                    else:
                        print(f">{name2} countered {name1}'s attack")
        if op1 == "def":
            if atk2 != 0:
                print(f">{name1} blocked {dn1} damage")
        if op1 == "foc":
            print(f">{name1} focused to a level of {foc1}")

        if op2 == "atk":
            if atk2 != 0:
                if crit2 != 8:
                    print(f">{name2} dealt {atk2+foc2} damage")
                else:
                    if op1 != "def":
                        print(f">{name2} crit for {atk2} damage")
                    else:
                        print(f">{name1} countered {name2}'s attack")
        if op2 == "def":
            if atk1 != 0:
                print(f">{name2} blocked {dn2} damage")
        if op2 == "foc":
            print(f">{name2} focused to a level of {foc2}")
        if op1 == "def" and op2 == "def":
            print(f">Moronicly, both {name1} and {name2} tried to defend eachother")
        print(f"\n>{name1} has {hp1} health remaining\n>{name2} has {hp2} health remaining")        
            
    if hp2 <= 0 and hp1 >= 0:
        print(f">{name1} wins!")
    elif hp1 <= 0 and hp2 >= 0:
        print(f">{name2} wins!")
    elif hp1 <= 0 and hp2 <= 0:
        print(f">Both {name1} and {name2} slay eachother at the same time")
        
    play = input(">Game over\n\n>Play again?\n>") == "yes"