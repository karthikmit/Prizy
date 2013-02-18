package prizy



import grails.test.mixin.*
import org.junit.Ignore
import org.junit.Test
import prizy.service.ProductDetailsFetcher

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
class ProductDetailsTests {

    public static final String TESTBARCODE = "testbarcode12345"

    @Test
    void givenNoBarcodeNullProductDetailsTest() {
        String barcode = "1";

        ProductDetails productDetails = new ProductDetailsFetcher().fetchProductDetails(barcode);
        assert productDetails == null
    }

    @Test

    void givenBarcodeFetchIdealPriceTest() {
        String barcode = TESTBARCODE;
        // Generate diff stores and different prices
        for(int i = 0; i < 10; i++) {
            def product = new Product()
            product.barcode = barcode

            product.price = new Random().nextDouble() * 100 + 120;
            product.store = "store"  + i.toString();
            product.version = 0L

            product.save()
        }

        ProductDetails productDetails = new ProductDetailsFetcher().fetchProductDetails(barcode);
        println productDetails
        assert productDetails != null
    }
}
