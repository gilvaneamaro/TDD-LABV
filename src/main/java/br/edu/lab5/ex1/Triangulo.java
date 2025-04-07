package br.edu.lab5.ex1;


public class Triangulo {

    public static String tipoTriangulo(int a, int b, int c) {
        if (!formaTriangulo(a, b, c)) {
            return "Não é um triângulo";
        }

        if (a == b && b == c) {
            return "Equilátero";
        } else if (a == b || a == c || b == c) {
            return "Isósceles";
        } else {
            return "Escaleno";
        }
    }

    private static boolean formaTriangulo(int a, int b, int c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }
}
