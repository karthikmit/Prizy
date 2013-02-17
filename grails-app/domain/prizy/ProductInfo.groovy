package prizy

class ProductInfo{

    static constraints = {

    }

    static mapping = {
        id generator: 'assigned', name: "barcode", type: 'string'
    }

    String barcode;
    String productName;
}
