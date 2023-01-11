import mysql.connector
n=int(input("Enter number of partitions:"))
print("Enter range:")
l = [int(input()) for _ in range(n-1)]
conn = mysql.connector.connect(
    host="localhost",
    user="root", 
    passwd="root",
    database="practical"
    )
cursor = conn.cursor()


def search_tuple():
    cursor.execute("select * from employee where eid="+str(tup))
    res = cursor.fetchall()
    if res:
        print(res)
    else:
        print("eid not found")

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

tup = int(input("\n\nEnter eid whose tuple is to be searched:"))
search_tuple()

