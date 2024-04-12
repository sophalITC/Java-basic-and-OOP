package com.prasertcbs;

/**
 * Created by prasert on 10/16/2014.
 */
public class SilverCard extends MemberCard {
    @Override
    public float discount(float amount) {
        if (amount > 2000f) {
            return amount * .03f;
        } else {
            return 0f;
        }
    }
}
