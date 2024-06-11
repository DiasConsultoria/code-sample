package com.code.sample.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonModel {

    private String name;
    private int age;
    private String gender;
    private String address;
    private String phone;

    @Override
    public String toString() {
        return "PersonModel [name=" + name + ", age=" + age + ", gender=" + gender + ", address=" + address;
    }
}
