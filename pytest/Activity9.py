list1=[12,3,4,56,6,7,78,34,23,22,343,5]
list2=[2,6,78,67,65,45,77,99,34,23,26,556]
list3=[]
for x in list1:
    if x%2!=0:
        list3.append(x)

for x in list2:
    if x%2==0:
        list3.append(x)
        
print(list3)