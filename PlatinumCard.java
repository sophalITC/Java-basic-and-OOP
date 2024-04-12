package com.prasertcbs;

/**
 * Created by prasert on 10/16/2014.
 */
public class PlatinumCard extends MemberCard {
    // annotation
    @Override
    public float discount(float amount) {
        return amount * .05f;
    }
}
