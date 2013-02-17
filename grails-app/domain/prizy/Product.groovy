package prizy

import org.apache.commons.lang.builder.HashCodeBuilder

class Product implements Serializable{

    static constraints = {
        store()
        barcode()
        price()
        notes()
    }

    static mapping = {
        id composite: ['store', 'barcode']
    }

    String store
    String barcode
    double price
    String notes

    boolean equals(other) {
        if (!other instanceof Product) {
            return false;
        }

        store == other.store && barcode == other.barcode
    }

    int hashcode() {
        def builder = new HashCodeBuilder()
        builder.append(store)
        builder.append(barcode)

        builder.toHashCode()
    }
}
