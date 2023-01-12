file = open("aoc2015/day2input.txt", "r")
wrapping_paper = 0
ribbon_total=0
lines = file.readlines()
for line in lines:
    dim = line.split("x")
    dim[2] = dim[2].strip()

    l = int(dim[0])
    w = int(dim[1])
    h = int(dim[2])

    s1=l*h
    s2=l*w
    s3=w*h
    if s1 <= s2 and s1 <= s3:
        smallest = s1
    if s2 <= s1 and s2 <= s3:
        smallest = s2
    if s3 <= s2 and s3 <= s1:
        smallest = s3

    bow=l*w*h

    if l > w and l > h:
        smalls1 = w
        smalls2 = h
    elif w > l and w > h:
        smalls1 = l
        smalls2 = h
    elif h > w and h > l:
        smalls1 = l
        smalls2 = w
    elif l == h and l == w:
        smalls1 = l
        smalls2 = w
    elif l < h and h == w:
        smalls1 = l
        smalls2 = w
    elif w < h and h == l:
        smalls1 = w
        smalls2 = l
    else:
        smalls1 = h
        smalls2 = l

    ribbon_total += (2*smalls1) + (2*smalls2) + bow

    wrapping_paper += (2*s1) + (2*s2) + (2*s3)+ smallest

print (wrapping_paper)
print (ribbon_total)