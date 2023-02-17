package com.example.child1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class Person {
    private String name;
    private int age;
    private String email;
}
