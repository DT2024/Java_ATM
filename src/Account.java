import java.util.Date;
import java.util.Scanner;

public class Account {
    //creating private variables
	private int id;
	private double balance;
	private static double annualInterestRate;
	private Date dateCreated;
	
	//no args constructor to create default account
	public Account() {
	    this(0, 0);
	}

	//creating default constructor with the specified id and balance
	public Account(int id, int balance) {
		this.id=id;
		this.balance=balance;
		this.annualInterestRate=0;
		this.dateCreated= new Date();
	}
	//creating getters and setters for all of the private data(accessors)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	//creating a getmonthlyInterestrate with the return 
	public double getMonthlyInterestRate() {
		return annualInterestRate/12/100;
	}//creating a getmonthlyInterest with  the return
	public double getMonthlyInterest() {
		return balance *getMonthlyInterestRate();
	}
	//creating a method of withdrawing a money
	public void Withdraw(double amount) {
		if (amount>0 && amount<=balance) {
			balance-=amount;
		} else {
			System.out.println("Insufficient amount to withdraw try sgain later!");
		}
	} //creating a method of depositing money
	public void Deposit(double amount) {
		if(amount>0) {
		balance+=amount;}
	}
	//main method, to prompt the user to enter details and run the program
	public static void main (String [] args) {
		//needed to create an array of the object Account class, that's why can't be used as int account []=new int[10];
		Account[] accounts=new Account[10];
		for(int i=0; i<accounts.length;i++) {
			//as I created before, constructor with the specified id and balance, I can mention that all accounts 
			//have starting amount of 100$, with any id including 9
			accounts[i]=new Account(i,100);
		}
		Scanner sc=new Scanner(System.in);
		
		while(true) {//while (true) in order to keep the loop, until the specified action done to be done
			System.out.println("Please enter your id:");
			int enterId=sc.nextInt();
			if (enterId>= 0&& enterId<accounts.length) {
				int choice;
				do {
					
					System.out.println("\nMain menu");
                    System.out.println("1: Check Balance");
                    System.out.println("2: Withdraw");
                    System.out.println("3: Deposit");
                    System.out.println("4: Exit");
                    System.out.print("Enter a choice: ");
                    choice = sc.nextInt();
                    switch (choice) {
                    case 1:
                        System.out.println("Balance: $" + accounts[enterId].getBalance());
                        break;
                    case 2:
                        System.out.print("Enter an amount to withdraw: $");
                        double withdrawAmount = sc.nextDouble();
                        accounts[enterId].Withdraw(withdrawAmount);
                        break;
                    case 3:
                        System.out.print("Enter an amount to deposit: $");
                        double depositAmount = sc.nextDouble();
                        accounts[enterId].Deposit(depositAmount);
                        break;
                    case 4:
                        System.out.println("Exiting main menu.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            } while (choice != 4);//if choice is not between 1-4, it will execute an error
        }     else {
            System.out.println("Invalid id. Please enter a correct id.");
        }
				}
			}
		}



