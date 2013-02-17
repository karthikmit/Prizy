package prizy

import grails.test.mixin.*

@TestFor(ProductLoaderController)
@Mock(Product)
class ProductLoaderControllerTests {

    def populateValidParams(params) {
        assert params != null
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
        assert view == '/productLoader/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/productLoader/show/1'
        assert controller.flash.message != null
        assert Product.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/productLoader/list'

        populateValidParams(params)
        def productLoader = new Product(params)

        assert productLoader.save() != null

        params.id = productLoader.id

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

        params.id = productLoader.id

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

        // test invalid parameters in update
        params.id = productLoader.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/productLoader/edit"
        assert model.productLoaderInstance != null

        productLoader.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/productLoader/show/$productLoader.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        productLoader.clearErrors()

        populateValidParams(params)
        params.id = productLoader.id
        params.version = -1
        controller.update()

        assert view == "/productLoader/edit"
        assert model.productLoaderInstance != null
        assert model.productLoaderInstance.errors.getFieldError('version')
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

        params.id = productLoader.id

        controller.delete()

        assert Product.count() == 0
        assert Product.get(productLoader.id) == null
        assert response.redirectedUrl == '/productLoader/list'
    }
}
