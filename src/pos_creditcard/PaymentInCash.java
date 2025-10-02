package pos_creditcard;

public class PaymentInCash extends Payment {
  double amountHanded;
  private CashBox cashBox;

  public PaymentInCash(double amountHanded, double amountToPay, CashBox cashBox) {
    super(amountToPay);
    assert amountHanded >= amountToPay;
    this.amountHanded = amountHanded;
    this.cashBox = cashBox;
  }


  private double change() {
    double change = amountHanded - amountToPay;
    assert change >= 0;
    cashBox.takeBill(amountHanded);
    //ChangeGreedy changeMethod = new ChangeGreedy(change, cashBox);
    ChangeRandom changeMethod = new ChangeRandom(change, cashBox);
    int changes[] = changeMethod.change();
    cashBox.update(changes);
    return change;
  }

  @Override
  public void print() {
    System.out.printf("\nAmount handed : %.2f\nChange : %.2f\n", amountHanded, change());
  }
}
