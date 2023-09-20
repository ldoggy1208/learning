file = open("aoc2015/day8input.txt", "r")
lines = file.readlines()
total_code = 0
total_characters = 0
for line in lines:
    current_code = len(line) - 1
    total_code += current_code
    
    mod = 0
    
    current_code -= 2
    for i in range(len(line)):
        i += mod
        if line[i: i + 2] == "\\\\":
            #print(line[i: i+2])
            current_code -= 1
            mod += 2
        
        elif line[i: i + 2] == "\\x":
            #print(line[i: i+2])
            current_code -= 3
            mod += 2
            
        elif line[i: i + 2] == "\\\"" and i+2 != len(line)-1:
            #print(line[i: i+2])
            current_code -= 1
            mod += 2

        total_characters += current_code 
        current_code = 0 
print(f"the total amount of code is: {total_code}")
print(f"the total amount of characters is: {total_characters}")
print(f"the amount of characters in the strings is: {total_code - total_characters}")