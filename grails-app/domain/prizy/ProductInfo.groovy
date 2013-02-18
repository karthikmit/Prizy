package prizy

class ProductInfo{

    static mapping = {
        id generator: 'assigned', name: "barcode", type: 'string'
    }

    String barcode;
    String productName;

    static constraints = {
        barcode(blank: false, maxSize: 30,nullable: false)
        productName(blank: false, maxSize: 25,nullable: false)
    }
}
