import random

def get_input(valid_options, prompt_text):
    choice = input(prompt_text)
    while choice not in valid_options:
        choice = input(prompt_text)
    return choice

def get_name():
    name = input(">input your name\n>")
    return name

def one_player():
    difficulties = ["test", "easy", "medium", "hard", "impossible"]
    text = "\n>Invalid difficulty.>Select difficulty (easy medium or hard)\n>"
    dif_input = get_input(difficulties, text)

    if dif_input == "test":
        dif = 0
    elif dif_input == "easy":
        dif = 1
    elif dif_input == "medium":
        dif = 2
    elif dif_input == "hard":
        dif = 3
    elif dif_input == "impossible":
        dif = 4
        
    hp1 = random.randint(20,50)
    hpm = random.randint(-10,10)
    hp2 = hp1 + hpm
    if hp2 > 50:
        hp2 = 50
    if hp2 < 20:
        hp2 = 20
    m1 = 1
    m2 = 1
    
    print(">For you,")
    name1 = get_name()
    
    print(">For opponent,")
    name2 = get_name()

    while name2 == name1:
        print(f">Come on I know you aren't trying to fight yourself")
        name2 = get_name()

    print(f"\n>{name1} hp:{hp1} vs. {name2} hp:{hp2}\n\n")

    foc1 = 0
    foc2 = 0
    op1 = 0
    op2 = 0
    prv = False


    while hp1 > 0 and hp2 > 0:
        atk1 = 0
        atk2 = 0
        dn1 = 0
        dn2 = 0
        miss1 = 0
        miss2 = 0
        hl1 = 0
        hl2 = 0

        main_dif = ["easy", "medium", "hard"]

        if dif_input in main_dif:
            if op1 == "def":
                m1 -= 0.2
            else:
                m1 = 1
            if m1 < 0:
                m1 = 0
        else:
            m1 = 1
        
        if op2 == "def":
            m2 -= 0.2
        else:
            m2 = 1
        if m2 < 0:
            m2 = 0

        inputs = ["atk", "def", "foc"]
        text = ">Choose atk, def, foc\n>"
        op1 = get_input(inputs, text)

        if dif == 0:
            op2 = "def"

        elif dif == 1:
            op2_input = random.randint(1,3)
            if op2_input == 1:
                op2 = "atk"
            elif op2_input == 2:
                op2 = "def"
            else:
                op2 = "foc" 

        elif dif == 2:                    
            if prv == False:
                op2 = "foc"
            else:
                op2 = prv

        elif dif == 3:
            op2_input = random.randint(1,5)
            if foc2 < 3:
                if op2_input == 1:
                    op2 = "atk"
                elif op2_input == 2:
                    op2 = "def"
                else:
                    op2 = "foc"
            else:
                if op2_input == 1 or op2_input == 2:
                    op2 = "atk"
                if op2_input == 5:
                    op2 = "foc"
                else:
                    op2 = "def"
                
        else:
            if op1 == "atk":
                op2 = "def"
            elif op1 == "def":
                op2 = "foc"
            else:
                op2 = "atk"

        if op1 == "atk":
            atk1 = random.randint(1,10)
            miss1 = random.randint(1,10)
            if miss1 != 10:
                crit1 = random.randint(1,8)
                miss1 = False
                if crit1 == 8:
                    atk1 = 2*(atk1)+foc1
                    crit1 = True
                else:
                    crit1 = False
            if miss1 == 10:
                atk1 = 0
                miss1 = True
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
                miss2 = False
                if crit2 == 8:
                    atk2 = 2*(atk2)+foc2
                    crit2 = True
                else:
                    crit2 = False   
            if miss2 == 10:
                atk2 = 0
                miss2 = True
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
            if crit2 == True and op1 == "def":
                atk1 = (atk2 / 2)
                atk2 = 0
        
        if op1 == "atk":
            if crit1 == True and op2 == "def":
                atk2 = (atk1 / 2)
                atk1 = 0

        if op1 == "atk" and atk1 != 0:
            hp2 -= (atk1 + foc1)-(dn2 * m2) 
        if op2 == "atk" and atk2 != 0:
            hp1 -= (atk2 + foc2)-(dn1 * m1)

        if op1 == "def":
            hl1 += random.randint(1,3)
            hp1 += hl1 + foc1
        if op2 == "def":
            hl2 += random.randint(1,3)
            hp2 += hl2 + foc2

        print("\n")
        if miss1 == True:
            print(f">{name1} missed their attack")
        if miss2 == True:
            print(f">{name2} missed their attack")

        if op1 == "atk":
            if atk1 != 0:
                if crit1 == False:
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
                if crit2 == False:
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
            print(f">Moronicly, both {name1} and {name2} tried to defend each other")
        print(f"\n>{name1} has {hp1} health remaining\n>{name2} has {hp2} health remaining")        
        prv = op1    
    if hp2 <= 0 and hp1 >= 0:
        print(f">{name1} wins!")
    elif hp1 <= 0 and hp2 >= 0:
        print(f">{name2} wins!")
    elif hp1 <= 0 and hp2 <= 0:
        print(f">Both {name1} and {name2} slay eachother at the same time")
        
    play = input(">Game over\n\n>Play again?\n>") == "yes"

    prv = op1

