package attractions;

import behaviours.ISecurity;
import behaviours.ITicketed;
import people.Visitor;

public class Dodgems extends Attraction implements ITicketed, ISecurity {

    public Dodgems(String name, int rating) {
        super(name, rating);
    }

    @Override
    public double defaultPrice() {
        return 4.5;
    }

    @Override
    public double priceFor(Visitor visitor) {
        if (visitor.getAge() > 12) {
            return defaultPrice();
        }
        else return defaultPrice() / 2;
    }

    @Override
    public boolean isAllowedTo(Visitor visitor) {
        return true;
    }
}
