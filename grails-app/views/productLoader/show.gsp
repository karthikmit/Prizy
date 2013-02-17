
<%@ page import="prizy.Product" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'productLoader.label', default: 'Product')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-productLoader" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-productLoader" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list productLoader">
			
				<g:if test="${productLoaderInstance?.barcode}">
				<li class="fieldcontain">
					<span id="barcode-label" class="property-label"><g:message code="productLoader.barcode.label" default="Barcode" /></span>
					
						<span class="property-value" aria-labelledby="barcode-label"><g:fieldValue bean="${productLoaderInstance}" field="barcode"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productLoaderInstance?.notes}">
				<li class="fieldcontain">
					<span id="notes-label" class="property-label"><g:message code="productLoader.notes.label" default="Notes" /></span>
					
						<span class="property-value" aria-labelledby="notes-label"><g:fieldValue bean="${productLoaderInstance}" field="notes"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productLoaderInstance?.price}">
				<li class="fieldcontain">
					<span id="price-label" class="property-label"><g:message code="productLoader.price.label" default="Price" /></span>
					
						<span class="property-value" aria-labelledby="price-label"><g:fieldValue bean="${productLoaderInstance}" field="price"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productLoaderInstance?.store}">
				<li class="fieldcontain">
					<span id="store-label" class="property-label"><g:message code="productLoader.store.label" default="Store" /></span>
					
						<span class="property-value" aria-labelledby="store-label"><g:fieldValue bean="${productLoaderInstance}" field="store"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:link class="edit" action="edit" params="[barcode:productLoaderInstance.barcode, store:productLoaderInstance.store,
                            price:productLoaderInstance.price, notes:productLoaderInstance.notes, version:productLoaderInstance.version]"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                    <g:link class="delete" action="delete" params="[barcode:productLoaderInstance.barcode, store:productLoaderInstance.store]"><g:message code="default.button.delete.label" default="Delete" /></g:link>
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
