public class Clothing extends Product{
    private int size;
    private String colour;

    public Clothing(String productID, String productName, int NoOfProductsAvailable, double price,int size, String colour) {
        super(productID,productName,NoOfProductsAvailable,price);
        this.size = size;
        this.colour = colour;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
    @Override
    public String getType(){
        return "Clothing";
    }
}
