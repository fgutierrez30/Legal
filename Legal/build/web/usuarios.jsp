<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
  
  <%@include file="master/head.jsp" %>
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
  
      <%@include file="master/header.jsp" %>

    <div class="page-content">
    	<div class="row">
	
     <%@include file="menu.jsp" %>
     
     <jsp:include page="./usr" flush="true"/>
            
		  <div class="col-md-10">
		  	<div class="row">
		  		

		  		<div class="col-md-11">
		  			<div class="row">
		  				<div class="col-md-12">
		  					<div class="content-box-header">
			  					<div class="panel-title">Mantenedor de Usuarios</div>
								
								<div class="panel-options">
                                                                    <button class="btn btn-xs btn-primary" data-toggle="modal" data-target="#nuevoUsr">
                                                                        Agregar
                                                                    </button>
                                                                    <!--<input type="button" value="Agregar" class="btn btn-xs btn-primary" data-toggle="modal" data-target="nuevoUsr" />-->
								</div>
				  			</div>
				  			<div class="content-box-large box-with-header">
				  				
                                                            <table class="table table-hover">
                                                                <thead>
                                                                    <tr>
                                                                        <th>Rut</th>
                                                                        <th>Nombre</th>
                                                                        <th>Apellido</th>
                                                                        <th>Correo</th>
                                                                        <th>Telefono</th>
                                                                        <th>Login</th>
                                                                        <th>Estado</th>
                                                                    </tr>
                                                                </thead>
                                                                
                                                                <tbody>
                                                                    <c:forEach items="${usuarios}" var="usr">
                                                                    <tr>
                                                                        <td><c:out value="${usr.rutUsr}"/></td>
                                                                        <td><c:out value="${usr.nomUsr}"/></td>
                                                                        <td><c:out value="${usr.apellUsr}"/></td>
                                                                        <td><c:out value="${usr.emailUsr}"/></td>
                                                                        <td><c:out value="${usr.telefUsr}"/></td>
                                                                        <td><c:out value="${usr.loginUsr}"/></td>
                                                                        
                                                                        
                                                                        <td>
                                                                            <c:choose>
                                                                                <c:when test="${usr.estadoUsr==1}">
                                                                                    Vigente
                                                                                </c:when>
                                                                                    
                                                                                <c:otherwise>
                                                                                    Bloqueado
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                        </td>
                                                                        
                                                                        <td><input type="button" value="Editar" class="btn btn-xs btn-danger" /></td>
                                                                    </tr>
                                                                    </c:forEach>
                                                                </tbody>
                                                                
                                                                
                                                            </table>
							</div>
		  				</div>
		  			</div>
		  			
		  		</div>
		  	</div>

		  

		  	
		  </div>
		</div>
    </div>

    <footer>
         <div class="container">
         
            <div class="copy text-center">
               Copyright 2018 <a href='#'>Website</a>
            </div>
            
         </div>
      </footer>
     
     
     
     
     <div class="modal fade" id="nuevoUsr" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Nuevo Usuario</h5>
        
      </div>
      <div class="modal-body">
        
          <form>
              
                  <div class="col-md-6">
                      <input type="tex" name="txbRut" class="form-control" placeholder="Rut" /> 
                      
                  </div>
                  <div class="col-md-6">
                  <input type="tex" name="txbNombre" class="form-control" placeholder="Nombre" />
                  </div>
                  
                  <div class="col-md-6">
                  <input type="tex" name="txbApell" class="form-control" placeholder="Apellido" />
                  </div>
                   
                  <div class="col-md-6"> 
                  <input type="tex" name="txbEmail" class="form-control" placeholder="Correo" />
                  </div>
           
             
          </form>
          
          
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
        <button type="button" class="btn btn-success">Crear Usuario</button>
      </div>
    </div>
  </div>
</div>
     
     
     
     
     
     

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://code.jquery.com/jquery.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
    <script src="js/custom.js"></script>
    
  </body>
</html>