import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CurrencyConverter converter = new CurrencyConverter();

        Map<Integer, String[]> options = Map.of(
                1, new String[]{"USD", "BRL"},
                2, new String[]{"BRL", "USD"},
                3, new String[]{"EUR", "BRL"},
                4, new String[]{"BRL", "EUR"},
                5, new String[]{"BRL", "ARS"},
                6, new String[]{"ARS", "BRL"}
        );

        System.out.println("Bem-vindo ao Conversor de Moedas!");
        System.out.println("Escolha uma opção:");
        options.forEach((key, value) ->
                System.out.println(key + " - " + value[0] + " para " + value[1]));

        int choice = scanner.nextInt();
        if (!options.containsKey(choice)) {
            System.out.println("Opção inválida.");
            return;
        }

        System.out.print("Digite o valor a ser convertido: ");
        double amount = scanner.nextDouble();

        try {
            double result = converter.convert(
                    options.get(choice)[0],
                    options.get(choice)[1],
                    amount
            );
            System.out.printf("Valor convertido: %.2f %s\n", result, options.get(choice)[1]);
        } catch (Exception e) {
            System.out.println("Erro na conversão: " + e.getMessage());
        }

        scanner.close();
    }
}
