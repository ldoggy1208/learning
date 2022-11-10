lst = []
n = int(input("enter number of elements : "))
for i in range(n):
    ele = int(input())
    lst.append(ele)
answer = 0
for i in lst:
    answer += i
print(answer)

