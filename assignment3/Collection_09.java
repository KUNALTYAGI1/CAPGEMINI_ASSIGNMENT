package collection_a;
import java.util.*;
//import java.io.*;
//import java.util.Iterator;

class SavingAccount implements Comparable<SavingAccount>{
 int acc_balance;
 int acc_id;
 String accountholdername;
 boolean issalaryAccount;
 SavingAccount(int acc_balance,int acc_id,String accountholdername,boolean issalaryAccount){
     this.acc_balance=acc_balance;
     this.acc_id=acc_id;
     this.accountholdername=accountholdername;
     this.issalaryAccount=issalaryAccount;
 }
 public int getAcc_balance() {
     return acc_balance;
 }
 public void setAcc_balance(int acc_balance) {
     this.acc_balance = acc_balance;
 }
 public int getAcc_id() {
     return acc_id;
 }
 public void setAcc_id(int acc_id) {
     this.acc_id = acc_id;
 }
 public String getAccountholdername() {
     return accountholdername;
 }
 public void setAccountholdername(String accountholdername) {
     this.accountholdername = accountholdername;
 }
 public boolean isIssalaryAccount() {
     return issalaryAccount;
 }
 public void setIssalaryAccount(boolean issalaryAccount) {
     this.issalaryAccount = issalaryAccount;
 }

 public int compareTo(SavingAccount p) {  
     if(acc_id>p.acc_id){  
         return 1;  
     }else if(acc_id<p.acc_id){  
         return -1;  
     }else{ 
         return 0;
     }  
 
}
}

/**
* Collection9
*/

//collection9 == BankAccountList
public class Collection_09 {

 public static void main(String[] args) {
     TreeSet<SavingAccount> saving= new TreeSet<SavingAccount>();
     SavingAccount sa1 = new SavingAccount(100, 1, "a1", true);
     SavingAccount sa2 = new SavingAccount(100, 4, "a2", true);
     SavingAccount sa3 = new SavingAccount(100, 3, "a3", true);

     saving.add(sa1);
     saving.add(sa2);
     saving.add(sa3);

     // Collections.sort(saving,new acc_idcomparator());

     for (SavingAccount p:saving){
         System.out.println(p.acc_balance+" "+p.acc_id+" "+p.accountholdername+" "+p.issalaryAccount);
     }

 }
 
}

