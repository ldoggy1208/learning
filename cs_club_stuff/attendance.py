csclub = {}
def main():
    start = int(input("enter 1 to add names, enter 2 to delete names, enter 3 to show the list of naems."))
    if start == 1:
        add()
    elif start == 2:
        dele()
    if start == 3:
        show()
def add():
    name = input("Enter in the name of the member you would like to add:")
    grade = int(input("Enter in the grade of the member:"))
    csclub [name] = grade
    print(csclub)
def dele():
    namedele = input("Enter the name of the  member you would like to delete:")
    if namedele in csclub:
        del csclub[namedele]
    else:
        print("This member does not exist in the list")
def show():
    print(csclub)

while True:
    main()