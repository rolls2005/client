package com.xx.clients.logic;

import com.xx.clients.model.Client;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeData {

  private static final Client[] clients = {
      new Client("Іванов І.І.", "вул. Прикладна, 123", 763814295, 4852763901278345L, "UA7382150946321876"),
      new Client("Петров П.П.", "вул. Тестова, 456", 215683791, 9021567438291076L, "UA987654321098765432"),
      new Client("Сидоров С.С.", "вул. Зразкова, 789", 570298461, 6347802159834761L, "UA5096238745612038"),
      new Client("Коваленко К.К.", "вул. Прикладна, 987", 984327615, 1589346720457839L, "UA8467302159873412"),
      new Client("Сергієнко С.С.", "вул. Тестова, 111", 649372518, 7264908132546079L, "UA1234987650298765"),
      new Client("Мельник М.М.", "вул. Зразкова, 222", 108927534, 3091856745823012L, "UA6578321098745632"),
      new Client("Антонов А.А.", "вул. Прикладна, 345", 432765981, 5432167890123456L, "UA3941856720562108"),
      new Client("Григоренко Г.Г.", "вул. Тестова, 789", 796145302, 7612058349670124L, "UA2109876543897654"),
  };

  public static List<Client> getAllClientsSortedAlphabetically() {
    return Arrays.stream(clients)
        .sorted((c1, c2) -> c1.surnameAndInitials().compareToIgnoreCase(c2.surnameAndInitials()))
        .collect(Collectors.toList());
  }

  public static List<Client> getCreditCardNumber(long creditCardNumber1, long creditCardNumber2) {
    return Arrays.stream(clients)
        .filter(
            client -> creditCardNumber1 <= client.creditCardNumber() && client.creditCardNumber() <= creditCardNumber2)
        .toList();
  }
}