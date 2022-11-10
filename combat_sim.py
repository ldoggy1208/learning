import random
critc = 0
play = input(">Play game (yes or no)?\n>")
while play == "yes":
    hpc = random.randint(22,57)
    hpp = random.randint(20,50)
    name = input(">Enter your name\n>")
    opp = input(">Enter your opponent's name\n>")
    print(f">{name} hp:{hpp} vs. {opp} hp:{hpc}")
    while hpp > 0 and hpc > 0:
        atkp = 0
        atkc = 0
        dn = 0
        critc = random.randint(1,8)
        critp = random.randint(1,8)
        atkc = random.randint(1,8)
        op = input(">Choose atk or def\n>")
        while op != "atk" and op != "def":
            print(">invalid input")
        op = input(">Choose atk or def\n>")
        if op == "atk":
            atkp = random.randint(1,10)
            critp = random.randint(1,8)
            if critp == 8:
                atkp *= 2
        elif op == "def":
            dn = random.randint(0,5)
        if dn > atkp:
            dn = atkp
        if critc == 8:
            atkc *= 2
        if critc == 8 and op == "def":
            atkp = (atkc / 2)
            atkc = 0
        hpc -= atkp
        hpp -= (atkc - dn)
        if critp == 8 and critc != 8:
            print (f">{name} crit for {atkp} damage and has {hpp} health remaining.\n>{opp} has {hpc} health remaining and did {atkc} damage.")
        elif critp == 8 and critc == 8:
            print (f">Both {name} and {opp} crit.\n>{name} crit for {atkp} damage and has {hpp} health remaining.\n>{opp} crit for {atkc} damage and has {hpc} health remaining.")
        elif critp != 8 and critc == 8 and op == "def":
            print (f">{name} countered {opp}'s attack.\n>{name} dealt {atkp} damage and healed up to {hpp}\n>{opp} has {hpc} health left.")
        elif critp != 8 and critc == 8 and op != "def":
            print (f">{opp} ctit {name} for {atkc} damage and has {hpc} left.\n>{name} dealth {atkp} damage and has {hpp} health left.")
        else:
            print (f">{name}'s health is {hpp} and did {atkp} damage and blocked for {dn}.\n>{opp}'s health is {hpc} and did {atkc} damage.")
    if hpc <= 0 and hpp != 0:
        print(">You win. Yay!")
    elif hpp <= 0 and hpc != 0:
        print(">you lose. Boo!")
    elif hpp <= 0 and hpc <= 0:
        print(f">As you slay {opp} both of you fall to the ground")
    play = input(">Play again?")
