import mysql.connector

def salpartition():
    for i in range(n):
        print("\n\nPartition number ",i)
        if i==0:
            cursor.execute("select * from employee where salary<= "+str(l[i]))
        elif i==n-1:
            cursor.execute("select * from employee where salary> "+str(l[i-1]))
        else:
            cursor.execute("select * from employee where salary> "+str(l[i-1])+" and salary<= "+str(l[i]))
        result = cursor.fetchall()
        for row in result:
            print(row)

def agepartition():
    for i in range(n):
        print("\n\nPartition number ",i)
        if i==0:
            cursor.execute("select * from employee where age<= "+str(l[i]))
        elif i==n-1:
            cursor.execute("select * from employee where age> "+str(l[i-1]))
        else:
            cursor.execute("select * from employee where age> "+str(l[i-1])+" and age<= "+str(l[i]))
        result = cursor.fetchall()
        for row in result:
            print(row)

def search_tuple():
    cursor.execute("select * from employee where eid="+str(tup))
    res = cursor.fetchall()
    if res:
        print(res)
    else:
        print("eid not found")



n=int(input("Enter number of partitions:"))
print("Enter column by which you want to partition:\n1.Salary\n2.Age")
v=int(input())
print("Enter range:")
l = [int(input()) for _ in range(n-1)]
conn = mysql.connector.connect(
    host="localhost",
    user="root", 
    passwd="root",
    database="practical"
    )
cursor = conn.cursor()
if v==1:
    salpartition()
else:
    agepartition()
tup = int(input("\n\nEnter eid whose tuple is to be searched:"))
search_tuple()
