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

    void fetchProductDetails(String barcode, ProductDetails productDetails) {
        List<Double> prices = getAllPricesFor(barcode);
        Collections.sort(prices);

        println "totalcount" + prices.size()

        if (prices.size() <= 0) {
            return;
        }

        productDetails.highPrice = prices.get(prices.size() - 1);
        productDetails.lowPrice = prices.get(0);
        productDetails.avgPrice = findAvgPrice(prices);
        productDetails.idealPrice = calculateIdealPrice(prices);
        productDetails.barcode = barcode;
        productDetails.pricesCollected = prices.size()

        // TODO Fetch from prod info table
        productDetails.productDec = ProductInfo.findByBarcode(barcode).productName

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

        // Get all prices from Product table and populate in the List.
        // TODO Fetch only relevant records.
        def allProducts = Product.all;
        for(Product prod : allProducts) {
            if (prod.barcode == barcodeIn) {
                pricesList.add(prod.price);
            }
        }

        return pricesList;
    }

    def getProductDetails(String barcode) {
        ProductDetails prodDetails = new ProductDetails();

        fetchProductDetails(barcode, prodDetails);

        return prodDetails
    }
}
