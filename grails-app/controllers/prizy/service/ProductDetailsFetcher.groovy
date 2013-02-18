package prizy.service

import prizy.Product
import prizy.ProductDetails
import prizy.ProductInfo
import prizy.service.IdealPriceCalculationStrategy
import prizy.service.NormalIdealPriceCalculation

class ProductDetailsFetcher {

    static constraints = {
    }

    IdealPriceCalculationStrategy idealPriceCalculationStrategy = new NormalIdealPriceCalculation();

    ProductDetailsFetcher() {

    }

    def fetchProductDetails(String barcode) {
        List<Double> prices = getAllPricesFor(barcode);
        Collections.sort(prices);

        println "totalcount" + prices.size()

        if (prices.size() <= 0) {
            return null;
        }

        ProductDetails productDetails = new ProductDetails();

        productDetails.highPrice = prices.get(prices.size() - 1);
        productDetails.lowPrice = prices.get(0);
        productDetails.avgPrice = findAvgPrice(prices);
        productDetails.idealPrice = calculateIdealPrice(prices);
        productDetails.barcode = barcode;
        productDetails.pricesCollected = prices.size()

        // TODO Fetch from prod info table
        productDetails.productDec = ProductInfo.findByBarcode(barcode).productName

        return productDetails;

    }

    Double findAvgPrice(List<Double> prices) {
        double totalPrice = 0.0;

        for( double price : prices) {
            totalPrice += price;
        }

        println totalPrice

        return totalPrice / prices.size();
    }

    double calculateIdealPrice(List<Double> prices) {
        return idealPriceCalculationStrategy.calculate(prices)
    }

    List<Double> getAllPricesFor(String barcodeIn) {
        List<Double> pricesList = new ArrayList<>();

        if (barcodeIn == null) {
            return pricesList;
        }

        // Get all prices from Product table and populate in the List.
        def allProducts = Product.findAllByBarcode(barcodeIn);
        for(Product product : allProducts) {
            pricesList.add(product.price)
        }

        return pricesList;
    }

    def getProductDetails(String barcode) {
        println "Barcode is " + barcode
        ProductDetails prodDetails = fetchProductDetails(barcode);

        return prodDetails
    }
}
