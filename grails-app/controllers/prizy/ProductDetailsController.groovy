package prizy

import org.springframework.dao.DataIntegrityViolationException
import prizy.service.ProductDetailsFetcher

class ProductDetailsController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {

    }


    def show() {
        String barcode = params.get("barcode")
        def productDetailsInstance = new ProductDetailsFetcher().getProductDetails(barcode);

        if (!productDetailsInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'productDetails.label', default: 'ProductDetails'), barcode])
            //redirect(action: "list")
            return
        }

        [productDetailsInstance: productDetailsInstance]
    }
}
