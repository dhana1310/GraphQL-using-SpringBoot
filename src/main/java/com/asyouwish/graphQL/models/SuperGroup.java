package com.asyouwish.graphQL.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Builder
@AllArgsConstructor
public class SuperGroup {

    private String name;
    private Orientation orientation;
    private List<SuperCharacter> members;

    public void addCharacter(SuperCharacter superCharacter) {
        if(this.members == null){
            this.members = new ArrayList<>();
        }

        if(superCharacter != null) {
            this.members.add(superCharacter);
        }

    }

    public void removeCharacter(SuperCharacter superCharacter) {
        if(this.members != null && superCharacter != null){
            this.members.removeIf(character -> character.getName().equalsIgnoreCase(superCharacter.getName()));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SuperGroup that = (SuperGroup) o;
        return name.equalsIgnoreCase(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
