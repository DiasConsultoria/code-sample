package com.code.sample.repository;

import com.code.sample.models.PersonModel;

import java.util.List;

public interface PersonRepository {

    PersonModel getPerson();

    List<PersonModel> getAllPersons();

    String getName();

    Integer getAge();

    String getGender();

}
