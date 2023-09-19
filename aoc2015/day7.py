def NOT (base):
    num = 0
    while num < 16:
        if base[num] == 1:
            base[num] = 0
        else:
            base[num] = 1
        num += 1
    print("NOT")
    return base

def AND(var1, var2):
    num = 0
    base = {}
    while num < 16:
        if var1[num] == 1 and var2[num] == 1:
            base[num] = 1
        else:
            base[num] = 0
        num += 1
    print('AND')
    return base

def OR(var1, var2):
    num = 0
    base = {}
    while num < 16:
        if var1[num] == 0 and var2[num] == 0:
            base[num] = 0
        else:
            base[num] = 1
        num += 1
    print("OR")
    return base

def XOR(var1, var2):
    num = 0
    base = {}
    while num < 16:
        if var1[num] == var2[num]:
            base[num] = 0
        else:
            base[num] = 1
    print("XOR")
    return base
            
def RSHIFT(var, amp):
    num = 15
    base = {}
    while num >= 0:
        if num + amp < 16:
            base[num] = var[num+amp]
        else:
            base[num] = 0
        num -= 1
    print("RSHIFT")
    return base
            
def LSHIFT(var, amp):
    num = 15
    base = {}
    while num >= 0:
        ampmod = 0
        if num - amp < 0:
            ampmod = 16
        base[num] = var[num-amp+ampmod]
        num -= 1
    print("LSHIFT")
    return base

def Convert(var):
    final = 0         
    num = 0
    global values
    while num < 16:
        if values[var][num] == 1:
            final += 2**num
        num += 1
    print(final)
    return(final)
        
file = open("aoc2015/day7input.txt", "r")
lines = file.readlines()
values = {'a': None}
first = False
while values["a"] == None:
    for line in lines:
        instructions = line.split(' ')
        if instructions[-1] == "lx\n" and 'lx' in values and not first:
            print("caught")
            first = True
        if instructions[1] == '->' and instructions[-1].strip() != 'a':
            stand_in = int(instructions[0])
            base = {}
            num = 15
            while num >= 0:
                if stand_in - (2**num) <0:
                    base[num] = 0
                else:
                    base[num] = 1
                    stand_in -= (2**num)
                num -= 1
            values[instructions[-1].strip()] = base
        
        elif instructions[0] == "NOT" and instructions[1] in values and instructions[-1].strip() not in values:
            values[instructions[-1].strip()] = NOT(values[instructions[1]])
        
        elif instructions[1] == "OR" and instructions[0] in values and instructions[2] in values and instructions[-1].strip() not in values:
            values[instructions[-1].strip()] = OR(values[instructions[0]], values[instructions[2]])
            print(instructions[-1].strip())
            
        elif instructions[1] == "AND" and instructions[0] == '1' and instructions[2] in values and instructions[-1].strip() not in values:
            base = {}
            num = 15
            while num >= 0:
                if num == 0:
                    base[0] = 1
                else:
                    base[num] = 0
                num -= 1
            values[instructions[-1].strip()] = AND(base, values[instructions[2]])
            
        elif instructions[1] == "AND" and instructions[0] in values and instructions[2] in values and instructions[-1].strip() not in values:
            values[instructions[-1].strip()] = AND(values[instructions[0]], values[instructions[2]])
            
        elif instructions[1] == "XOR" and instructions[0] in values and instructions[2] in values and instructions[-1].strip() not in values:
            values[instructions[-1].strip()] = XOR(values[instructions[0]], values[instructions[2]])
            
        elif instructions[1] == "LSHIFT" and instructions[0] in values and instructions[-1].strip() not in values:
            values[instructions[-1].strip()] = LSHIFT(values[instructions[0]], int(instructions[2]))
            
        elif instructions[1] == "RSHIFT" and instructions[0] in values and instructions[-1].strip() not in values:
            values[instructions[-1].strip()] = RSHIFT(values[instructions[0]], int(instructions[2]))
            
        elif instructions[-1].strip() == "a" and instructions[0] in values:
            print(values[instructions[0]])
            values['a'] = values[instructions[0].strip()]
            final = 0         
            num = 0
            while num < 16:
                if values['a'][num] == 1:
                    final += 2**num
                num += 1
            print(final)
base = values['a']
values = {}
values['a'] = base
base = {}
while True:
    for line in lines:
        instructions = line.split(' ')
        if instructions[-1] == "lx\n" and 'lx' in values and not first:
            print("caught")
            first = True
        if instructions[1] == '->' and instructions[-1].strip() != 'a' and instructions[-1].strip != 'b':
            stand_in = int(instructions[0])
            base = {}
            num = 15
            while num >= 0:
                if stand_in - (2**num) <0:
                    base[num] = 0
                else:
                    base[num] = 1
                    stand_in -= (2**num)
                num -= 1
            values[instructions[-1].strip()] = base
            
        elif instructions[1] == '->' and instructions[-1].strip() == 'b':
            stand_in = Convert(values['a'])
            base = {}
            num = 15
            while num >= 0:
                if stand_in - (2**num) <0:
                    base[num] = 0
                else:
                    base[num] = 1
                    stand_in -= (2**num)
                num -= 1
            values[instructions[-1].strip()] = base
                       
        elif instructions[0] == "NOT" and instructions[1] in values and instructions[-1].strip() not in values:
            values[instructions[-1].strip()] = NOT(values[instructions[1]])
        
        elif instructions[1] == "OR" and instructions[0] in values and instructions[2] in values and instructions[-1].strip() not in values:
            values[instructions[-1].strip()] = OR(values[instructions[0]], values[instructions[2]])
            print(instructions[-1].strip())
            
        elif instructions[1] == "AND" and instructions[0] == '1' and instructions[2] in values and instructions[-1].strip() not in values:
            base = {}
            num = 15
            while num >= 0:
                if num == 0:
                    base[0] = 1
                else:
                    base[num] = 0
                num -= 1
            values[instructions[-1].strip()] = AND(base, values[instructions[2]])
            
        elif instructions[1] == "AND" and instructions[0] in values and instructions[2] in values and instructions[-1].strip() not in values:
            values[instructions[-1].strip()] = AND(values[instructions[0]], values[instructions[2]])
            
        elif instructions[1] == "XOR" and instructions[0] in values and instructions[2] in values and instructions[-1].strip() not in values:
            values[instructions[-1].strip()] = XOR(values[instructions[0]], values[instructions[2]])
            
        elif instructions[1] == "LSHIFT" and instructions[0] in values and instructions[-1].strip() not in values:
            values[instructions[-1].strip()] = LSHIFT(values[instructions[0]], int(instructions[2]))
            
        elif instructions[1] == "RSHIFT" and instructions[0] in values and instructions[-1].strip() not in values:
            values[instructions[-1].strip()] = RSHIFT(values[instructions[0]], int(instructions[2]))
            
        elif instructions[-1].strip() == "a" and instructions[0] in values and Convert(values['a']) != 3176:
            values['a'] = values[instructions[0].strip()]
            print(values['a'])
            final = 0         
            num = 0
            while num < 16:
                if values['a'][num] == 1:
                    final += 2**num
                num += 1
            print(final)
    #print("looped")