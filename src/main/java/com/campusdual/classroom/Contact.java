package com.campusdual.classroom;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class Contact{
    private String name;
    private String surname;
    private String phoneNumber;
    private String code;

    public Contact(String name, String surname, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.code = generateContactCode();
    }

    private String generateContactCode() {

        StringBuilder stringBuilder = new StringBuilder();
        String normalizedName = removeAccents(name);
        String normalizedSurname = removeAccents(surname);


        String primera_letra_nombre = String.valueOf(normalizedName.toLowerCase().charAt(0));
        stringBuilder.append(primera_letra_nombre);
        String[] apellidos = normalizedSurname.split(" ");
        for (int i = 0; i < apellidos.length; i++) {
            if (apellidos.length > 1) {
                if (i == 0) {
                    stringBuilder.append(apellidos[i].toLowerCase().charAt(0));
                } else {
                    stringBuilder.append(apellidos[i].toLowerCase());
                }
            } else {
                stringBuilder.append(apellidos[i].toLowerCase());
            }
        }

        return stringBuilder.toString();
    }





    public void callMyNumber() {
        System.out.println("Llamando a " + name + " " + surname + " al número " + phoneNumber);
    }

    public void callOtherNumber(String otherPhoneNumber) {
        System.out.println("Llamando al número " + otherPhoneNumber + " para " + name + " " + surname);
    }


    public void showContactDetails() {
        System.out.println("Detalles del contacto:");
        System.out.println("Nombre: " + name);
        System.out.println("Apellido: " + surname);
        System.out.println("Teléfono: " + phoneNumber);
        System.out.println("Código: " + code);
    }

    public String getName() {
        return name;
    }

    public String getSurnames() {
        return surname;
    }

    public String getPhone() {
        return phoneNumber;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "Nombre: " + name + ", Apellido: " + surname + ", Teléfono: " + phoneNumber + ", Código: " + code;
    }
    private String removeAccents(String input) {
        if (input == null) return null;

        // Normalizar el texto para eliminar tildes
        String normalized = Normalizer.normalize(input, Normalizer.Form.NFD);
        // Crear un patrón para eliminar caracteres diacríticos (acentos)
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");

        // Reemplazar los caracteres acentuados por sus equivalentes no acentuados
        String cleaned = pattern.matcher(normalized).replaceAll("");
        // Mantener solo letras, espacios y guiones
        return cleaned.replaceAll("[^a-zA-Z- ]", "");
    }

}
