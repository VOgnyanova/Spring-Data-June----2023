package org.example;

import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        Persistence.createEntityManagerFactory("university_system")
                .createEntityManager();
    }
}
