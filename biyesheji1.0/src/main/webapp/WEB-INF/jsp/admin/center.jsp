<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

	
	
<ul>
<s:iterator value="#application.topPrivilegeList" >
		                        <s:if test="#session.user.hasPrivilegeByName(name)">
								 
								   <li class="glyphicons hasSubmenu2">
								   <a data-toggle="collapse" class="glyphicons ${icon}" href="#${icon}"><i></i><span>${name}</span></a>
										<ul class="collapse" id="${icon}">
										<s:iterator value="childrens">
	            	                 <s:if test="#session.user.hasPrivilegeByName(name)">
											<li class=""><a href="${pageContext.request.contextPath}/${url}.action" class="glyphicons show_thumbnails"><i></i><span>${name}</span></a></li>
											<!-- <li class=""><a href="${pageContext.request.contextPath}/${url}.action" class="glyphicons show_big_thumbnails"><i></i><span>${name}</span></a></li> -->
											
										 </s:if>
	            	                </s:iterator>
										</ul>
										</li>
								    </s:if>
	            	                </s:iterator>
</ul>
