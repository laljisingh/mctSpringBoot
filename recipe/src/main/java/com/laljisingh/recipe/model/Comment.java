package com.laljisingh.recipe.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer comment_id;
    @NotNull(message = "comment not null")
    @NotBlank(message = "comment not blank")
    private String comment;
    @ManyToMany(cascade = CascadeType.ALL)
    List<User> userList = new ArrayList<>();
    @ManyToMany(cascade = CascadeType.ALL)
    List<Recipe> reciepList = new ArrayList<>();
}
