package br.com.dio.exception;

public class GlobalExceptionHandler {

    public static void register() {
        Thread.setDefaultUncaughtExceptionHandler((thread, throwable) -> {
            System.err.println(String.format("Ocorreu um erro inesperado: %s", throwable.getMessage()));
            System.err.println("Por favor, verifique os logs para mais detalhes.");
        });
    }
}
