package com.xx.clients.ui;

import com.xx.clients.logic.EmployeeData;
import com.xx.clients.model.Client;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;

public class CLI {

  private static final Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);

  public static void init() {
    getClientSurnameAndInitialsPrint();
    getCreditCadrNumberPrint();
  }

  public static void getClientSurnameAndInitialsPrint() {
    List<Client> sortedClients = EmployeeData.getAllClientsSortedAlphabetically();
    sortedClients.forEach(client -> System.out.println(client.surnameAndInitials()));
  }

  private static int getCreditCadrNumberPrint() {
    long creditCardNumber1, creditCardNumber2;

    System.out.println("Введіть початок діапазону номеру кредитної картки: ");
    creditCardNumber1 = scanner.nextLong();

    System.out.println("Введіть кінець діапазону номеру кредитної картки: ");
    creditCardNumber2 = scanner.nextLong();

    if (creditCardNumber1 > creditCardNumber2) {
      long temp = creditCardNumber1;
      creditCardNumber1 = creditCardNumber2;
      creditCardNumber2 = temp;

      System.out.println("Початоком діапазону не може бути більшим ніж кінець");
      creditCardNumber1 = getCreditCadrNumberPrint();
    }

    List<Client> clients = EmployeeData.getCreditCardNumber(creditCardNumber1, creditCardNumber2);

    for (Client client : clients) {
      System.out.printf("%s%n", client);
    }

    return 1;
  }
}