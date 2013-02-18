package prizy



import org.junit.*
import grails.test.mixin.*

@TestFor(ProductInfoController)
@Mock(ProductInfo)
class ProductInfoControllerTests {

    def populateValidParams(params) {
        params["barcode"] = "testbarcode123"
        params["productName"] = "Horlicks"
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/productInfo/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.productInfoInstanceList.size() == 0
        assert model.productInfoInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.productInfoInstance != null
    }

    void testSave() {
        controller.save()

        assert model.productInfoInstance != null
        assert view == '/productInfo/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/productInfo/list'
        assert controller.flash.message != null
        assert ProductInfo.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message == null
        assert response.redirectedUrl == '/productDetails/show'

        populateValidParams(params)
        assert response.redirectedUrl == '/productDetails/show'
    }

    /*void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/productInfo/list'

        populateValidParams(params)
        def productInfo = new ProductInfo(params)

        assert productInfo.save() != null

        params.id = productInfo.id

        def model = controller.edit()

        assert model.productInfoInstance == productInfo
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/productInfo/list'

        response.reset()

        populateValidParams(params)
        def productInfo = new ProductInfo(params)

        assert productInfo.save() != null

        // test invalid parameters in update
        params.id = productInfo.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/productInfo/edit"
        assert model.productInfoInstance != null

        productInfo.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/productInfo/show/$productInfo.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        productInfo.clearErrors()

        populateValidParams(params)
        params.id = productInfo.id
        params.version = -1
        controller.update()

        assert view == "/productInfo/edit"
        assert model.productInfoInstance != null
        assert model.productInfoInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/productInfo/list'

        response.reset()

        populateValidParams(params)
        def productInfo = new ProductInfo(params)

        assert productInfo.save() != null
        assert ProductInfo.count() == 1

        params.id = productInfo.id

        controller.delete()

        assert ProductInfo.count() == 0
        assert ProductInfo.get(productInfo.id) == null
        assert response.redirectedUrl == '/productInfo/list'
    }*/
}
