package com.example.padroesprojetospringdesafio.outros.adapter;

import java.util.Scanner;

// Antiga classe de conversão que só suporta a conversão de USD para GBP
class OldCurrencyConverter {
    public double convertUSDtoGBP(double amount) {
        return amount * 0.80; // 80% do valor em USD
    }
}

class EuroCurrencyConverter {
    public double convertUSDtoEUR(double amount) {
        return amount * 0.85; // 80% do valor em USD
    }
}

// Novo adaptador que usa a antiga conversão e aplica a taxa adicional de GBP para EUR
class CurrencyAdapter {
    private final OldCurrencyConverter oldConverter;

    public CurrencyAdapter(OldCurrencyConverter oldConverter) {
        this.oldConverter = oldConverter;
    }
}

class ConverterToEuro extends EuroCurrencyConverter{
    private final EuroCurrencyConverter euroCurrencyConverter;

    public ConverterToEuro(EuroCurrencyConverter euroCurrencyConverter) {
        this.euroCurrencyConverter = euroCurrencyConverter;
    }
}


class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double input = Double.parseDouble(scanner.nextLine());

       ConverterToEuro converterToEuro = new ConverterToEuro(new EuroCurrencyConverter());


       double valorConvertido = converterToEuro.convertUSDtoEUR(input);

        System.out.println("USD: " + input);
        System.out.println("EUR: " + valorConvertido);
    }
}