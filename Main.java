import java.util.Scanner;

class BankAccount{
    private int balance;

    public BankAccount(int intialAmount){
        this.balance = intialAmount;
   }
    public int balance(){
        return balance;
    }

    public void deposite(int amount){
        if (amount > 0){
            balance += amount;
            System.out.println("Deposite of" + amount + "Rs was succesful");
        } else {
            System.out.println("Invalid entry!. Please choose an number above 0 ");
        }
    } 

    public void withdraw(int amount){
        if (amount > 0 && amount < balance){
            System.out.println("withdraw succesfull" +amount+"Rs");
            amount -= balance;
        }else{
            System.out.println("Invalid entry!!. Insuffucient balance or negative value entered ");
        }
    }

}
class ATM{

    private BankAccount account; // this creates a which can only be used in ATM class
    public ATM(BankAccount account){
        this.account = account;
    }
   public void display(){
    System.out.println("selected options");
    System.out.println("1.Deposite");
    System.out.println("2.Check Balance");
    System.out.println("3.Withdraw");
    System.out.println("4.Leave");
   }
   
   public void run(){
        Scanner sc = new Scanner(System.in);
          int option; 
          do {
            display();
            System.out.println("Pick an opton");
            option = sc.nextInt();
                 
            switch (option){
                case 1:
                      System.out.println("Current balance "  +account.balance());
                      break;
                case 2:
                      System.out.println("Enter amount to deposite ");  
                      int depositeAmount = sc.nextInt();
                      account.deposite(depositeAmount);
                      break;
                case 3:
                    System.out.println("Enter amount to withdraw");
                    int withdrawAmount = sc.nextInt();
                    account.withdraw(withdrawAmount);
                case 4: 
                        System.out.println("Thanks for working with SBI Bank"); 
                        break;
                default:
                System.out.println("Invalid enrty!!. Enter only the given option");        

            }
          }while (option != 4);
          sc.close();;
   }
}


public class Main {

    public static void main(String[] args){
        BankAccount userAccount = new  BankAccount(3000);
        ATM atm = new ATM(userAccount);
        atm.run();
    }
    
}
