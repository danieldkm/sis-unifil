<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Formulário JSF com CSS</title>
<!--Chamada ao arquivo CSS -->
<link rel="StyleSheet" type="text/css" href="./css/estilos.css" media="screen">
</head>
<body>
	<f:view>
		<h:form>
			<fieldset>
				<legend>Dados</legend>
				<!--Tag JSF, com o atributo styleClass referenciado o seletor CSS específico  -->
				<h:outputText value="Nome:" styleClass="rotulos" />
				<br>
				<h:inputText id="edtNome" value="" styleClass="edit" size="60" />
				<br>
				<h:outputText value="RG:" styleClass="rotulos" />
				<br>
				<h:inputText id="edtRG" value="" styleClass="edit" size="20" />
				<br>
				<h:outputText value="CPF:" styleClass="rotulos" />
				<br>
				<h:inputText id="edtCPF" value="" styleClass="edit" size="30" />
				<br>
				<h:outputText value="E-mail:" styleClass="rotulos" />
				<br>
				<h:inputText id="edtEmail" value="" styleClass="edit" size="50" />
				<br>
				<br>
				<hr>
				<h:commandButton value="Gravar" type="submit" styleClass="botoes" />
				<h:commandButton value="Limpar" type="reset" styleClass="botoes" />
			</fieldset>
			<br>
		</h:form>
	</f:view>
</body>
</html>
