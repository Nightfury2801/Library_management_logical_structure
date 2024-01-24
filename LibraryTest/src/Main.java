import java.util.*;


class Book {
    String bno;
    String bname;
    String aname;
    boolean available=true;
    Book(String bno,String bname,String aname){
        this.bno=bno;
        this.aname=aname;
        this.bname=bname;
    }

    Book(){
        Scanner input = new Scanner(System.in);
        System.out.println("\nNEW BOOK ENTRY...");
        System.out.print("Enter The book no.: ");
        bno = input.nextLine();
        System.out.print("\nEnter The Name of The Book: ");
        bname = input.nextLine();
        System.out.print("Enter The Author's Name: ");
        aname = input.nextLine();
        System.out.println("\nBook Created..");
    }

    public void showBook() {
        System.out.println("Book no.: " + bno);
        System.out.println("Book Name: " + bname);
        System.out.println("Author Name: " + aname);
    }

    public void modifyingBook() {
        System.out.println("Book no.: " + bno);
        Scanner input = new Scanner(System.in);
        System.out.print("Modify Book Name: ");
        bname = input.nextLine();
        System.out.print("Modify Author's Name of Book: ");
        aname = input.nextLine();
    }

}

class Student {
    String admno;
    String name;
    List<String> stbno=new ArrayList<>();
    int token;

    Student(String admno,String name){
        this.admno=admno;
        this.name=name;
        this.token=0;

    }

    Student() {
        Scanner input = new Scanner(System.in);
        System.out.println("\nNEW STUDENT ENTRY...");
        System.out.print("Enter The admission no.: ");
        admno = input.nextLine();
        System.out.print("Enter The Name of The Student: ");
        name = input.nextLine();
        token = 0;
        System.out.println("Student Record Created..");
    }

    public void showStudent() {
        System.out.println("Admission no.: " + admno);
        System.out.println("Student Name: " + name);
        System.out.println("No of Book issued: " + token);
        if (token >= 1) {
            System.out.println("Book No " + stbno);
        }
    }

    public void modifyingStudent() {
        System.out.println("Admission no.: " + admno);
        Scanner input = new Scanner(System.in);
        System.out.print("Modify Student Name: ");
        name = input.nextLine();
    }

}

class LibraryTest {
    static ArrayList<Book> bk=new ArrayList<Book>();
    static ArrayList<Student> st=new ArrayList<Student>();

    public static void writeStudent(String admissionNo,String studentName) {
        Student studentTemp= new Student(admissionNo,studentName);
        st.add(studentTemp);
    }
    public static void displayAllStudent(){
        for (Student s:st) {
            s.showStudent();
        }
    }
    public static void displaySps(String admissionNo){
        int i=0,flag=0;
        while(i<st.size()){
            if(st.get(i).admno.equals(admissionNo)){
                flag=1;
                st.get(i).showStudent();
                break;
            }
            i++;
        }
        if(flag==0){
            System.out.println("Student not found");
        }
    }
    public static void modifyStudent(String admissionNo){
        int i=0,flag=0;
        while(i<st.size()){
            if(st.get(i).admno.equals(admissionNo)){
                flag=1;
                break;
            }
            i++;
        }
        if(flag==0){
            System.out.println("Student not found");
        }
        else{
            st.get(i).modifyingStudent();
        }
    }
    public static void deleteStudent(String admissionNo){
        int i=0,flag=0;
        while(i<st.size()){
            if(st.get(i).admno.equals(admissionNo)){
                flag=1;
                break;
            }
            i++;
        }
        if(flag==0){
            System.out.println("Student not found");
        }
        else{
            st.remove(i);
        }
    }
    public static void writeBook(String bookNo, String bookName, String authorName) {
        Book bookTemp= new Book(bookNo,bookName,authorName);
        bk.add(bookTemp);
    }
    public static void displayAllBook(){
        for (Book b:bk) {
            b.showBook();
        }
    }
    public static void displaySpb(String bookNo){
        int i=0,flag=0;
        while(i<bk.size()){
            if(bk.get(i).bno.equals(bookNo)){
                flag=1;
                bk.get(i).showBook();
                break;
            }
            i++;
        }
        if(flag==0){
            System.out.println("Book not found");
        }
    }
    public static void modifyBook(String bookNo){
        int i=0,flag=0;
        while(i<bk.size()){
            if(bk.get(i).bno.equals(bookNo)){
                flag=1;
                break;
            }
            i++;
        }
        if(flag==0){
            System.out.println("Book not found");
        }
        else{
            bk.get(i).modifyingBook();
        }
    }
    public static void deleteBook(String bookNo){
        int i=0,flag=0;
        while(i<bk.size()){
            if(bk.get(i).bno.equals(bookNo)){
                flag=1;
                break;
            }
            i++;
        }
        if(flag==0){
            System.out.println("Book not found");
        }
        else{
            bk.remove(i);
        }
    }
    public static void bookIssue(String admissionNo) {
        Scanner input = new Scanner(System.in);
        String bookNo;
        int i = 0, flag = 0;
        while(i<st.size()) {
            if(st.get(i).admno.equals(admissionNo)) {
                flag=1;
                System.out.println("\nBOOK ISSUE ...");
                System.out.print("Enter The book number of book you want to borrow: ");
                bookNo = input.next();
                if(st.get(i).stbno.size()<5) {
                    int j = 0,flag2=0;
                    while (j < bk.size()) {
                        if (bk.get(j).bno.equals(bookNo)) {
                            flag2=1;
                            if (bk.get(j).available) {
                                bk.get(j).available = false;
                                st.get(i).stbno.add(bk.get(j).bno);
                                st.get(i).token+=1;
                            } else {
                                System.out.println("Book not available at the moment!");
                                return;
                            }
                        }
                        j++;

                    }
                    if(flag2==0){
                        System.out.println("Book not found!");
                        return;
                    }
                }
                else{
                    System.out.println("You have already borrowed 5 books. Pls return books to issue new ones!");
                    return;
                }
                break;
            }
            i++;
        }
        if(flag==0){
            System.out.println("Student not found!");
        }
    }

