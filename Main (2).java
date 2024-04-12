package person;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //person p1 = new person("Tang", "Piseth", "Seth", "Student");
        /*person p1 = new person("Sok", "Rachana", "Rach", "Also a student");
        System.out.print("Rachana's information: ");
        System.out.println(p1.F_name + "\t" + p1.L_name + "\t" + p1.N_name + "\t" + p1.get_job);
        System.out.println("--------------------------------------");*/
        /*p1.F_name = "Tang";
        p1.L_name = "piSeTh"; // ----> write a program to turn this into Piseth (first letter is capitalized and every other letter is not in small-caps)
        p1.N_name  = "Seth";
        p1.get_job = "Student";
        System.out.printf("%10S %10S %10S %10S", p1.F_name, p1.L_name, p1.N_name, p1.get_job);*/
        /*p1.setF_name("Tang");
        System.out.println("Therefore ====> your first name is " + p1.getF_name());
        p1.setL_name("Piseth");
        p1.setN_name("Seth");
        p1.setGet_job("Student");
        String first_name = p1.getF_name();
        String last_name = p1.getL_name();
        String nick_name = p1.getN_name();
        String job = p1.getGet_job();
        ArrayList<String> p_information = new ArrayList<>();
        p_information.add(first_name);
        p_information.add(last_name);
        p_information.add(nick_name);
        p_information.add(job);
        System.out.println(p_information);
*/
        System.out.println("\n\n------------------Write a program to capitalize the first letter of each word---------------");
        person p3 = new person("chArLeS", "daRwiN", "cD", "biOlOgisT");
        System.out.println(p3.F_name);
        System.out.println("---------");
        demo2();

        /*Chained constructor: */
        demo3();

    }


    public static void demo1(person per){

    }
    public static void demo2(){
        person p2 = new person("joRdAN", "Peterson", "You know who", "Clinical Psychologist");
        System.out.println(p2.F_name);
    }
    public static void demo3(){
        person p3 = new person("taNg", "pIsetH");
        System.out.println(p3.F_name);
    }
}