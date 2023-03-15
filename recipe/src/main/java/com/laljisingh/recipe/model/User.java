package com.laljisingh.recipe.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;
    @NotNull(message = "name not null")
    @NotBlank(message = "User name not blanks")
    private String name;
    @NotNull(message = "email not null")
    @Email(message = "please provide valid emails")
    private String email;
    @NotNull(message = "phone not null")
    @Length(message = "must be 10 digit")
    @Min(10)
    private String phone;
    @NotNull(message = "address not null")
    private String address;

}
