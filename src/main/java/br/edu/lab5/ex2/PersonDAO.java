package br.edu.lab5.ex2;

import java.util.ArrayList;
import java.util.List;

public class PersonDAO {
    public List<String> isValidToInclude(Person p) {
        List<String> errors = new ArrayList<>();

        // Regra 1: Nome deve ter pelo menos 2 partes e apenas letras
        String[] nameParts = p.getName().split(" ");
        if (nameParts.length < 2) {
            errors.add("Nome deve conter pelo menos duas partes.");
        }
        for (String part : nameParts) {
            if (!part.matches("[a-zA-Z]+")) {
                errors.add("Nome deve conter apenas letras.");
                break;
            }
        }

        // Regra 2: Idade no intervalo [1, 200]
        if (p.getAge() < 1 || p.getAge() > 200) {
            errors.add("Idade deve estar entre 1 e 200.");
        }

        // Regra 3: Deve ter ao menos um Email associado
        if (p.getEmails().isEmpty()) {
            errors.add("Deve conter pelo menos um email.");
        } else {
            // Regra 4: Formato do email
            for (Email email : p.getEmails()) {
                String emailStr = email.getName();
                String[] parts = emailStr.split("@");
                if (parts.length != 2 ) {
                    errors.add("Email inválido: " + emailStr);
                    continue;
                }

                String[] domainParts = parts[1].split("\\.");
                if (domainParts.length != 2 ) {
                    errors.add("Email inválido: " + emailStr);
                }
            }
        }

        return errors;
    }
}
