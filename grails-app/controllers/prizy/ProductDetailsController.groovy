package prizy

import org.springframework.dao.DataIntegrityViolationException

class ProductDetailsController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {

    }


    def show() {
        String barcode = params.get("barcode")
        def productDetailsInstance = new ProductDetailsFetcher().getProductDetails(barcode);
        if (!productDetailsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'productDetails.label', default: 'ProductDetails'), id])
            redirect(action: "list")
            return
        }

        [productDetailsInstance: productDetailsInstance]
    }
}
