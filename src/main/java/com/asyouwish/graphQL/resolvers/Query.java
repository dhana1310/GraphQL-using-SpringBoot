package com.asyouwish.graphQL.resolvers;

import com.asyouwish.graphQL.models.SuperCharacter;
import com.asyouwish.graphQL.models.SuperGroup;
import com.asyouwish.graphQL.repository.SuperCharacterRepository;
import com.asyouwish.graphQL.repository.SuperGroupRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component  // will be treated as bean
@AllArgsConstructor  // using Constructor Dependency Injection
public class Query implements GraphQLQueryResolver {

    private SuperCharacterRepository superCharacterRepository;
    private SuperGroupRepository superGroupRepository;

    public List<SuperCharacter> characters() {

        return this.superCharacterRepository.getSuperCharacterList();
    }

    public SuperCharacter charactersById(String id) {

        return this.superCharacterRepository.getCharacterById(id);
    }

    public List<SuperGroup> groups() {
        return this.superGroupRepository.groups();
    }

    public SuperGroup groupByName(String name) {
        return this.superGroupRepository.groupByName(name);
    }
}

