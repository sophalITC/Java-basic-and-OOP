package com.prasertcbs;

/**
 * Created by prasert on 10/16/2014.
 */
public class MemberCard {
    private String firstName, lastName;

    @Override
    public String toString() {
        return String.format("firstName = %s, lastName = %s", firstName, lastName);
//        return super.toString();
    }

    public MemberCard(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public MemberCard() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public float discount(float amount) {
        if (amount > 1000f) {
            return amount * .02f;
        } else {
            return 0f;
        }
    }
}
