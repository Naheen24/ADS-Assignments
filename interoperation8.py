import mysql.connector
import tkinter  as tk
from tkinter import *


r = tk.Tk()
r.title('Site s1')
r.geometry("800x600")
conn = mysql.connector.connect(
        host="localhost",
        user="root", 
        passwd="root",
        database="exammanagement"
    )
c = conn.cursor()

r1=c.execute("SELECT * FROM subject")

l1=Entry(r,width=10)
l1.grid(row=0,column=0)
l1.insert(END,"sub_code")
l2=Entry(r,width=10)
l2.grid(row=0,column=1)
l2.insert(END,"sub_name")
l3=Entry(r,width=10)
l3.grid(row=0,column=2)
l3.insert(END,"dept_id")
l4=Entry(r,width=10)
l4.grid(row=0,column=3)
l4.insert(END,"semester")
i=0 # row value inside the loop
for k in r1:
    for j in range(len(k)):
        e = Entry(r, width=10, fg='blue')
        e.grid(row=i+1, column=j)
        e.insert(END, k[j])
    i=i+1

l=Label(r,text="                          ")
l.grid(row=0,column=6)

r2=c.execute("SELECT * FROM department")
m1=Entry(r,width=10)
m1.grid(row=0,column=7)
m1.insert(END,"Dept_id")
m2=Entry(r,width=10)
m2.grid(row=0,column=8)
m2.insert(END,"Dept_code")
m3=Entry(r,width=10)
m3.grid(row=0,column=9)
m3.insert(END,"Dept_name")
m4=Entry(r,width=10)
i=0 # row value inside the loop
for k in r2:
    for j in range(len(k)):
        e = Entry(r, width=10, fg='blue')
        e.grid(row=i+1, column=j+7)
        e.insert(END, k[j])
    i=i+1
