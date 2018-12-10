<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-md-2">
    <div class="sidebar content-box" style="display: block;">
                <ul class="nav">
                    <c:forEach items="${menu}" var="menuPadre">
                    <!-- Main menu -->
                        <c:if test="${menuPadre.padreMenu==0}">
                     <li class="submenu">
                         <a href="#">
                             
                                 <c:out value="${menuPadre.nomMenu}"/>
                            
                            <span class="caret pull-right"></span>
                         </a>
                         <!-- Sub menu -->
                         <ul>
                             <c:forEach items="${menu}" var="menuHijo">
                                 <c:if test="${menuHijo.padreMenu==menuPadre.idMenu}">
                                 <li><a href="${menuHijo.urlMenu}"><c:out value="${menuHijo.nomMenu}"/></a></li>
                                 </c:if>
                                    
                             </c:forEach>   
                        </ul>
                         
                    </li>
                    </c:if>
                    </c:forEach>
                </ul>
    </div>
</div>