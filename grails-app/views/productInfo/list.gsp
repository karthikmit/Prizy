
<%@ page import="prizy.ProductInfo" %>
<!DOCTYPE html>
<html>
	<head>
        <script>
            var search = function() {
                document.location.href = "list" + "?search=" +
                                            document.getElementById("searchquery").value;
            }
        </script>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'productInfo.label', default: 'ProductInfo')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-productInfo" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-productInfo" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <input type="text" placeholder="Enter product name to search" id="searchquery"/>
            <input type="button" id="search" onclick="search()" value="Search"/>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="barcode" title="${message(code: 'productInfo.barcode.label', default: 'Barcode')}" />
					
						<g:sortableColumn property="productName" title="${message(code: 'productInfo.productName.label', default: 'Product Name')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${productInfoInstanceList}" status="i" var="productInfoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" params="[barcode: productInfoInstance.barcode]">${fieldValue(bean: productInfoInstance, field: "barcode")}</g:link></td>

						<td>${fieldValue(bean: productInfoInstance, field: "productName")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${productInfoInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
