<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
            
          <script>
             $( function() {
              $( "#fecha" ).datepicker({monthNames:["Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"],dayNames:["Lunes","Martes","Miercoles","Jueves","Viernes","Sábado","Domingo"],dayNamesMin:["do","lu","ma","mi","ju","vi","sá"],dateFormat:"dd-m-yy" });
            } );
          </script> 
        
        <title>Notebook de Préstamo</title>
    </head>
    <body>
        <jsp:include page="./registra" flush="true"/>
        <jsp:include page="./usr" flush="true"/>
        <jsp:include page="./listaPrestamo" flush="true"/>
        
        
        <section class="content">
           
            <fieldset>
            
                <legend>Solicitud</legend>
            
            <div class="col-sm-4">  
                
                   
                        
                <form action="./registra" method="post">
                         <div class="form-group row">
                             <label class="col-sm-2 col-form-label" for="notebook" >Equipo</label>
                            <div class="col-sm-6">
                                
                                <select id="notebook" class="form-control" name="cmbEquipo">
                                <option selected="">(Seleccione)</option>
                                <c:forEach items="${equipos}" var="equipo">
                                    <option value="${equipo.getNombre()}"> <c:out value="${equipo.getNombre()}" /> </option>
                                </c:forEach>
                            </select>  
                            </div>
                         </div>
                    
                    <div class="form-group row">
                             <label class="col-sm-2 col-form-label" for="usr" >Usuario</label>
                            <div class="col-sm-6">
                                
                                <select id="usr" class="form-control" name="cmbUsr">
                                <option selected="">(Seleccione)</option>
                                <c:forEach items="${usuarios}" var="usr">
                                    <option value="${usr.getNombre()} ${usr.getApellido()}"> <c:out value="${usr.getNombre()}  ${usr.getApellido()}" /> </option>
                                </c:forEach>
                            </select>  
                            </div>
                         </div>
                            
                             <div class="form-group row">
                                <label for="fecha" class="col-sm-2 col-form-label">Fecha</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" id="fecha" name="txbFecha" >
                                </div>
                                
                               
                                
                            </div>
                    <input type="hidden" name="usr" value="Felipe"/>
                            <div class="form-group row">
                                
                                <div class="col-sm-3">
                                    <input type="submit" class="btn btn-success" id="btn" value="Solicitar" >
                                </div>
                            </div>
                       </form>
                   
                    </div>     
                            
           </fieldset>
                    
                        
                
                
                    <br> <br>
                    
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
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        
                        
                    </fieldset>
                    
                    
              
                
               
           
            
        </section>          
      
        
       
       
          
            
    </body>
</html>
