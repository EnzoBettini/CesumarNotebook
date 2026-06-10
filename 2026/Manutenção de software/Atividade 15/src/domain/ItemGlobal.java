package domain;

public class ItemGlobal {
    private String sku;
    private String description;
    private double priceInDollars;
    private int availableUnits;

    public ItemGlobal(String sku, String description, double priceInDollars, int availableUnits) {
        this.sku = sku;
        this.description = description;
        this.priceInDollars = priceInDollars;
        this.availableUnits = availableUnits;
    }

    public String getSku() {
        return sku;
    }

    public String getDescription() {
        return description;
    }

    public double getPriceInDollars() {
        return priceInDollars;
    }

    public int getAvailableUnits() {
        return availableUnits;
    }
}
