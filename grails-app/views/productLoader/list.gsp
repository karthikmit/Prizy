
<%@ page import="prizy.Product" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'productLoader.label', default: 'Product')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-productLoader" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-productLoader" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="barcode" title="${message(code: 'productLoader.barcode.label', default: 'Barcode')}" />
					
						<g:sortableColumn property="notes" title="${message(code: 'productLoader.notes.label', default: 'Notes')}" />
					
						<g:sortableColumn property="price" title="${message(code: 'productLoader.price.label', default: 'Price')}" />
					
						<g:sortableColumn property="store" title="${message(code: 'productLoader.store.label', default: 'Store')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${productLoaderInstanceList}" status="i" var="productLoaderInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" params="[barcode:productLoaderInstance.barcode, store:productLoaderInstance.store]">${fieldValue(bean: productLoaderInstance, field: "barcode")}</g:link></td>
					
						<td>${fieldValue(bean: productLoaderInstance, field: "notes")}</td>
					
						<td>${fieldValue(bean: productLoaderInstance, field: "price")}</td>
					
						<td>${fieldValue(bean: productLoaderInstance, field: "store")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${productLoaderInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