    public static void bookDeposit(String admissionNo) {
        Scanner input = new Scanner(System.in);
        int whichBook;
        int i = 0, flag = 0;
        while(i<st.size()) {
            if(st.get(i).admno.equals(admissionNo)) {
                if (!(st.get(i).stbno.isEmpty())) {
                    flag = 1;
                    System.out.println("\nBook Deposit ...");
                    int index = 0;

                    while (index < st.get(i).stbno.size()) {
                        System.out.println(index + " " + st.get(i).stbno.get(index));
                        index++;
                    }
                    System.out.println("Enter which book you want to return");
                    whichBook = input.nextInt();
                    Student student = st.get(i);
                    String depBook = "";
                    try {
                        depBook = student.stbno.get(whichBook);
                    } catch (Exception e) {
                        System.out.println("Pls enter valid serial number!");
                        bookDeposit(admissionNo);
                    }
                    int j = 0;
                    while (j < bk.size()) {
                        if (bk.get(j).bno.equals(depBook)) {
                            bk.get(j).available = true;
                            System.out.println("Deposit successful");
                            st.get(i).stbno.remove(whichBook);
                            return;
                        }
                        j++;

                    }

                    break;
                }
                else{
                    System.out.println("You have no books to deposit!");
                    return;
                }
            }

            i++;
        }
        if(flag==0){
            System.out.println("Student not found!");
        }
    }

    public static void adminMenu() {
        Scanner input = new Scanner(System.in);

        System.out.println("\n\nADMINISTRATOR MENU");
        System.out.println("1. CREATE STUDENT RECORD");
        System.out.println("2. DISPLAY ALL STUDENTS RECORD");
        System.out.println("3. DISPLAY SPECIFIC STUDENT RECORD");
        System.out.println("4. MODIFY STUDENT RECORD");
        System.out.println("5. DELETE STUDENT RECORD");
        System.out.println("6. CREATE BOOK");
        System.out.println("7. DISPLAY ALL BOOKS");
        System.out.println("8. DISPLAY SPECIFIC BOOK");
        System.out.println("9. MODIFY BOOK");
        System.out.println("10. DELETE BOOK");
        System.out.println("11. BACK TO MAIN MENU");
        System.out.print("Please Enter Your Choice (1-11): ");
        int ch2 = input.nextInt();
        switch(ch2){
            case 1:{
                String name,admissionNo;
                System.out.println("Enter name of student:");
                name=input.next();
                System.out.println("Enter Admission No:");
                admissionNo=input.next();
                writeStudent(admissionNo,name);
                break;
            }
            case 2:{
                displayAllStudent();
                break;
            }
            case 3:{
                String num;
                System.out.println("Pls enter admission number:");
                num = input.next();
                displaySps(num);
                break;
            }
            case 4: {
                String num;
                System.out.println("Pls enter admission number:");
                num = input.next();
                modifyStudent(num);
                break;
            }
            case 5: {
                String num;
                System.out.println("Pls enter admission number:");
                num = input.next();
                deleteStudent(num);
                break;
            }
            case 6: {
                String bName,bNo,authorName;
                System.out.println("Enter name of Book:");
                bName=input.next();
                System.out.println("Enter name of author:");
                authorName=input.next();
                System.out.println("Enter Book No:");
                bNo=input.next();
                writeBook(bNo,bName,authorName);
                break;
            }
            case 7: {
                displayAllBook();
                break;
            }
            case 8: {
                String num;
                System.out.println("Please Enter The book No. ");
                num=input.next();
                displaySpb(num);
                break;
            }
            case 9: {
                String num;
                System.out.println("Please Enter The book No. ");
                num=input.next();
                modifyBook(num);
                break;
            }
            case 10: {
                String num;
                System.out.println("Please Enter The book No. ");
                num=input.next();
                deleteBook(num);
                break;
            }
            case 11: {
                return;
            }
            default: {
                System.out.println("Option doesn't exist try again!");
            }
        }
        adminMenu();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int ch;

        do {
            System.out.println("\n\n\nMAIN MENU");
            System.out.println("1. BOOK ISSUE");
            System.out.println("2. BOOK DEPOSIT");
            System.out.println("3. DISPLAY ALL BOOKS");
            System.out.println("4. ADMINISTRATOR MENU");
            System.out.println("5. EXIT");
            System.out.print("Please Select Your Option (1-5): ");
            ch = input.nextInt();

            switch (ch) {
                case 1: {
                    String admissionNo;
                    System.out.println("Enter your admission number:");
                    admissionNo=input.next();
                    bookIssue(admissionNo);
                    break;
                }
                case 2: {
                    String admissionNo;
                    System.out.println("Enter your admission number:");
                    admissionNo=input.next();
                    bookDeposit(admissionNo);
                    break;
                }
                case 3:{
                    displayAllBook();
                    break;
                }
                case 4: {
                    adminMenu();
                    break;
                }
                case 5: {
                    System.exit(0);
                    break;
                }
                default:
                    System.out.println("\nInvalid option. Please select a valid option.");
            }
        } while (true);
    }
}