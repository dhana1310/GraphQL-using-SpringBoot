package com.asyouwish.graphQL.repository;

import com.asyouwish.graphQL.models.Orientation;
import com.asyouwish.graphQL.models.SuperCharacter;
import com.asyouwish.graphQL.models.SuperGroup;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Component
@Slf4j
public class SuperCharacterRepository {

    private final List<SuperCharacter> superCharacterList = new ArrayList<>();

    @Autowired
    private SuperGroupRepository superGroupRepository;

    public SuperCharacterRepository() {
        populateSuperCharacterList();
    }

    private void populateSuperCharacterList() {

        SuperCharacter c1 = SuperCharacter.builder().id("Dhananjay").name("Dhananjay").age(25)
                .group(SuperGroup.builder().name("Marvels").orientation(Orientation.HERO).members(Collections.emptyList()).build())
                .build();
        this.superCharacterList.add(c1);

        SuperCharacter c2 = SuperCharacter.builder().id("Famia").name("Famia").age(24)
                .group(SuperGroup.builder().name("DC").orientation(Orientation.HERO).members(Collections.emptyList()).build())
                .build();
        this.superCharacterList.add(c2);

    }

    public List<SuperCharacter> getSuperCharacterList() {
        return this.superCharacterList;
    }

    public SuperCharacter getCharacterById(String id) {

        return this.superCharacterList.stream()
                .filter(superCharacter -> superCharacter.getId().equals(id)).findFirst().orElse(null);
    }

    public SuperCharacter addCharacter(String name, Integer age, String groupName) {

        SuperGroup superGroup = superGroupRepository.groupByName(groupName);
        SuperCharacter superCharacter = SuperCharacter.builder().id(name + (this.getSuperCharacterList().size() + 1))
                .name(name).age(age).group(superGroup).build();
        this.getSuperCharacterList().add(superCharacter);

        if (superGroup != null) {
            superGroup.addCharacter(superCharacter);
        }
        return superCharacter;
    }

    public Boolean removeCharacter(String id) {

        Predicate<SuperCharacter> superCharacterPredicate = superCharacter -> superCharacter.getId().equalsIgnoreCase(id);
        Optional<SuperCharacter> superCharacterOptional = superCharacterList.stream()
                .filter(superCharacterPredicate)
                .findFirst();

        superCharacterOptional.filter(superCharacter -> superCharacter.getGroup() != null).ifPresent(superCharacter ->
                superGroupRepository.groupByName(superCharacter.getGroup().getName())
                        .removeCharacter(superCharacter)
        );
        superCharacterList.removeIf(superCharacterPredicate);
        return superCharacterOptional.isPresent();
    }


}
