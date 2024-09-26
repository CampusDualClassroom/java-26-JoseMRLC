package com.campusdual.classroom;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    private Map<String, Contact> contacts;

    public Phonebook() {
        this.contacts = new HashMap<>();
    }


    public void addContact(Contact contact) {
        contacts.put(contact.getCode(), contact);
    }

    // Método para eliminar un contacto por código
    public void deleteContact(String code) {
        contacts.remove(code);
    }

    // Método para mostrar todos los contactos
    public void showPhonebook() {
        if (contacts.isEmpty()) {
            System.out.println("El listín telefónico está vacío.");
        } else {
            System.out.println("Contactos en el listín telefónico:");
            for (Contact contact : contacts.values()) {
                contact.showContactDetails();
                System.out.println();
            }
        }
    }


    public Map<String, Contact> getData() {
        return contacts;
    }



}
