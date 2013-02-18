package prizy

import prizy.service.ProductDetailsFetcher

import static org.junit.Assert.*
import org.junit.*

class ProductDetailsTests {

    @Before
    void setUp() {
        // Setup logic here
    }

    @After
    void tearDown() {
        // Tear down logic here
    }

    @Test
    public void noPriceSamplesProductDetailsShowTest() {

        ProductInfo info = new ProductInfo();
        info.setBarcode("testbarcode123");
        info.setProductName("Horlicks");

        info.save();

        def prodDetails = new ProductDetailsFetcher().fetchProductDetails("testbarcode123");
        assert prodDetails == null
    }
}

