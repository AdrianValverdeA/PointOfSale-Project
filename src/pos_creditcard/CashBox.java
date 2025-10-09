package pos_creditcard;
import java.util.Arrays;
import java.util.HashMap;

public class CashBox {
  private HashMap<Double, Integer> cashbox = new HashMap<>();
  private final double[] keys = {0.01, 0.02, 0.05, 0.10, 0.20, 0.50, 1.0, 2.0, 5.0, 10.0, 20.0};

  public CashBox() {
    cashbox.put(0.01, 5);
    cashbox.put(0.02, 5);
    cashbox.put(0.05, 5);
    cashbox.put(0.1, 5);
    cashbox.put(0.2, 5);
    cashbox.put(0.5, 5);
    cashbox.put(1.0, 5);
    cashbox.put(2.0, 5);
    cashbox.put(5.0, 2);
    cashbox.put(10.0, 2);
    cashbox.put(20.0, 2);
  }

  public HashMap<Double, Integer> getCashbox() {
    return cashbox;
  }
  public void takeBill(double amount)
  {
    int[] changes = new int[keys.length];
    for(int i = (keys.length - 1); i >= 0; i--)
    {
      while (amount >= keys[i])
      {
        changes[i] += 1;
        amount -= keys[i];
        amount = Math.round(amount * 100.0) / 100.0;
      }
    }
    update(changes);
  }

  public void update(int[] changes) {
    for (int i = 0; i < changes.length; i++) {
      if (changes[i] != 0) {
        cashbox.replace(keys[i], cashbox.get(keys[i]) + changes[i]);
        if (cashbox.get(keys[i]) < 0)
        {
          System.out.println("No tienes monedas suficientes de " + keys[i]);
        }

      }
    }
    cashBoxAmounts();
  }

  public void cashBoxAmounts() {
    System.out.println("Contenido de la caja:");

    for (int i = 0; i < keys.length; i++) {
      System.out.println(cashbox.get(keys[i]) + " of " + keys[i]);

    }

  }
}
