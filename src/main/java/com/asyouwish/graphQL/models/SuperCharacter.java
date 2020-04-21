package com.asyouwish.graphQL.models;

import lombok.Builder;
import lombok.Data;

import java.util.Objects;

@Data
@Builder
public class SuperCharacter {

    private String id;
    private String name;

    private Integer age;

    private SuperGroup group;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SuperCharacter that = (SuperCharacter) o;
        return id.equalsIgnoreCase(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
