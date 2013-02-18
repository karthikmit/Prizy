package prizy

import org.junit.Test
import prizy.service.ProductDetailsFetcher

class ProductDetailsFetcherTests{

    @Test
    public void nullBarcodeProductDetailsFetcherTest() {
        ProductDetailsFetcher fetcher = new ProductDetailsFetcher();

        String barcode = null;
        def productDetails = fetcher.fetchProductDetails(null);
        assert productDetails == null;
    }

    @Test
    public void populateABarcodeAndPricesTest() {
        ProductDetailsFetcher fetcher = new ProductDetailsFetcher();

        Double avgExpected = 100;
        String barcode = "testbarcode134";
        String prodName = "horlix";
        ProductInfo prodInfo = new ProductInfo();
        prodInfo.barcode = barcode;
        prodInfo.productName = prodName;

        prodInfo.save();

        for(int i = 0; i < 10000; i++) {
            String notes = "Hello";
            long version = 0;
            double price = new Random().nextDouble() * 2 * avgExpected;

            Product product = new Product();
            product.setStore("store" + i.toString());
            product.setBarcode(barcode);
            product.setNotes(notes);
            product.setVersion(version);
            product.setPrice(price);
            product.save();
        }

        def productDetails = fetcher.fetchProductDetails(barcode);
        println productDetails.barcode +  " " + productDetails.idealPrice;

        double diff = Math.abs(1.2 * avgExpected - productDetails.idealPrice);
        assert diff < 0.1 * 1.2 * avgExpected;
    }
}
