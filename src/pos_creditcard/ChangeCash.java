package pos_creditcard;

public abstract class ChangeCash {
  protected double change;
  protected CashBox cashBox;
  public abstract int[] change ();
  protected final double[] keys = {0.01, 0.02, 0.05, 0.10, 0.20, 0.50, 1.0, 2.0, 5.0, 10.0, 20.0};
  public ChangeCash(double change, CashBox cashBox) {
    this.change = change;
    this.cashBox = cashBox;
  }
}
