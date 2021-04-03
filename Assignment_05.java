package assignment_05;
import java.util.*;

import java.util.stream.*;  
class Fruit{
    String name;
    int calories;
    int price;
    String color;
    Fruit(String name,int calories,int price,String color){
        this.name=name;
        this.calories=calories;
        this.price=price;
        this.color=color;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getCalories() {
        return calories;
    }
    public void setCalories(int calories) {
        this.calories = calories;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    @Override
    public String toString(){
        return this.getName()+" "+this.getCalories()+" "+this.getPrice()+" "+this.getColor();
    }
}

class News{
    int newsid;
    String postedByUser;
    String commentByUser;
    String comment;
    News(int newsid,String postedByUser,String commentByUser,String comment){
        this.newsid=newsid;
        this.postedByUser=postedByUser;
        this.commentByUser=commentByUser;
        this.comment=comment;
    }
    public int getNewsid() {
        return newsid;
    }
    public void setNewsid(int newsid) {
        this.newsid = newsid;
    }
    public String getPostedByUser() {
        return postedByUser;
    }
    public void setPostedByUser(String postedByUser) {
        this.postedByUser = postedByUser;
    }
    public String getCommentByUser() {
        return commentByUser;
    }
    public void setCommentByUser(String commentByUser) {
        this.commentByUser = commentByUser;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    
}

class Trader{
    String name,city;
    Trader(String name,String city){
        this.name=name;
        this.city=city;
    }
    

    @Override
	public String toString() {
		return "Trader [name=" + name + ", city=" + city + "]";
	}


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getCity() {
        return city;
    }


    public void setCity(String city) {
        this.city = city;
    }
}

class Transaction{
    int year,value;
    Trader trader;
    Transaction(Trader trader,int year,int value){
        // super();
        this.trader = trader;
        this.year=year;
        this.value=value;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public Trader getTrader() {
        return trader;
    }
    public void setTrader(Trader trader) {
        this.trader = trader;
    }
    @Override
	public String toString() {
		return "Transaction [trader=" + trader + ", year=" + year + ", value=" + value + "]";
	}

}

/**
 * assignment5
 */
public class Assignment_05 {
    public static void main(String[] args) {
        System.out.println("*********Question1********");
        List<Fruit> fruitlist = new ArrayList<>();
        fruitlist.add(new Fruit("Apple", 150, 100, "Red"));
        fruitlist.add(new Fruit("Orange", 50, 50, "Orange"));
        fruitlist.add(new Fruit("Banana", 120, 20, "Yellow"));
        fruitlist.add(new Fruit("Grapes", 20, 100, "green"));
        fruitlist.stream()
                    .filter(c ->c.calories<100)
                    .map(c-> c.calories)
                    .sorted(Comparator.reverseOrder())
                    .forEach(System.out::println);
        
        System.out.println("*********Question2********");
        Map<Object, List<Fruit>> colorFruit = fruitlist.stream()
                .sorted(Comparator.comparing(Fruit::getColor))
                .collect(Collectors.groupingBy(Fruit::getColor));
        System.out.println(colorFruit);

        System.out.println("*********Question3********");
        fruitlist.stream().filter(c->c.color.equals("Red")).map(c->c.toString()).forEach(System.out::println);

        System.out.println("*********Question4********");
        List<News> newslist = new ArrayList<>();
        newslist.add(new News(101, "a", "a", "aa"));
        newslist.add(new News(101,"a","a","aa"));
        newslist.add(new News(102,"b","b","bb"));
        newslist.add(new News(103,"c","c","cc"));
        newslist.add(new News(104,"d","d","dd"));

        System.out.println(newslist.stream().collect(Collectors.groupingBy((News n)->n.getNewsid(),Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey());

        System.out.println("*********Question5********");
        System.out.println(newslist.stream().filter((News n)->n.getComment().contains("budgets")).count());;

        System.out.println("*********Question6********");
        Integer newsId = newslist.stream().collect(Collectors.groupingBy((News n)->n.getNewsid(),Collectors.counting()))
                                          .entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey(); 
        System.out.println(newsId);

        System.out.println("*********Question7********");
        Map<String,Long> commentbyuser = newslist.stream().collect(Collectors.groupingBy((News n)-> n.getCommentByUser(),Collectors.counting()));
        System.out.println(commentbyuser);

        System.out.println("*********Question8********");
        List<Transaction> transactions = new ArrayList<Transaction>();
		transactions.add(new Transaction(new Trader("a", "a"), 2011, 10000));
		transactions.add(new Transaction(new Trader("b", "Delhi"), 2012, 50000));
		transactions.add(new Transaction(new Trader("Kunal", "Delhi"), 2013, 25000));
		transactions.add(new Transaction(new Trader("d", "Pune"), 2014, 5000));
		transactions.add(new Transaction(new Trader("c", "Pune"), 2015, 75000));
		transactions.add(new Transaction(new Trader("f", "Indore"), 2016, 100000));

        transactions.stream().filter((Transaction t)->t.getYear()==2011).sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("*********Question9********");
        System.out.println(transactions.stream().map((Transaction t)->t.getTrader()).map((Trader T)->T.city).distinct().collect(Collectors.toList()));

        System.out.println("*********Question10********");
        System.out.println(transactions.stream().filter((Transaction t)->t.trader.city.equals("Pune"))
                                                    .map((Transaction t)->t.getTrader()).sorted(Comparator.comparing(Trader::getName))
                                                    .collect(Collectors.toList()));

        System.out.println("*********Question11********");
        System.out.println(transactions.stream().map((Transaction t)->t.getTrader())
                                                .map((Trader T)->T.name)
                                                .collect(Collectors.toList()));

        System.out.println("*********Question12********");
        System.out.println(transactions.stream().filter((Transaction t)->t.getTrader().getCity().equals("Indore")).findAny());

        System.out.println("*********Question13********");
        System.out.println(transactions.stream().filter((Transaction t)->t.getTrader().getCity().equals("Delhi"))
                                                .collect(Collectors.toList()));

                    
        System.out.println("*********Question14********");
        System.out.println(transactions.stream().collect(Collectors.groupingBy(value->value.getValue(),Collectors.counting()))
                                                .entrySet()
                                                .stream()
                                                .min(Map.Entry.comparingByKey()).get().getKey());

        
    }
}

