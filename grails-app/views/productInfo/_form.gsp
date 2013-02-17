<%@ page import="prizy.ProductInfo" %>



<div class="fieldcontain ${hasErrors(bean: productInfoInstance, field: 'barcode', 'error')} ">
	<label for="barcode">
		<g:message code="productInfo.barcode.label" default="Barcode" />
		
	</label>
	<g:textField name="barcode" value="${productInfoInstance?.barcode}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: productInfoInstance, field: 'productName', 'error')} ">
	<label for="productName">
		<g:message code="productInfo.productName.label" default="Product Name" />
		
	</label>
	<g:textField name="productName" value="${productInfoInstance?.productName}"/>
</div>

