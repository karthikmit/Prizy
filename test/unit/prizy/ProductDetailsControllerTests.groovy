package prizy



import org.junit.*
import grails.test.mixin.*

@TestFor(ProductDetailsController)
@Mock(ProductDetails)
class ProductDetailsControllerTests {

    def populateValidParams(params) {
        params["barcode"] = "1";
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

//    void testIndex() {
//        controller.index()
//        assert "/productDetails/list" == response.redirectedUrl
//    }

    void testShow() {
        controller.show()

        assert flash.message != null

        populateValidParams(params)
        controller.show()

        assert model.productDetailsInstance.barcode == "1"
//        def productDetails = new ProductDetails(params)
//
//        assert productDetails.save() != null
//
//        params.id = productDetails.id
//
//        def model = controller.show()
//
//        assert model.productDetailsInstance == productDetails
    }
}
