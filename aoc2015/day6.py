file = open("aoc2015/day6input.txt", "r")
lines = file.readlines()
xnum = 0
ynum = 0
lights = {"0,0": False}
while ynum < 1000:
    while xnum < 1000:
        lights[f"{xnum},{ynum}"] = False
        xnum += 1
    ynum += 1

for line in lines:
    if line[:7] == "turn on":
        num = 8
        base = line[num:num+7].strip(" ")
        coordinates = base.split(",")
        x1 = coordinates[0]
        y1 = coordinates[1]
        num = len(line)
        base = line[num-8:num].strip(" ")
        coordinates = base.split(',')
        x2 = int(coordinates[0])
        y2 = coordinates[1]
        y2 = int(y2.strip("\n"))
        x = int(x1)
        y = y1
        while y <= y2:
            while x <= x2:
                lights[f"{x},{y}"] = True
                x += 1
            y += 1
    elif line[:8] == "turn off":
        num = 9
        base = line[num:num+7].strip(" ")
        coordinates = base.split(",")
        x1 = coordinates[0]
        y1 = coordinates[1]
        y1 = y1.strip(" t")
        num = len(line)
        base = line[num-8:num].strip(" ")
        coordinates = base.split(',')
        x2 = coordinates[0]
        y2 = coordinates[1]
        y2 = y2.strip("\n")
        x = x1
        y = y1
        while y <= y2:
            while x <= x2:
                lights[f"{x},{y}"] = False
                x += 1
            y += 1
    else:
        num = 7
        base = line[num:num+7].strip(" ")
        coordinates = base.split(",")
        x1 = coordinates[0]
        y1 = coordinates[1]
        y1 = y1.strip(" t")
        num = len(line)
        base = line[num-8:num].strip(" ")
        coordinates = base.split(',')
        x2 = coordinates[0]
        y2 = coordinates[1]
        y2 = y2.strip("\n")
        x = x1
        y = y1
        while y <= y2:
            while x <= x2:
                if lights[f"{x},{y}"]:
                    lights[f"{x},{y}"] = False
                else:
                    lights[f"{x},{y}"] = True
                x += 1
            y += 1
xnum = 0
ynum = 0
totalLights = 0
while ynum < 1000:
    while xnum < 1000:
        if lights[f"{xnum},{ynum}"]:
            totalLights += 1
        xnum += 1
    ynum += 1
print(totalLights)
        