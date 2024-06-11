package com.code.sample.repository;

import com.code.sample.handlers.PersonHandler;
import com.code.sample.models.PersonModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonRepositoryImp implements PersonRepository {

    private static final Logger logger = LogManager.getLogger(PersonRepositoryImp.class);

    private final PersonModel mockPersonModel = new PersonModel("Tiago", 20, "M", "SHIS Qi 27", "6199999999");
    private final PersonModel[] mockPersonModels = {
            mockPersonModel,
            mockPersonModel,
            mockPersonModel,
            mockPersonModel,
            mockPersonModel,
    };

    @Override
    public PersonModel getPerson() {
        logger.info("Acessing database to retrieve person");
        return mockPersonModel;
    }

    @Override
    public List<PersonModel> getAllPersons() {
        logger.info("Acessing database to retrieve persons");
        return List.of(mockPersonModels);
    }

    @Override
    public String getName() {
        logger.info("Acessing database to retrieve person name");
        return mockPersonModel.getName();
    }

    @Override
    public Integer getAge() {
        logger.info("Acessing database to retrieve person age");
        return mockPersonModel.getAge();
    }

    @Override
    public String getGender() {
        logger.info("Acessing database to retrieve person gender");
        return mockPersonModel.getGender();
    }
}
