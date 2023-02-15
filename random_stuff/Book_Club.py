person = int(input("1 for liam 2 for tony\n>"))
monthinput = input("What month is it?\n>")
dayinput = input("What day is it?\n>")
yearinput = input("What year is it?\n>")
Pagest = input("What page did you start on?\n>")
Pageen = input("What page did you end on?\n>")
if person == 1:
    f = open("random_stuff/Liam_records.txt", 'a')
    f.write(f"{monthinput}, {dayinput}, {yearinput}\npg.{Pagest} - pg.{Pageen}\n\n")
elif person == 2:
    f = open("random_stuff/Tony_records.txt", 'a')
    f.write(f"{monthinput}, {dayinput}, {yearinput}\npg.{Pagest} - pg.{Pageen}\n\n")
else:
    print("Invalid number")