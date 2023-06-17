package pages.components;

import com.github.javafaker.Faker;

public class RandomUtilsFaker {
    public static String getName() {
        return new Faker().name().firstName();
    }

    public static String getLastName(){
        return new Faker().name().lastName();
    }

    public static String getEmail(){
        return new Faker().internet().emailAddress();
    }

    public static String getNumber(){
        return new Faker().phoneNumber().subscriberNumber(10);
    }

    public static String getAddress(){
        return new Faker().address().fullAddress();
    }
}
