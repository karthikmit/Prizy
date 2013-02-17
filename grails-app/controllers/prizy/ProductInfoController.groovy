package prizy

import org.springframework.dao.DataIntegrityViolationException

class ProductInfoController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        String name = params.get("search");
        if (name != null) {
            println name

            def possibleProducts = ProductInfo.findAllByProductNameIlike("%" + name + "%")
            println possibleProducts
            return [productInfoInstanceList: possibleProducts, productInfoInstanceTotal: possibleProducts.size()]
        }
        params.max = Math.min(max ?: 10, 100)
        [productInfoInstanceList: ProductInfo.list(params), productInfoInstanceTotal: ProductInfo.count()]
    }

    def create() {
        [productInfoInstance: new ProductInfo(params)]
    }

    def save() {
        def productInfoInstance = new ProductInfo(params)
        if (!productInfoInstance.save(flush: true)) {
            render(view: "create", model: [productInfoInstance: productInfoInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'productInfo.label', default: 'ProductInfo'), productInfoInstance.barcode])
        redirect(action: "list")
    }

    def show() {

        String barcode = params.get("barcode")
        println barcode

        redirect(controller: "productDetails", action: "show", params: params)
    }

    def edit(Long id) {
        def productInfoInstance = ProductInfo.get(id)
        if (!productInfoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'productInfo.label', default: 'ProductInfo'), id])
            redirect(action: "list")
            return
        }

        [productInfoInstance: productInfoInstance]
    }

    def update(Long id, Long version) {
        def productInfoInstance = ProductInfo.get(id)
        if (!productInfoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'productInfo.label', default: 'ProductInfo'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (productInfoInstance.version > version) {
                productInfoInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'productInfo.label', default: 'ProductInfo')] as Object[],
                          "Another user has updated this ProductInfo while you were editing")
                render(view: "edit", model: [productInfoInstance: productInfoInstance])
                return
            }
        }

        productInfoInstance.properties = params

        if (!productInfoInstance.save(flush: true)) {
            render(view: "edit", model: [productInfoInstance: productInfoInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'productInfo.label', default: 'ProductInfo'), productInfoInstance.id])
        redirect(action: "show", id: productInfoInstance.id)
    }

    def delete(Long id) {
        def productInfoInstance = ProductInfo.get(id)
        if (!productInfoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'productInfo.label', default: 'ProductInfo'), id])
            redirect(action: "list")
            return
        }

        try {
            productInfoInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'productInfo.label', default: 'ProductInfo'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'productInfo.label', default: 'ProductInfo'), id])
            redirect(action: "show", id: id)
        }
    }
}
