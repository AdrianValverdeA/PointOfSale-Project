package pos_creditcard;
import java.sql.Array;
import java.util.HashMap;

public class ChangeGreedy extends ChangeCash {

  public ChangeGreedy(double change, CashBox cashBox) {
    super(change, cashBox);
  }

  public int[] change() {
    int[] changes = new int[keys.length];
    HashMap<Double, Integer> cb = cashBox.getCashbox();
    for (int i = (keys.length-1); i >= 0; i--) {
      while (change >= keys[i]) {
        if (cb.get(keys[i])+changes[i] > 0)
        {
          changes[i] -= 1;
          change -= keys[i];
          change = Math.round(change * 100.0) / 100.0;
        }
        else{
          break;
        }
      }
    }

    return changes;
  }
}