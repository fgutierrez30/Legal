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
                                                                    <button class="btn btn-xs btn-primary" data-toggle="modal" data-target="#myModalNorm">
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
                                                                        
                                                                        <td><input type="button" value="Editar" class="btn btn-xs btn-danger" data-toggle="modal" data-target="#view-modal" id="getUsr" data-id="${usr.idUsr}" /></td>
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
     
     
     
     
<div class="modal fade" id="myModalNorm" tabindex="-1" role="dialog" 
     aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <!-- Modal Header -->
            <div class="modal-header">
                <button type="button" class="close" 
                   data-dismiss="modal">
                       <span aria-hidden="true">&times;</span>
                       <span class="sr-only">Close</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    Nuevo Usuario
                </h4>
            </div>
            
            <!-- Modal Body -->
            <div class="modal-body">
                
                <form role="form" method="post" action="./usr">
                    <div class="row">
                        <div class="col-md-5">
                            <input type="text" class="form-control" id="exampleInputEmail1" placeholder="Rut" name="txbRut" />
                        </div>
                        <div class="col-md-5 col-md-offset-0">
                            <input type="text" class="form-control" id="exampleInputPassword1" name="txbNombre" placeholder="Nombre" />
                       </div> 
                    </div><br>
                    
                    <div class="row">
                        <div class="col-md-5">
                            <input type="text" class="form-control" id="exampleInputEmail1" name="txbApell" placeholder="Apellido" />
                        </div>
                        <div class="col-md-5">
                            <input type="email" class="form-control"id="exampleInputPassword1" name="txbCorreo" placeholder="Correo"/>
                        </div>
                    </div><br>
                    
                     <div class="row">
                        <div class="col-md-5">
                            <input type="text" name="txbFono" class="form-control" id="exampleInputEmail1" placeholder="Telefono" />
                        </div>
                        <div class="col-md-5">
                            <input type="text" name="txbNomUsr" class="form-control"id="exampleInputPassword1" placeholder="Nombre de Usuario"/>
                        </div>
                     </div> <br>
                    
                    <div class="row">
                        <div class="col-md-5">
                            <input type="password" class="form-control" id="exampleInputEmail1" placeholder="Clave" name="txbClave" />
                        </div>
                        <div class="col-md-5">
                            <select class="form-control" name="cmbPerfil">
                                <option value="0">(Perfil)</option>
                                <option value="1">Administrador</option>
                                <option value="2">Usuario</option>
                            </select>
<!--                            <input type="text" class="form-control"id="exampleInputPassword1" placeholder="Usuario"/>-->
                        </div>
                    </div>
                    
                    
                  
                   
                  
                   
                    
                    
                    
<!--                  <button type="submit" class="btn btn-success">Submit</button>-->
               
               
               
                
            </div>
            
            <!-- Modal Footer -->
            <div class="modal-footer">
               <button type="submit" class="btn btn-success">Crear</button> 
            </div>
            
             </form>
                    
           
        </div>
    </div>
</div>
     

<!--MODAL PARA EDITAR  ***********************   -->
     
    <div id="view-modal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
  <div class="modal-dialog"> 
     <div class="modal-content">  
   
        <div class="modal-header"> 
           <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button> 
           <h4 class="modal-title">
           <i class="glyphicon glyphicon-user"></i> Modificar Usuario
           </h4> 
        </div> 
            
        <div class="modal-body">                     
           <div id="modal-loader" style="display: none; text-align: center;">
               
              
               
               
               <!-- ajax loader -->
           <img src="ajax-loader.gif">
           </div>
                            
           <!-- mysql data will be load here -->                          
           <div id="dynamic-content"></div>
        </div> 
        
                        
    </div> 
  </div>
</div>          
     
  <script>
$(document).ready(function(){
	
	$(document).on('click', '#getUsr', function(e){
		
		e.preventDefault();
		
		var uid = $(this).data('id');   // it will get id of clicked row
		
		$('#dynamic-content').html(''); // leave it blank before ajax call
		$('#modal-loader').show();      // load ajax loader
		
		$.ajax({
			url: './actUst',
			type: 'GET',
			data: 'id_usr='+uid,
			dataType: 'html'
		})
		.done(function(data){
			console.log(data);	
			$('#dynamic-content').html('');    
			$('#dynamic-content').html(data); // load response 
			$('#modal-loader').hide();		  // hide ajax loader	
		})
		.fail(function(){
			$('#dynamic-content').html('<i class="glyphicon glyphicon-info-sign"></i> Something went wrong, Please try again...');
			$('#modal-loader').hide();
		});
		
	});
	
});

</script>   
     
     
     

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://code.jquery.com/jquery.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
    <script src="js/custom.js"></script>
    
  </body>
</html>