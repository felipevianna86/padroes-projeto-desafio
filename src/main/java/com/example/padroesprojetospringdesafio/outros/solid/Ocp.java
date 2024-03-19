package com.example.padroesprojetospringdesafio.outros.solid;

import java.util.Scanner;

/** Classe base para descontos (aberto para extensões) */
class Discount {
    public double calculateDiscount(double originalValue) {
        return originalValue; // No default discount
    }
}

/** Classe derivada para desconto de estudante (10%). */
final class StudentDiscount extends Discount {
    // TODO: Substituir o método aberto "calculateDiscount" com base nesta responsabilidade final da classe.
    @Override
    public double calculateDiscount(double originalValue) {
        return originalValue * 0.9; // No default discount
    }
}

/** Classe derivada para desconto de afiliado (15%). */
final class MembershipDiscount extends Discount {
    // Substitua o método aberto "calculateDiscount" com base nesta responsabilidade final da classe.
    @Override
    public double calculateDiscount(double originalValue) {
        return originalValue * 0.85; // No default discount
    }
}

public class Ocp {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            String discountType = scanner.next();
            double originalValue = scanner.nextDouble();

            // Aplicação OCP: Criando uma instância com base no tipo de desconto fornecido
            Discount discount = null;
            if ("student".equals(discountType)) {
                discount = new StudentDiscount();
            } else if ("membership".equals(discountType)) {
                discount = new MembershipDiscount();
            }

            if(discount != null){
                double discountValue = discount.calculateDiscount(originalValue);
                System.out.printf("%.2f", discountValue);
            }

        }
    }
}