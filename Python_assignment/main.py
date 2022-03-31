# import operator
# from Tools.scripts.make_ctype import values


# # a=[1,2,3,4,5,6,7,8,9]
# # print(a[::2])
#output will be =(1,3,5,7,9)


# # def f(value, values):
# # v = 1
# # values[0] = 44
# # t = 3
# # v = [1, 2, 3]
# # f(t, v)
# # print(t, v[0])
# its an infinite loop



# # data = [[[1, 2], [3, 4]], [[5, 6], [7, 8]]]
# #     def fun(m):
# #         v = m[0][0]
# #         for row in m:
# #            for element in row:
# #             if v < element:
# #                 v = element
# #                 return v
# #                 print(fun(data[0]))
#output will be 2




# # Write a program in Python to delete first element from a list
list = [1,2,3,4,5]
list.pop(0)
print(list)
print()


# # Write a program to accept three numbers from the user and insert it at the end of given Tuple T1.
T1 = (23, 32, 4, 5, 2, 12, 23, 7, 9, 10, 23)
i =0
while(i<3):
     num = int(input("Enter any number : "))
     T1 = T1 + (num,)
     i = i+1
print(T1)
print()


# # How to remove all items at once from dictionary ?
dictionary = {'name': 'shejal', 'age': 22, 'department' : 'training',}
dictionary = {}
print(dictionary)
print()


# # Write a Python script to sort (ascending and descending) a dictionary by value.
import operator

dictionary1 = {1: 21, 3: 14, 4: 13, 2: 11, 0: 10}
print('Original dictionary : ',dictionary1)
sorted_d = sorted(dictionary1.items(), key=operator.itemgetter(1))
print('Dictionary in ascending order  : ',sorted_d)
sorted_d = dict( sorted(dictionary1.items(), key=operator.itemgetter(1),reverse=True))
print('Dictionary in descending order  : ',sorted_d)
print()

# # Write a Python script to print a dictionary where the keys are numbers between 1 and 15 (both included) and the values are square of keys.
dictionary2=dict()
for x in range(1,16):
    dictionary2[x]=x**2
print(dictionary2)
print()



# # Write a programto find the sum of the digits of a number accepted from user.
Num1 = int(input("Please Enter any Number: "))
Sum = 0

while (Num1 > 0):
    Reminder = Num1 % 10
    Sum = Sum + Reminder
    Num1 = Num1 // 10

print("\n Sum of the digits of Given Number = %d" % Sum)
print()

# Write a Python program to construct the following pattern, using a nested for loop.


rows = int(input("Enter number of rows you want in pattern: "))
for i in range(0, rows):
    for j in range(0, i + 1):
        print("*", end=' ')
    print("\r")
print()

# Write a program to read first 10 characters from a file named “data.txt”
from turtle import pd

f = open('data','r')
data = f.read(10)
print(data)
print()

# Write a program in python to display number of lines in a file(“data.txt”).
f = open('data','r')
data = f.readlines()
size = len(data)
print("total number of lines in file named as data are :" ,size)
print()


# Write a program to convert these json files to a csv file. Content of the files is given below. Create a single csv that should contain data from the json files.

import pandas as pd
df1 = pd.read_json('data1.json')
df2 = pd.read_json('data2.json')
df = pd.concat([df1,df2])
df.to_csv("CSVdata.csv",index=False)
result = pd.read_csv("CSVdata.csv")