def res():
    r4 = c.execute("SELECT * FROM subject NATURAL JOIN department")
    p = Entry(r, width=10)
    p.grid(row=15, column=0)
    p.insert(END, "sub_code")
    p2 = Entry(r, width=10)
    p2.grid(row=15, column=1)
    p2.insert(END, "sub_name")
    p3 = Entry(r, width=10)
    p3.grid(row=15, column=2)
    p3.insert(END, "dept_id")
    p5 = Entry(r, width=10)
    p5.grid(row=15, column=3)
    p5.insert(END, "semester")
    p6 = Entry(r, width=10)
    p6.grid(row=15, column=4)
    p6.insert(END, "dept_code")
    p7 = Entry(r, width=10)
    p7.grid(row=15, column=5)
    p7.insert(END, "dept_name")
    p8 = Entry(r, width=10)
    i = 0  # row value inside the loop
    for k in r4:
        for j in range(len(k)):
            e = Entry(r, width=10, fg='blue')
            e.grid(row=i + 16, column=j)
            e.insert(END, k[j])
        i = i + 1
    def s2():
        global root
        root = tk.Tk()
        root.title("site S2")
        root.geometry("700x500")
        r1 = c.execute("SELECT * FROM student")

        l1 = Entry(root, width=10)
        l1.grid(row=0, column=0)
        l1.insert(END, "Enrollment_id")
        l2 = Entry(root, width=10)
        l2.grid(row=0, column=1)
        l2.insert(END, "studname")
        l3 = Entry(root, width=10)
        l3.grid(row=0, column=2)
        l3.insert(END, "depatid")

        i = 0  # row value inside the loop
        for k in r1:
            for j in range(len(k)):
                e = Entry(root, width=10, fg='blue')
                e.grid(row=i + 1, column=j)
                e.insert(END, k[j])
            i = i + 1

        l = Label(root, text="                          ")
        l.grid(row=0, column=6)

        r2 = c.execute("SELECT * FROM department")
        m1 = Entry(root, width=10)
        m1.grid(row=0, column=7)
        m1.insert(END, "dept_id")
        m2 = Entry(root, width=10)
        m2.grid(row=0, column=8)
        m2.insert(END, "dept_name")

        i = 0  # row value inside the loop
        for k in r2:
            for j in range(len(k)):
                e = Entry(root, width=10, fg='blue')
                e.grid(row=i + 1, column=j + 7)
                e.insert(END, k[j])
            i = i + 1

        def res():
            r4 = c.execute("SELECT * FROM student NATURAL JOIN departtment")
            p = Entry(root, width=10)
            p.grid(row=15, column=0)
            p.insert(END, "Enrollment_id")
            p2 = Entry(root, width=10)
            p2.grid(row=15, column=1)
            p2.insert(END, "studname")
            p3 = Entry(root, width=10)
            p3.grid(row=15, column=2)
            p3.insert(END, "Dept_id")
            p5 = Entry(root, width=10)
            p5.grid(row=15, column=3)
            p5.insert(END, "dept_name")

            i = 0  # row value inside the loop
            for k in r4:
                for j in range(len(k)):
                    e = Entry(root, width=10, fg='blue')
                    e.grid(row=i + 16, column=j)
                    e.insert(END, k[j])
                i = i + 1
            def s3():
                global ro
                ro = tk.Tk()
                ro.title("site S3")
                ro.geometry("1000x600")
                r1 = c.execute("SELECT * FROM student NATURAL JOIN department")

                l1 = Entry(ro, width=10)
                l1.grid(row=0, column=0)
                l1.insert(END, "f_id")
                l2 = Entry(ro, width=10)
                l2.grid(row=0, column=1)
                l2.insert(END, "R_id")
                l3 = Entry(ro, width=10)
                l3.grid(row=0, column=2)
                l3.insert(END, "f_name")
                l4 = Entry(ro, width=10)
                l4.grid(row=0, column=3)
                l4.insert(END, "price")
                l5 = Entry(ro, width=10)
                l5.grid(row=0, column=4)
                l5.insert(END, "R_name")
                l6 = Entry(ro, width=10)
                l6.grid(row=0, column=5)
                l6.insert(END, "R_add")
                l7 = Entry(ro, width=10)
                l7.grid(row=0, column=6)
                l7.insert(END, "R_no")

                i = 0  # row value inside the loop
                for k in r1:
                    for j in range(len(k)):
                        e = Entry(ro, width=10, fg='blue')
                        e.grid(row=i + 1, column=j)
                        e.insert(END, k[j])
                    i = i + 1

                l = Label(ro, text="                          ")
                l.grid(row=0, column=7)

                r2 = c.execute("select * from orders natural join delivers")
                m1 = Entry(ro, width=10)
                m1.grid(row=0, column=8)
                m1.insert(END, "order_id")
                m2 = Entry(ro, width=10)
                m2.grid(row=0, column=9)
                m2.insert(END, "c_id")
                m3 = Entry(ro, width=10)
                m3.grid(row=0, column=10)
                m3.insert(END, "R_id")
                m4 = Entry(ro, width=10)
                m4.grid(row=0, column=11)
                m4.insert(END, "d_id")

                i = 0  # row value inside the loop
                for k in r2:
                    for j in range(len(k)):
                        e = Entry(ro, width=10, fg='blue')
                        e.grid(row=i + 1, column=j + 8)
                        e.insert(END, k[j])
                    i = i + 1

                def res():
                    r4 = c.execute("SELECT * FROM food natural join restaurant natural join orders NATURAL JOIN delivers")
                    p = Entry(ro, width=10)
                    p.grid(row=15, column=0)
                    p.insert(END, "f_id")
                    p2 = Entry(ro, width=10)
                    p2.grid(row=15, column=1)
                    p2.insert(END, "R_id")
                    p3 = Entry(ro, width=10)
                    p3.grid(row=15, column=2)
                    p3.insert(END, "f_name")
                    p5 = Entry(ro, width=10)
                    p5.grid(row=15, column=3)
                    p5.insert(END, "price")
                    p6 = Entry(ro, width=10)
                    p6.grid(row=15, column=4)
                    p6.insert(END, "R_name")
                    p7 = Entry(ro, width=10)
                    p7.grid(row=15, column=5)
                    p7.insert(END, "R_add")
                    p8 = Entry(ro, width=10)
                    p8.grid(row=15, column=6)
                    p8.insert(END, "R_no")
                    p9 = Entry(ro, width=10)
                    p9.grid(row=15, column=7)
                    p9.insert(END, "order_id")
                    p10 = Entry(ro, width=10)
                    p10.grid(row=15, column=8)
                    p10.insert(END, "c_id")
                    p11 = Entry(ro, width=10)
                    p11.grid(row=15, column=9)
                    p11.insert(END, "d_id")
                    i = 0  # row value inside the loop
                    for k in r4:
                        for j in range(len(k)):
                            e = Entry(ro, width=10, fg='blue')
                            e.grid(row=i + 16, column=j)
                            e.insert(END, k[j])
                        i = i + 1

                b = Button(ro, text="temp1 temp2", command=res).grid(row=14, column=0)
            b2 = Button(root, text="send temp1, temp2 to S3", command=s3).grid(row=26, column=5)
        b = Button(root, text="orders delivers", command=res).grid(row=14, column=0)
    b2 = Button(r, text="goto S2", command=s2).grid(row=26, column=5)
b=Button(r,text="food res",command=res).grid(row=14,column=0)

r.mainloop()
