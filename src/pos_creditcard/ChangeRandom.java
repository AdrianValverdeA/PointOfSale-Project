package pos_creditcard;
import java.sql.Array;
import java.util.HashMap;

public class ChangeRandom extends ChangeCash {
  public ChangeRandom(double change, CashBox cashBox) {
    super(change, cashBox);
  }


  public int[] change() {
    int[] changes = new int[keys.length];
    int securityInfiniteLoop = 0;
    while (change > 0) {
      HashMap<Double, Integer> cb = cashBox.getCashbox();
      int i = (int) (Math.random() * 11);
      change = Math.round(change * 100.0) / 100.0;
      if (change >= keys[i]) // faltaria comprovacio caixa, pero surt un comentari
      {
        if (cb.get(keys[i]) + changes[i] > 0)
        {
          changes[i] -= 1;
          change -= keys[i];
          change = Math.round(change * 100.0) / 100.0;
        }
        else{
          securityInfiniteLoop++;
          if (securityInfiniteLoop > 100)
          {
            changes[i] -= 1;

            break;
          }
        }
      }
    }
    return changes;
  }
}