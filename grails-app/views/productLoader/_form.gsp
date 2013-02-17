<%@ page import="prizy.Product" %>



<div class="fieldcontain ${hasErrors(bean: productLoaderInstance, field: 'barcode', 'error')} ">
	<label for="barcode">
		<g:message code="productLoader.barcode.label" default="Barcode" />
		
	</label>
	<g:textField name="barcode" value="${productLoaderInstance?.barcode}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: productLoaderInstance, field: 'notes', 'error')} ">
	<label for="notes">
		<g:message code="productLoader.notes.label" default="Notes" />
		
	</label>
	<g:textField name="notes" value="${productLoaderInstance?.notes}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: productLoaderInstance, field: 'price', 'error')} required">
	<label for="price">
		<g:message code="productLoader.price.label" default="Price" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="price" value="${fieldValue(bean: productLoaderInstance, field: 'price')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: productLoaderInstance, field: 'store', 'error')} ">
	<label for="store">
		<g:message code="productLoader.store.label" default="Store" />
		
	</label>
	<g:textField name="store" value="${productLoaderInstance?.store}"/>
</div>

