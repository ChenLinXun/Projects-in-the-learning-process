package AnnotationTest.Parameters;

import AnnotationTest.Annotations.Animal;

@SuppressWarnings("all")
@Animal(type = "cat")
public class Cat{
    private String name;
    private String age;
}
