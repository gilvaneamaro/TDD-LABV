package br.edu.lab5;

import br.edu.lab5.ex1.Triangulo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TrianguloTeste {

    @Test
    public void testTrianguloEscalenoValido() {
        assertEquals("Escaleno", Triangulo.tipoTriangulo(3, 4, 5));
    }

    @Test
    public void testTrianguloIsoscelesValido1() {
        assertEquals("Isósceles", Triangulo.tipoTriangulo(5, 5, 3));
    }

    @Test
    public void testTrianguloEquilatero() {
        assertEquals("Equilátero", Triangulo.tipoTriangulo(6, 6, 6));
    }

    @Test
    public void testTrianguloIsoscelesPermutacao1() {
        assertEquals("Isósceles", Triangulo.tipoTriangulo(5, 3, 5));
    }

    @Test
    public void testTrianguloIsoscelesPermutacao2() {
        assertEquals("Isósceles", Triangulo.tipoTriangulo(3, 5, 5));
    }

    @Test
    public void testValorZero() {
        assertEquals("Não é um triângulo", Triangulo.tipoTriangulo(0, 4, 5));
    }

    @Test
    public void testValorNegativo() {
        assertEquals("Não é um triângulo", Triangulo.tipoTriangulo(-3, 4, 5));
    }

    @Test
    public void testSomaDoisLadosIgualAoTerceiro1() {
        assertEquals("Não é um triângulo", Triangulo.tipoTriangulo(2, 3, 5));
    }

    @Test
    public void testSomaDoisLadosIgualAoTerceiro2() {
        assertEquals("Não é um triângulo", Triangulo.tipoTriangulo(5, 2, 3));
    }

    @Test
    public void testSomaDoisLadosIgualAoTerceiro3() {
        assertEquals("Não é um triângulo", Triangulo.tipoTriangulo(3, 5, 2));
    }

    @Test
    public void testSomaDoisLadosMenorQueTerceiro1() {
        assertEquals("Não é um triângulo", Triangulo.tipoTriangulo(2, 2, 5));
    }

    @Test
    public void testSomaDoisLadosMenorQueTerceiro2() {
        assertEquals("Não é um triângulo", Triangulo.tipoTriangulo(5, 2, 2));
    }

    @Test
    public void testSomaDoisLadosMenorQueTerceiro3() {
        assertEquals("Não é um triângulo", Triangulo.tipoTriangulo(2, 5, 2));
    }

    @Test
    public void testTodosOsLadosZero() {
        assertEquals("Não é um triângulo", Triangulo.tipoTriangulo(0, 0, 0));
    }
}