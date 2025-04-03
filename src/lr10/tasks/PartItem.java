package lr10.tasks;

public class PartItem {
    public String name;
    public String category;
    public String description;
    public String price;

    public PartItem() {
        name = "";
        category = "";
        description = "";
        price = "";
    }

    public PartItem(String name, String category, String description, String price) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
    }
}
