# Initialize a variable to count nice strings
nice_strings = 0

# Open the file for reading
with open("aoc2015/day5input.txt", "r") as file:
    for line in file:
        line = line.strip()  # Remove leading/trailing whitespace and newline characters

        # Initialize counters for vowels and double letters
        vowel_count = 0
        has_double_letter = False

        # Initialize a flag for the forbidden strings
        has_forbidden_strings = False

        # Iterate through the characters in the line
        for i in range(len(line)):
            # Check for the forbidden strings
            if line[i:i + 2] in ["ab", "cd", "pq", "xy"]:
                has_forbidden_strings = True

            # Count vowels
            if line[i] in "aeiou":
                vowel_count += 1

            # Check for double letters
            if i < len(line) - 1 and line[i] == line[i + 1]:
                has_double_letter = True

        # Check if the line meets all criteria for a nice string
        if vowel_count >= 3 and has_double_letter and not has_forbidden_strings:
            nice_strings += 1

# Print the count of nice strings
print("Number of nice strings:", nice_strings)
