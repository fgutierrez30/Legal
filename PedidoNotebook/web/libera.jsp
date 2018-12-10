<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/AdminLTE.min.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <link rel="stylesheet" href="/resources/demos/style.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
            
         
        
        <title>Notebook de Préstamo</title>
    </head>
    <body>
       
        <jsp:include page="./listaPrestamo" flush="true"/>
        
        
        <section class="content">
           
       
                    
                    <fieldset>
                        <legend>Equipos en Préstamo</legend>
                        
                        <table class="table">
                            <thead>
                                <th>ID</th>
                                <th>Usuario</th>
                                <th>Equipo</th>
                                <th>Fecha Solicitud</th>
                                <th> </th>
                            </thead>
                            <tbody>
                                <c:forEach items="${prestamos}" var="pres">
                                    <tr>
                                        <td><c:out value="${pres.getId()}"/></td>
                                        <td>${pres.getUsr()}</td>
                                        <td>${pres.getEquipo()}</td>
                                        <td><fmt:formatDate pattern="dd-MM-yyyy" value="${pres.getFechaPedido()}"/></td>
                                        <form method="post" action="./listaPrestamo">
                                            <input type="hidden" name="idPrestamo" value="${pres.getId()}" />
                                            <input type="hidden" name="fechaEntrega" value="<% out.print(fecha); %>" />
                                            <input type="hidden" name="nomEquipo" value="${pres.getEquipo()}" />
                                            <td> <input type="submit" value="Finalizar" class="btn btn-danger btn-sm" /> </td>
                                        </form>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        
                        
                    </fieldset>
                    
                    
              
                
               
           
            
        </section>          
      
        
       
               
            
    </body>
</html>
