current_input = "1"
new_string = current_input
count = 0
while count < 5:
    i = 0
    current_input = new_string
    new_string = ""
    while i < len(current_input):
        amount = 1
        #print("step 1")
        added_string = ""
        if i < len(current_input):
            #print("step 2")
            while i < len(current_input) - 1 and current_input[i] == current_input[i+1]:
                #print("step 3")
                amount += 1
                #print(amount)
                #print(f"{amount}" + current_input[i])
                i += 1
                print(i)
                print(len(current_input))
                if i <= len(current_input) and current_input[i] != current_input[i+1]:
                    print("step 4")
                    added_string = f"{amount}" + current_input[i]
                    #print(added_string)
                    new_string += added_string
                    #print(new_string)
                elif i == len(current_input) -1:
                    added_string = f"{amount}" + current_input[i]
                    new_string += added_string
            if i == len(current_input)-1 or current_input[i] != current_input[i+1]:
                #print("step 5")
                added_string = "1" + current_input[i]
                new_string += added_string
            i += 1
    count+=1
    #print(count)
print(current_input)
        
        
         