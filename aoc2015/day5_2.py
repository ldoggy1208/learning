def has_non_overlapping_pair(line):
    for i in range(len(line) - 1):
        pair = line[i:i+2]
        remaining = line[i+2:]
        if pair in remaining:
            return True
    return False
nice_strings = 0

with open("aoc2015/day5input.txt", "r") as file:
    for line in file:
        line = line.strip()
        has_double_between = False

        has_pair_twice = has_non_overlapping_pair(line)

        for i in range(len(line)-2):
            num = i+2
            if line[i] == line[i + 2]:
                has_double_between = True
                       
        if has_double_between and has_pair_twice:
            nice_strings += 1

print("Number of nice strings:", nice_strings)
