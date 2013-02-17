package prizy



import org.junit.*
import grails.test.mixin.*

@TestFor(ProductDetailsController)
@Mock(ProductDetails)
class ProductDetailsControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/productDetails/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.productDetailsInstanceList.size() == 0
        assert model.productDetailsInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.productDetailsInstance != null
    }

    void testSave() {
        controller.save()

        assert model.productDetailsInstance != null
        assert view == '/productDetails/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/productDetails/show/1'
        assert controller.flash.message != null
        assert ProductDetails.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/productDetails/list'

        populateValidParams(params)
        def productDetails = new ProductDetails(params)

        assert productDetails.save() != null

        params.id = productDetails.id

        def model = controller.show()

        assert model.productDetailsInstance == productDetails
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/productDetails/list'

        populateValidParams(params)
        def productDetails = new ProductDetails(params)

        assert productDetails.save() != null

        params.id = productDetails.id

        def model = controller.edit()

        assert model.productDetailsInstance == productDetails
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/productDetails/list'

        response.reset()

        populateValidParams(params)
        def productDetails = new ProductDetails(params)

        assert productDetails.save() != null

        // test invalid parameters in update
        params.id = productDetails.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/productDetails/edit"
        assert model.productDetailsInstance != null

        productDetails.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/productDetails/show/$productDetails.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        productDetails.clearErrors()

        populateValidParams(params)
        params.id = productDetails.id
        params.version = -1
        controller.update()

        assert view == "/productDetails/edit"
        assert model.productDetailsInstance != null
        assert model.productDetailsInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/productDetails/list'

        response.reset()

        populateValidParams(params)
        def productDetails = new ProductDetails(params)

        assert productDetails.save() != null
        assert ProductDetails.count() == 1

        params.id = productDetails.id

        controller.delete()

        assert ProductDetails.count() == 0
        assert ProductDetails.get(productDetails.id) == null
        assert response.redirectedUrl == '/productDetails/list'
    }
}
