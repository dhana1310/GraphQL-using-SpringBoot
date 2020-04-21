package com.asyouwish.graphQL.resolvers;

import com.asyouwish.graphQL.models.Orientation;
import com.asyouwish.graphQL.models.SuperCharacter;
import com.asyouwish.graphQL.models.SuperGroup;
import com.asyouwish.graphQL.repository.SuperCharacterRepository;
import com.asyouwish.graphQL.repository.SuperGroupRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Mutation implements GraphQLMutationResolver {

    private SuperCharacterRepository superCharacterRepository;
    private SuperGroupRepository superGroupRepository;

    public SuperCharacter addCharacter(String name, Integer age, String groupName) {

       return this.superCharacterRepository.addCharacter(name, age, groupName);
    }

    public SuperGroup addGroup(String name, Orientation orientation) {
        return superGroupRepository.addGroup(name, orientation);
    }

    public Boolean removeCharacter(String id) {
        return superCharacterRepository.removeCharacter(id);
    }


}
