package de.htwberlin.webtech.gamingBud.gaming.api.service;

import de.htwberlin.webtech.gamingBud.gaming.api.persistence.Gender;
import de.htwberlin.webtech.gamingBud.gaming.api.persistence.PersonEntity;
import de.htwberlin.webtech.gamingBud.gaming.api.persistence.PetEntity;
import de.htwberlin.webtech.gamingBud.gaming.api.Person;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class PersonTransformer {

    public Person transformEntity(PersonEntity personEntity) {
        var gender = personEntity.getGender() != null ? personEntity.getGender().name() : Gender.UNKNOWN.name();
        var petIds = personEntity.getPets().stream().map(PetEntity::getId).collect(Collectors.toList());
        return new Person(
                personEntity.getId(),
                personEntity.getFirstName(),
                personEntity.getLastName(),
                gender,
                personEntity.getVaccinated(),
                petIds);
    }
}
