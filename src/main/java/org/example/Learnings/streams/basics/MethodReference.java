package org.example.Learnings.streams.basics;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//Use method without invoking and in place of lambda expression.
public class MethodReference {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<String> models = Arrays.asList("Samsung", "Apple", "Nokia", "Sony", "LG", "HTC", "Micromax", "Motorola", "Lenovo", "Oppo");

        //this is normal way using lambda
        numbers.forEach(x-> System.out.println(x));

        //this is using method reference
        numbers.forEach(System.out::println);

        //normal way using lambda
        List<MobilePhone> phones = models.stream().map(x -> new MobilePhone(x)).collect(Collectors.toList());

        //Constructor reference
        List<MobilePhone> phones2 = models.stream().map(MobilePhone::new).collect(Collectors.toList());


    }

}

class MobilePhone {
    String model;
    MobilePhone(String model) {
        this.model = model;
    }
}
