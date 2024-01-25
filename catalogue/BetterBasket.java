package catalogue;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;

/**
 * Write a description of class BetterBasket here.
 * BetterBasket is an extension of Basket which has two enhancements:
 * <ol>
 * <li> it merges multiple instances of the same product into a single record
 * <li> it sorts the record by ProductNum
 * <ol>
 * 
 * @author  landry Nsengiyumva
 * @version 1.0
 */
public class BetterBasket extends Basket implements Serializable, Comparator<Product> {
  private static final long serialVersionUID = 1L;

  // You need to add code here

  @Override
  public boolean add(Product p1) {
    // search existing products for matching record 
    for (Product p2 : this) {
      if (p1.getProductNum().equals(p2.getProductNum())) {
        // found - update quantity and return 
        p2.setQuantity(p2.getQuantity() + p1.getQuantity());
        return true;
      }
    }

    // not found - add new product, using superclass method
    super.add(p1);
    // sorting the list
    // we turn BetterBasket into a Comparator object,
    // and give it a compare method to order products 
    Collections.sort(this, this);
    return true;
  }

  @Override
  public int compare(Product p1, Product p2) {
    // Delegate comparison to the Basket class
    return p1.getProductNum().compareTo(p2.getProductNum());
  }
}
