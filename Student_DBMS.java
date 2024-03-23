import java.util.Scanner;
import java.io.FileWriter;
import java.io.File;
class Student_DBMS
{
    static int N=0;
    static Scanner scan=new Scanner(System.in);
    static class student
    {
        static String[] name=new String[100];
        static int[] roll=new int[100];
        static String[] grade=new String[100];
    }
    static class StudentManagementSystem
    {
        student o=new student();
        void add(int n)
        {
            System.out.print("\nADD STUDENT\n");
            for(int i=0;i<n;i++)
            {
                System.out.println("\nSTUDENT "+(i+1));
                System.out.print("\nenter name: ");
                String name=scan.next();
                System.out.print("\nenter roll number: ");
                int roll=scan.nextInt();
                System.out.print("\nenter grade: ");
                String grade=scan.next();
                N++;
                o.name[N-1]=name;
                o.roll[N-1]=roll;
                o.grade[N-1]=grade;
            }
        }
        void display()
        {
            System.out.println("\nDISPLAY ALL STUDENTS\n");
            for(int i=0;i<N;i++)
            {
                System.out.print("\nSTUDENT "+(i+1));
                System.out.print("\nname: ");
                System.out.print(o.name[i]);
                System.out.print("\nroll number: ");
                System.out.print(o.roll[i]);
                System.out.print("\ngrade: ");
                System.out.print(o.grade[i]);
            }
        }
        int search()
        {
            System.out.print("\nSEARCH STUDENT\n");
            System.out.print("\nenter roll number of the student: ");
            int r=scan.nextInt();
            for(int i=0;i<N;i++)
            {
                if(o.roll[i]==r)
                {
                    System.out.print("\n\nSTUDENT FOUND");
                    System.out.print("\nname: ");
                    System.out.print(o.name[i]);
                    System.out.print("\nroll number: ");
                    System.out.print(o.roll[i]);
                    System.out.print("\ngrade: ");
                    System.out.print(o.grade[i]);
                    return 0;
                }
            }
            System.out.print("\nSTUDENT NOT FOUND");
            return 0;
        }
        int remove()
        {
            System.out.println("\nREMOVE STUDENT\n");
            System.out.print("\nenter roll number of the student: ");
            int r=scan.nextInt();
            for(int i=0;i<N;i++)
            {
                if(o.roll[i]==r)
                {
                    for(int j=i;j<N-1;j++)
                    {
                        o.name[j]=o.name[j+1];
                        o.roll[j]=o.roll[j+1];
                        o.grade[j]=o.grade[j+1];
                    }
                    N--;
                    System.out.print("\nSTUDENT REMOVED");
                    return 0;
                }
            }
            System.out.print("\nSTUDENT NOT FOUND");
            return 0;
        }
        int edit()
        {
            System.out.print("\nUPDATE STUDENT DETAILS\n");
            System.out.print("\nenter roll number of the student: ");
            int r=scan.nextInt();
            for(int i=0;i<N;i++)
            {
                if(o.roll[i]==r)
                {
                    System.out.println("\nSTUDENT "+(i+1));
                    System.out.print("\nenter name: ");
                    String name=scan.next();
                    System.out.print("\nenter roll number: ");
                    int roll=scan.nextInt();
                    System.out.print("\nenter grade: ");
                    String grade=scan.next();
                    o.name[i]=name;
                    o.roll[i]=roll;
                    o.grade[i]=grade;
                    System.out.print("\nSTUDENT DETAILS UPDATED");
                    return 0;
                }
            }
            System.out.println("\nSTUDENT NOT FOUND");
            return 0;
        }
        void store()
        {
            try
            {
            FileWriter f=new FileWriter("student.txt");
            student o=new student();
            f.write(N+"\n");
            for(int i=0;i<N;i++)
            {
                f.write(o.name[i]+"\n");
                f.write(o.roll[i]+"\n");
                f.write(o.grade[i]+"\n");
            }
            f.close();
            System.out.print("\nDATA HAS BEEN STORED");
            }
            catch(Exception e)
            {
                System.out.print("\nUNABLE TO STORE DATA");
            }
        }
        void load()
        {
            try
            {
            student o=new student();
            File f=new File("student.txt");
            Scanner scan=new Scanner(f);
            N=Integer.parseInt(scan.nextLine());
            for(int i=0;i<N;i++)
            {
                o.name[i]=scan.nextLine();
                o.roll[i]=Integer.parseInt(scan.nextLine());
                o.grade[i]=scan.nextLine();
            }
            scan.close();
            System.out.print("\nDATA HAS BEEN LOADED");
            }
            catch(Exception e)
            {
                System.out.print("\nUNABLE TO LOAD DATA");
            }
        }
    }
    public static void main(String[] args)
    {
        System.out.println("STUDENT MANAGEMENT SYSTEM");
        StudentManagementSystem o=new StudentManagementSystem();
        while(true)
        {
            System.out.println("\n1. ADD STUDENT\n2. REMOVE STUDENT\n3. SEARCH STUDENT\n4. DISPLAY ALL STUDENTS\n5. EDIT STUDENT DETAILS\n6. STORE DATA\n7. LOAD DATA\n8. EXIT");
            int choice=scan.nextInt();
            switch(choice)
            {
                case 1:System.out.print("\nenter number of students: ");
                    int n=scan.nextInt();
                    o.add(n);
                    break;
                case 2:o.remove();
                    break;
                case 3:o.search();
                    break;
                case 4:o.display();
                    break;
                case 5:o.edit();
                    break;
                case 6:o.store();
                    break;
                case 7:o.load();
                    break;
                case 8:System.out.print("\nTHANK YOU!!!!!");
                    System.exit(0);
                default:System.out.print("\nINVALID CHOICE");
                    break;
            }
            System.out.println("");
        }
    }
}