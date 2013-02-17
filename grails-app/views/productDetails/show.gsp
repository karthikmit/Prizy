
<%@ page import="prizy.ProductDetails" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'productDetails.label', default: 'ProductDetails')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-productDetails" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>


			</ul>
		</div>
		<div id="show-productDetails" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list productDetails">
			
				<g:if test="${productDetailsInstance?.avgPrice}">
				<li class="fieldcontain">
					<span id="avgPrice-label" class="property-label"><g:message code="productDetails.avgPrice.label" default="Avg Price" /></span>
					
						<span class="property-value" aria-labelledby="avgPrice-label"><g:fieldValue bean="${productDetailsInstance}" field="avgPrice"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productDetailsInstance?.barcode}">
				<li class="fieldcontain">
					<span id="barcode-label" class="property-label"><g:message code="productDetails.barcode.label" default="Barcode" /></span>
					
						<span class="property-value" aria-labelledby="barcode-label"><g:fieldValue bean="${productDetailsInstance}" field="barcode"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productDetailsInstance?.highPrice}">
				<li class="fieldcontain">
					<span id="highPrice-label" class="property-label"><g:message code="productDetails.highPrice.label" default="High Price" /></span>
					
						<span class="property-value" aria-labelledby="highPrice-label"><g:fieldValue bean="${productDetailsInstance}" field="highPrice"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productDetailsInstance?.idealPrice}">
				<li class="fieldcontain">
					<span id="idealPrice-label" class="property-label"><g:message code="productDetails.idealPrice.label" default="Ideal Price" /></span>
					
						<span class="property-value" aria-labelledby="idealPrice-label"><g:fieldValue bean="${productDetailsInstance}" field="idealPrice"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productDetailsInstance?.lowPrice}">
				<li class="fieldcontain">
					<span id="lowPrice-label" class="property-label"><g:message code="productDetails.lowPrice.label" default="Low Price" /></span>
					
						<span class="property-value" aria-labelledby="lowPrice-label"><g:fieldValue bean="${productDetailsInstance}" field="lowPrice"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${productDetailsInstance?.productDec}">
				<li class="fieldcontain">
					<span id="productDec-label" class="property-label"><g:message code="productDetails.productDec.label" default="Product Dec" /></span>
					
						<span class="property-value" aria-labelledby="productDec-label"><g:fieldValue bean="${productDetailsInstance}" field="productDec"/></span>
					
				</li>
				</g:if>

                <g:if test="${productDetailsInstance?.pricesCollected}">
                    <li class="fieldcontain">
                        <span id="pricesCollected-label" class="property-label"><g:message code="productDetails.pricesCollected.label" default="Prices Collected" /></span>

                        <span class="property-value" aria-labelledby="pricesCollected-label"><g:fieldValue bean="${productDetailsInstance}" field="pricesCollected"/></span>

                    </li>
                </g:if>
			
			</ol>
		</div>
	</body>
</html>
