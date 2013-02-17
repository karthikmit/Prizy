
<%@ page import="prizy.ProductDetails" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'productDetails.label', default: 'ProductDetails')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-productDetails" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-productDetails" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="avgPrice" title="${message(code: 'productDetails.avgPrice.label', default: 'Avg Price')}" />
					
						<g:sortableColumn property="barcode" title="${message(code: 'productDetails.barcode.label', default: 'Barcode')}" />
					
						<g:sortableColumn property="highPrice" title="${message(code: 'productDetails.highPrice.label', default: 'High Price')}" />
					
						<g:sortableColumn property="idealPrice" title="${message(code: 'productDetails.idealPrice.label', default: 'Ideal Price')}" />
					
						<g:sortableColumn property="lowPrice" title="${message(code: 'productDetails.lowPrice.label', default: 'Low Price')}" />
					
						<g:sortableColumn property="productDec" title="${message(code: 'productDetails.productDec.label', default: 'Product Dec')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${productDetailsInstanceList}" status="i" var="productDetailsInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${productDetailsInstance.id}">${fieldValue(bean: productDetailsInstance, field: "avgPrice")}</g:link></td>
					
						<td>${fieldValue(bean: productDetailsInstance, field: "barcode")}</td>
					
						<td>${fieldValue(bean: productDetailsInstance, field: "highPrice")}</td>
					
						<td>${fieldValue(bean: productDetailsInstance, field: "idealPrice")}</td>
					
						<td>${fieldValue(bean: productDetailsInstance, field: "lowPrice")}</td>
					
						<td>${fieldValue(bean: productDetailsInstance, field: "productDec")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${productDetailsInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
