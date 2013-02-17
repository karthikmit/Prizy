package prizy

import org.springframework.dao.DataIntegrityViolationException

class ProductLoaderController {

    static allowedMethods = [save: "POST", update: "POST", delete: "GET"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [productLoaderInstanceList: Product.list(params), productLoaderInstanceTotal: Product.count()]
    }

    def create() {
        [productLoaderInstance: new Product(params)]
    }

    def save() {
        def productLoaderInstance = new Product(params)

        def doesBarcodeExist = doesBarcodeExist(params.get("barcode"))
        if (false == doesBarcodeExist) {
            flash.message = message(code: 'default.create.unknown.barcode.error', args: [productLoaderInstance.barcode])
            render(view: "create", model: [productLoaderInstance: productLoaderInstance])
            return
        }

        try {
            if (!productLoaderInstance.save(flush: true)) {

                render(view: "create", model: [productLoaderInstance: productLoaderInstance])
                return
            }
        }
        catch (Exception e) {
            println e.message;
            flash.message = message(code: 'default.create.duplicate.error', args: [productLoaderInstance.barcode, productLoaderInstance.store])
            render(view: "create", model: [productLoaderInstance: productLoaderInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'productLoader.label', default: 'Product'), productLoaderInstance.barcode])
        redirect(action: "show", params: [barcode: params.get("barcode"), store: params.get("store")])
    }

    boolean doesBarcodeExist(String barcode) {
        println barcode
        def product = ProductInfo.findByBarcode(barcode)
        println product
        return (product != null)
    }

    def show() {
        String barcode = params.get("barcode")
        String store = params.get("store")

        def productLoaderInstance = Product.findByBarcodeAndStore(barcode, store);
        if (!productLoaderInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'productLoader.label', default: 'Product'), id])
            redirect(action: "list")
            return
        }

        [productLoaderInstance: productLoaderInstance]
    }

    def edit() {
        String barcode = params.get("barcode")
        String store = params.get("store")
        def productLoaderInstance = Product.findByBarcodeAndStore(barcode, store);
        if (!productLoaderInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'productLoader.label', default: 'Product'), id])
            redirect(action: "list")
            return
        }

        [productLoaderInstance: productLoaderInstance]
    }

    def update(Long version) {
        String barcode = params.get("barcode")
        String store = params.get("store")
        println params
        def productLoaderInstance = Product.findByBarcodeAndStore(barcode, store);

        if (!productLoaderInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'productLoader.label', default: 'Product'), id])
            redirect(action: "list")
            return
        }

//        if (version != null) {
//            if (productLoaderInstance.version > version) {
//                productLoaderInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
//                          [message(code: 'productLoader.label', default: 'Product')] as Object[],
//                          "Another user has updated this Product while you were editing")
//                render(view: "edit", model: [productLoaderInstance: productLoaderInstance])
//                return
//            }
//        }

        productLoaderInstance.version = params.get("version")
        productLoaderInstance.notes = params.get("notes")
        productLoaderInstance.price = Double.parseDouble(params.get("price"));
        productLoaderInstance.barcode = params.get("barcode");
        productLoaderInstance.store = params.get("store")

        if (!productLoaderInstance.save(flush: true)) {
            render(view: "edit", model: [productLoaderInstance: productLoaderInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'productLoader.label', default: 'Product'), productLoaderInstance.barcode])
        redirect(action: "show", params: [barcode: params.get("barcode"), store: params.get("store")])
    }

    def delete() {
        println "Karthik"
        println params
        def productLoaderInstance = Product.findByBarcodeAndStore(params.get("barcode"), params.get("store"));
        if (!productLoaderInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'productLoader.label', default: 'Product'), params.get("barcode")])
            redirect(action: "list")
            return
        }

        try {
            productLoaderInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'productLoader.label', default: 'Product'), params.get("barcode")])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'productLoader.label', default: 'Product'), params.get("barcode")])
            redirect(action: "show", id: id)
        }
    }
}
