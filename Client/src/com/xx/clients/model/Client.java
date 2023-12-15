package com.xx.clients.model;

import java.util.StringJoiner;

public record Client(String surnameAndInitials, String address, int phoneNumber,
                     long creditCardNumber, String bankAccountNubmer) {

  @Override
  public String toString() {
    return new StringJoiner(", ", "Клієнт ", "")
        .add("ПІБ: '%s'".formatted(surnameAndInitials))
        .add("Адреса: '%s'".formatted(address))
        .add("Номер телефону: '%d'".formatted(phoneNumber))
        .add("Номер кредитної картки: '%s'".formatted(creditCardNumber))
        .add("Номер банківського рахунку: '%s'".formatted(bankAccountNubmer))
        .toString();
  }
}