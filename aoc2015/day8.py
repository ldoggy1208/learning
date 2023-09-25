file = open("aoc2015/day8input.txt", "r")
lines = file.readlines()
total_code = 0
total_characters = 0

use_db = 1
if use_db == 21:
    import ipdb
    ipdb.set_trace()

for line in lines:
    current_chars = len(line)
    if line[-1] == "\n":
        current_chars -= 1
        line_length = current_chars
    total_code += current_chars
    
    i = 0
    
    current_chars -= 2
    while i < len(line):
        print(i)
        if line[i] == "\\":
            if line[i + 1] == "\\":
                #print(line[i: i+2])
                current_chars -= 1
                i += 1
            
            elif line[i + 1] == "x":
                #print(line[i: i+2])
                print(line[i: i+4])
                current_chars -= 3
            #print(i + 2)
                i += 3
            elif line[i + 1] == "\"" and i+2 != line_length:
                i += 1
                #print(line[i: i+2])
                #print(len(line))
                current_chars -= 1
        i += 1

        total_characters += current_chars 
        
        current_chars = 0 
    #print(total_characters)
print(f"the total amount of code is: {total_code}")
print(f"the total amount of characters is: {total_characters}")
print(f"the amount of characters only in the strings is: {total_code - total_characters}")