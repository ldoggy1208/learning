def NOT (base):
    num = 0
    while num < 16:
        if base[num] == 1:
            base[num] = 0
        else:
            base[num] - 1
        num += 1
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
    return base

def XOR(var1, var2):
    num = 0
    base = {}
    while num < 16:
        if var1[num] == var2[num]:
            base[num] = 0
        else:
            base[num] = 1
            
def LSHIFT(var, amp):
    num = 0
    base = {}
    while num < 16:
        ampmod = 0
        if num + amp > 16:
            ampmod = 16
        base[num] = var[num+amp-ampmod]
            
def RSHIFT(var, amp):
    num = 16
    base = {}
    while num > 0:
        ampmod = 0
        if num + amp > 16:
            ampmod = 16
        base[num] = var[num-amp+ampmod]
        
file = open("aoc2015/day7input.txt", "r")
lines = file.readlines()
values = {'a': None}
while values["a"] == None:
    for line in lines:
        instructions = line.split(" ")
        if type(line[0]) == int and line[1] == "->":
            stand_in = line[0]
            base = {}
            num = 15
            while num > 0:
                if stand_in - (2**num) <0:
                    base[num] = 0
                else:
                    base[num] = 1
                    stand_in -= (2**num)
                num -= 1
            values[line[-1]] = base
                
        if type(line[0]) == str and line[0] == "NOT" and values[line[1]] != KeyError:
            values[line[-1]] = ~ values[line[1]]
            print(values[line[-1]])