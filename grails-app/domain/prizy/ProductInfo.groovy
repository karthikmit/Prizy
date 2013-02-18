package prizy

class ProductInfo{

    static constraints = {
        barcode(blank: false)
        productName(blank: false, maxSize: 25)
    }

    static mapping = {
        id generator: 'assigned', name: "barcode", type: 'string'
    }

    String barcode;
    String productName;
}
