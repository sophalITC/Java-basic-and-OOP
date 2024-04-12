package person;

public class person {
    public String F_name, L_name,N_name, get_job;


    public person(String f_name, String l_name, String n_name, String get_job) {
        System.out.println("person constructor has been invoked");
        this.setF_name(f_name.trim().substring(0,1).toUpperCase() + f_name.trim().substring(1).toLowerCase());
        this.setL_name(l_name);
        this.setN_name(n_name);
        this.setGet_job(get_job);
    }

    /*public person(String f_name, String n_name) {
        F_name = f_name;
        N_name = n_name;
    }*/

    //chained constructor
    public person(String f_name, String n_name){
        this(f_name, "", n_name, "");
    }
    public person(String f_name, String l_name, String n_name){

    }
    //in one class, create many constructors

    public person(){

    }

    public String getF_name() {
        return F_name;
    }

    public void setF_name(String f_name) {
        this.F_name = f_name;
    }

    public String getL_name() {
        return L_name;
    }

    public void setL_name(String l_name) {
        L_name = l_name;
    }

    public String getN_name() {
        return N_name;
    }
    //in Setter we can use RE to remove 092-265-275....easy for data engineering
    public void setN_name(String n_name) {
        N_name = n_name;
    }
    //overwrite and overloading methods



    public String getGet_job() {
        return get_job;
    }

    public void setGet_job(String get_job) {
        this.get_job = get_job;
    }

}
