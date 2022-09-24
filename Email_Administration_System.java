import java.util.Scanner;
import java.io. File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedWriter;
// nilanjanvyas
 class Email{
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix = "nirmauni.ac.in";

    // constructor to receive the first name and last name;

      public Email(String firstName, String lastName)
    {
      this.firstName= firstName ;
      this.lastName=  lastName;
      //System.out.println("Email CREATED:"+ this.firstName+ ""+ this.lastName);

      // call a method asking for the department - return department:
      this.department= setDepartment();
        System.out.println("Department: "+this.department);

     // call a method that returns a random password
        this.password = randomPassword(defaultPasswordLength);

    //  Combine element to generate Email:
        email = firstName.toLowerCase()+ "" + lastName.toLowerCase() + "@" + department +"."+companySuffix;
    }
    // Ask for the department ;
    private String  setDepartment()
    {
        System.out.print("Enter the department \n1 for sale \n2 for Development \n3 for Accounting \n0 for none\nEnter the department code:");
        Scanner sc= new Scanner(System.in);
        int depChoice= sc.nextInt();
        if(depChoice==1)
        {
            return "sales";
        }
        else if(depChoice==2)
        {
            return "dev";
        }
        else if(depChoice==3)
        {
            return "acct";
        }
        else
        {
            return "";
        }
    }
    // Generate a random password;
    private String randomPassword(int length)
    {
        String passwordSet= "ABCDEFGHIJKLMANOPQRSTUVXYZ0123456789@#$%";
        char[] password = new char[length];
        for(int i=0;i<length;i++)
        {
            int rand = (int)(Math.random() * passwordSet.length());
            password[i]= passwordSet.charAt(rand);
        }
        return  new String(password);
    }

    // set the mailbox capacity:
    public void setMailboxCapacity(int capacity)
    {
        this.mailboxCapacity = capacity;
    }

    // set the alternative email:
    public void setAlternateEmail(String altEmail)
    {
        this.alternateEmail = altEmail;
    }

    //change the password:
    public void changePassword(String password)
    {
        this.password= password;
    }

    public int getMailboxCapacity()
    {
        return  mailboxCapacity;
    }
    public String getAlternateEmail()
    {
        return alternateEmail;
    }
    public String getPassword()
    {
        return password;
    }
    public String showInfo()
    {
        return "DISPLAY NAME:"+ firstName+ " "+ lastName +
                "\nCOMPANY EMAIL : "+ email +
                "\nMailBox CAPACITY:"+ mailboxCapacity +   "mb"+
                "\nPassowrd:"+password+
                "\nAlternate email:"+alternateEmail;
    }
}

 public class innovative
 {

   public static void main(String[] args)
   {
       Scanner sc=new Scanner(System.in);
       String a,b,c,f;
       int x,y,d,e,choice;
       System.out.print("enter no. of employee:");
       choice=sc.nextInt();
         Email em1[] = new Email[choice];
         for(int z=0;z<choice;z++){
       System.out.print("Enter first name: ");
       a=sc.next();
       System.out.print("Enter last name: ");
       b=sc.next();
       em1[z]=new Email(a,b); 
       System.out.println(em1[z].showInfo());
    
      System.out.print("Do you want to change password(1 for yes/2 for no):");
      x=sc.nextInt();
          if(x==1)
          {
              System.out.print("Enter new password:");
              c=sc.next();
                em1[z].changePassword(c);
          }
          else{
              System.out.println("Password not changed");
          }
          System.out.print("Do you want to change mailbox capacity(1 for yes/2 for no):");
      y=sc.nextInt();
          if(y==1)
          {
              System.out.print("Enter new capacity:");
              d=sc.nextInt();
                em1[z].setMailboxCapacity(d);
          }
          else{
              System.out.println("Capacity not changed");
          }
          System.out.print("Do you want to add alternate email(1 for yes/2 for no):");
          e=sc.nextInt();
          if(e==1)
          {
              System.out.print("Enter alt email:");
              f=sc.next();
                em1[z].setAlternateEmail(f);
          }
          else{
              System.out.println("No alternate email added");
          }
         }
 File myFile = new File("Email.txt");
  try
  {
    myFile.createNewFile();
  }
  catch(IOException i)
  {
      System.out.println("unable to create this File");
      i.printStackTrace();
  }

  try
  {
      FileWriter fileWriter = new FileWriter("Email.txt");
     
      PrintWriter printWriter = new PrintWriter(fileWriter);


    
      for(int z1=0;z1<choice;z1++){
            printWriter.println(em1[z1].showInfo());
           
          
      }
      printWriter.close();
      
      fileWriter.close();
  }
  catch (IOException i)
  {
      i.printStackTrace();
  }
       
         System.out.println("Info updated in Email.txt file"); 
    
   }

}

