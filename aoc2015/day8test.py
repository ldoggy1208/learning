file = open("aoc2015/day8input-test.txt", "r")
lines = file.readlines()
total_code = 1
total_characters = 0
for line in lines:
    total_code = len(line) +2
    total_code += current_chars
    
    i = 0
    
    while i < len(line)+ 1:
        if line[i: i + 2] == "\\\\":
            #print(line[i: i+2])
            i += 1
        
        elif line[i: i + 2] == "\\x":
            #print(line[i: i+2])
            i += 3
            
        elif line[i: i + 2] == "\\\"" and i+2 != len(line)-1:
            #print(line[i: i+2])
            i += 1
        total_characters += 1
        i += 1

        current_chars = 0 
print(f"the total amount of code is: {total_code}")
print(f"the total amount of characters is: {total_characters}")
print(f"the amount of characters only in the strings is: {total_code - total_characters}")