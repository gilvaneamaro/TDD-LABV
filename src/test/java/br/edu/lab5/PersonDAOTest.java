package br.edu.lab5;

import br.edu.lab5.ex2.Email;
import br.edu.lab5.ex2.Person;
import br.edu.lab5.ex2.PersonDAO;
import org.junit.jupiter.api.Test;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonDAOTest {
    private final PersonDAO dao = new PersonDAO();

    @Test
    public void testPessoaValida() {
        Person person = new Person(1, "Joao Silva", 30,
                List.of(new Email(1, "joao@empresa.com")));
        List<String> errors = dao.isValidToInclude(person);
        assertTrue(errors.isEmpty());
    }

    @Test
    public void testNomeComUmaParte() {
        Person person = new Person(1, "Joao", 30,
                List.of(new Email(1, "joao@empresa.com")));
        List<String> errors = dao.isValidToInclude(person);
        assertTrue(errors.contains("Nome deve conter pelo menos duas partes."));
    }

    @Test
    public void testNomeComCaracteresInvalidos() {
        Person person = new Person(1, "Joao123 Silva", 30,
                List.of(new Email(1, "joao@empresa.com")));
        List<String> errors = dao.isValidToInclude(person);
        assertTrue(errors.contains("Nome deve conter apenas letras."));
    }

    @Test
    public void testIdadeInvalidaMenorQue1() {
        Person person = new Person(1, "Joao Silva", 0,
                List.of(new Email(1, "joao@empresa.com")));
        List<String> errors = dao.isValidToInclude(person);
        assertTrue(errors.contains("Idade deve estar entre 1 e 200."));
    }

    @Test
    public void testIdadeInvalidaMaiorQue200() {
        Person person = new Person(1, "Joao Silva", 300,
                List.of(new Email(1, "joao@empresa.com")));
        List<String> errors = dao.isValidToInclude(person);
        assertTrue(errors.contains("Idade deve estar entre 1 e 200."));
    }

    @Test
    public void testSemEmails() {
        Person person = new Person(1, "Joao Silva", 30,
                Collections.emptyList());
        List<String> errors = dao.isValidToInclude(person);
        assertTrue(errors.contains("Deve conter pelo menos um email."));
    }

    @Test
    public void testEmailSemArroba() {
        Person person = new Person(1, "Joao Silva", 30,
                List.of(new Email(1, "joaoempresa.com")));
        List<String> errors = dao.isValidToInclude(person);
        assertTrue(errors.stream().anyMatch(msg -> msg.contains("Email inválido")));
    }

    @Test
    public void testEmailSemDominio() {
        Person person = new Person(1, "Joao Silva", 30,
                List.of(new Email(1, "joao@")));
        List<String> errors = dao.isValidToInclude(person);
        assertTrue(errors.stream().anyMatch(msg -> msg.contains("Email inválido")));
    }

    @Test
    public void testEmailSemPonto() {
        Person person = new Person(1, "Joao Silva", 30,
                List.of(new Email(1, "joao@empresa")));
        List<String> errors = dao.isValidToInclude(person);
        assertTrue(errors.stream().anyMatch(msg -> msg.contains("Email inválido")));
    }

    @Test
    public void testMultiplosErros() {
        Person person = new Person(1, "Joao123", 0,
                List.of(new Email(1, "emailinvalido")));
        List<String> errors = dao.isValidToInclude(person);
        assertEquals(4, errors.size());
        assertTrue(errors.contains("Nome deve conter apenas letras."));
        assertTrue(errors.contains("Idade deve estar entre 1 e 200."));
        assertTrue(errors.stream().anyMatch(msg -> msg.contains("Email inválido")));
    }
}
