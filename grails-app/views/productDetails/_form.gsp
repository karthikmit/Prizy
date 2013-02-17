<%@ page import="prizy.ProductDetails" %>



<div class="fieldcontain ${hasErrors(bean: productDetailsInstance, field: 'avgPrice', 'error')} required">
	<label for="avgPrice">
		<g:message code="productDetails.avgPrice.label" default="Avg Price" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="avgPrice" value="${fieldValue(bean: productDetailsInstance, field: 'avgPrice')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: productDetailsInstance, field: 'barcode', 'error')} ">
	<label for="barcode">
		<g:message code="productDetails.barcode.label" default="Barcode" />
		
	</label>
	<g:textField name="barcode" value="${productDetailsInstance?.barcode}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: productDetailsInstance, field: 'highPrice', 'error')} required">
	<label for="highPrice">
		<g:message code="productDetails.highPrice.label" default="High Price" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="highPrice" value="${fieldValue(bean: productDetailsInstance, field: 'highPrice')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: productDetailsInstance, field: 'idealPrice', 'error')} required">
	<label for="idealPrice">
		<g:message code="productDetails.idealPrice.label" default="Ideal Price" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="idealPrice" value="${fieldValue(bean: productDetailsInstance, field: 'idealPrice')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: productDetailsInstance, field: 'lowPrice', 'error')} required">
	<label for="lowPrice">
		<g:message code="productDetails.lowPrice.label" default="Low Price" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="lowPrice" value="${fieldValue(bean: productDetailsInstance, field: 'lowPrice')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: productDetailsInstance, field: 'productDec', 'error')} ">
	<label for="productDec">
		<g:message code="productDetails.productDec.label" default="Product Dec" />
		
	</label>
	<g:textField name="productDec" value="${productDetailsInstance?.productDec}"/>
</div>

