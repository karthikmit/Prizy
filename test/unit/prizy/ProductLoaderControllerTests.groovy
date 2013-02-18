package prizy

import grails.test.mixin.*

@TestFor(ProductLoaderController)
@Mock([Product, ProductInfo])
class ProductLoaderControllerTests {

    def populateValidParams(params) {
        params["barcode"] = "testbarcode123"
        params["store"] = "store"
        params["price"] = "100.0"
        params["notes"] = "Hllo"
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/productLoader/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.productLoaderInstanceList.size() == 0
        assert model.productLoaderInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.productLoaderInstance != null
    }

    void testSave() {
        controller.save()

        assert model.productLoaderInstance != null
        assert controller.flash.message != null
        assert view == '/productLoader/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        // Will fail as Barcode wouldn't exist, Flow would be further tested in Integration.
        assert controller.flash.message != null
        assert Product.count() == 0
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/productLoader/list'

        populateValidParams(params)
        def productLoader = new Product(params)

        assert productLoader.save() != null

        params.barcode = productLoader.barcode

        def model = controller.show()

        assert model.productLoaderInstance == productLoader
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/productLoader/list'

        populateValidParams(params)
        def productLoader = new Product(params)

        assert productLoader.save() != null

        params.barcode = productLoader.barcode

        def model = controller.edit()

        assert model.productLoaderInstance == productLoader
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/productLoader/list'

        response.reset()

        populateValidParams(params)
        def productLoader = new Product(params)

        assert productLoader.save() != null

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl.startsWith("/productLoader/show");
        assert flash.message != null

    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/productLoader/list'

        response.reset()

        populateValidParams(params)
        def productLoader = new Product(params)

        assert productLoader.save() != null
        assert Product.count() == 1

        params.barcode = productLoader.barcode

        controller.delete()

        assert Product.count() == 0
        assert Product.get(productLoader.id) == null
        assert response.redirectedUrl == '/productLoader/list'
    }
}
