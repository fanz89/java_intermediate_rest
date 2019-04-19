package com.mif.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Employees")
public class Employees {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employeeId;

    @Size(min = 3, max = 50)
    private String firstname;

    @Size(min = 3, max = 50)
    private String lastname;

    @Size(min = 3, max = 50)
    private String title;

    @Size(min = 10, max = 30)
    private String workPhone;

    @JsonIgnore
    @OneToMany(mappedBy = "employees")
    private List<Employees> employees = new ArrayList<>();

}