def two_player():
    hp1 = random.randint(20,50)
    hpm = random.randint(-10,10)
    hp2 = hp1 + hpm
    if hp2 > 50:
        hp2 = 50
    if hp2 < 20:
        hp2 = 20
    m1 = 1
    m2 = 1
    
    print(">Player 1,")
    name1 = get_name
    print(">Player 2,")
    name2 = get_name
    while name2 == name1:
        print(f">player 2 you cannot have the same name as {name1}. For all I care, add a space after.")
        name2 = get_name
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
        if m1 < 0:
            m1 = 0
        
        if op2 == "def":
            m2 -= 0.2
        elif op2 != "def":
            m2 = 1
        if m2 < 0:
            m2 = 0

        inputs = {"atk", "def", "foc"}
        text = "choose atk, def, or foc"

        if order == 1:
            print(f">{name1}'s turn first")
            op1 = get_input(inputs, text)

            print(f">{name2}'s turn second")
            op2 = get_input(inputs, text)

        if order == 2:
            print(f">{name2}'s turn first")
            op2 = get_input(inputs, text)
            
            print(f">{name1}'s turn second")
            op1 = get_input(inputs, text)

        if op1 == "atk":
            atk1 = random.randint(1,10)
            miss1 = random.randint(1,10)
            if miss1 != 10:
                crit1 = random.randint(1,8)
                miss1 = False
                if crit1 == 8:
                    atk1 = 2*(atk1)+foc1
                    crit1 = True
                else:
                    crit1 = False
            if miss1 == 10:
                atk1 = 0
                miss1 = True
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
                miss2 = False
                if crit2 == 8:
                    atk2 = 2*(atk2)+foc2
                    crit2 = True
                else:
                    crit2 = False   
            if miss2 == 10:
                atk2 = 0
                miss2 = True
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
            if crit2 == True and op1 == "def":
                atk1 = (atk2 / 2)
                atk2 = 0
        
        if op1 == "atk":
            if crit1 == True and op2 == "def":
                atk2 = (atk1 / 2)
                atk1 = 0

        if op1 == "atk" and atk1 != 0:
            hp2 -= (atk1 + foc1)-(dn2 * m2) 
        if op2 == "atk" and atk2 != 0:
            hp1 -= (atk2 + foc2)-(dn1 * m1)

        if op1 == "def":
            hl1 += random.randint(1,3)
            hp1 += hl1 + foc1
        if op2 == "def":
            hl2 += random.randint(1,3)
            hp2 += hl2 + foc2

        print("\n")
        if miss1 == True:
            print(f">{name1} missed their attack")
        if miss2 == True:
            print(f">{name2} missed their attack")

        if op1 == "atk":
            if atk1 != 0:
                if crit1 == False:
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
                if crit2 == False:
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
            print(f">Moronicly, both {name1} and {name2} tried to defend each other")
        print(f"\n>{name1} has {hp1} health remaining\n>{name2} has {hp2} health remaining")        

        

    if hp2 <= 0 and hp1 >= 0:
        print(f">{name1} wins!")
    elif hp1 <= 0 and hp2 >= 0:
        print(f">{name2} wins!")
    elif hp1 <= 0 and hp2 <= 0:
        print(f">Both {name1} and {name2} slay eachother at the same time")
        
    play = input(">Game over\n\n>Play again?\n>") == "yes"
    
play = True
crit2 = 0
crit1 = 0
name1 = " "
name2 = " "
while play:
    text = ">Choose to play by typing \"play\", type \"credits\" for credits, or \"help\" for what the options do\n>"
    pls = get_input(["play", "credits", "help"], text)

    if pls == "play":
        players = get_input(["1", "2"], ">1 player or 2 players?\n>")
        if players == "1":
            one_player()
        if players == "2":
            two_player()
    elif pls == "credits":
        print("""
>This game was made by Liam Temple

>With thanks to Michael Skyba for teaching me to code

>Partial thanks to Seb, Kolmyn, and Jay for beta testing""")

    elif pls == "help":
        print("""
>Atk attacks with a random attack power and your focus level

>Def defends with a deminishing return and heals you a small ammount and your focus level and defending has a small chance to counterattack

>Foc focuses and blocks a little bit of damage and increases focus level by one""")