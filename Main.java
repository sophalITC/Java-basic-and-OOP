package com.prasertcbs;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        demo1();
        demoCard();
    }

    public static void demoCard() {
        PlatinumCard p1 = new PlatinumCard();
        System.out.println("Platinum: " + p1.discount(1000f));

        GoldCard g1 = new GoldCard();
        System.out.println("Gold    : " + g1.discount(2000f));

        SilverCard s1 = new SilverCard();
        System.out.println("Silver  : " + s1.discount(3000f));
    }
    public static void demo1() {
        MemberCard m1 = new MemberCard("Peter", "Parker");
        System.out.println(m1.toString());
    }
}
