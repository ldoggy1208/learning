side = int(input("What side did it land on?\n>"))
with open('Personal_Advancements/Dice_Outcomes.txt', 'a') as file:
    file.write(f'{side}\n')
with open('Personal_Advancements/Dice_Outcomes.txt', 'r') as file:
    rows = [row.strip() for row in file.readlines()]
    
total1 = 0
total2 = 0
total3 = 0
total4 = 0
total5 = 0
total6 = 0
ttotal = 0

combined_sides = ''.join(rows)
print(combined_sides)
for i in combined_sides:
    if i == '1':
        total1 += 1
    elif i == '2':
        total2 += 1
    elif i == '3':
        total3 += 1
    elif i == '4':
        total4 += 1
    elif i == '5':
        total5 += 1
    elif i == '6':
        total6 += 1
    ttotal += 1
    print(total1)
    print(ttotal)

value1 = total1 / ttotal * 100
value2 = total2 / ttotal * 100
value3 = total3 / ttotal * 100
value4 = total4 / ttotal * 100
value5 = total5 / ttotal * 100
value6 = total6 / ttotal * 100

print(f"""
The average of times 1 was landed on was {value1}%\n
The average of times 2 was landed on was {value2}%\n
The average of times 3 was landed on was {value3}%\n
The average of times 4 was landed on was {value4}%\n
The average of times 5 was landed on was {value5}%\n
The average of times 6 was landed on was {value6}%
""")