package br.com.anderson.springbootwithjavaintroduction.data.vo.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dozermapper.core.Mapping;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Objects;


public class PersonVo extends RepresentationModel<PersonVo> implements Serializable {


    @JsonProperty("id")
    @Mapping("id")
    private Long key;
    private String firstName;
    private String lastName;
    private String address;
    private String gender;

    public PersonVo(){}

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonVo personVo)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getKey(), personVo.getKey()) && Objects.equals(getFirstName(), personVo.getFirstName()) && Objects.equals(getLastName(), personVo.getLastName()) && Objects.equals(getAddress(), personVo.getAddress()) && Objects.equals(getGender(), personVo.getGender());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getKey(), getFirstName(), getLastName(), getAddress(), getGender());
    }
}
