<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'companyCase.label', default: 'CompanyCase')}" />
	</head>
	<body>
		
		<div id="create-companyCase" class="content scaffold-create" role="main">
			<g:form url="[resource:companyCaseInstance, action:'save']" >
				<fieldset class="form">
					<g:render template="form"/>
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
