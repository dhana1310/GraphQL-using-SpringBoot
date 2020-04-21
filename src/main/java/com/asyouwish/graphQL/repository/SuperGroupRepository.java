package com.asyouwish.graphQL.repository;

import com.asyouwish.graphQL.models.Orientation;
import com.asyouwish.graphQL.models.SuperCharacter;
import com.asyouwish.graphQL.models.SuperGroup;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@Slf4j
public class SuperGroupRepository {

    private final List<SuperGroup> superGroupList = new ArrayList<>();

    public SuperGroupRepository() {
        populateSuperGroupList();
    }

    private void populateSuperGroupList() {

        SuperGroup c1 = SuperGroup.builder().name("Marvels").orientation(Orientation.HERO)
                .members(Collections.singletonList(SuperCharacter.builder().id("Dhananjay").name("Dhananjay").age(25).build()))
                .build();
        this.superGroupList.add(c1);

        SuperGroup c2 = SuperGroup.builder().name("DC").orientation(Orientation.HERO)
                .members(Collections.singletonList(SuperCharacter.builder().id("Famia").name("Famia").age(24).build()))
                .build();
        this.superGroupList.add(c2);

        SuperGroup c3 = SuperGroup.builder().name("Thanos").orientation(Orientation.VILLAIN).build();
        this.superGroupList.add(c3);

    }

    public List<SuperGroup> groups() {
        return this.superGroupList;
    }

    public SuperGroup groupByName(String name) {
        return this.superGroupList.stream().filter(group -> group.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }
    public SuperGroup addGroup(String name, Orientation orientation) {
        SuperGroup newSuperGroup = SuperGroup.builder().name(name).orientation(orientation).build();
        this.superGroupList.add(newSuperGroup);
        return newSuperGroup;
    }
}
