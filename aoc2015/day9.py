def Create (line):
    nums = line.split()
    nums[1] = nums[1].strip()
    nums[2] = nums[2].strip()
    distances[int(nums[0])-1][int(nums[1])-1] = int(nums[2])
    distances[int(nums[1])-1][int(nums[0])-1] = int(nums[2])

def Shortest ():
   
    
distances = [[],[],[],[],[],[],[],[]]
set1 = 0
while set1 != 8:
    distances[set1] = [0] * 8
    set1+=1
with open("aoc2015/day9_input.txt", 'r') as file:
    lines = file.readlines()
for line in lines:
    Create(line)
min = distances[0][1]+distances[1][2]+distances[2][3]+distances[3][4]+distances[4][5]+distances[5][6]+distances[6][7]
Shortest(min, distances)
print(min)

