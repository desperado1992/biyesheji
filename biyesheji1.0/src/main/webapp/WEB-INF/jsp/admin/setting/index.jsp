<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<title>${sessionScope.user.name}欢迎您</title>
		<script src="${pageContext.request.contextPath}/resources/admin/theme/scripts/jquery-1.8.2.min.js"></script>

	<!-- JQuery v1.8.2 -->
<script>
  $(function () {
     
      $("#content > div").hide(); // Initially hide all content
	    $("#tabs li:first a").attr("id","current"); // Activate first tab
	    $("#content > div:first").fadeIn(); // Show first tab content
	    
	    $("#tabs a").on("click",function(e) {
	        e.preventDefault();
	        if ($(this).attr("id") == "current"){ //detection for current tab
	         return;      
	        }
	        else{             
	        resetTabs();
	        $(this).attr("id","current"); // Activate this
	   
	        $($(this).attr('name')).fadeIn(); // Show content for current tab
	        }
	    });

	    for (i = 1; i <= $("#tabs li").length; i++) {
	      if (myUrlTab == myUrlTabName + i) {
	          resetTabs();
	          $("a[name='"+myUrlTab+"']").attr("id","current"); // Activate url tab
	          $(myUrlTab).fadeIn(); // Show url tab content        
	      }
	    }
	    
	    
		/**$("#seltemp").bind("change",function(){
		if(!$(this).attr("relValue")){
	        alert("没有选择节点");
	    }else{
	        alert("选中节点文本："+$(this).attr("relText")+"<br/>选中节点值："+$(this).attr("relValue"));
	    }
	})**/
	
  });
	

 

   function resetTabs(){
	    $("#content > div").hide(); //Hide all content
	    $("#tabs a").attr("id",""); //Reset id's      
	}

	var myUrl = window.location.href; //get URL
	var myUrlTab = myUrl.substring(myUrl.indexOf("#")); // For mywebsite.com/tabs.html#tab2, myUrlTab = #tab2     
	var myUrlTabName = myUrlTab.substring(0,4); // For the above example, myUrlTabName = #tab
   

	
 
	
</script> 
	<%@ include file="/WEB-INF/jsp/public/common.jspf"%>
	<style type="text/css">
	  #tabs {
    overflow: hidden;
    width: 100%;
    margin: 0;
    padding: 0;
    list-style: none;
  }

  #tabs li {
    float: left;
    margin: 0 -15px 0 0;
  }

  #tabs a {
    float: left;
    position: relative;
    padding: 0 40px;
    height: 0;
    line-height: 30px;
    text-transform: uppercase;
    text-decoration: none;
    color: #fff;      
    border-right: 30px solid transparent;
    border-bottom: 30px solid #3D3D3D;
    border-bottom-color: #777\9;
    opacity: .3;
    filter: alpha(opacity=30);      
  }

  #tabs a:hover,
  #tabs a:focus {
    border-bottom-color: #2ac7e1;
    opacity: 1;
    filter: alpha(opacity=100);
  }

  #tabs a:focus {
    outline: 0;
  }

  #tabs #current {
    z-index: 3;
    border-bottom-color: #3d3d3d;
    opacity: 1;
    filter: alpha(opacity=100);      
  }

  /* ----------- */
  #content {
      background: #fff;
      border-top: 2px solid #3d3d3d;
      padding: 2em;
      /*height: 220px;*/
  }

  #content h2,
    #content h3,
    #content p {
      margin: 0 0 15px 0;
  }  

  /* Demo page only */
  #about {
      color: #999;
      text-align: center;
      font: 0.9em Arial, Helvetica;
  }

  #about a {
      color: #777;
  }   
	</style>
</head>
<body>
<!-- Start Content -->
	<div class="container-fluid left-menu">
		
		<div class="navbar main">
			<div class="innerpx">
				<button type="button" class="btn btn-navbar hidden-desktop hidden-tablet">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<div class="positionWrapper">
					<span class="line"></span>
										<div class="profile">
						<img src="" class="avatar" alt="Profile" />
						<span class="info hidden-phone">
							<strong>${sessionScope.user.logName}</strong>
							<em>后台管理系统</em>
						</span>
					</div>
					<ul class="notif">
						<li><a href="" class="glyphicons chat btn" rel="tooltip" data-placement="bottom" data-original-title="7 new chat message(s)"><i></i><span>7</span></a></li>
						<li><a href="" class="glyphicons shopping_cart btn" rel="tooltip" data-placement="bottom" data-original-title="1 new product(s)"><i></i><span>1</span></a></li>
						<li><a href="" class="glyphicons user_add btn" rel="tooltip" data-placement="bottom" data-original-title="4 new member(s)"><i></i><span>4</span></a></li>
						<li><a href="" class="glyphicons envelope btn" rel="tooltip" data-placement="bottom" data-original-title="3 new email(s)"><i></i><span>3</span></a></li>
					</ul>
						<%@ include file="/WEB-INF/jsp/public/head.jspf"%>
				</div>
			</div>
		</div>
	
		<div class="row-fluid rrow main">
			<div class="span12 main col" role="main">
				<div class="row-fluid rrow">
					<div class="span2 col main-left hide hidden-phone menu-large">
						<div class="rrow scroll-y-left">
							<div class="iScrollWrapper">
								<%@include file="/WEB-INF/jsp/admin/center.jsp" %>
							</div>
							<span class="navarrow hide">
								<span class="glyphicons circle_arrow_down"><i></i></span>
							</span>
						</div>
					</div>
					<div class="span10 col main-right">
						<div class="rrow scroll-y" id="mainYScroller">
								<div class="inner topRight">
								<ul class="breadcrumb">
	<li><a href="index.html" class="glyphicons home" target="_blank"><i></i> 首页预览</a></li>
	<li class="divider"></li>
	<li>管理后台</li>
</ul>
<div class="separator"></div>

<h2 class="glyphicons display"><i></i> 网站设置</h2>
<div class="separator"></div>
	


 <ul id="tabs">
    <li><a href="#" name="#tab1">基本设置</a></li>
    <li><a href="#" name="#tab2">邮件设置</a></li>
   
    <li><a href="#" name="#tab3">友情链接</a></li>    
</ul>

<div id="content"> 
    <div id="tab1">
 


<h2 class="glyphicons user"><i></i> 系统设置</h2>
<div class="separator"></div>

<div class="row-fluid">
	
	<div class="span9">
		<form class="form-horizontal" />
		<div class="tab-content" style="padding: 0;">
			<div class="tab-pane active" id="account-details">
			
				<div class="widget widget-2">
					<div class="widget-head">
						<h4 class="heading glyphicons edit"><i></i>基本设置</h4>
					</div>
					<div class="widget-body" style="padding-bottom: 0;">
						<div class="row-fluid">
							<div class="span6">
								<div class="control-group">
									<label class="control-label">网店名称:</label>
									<div class="controls">
										<input type="text" value="网店名称" class="span10" />
										<span style="margin: 0;" class="btn-action single glyphicons circle_question_mark" rel="popover" data-placement="top" data-original-title="Help" data-content="First name is mandatory"><i></i></span>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">联系地址</label>
									<div class="controls">
										<input type="text" value="Doe" class="span10" />
										<span style="margin: 0;" class="btn-action single glyphicons circle_question_mark" rel="popover" data-placement="top" data-original-title="Help" data-content="Last name is mandatory"><i></i></span>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">email</label>
									<div class="controls">
										<input type="text" value="1050316096@qq.com" class="span10" />
										<span style="margin: 0;" class="btn-action single glyphicons circle_question_mark" rel="popover" data-placement="top" data-original-title="Help" data-content="Last name is mandatory"><i></i></span>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">热搜关键字</label>
									<div class="controls">
										<div class="input-append">
												<input type="text" value="shop" class="span10" />
											<span class="add-on glyphicons calendar"><i></i></span>
										</div>
									</div>
								</div>
							</div>
							<div class="span6">
								
								<div class="control-group">
									<label class="control-label">邮编</label>
									<div class="controls">
										<input type="text" value="25" class="input-mini" />
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">网站logo</label>
									<div class="controls">
								<div class="fileupload fileupload-new" data-provides="fileupload">
							  	<span class="btn btn-file"><span class="fileupload-new">Select file</span><span class="fileupload-exists">Change</span><input type="file" /></span>
							  	<span class="fileupload-preview"></span>
							  	<a href="#" class="close fileupload-exists" data-dismiss="fileupload" style="float: none">�</a>
							</div>
									</div>
								</div>
							</div>
							
						</div>
						<hr class="separator bottom" />
						<div class="control-group">
							<label class="control-label">商店描述</label>
							<div class="controls">
								<textarea id="mustHaveId" class="wysihtml5 span12" rows="5">Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium.</textarea>
							</div>
						</div>
						<div class="form-actions" style="margin: 0;">
							<button type="submit" class="btn btn-icon btn-primary glyphicons circle_ok"><i></i>保存</button>
							<button type="button" class="btn btn-icon btn-default glyphicons circle_remove"><i></i>取消</button>
						</div>
					</div>
				</div>
			</div>
			<div class="tab-pane" id="account-settings">
				<div class="widget widget-2">
					<div class="widget-head">
						<h4 class="heading glyphicons settings"><i></i>在线客服</h4>
					</div>
					<div class="widget-body" style="padding-bottom: 0;">
						<div class="row-fluid">
							<div class="span3">
								<strong>Change password</strong>
								<p class="muted">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
							</div>
							<div class="span9">
								<label for="inputEmail">Username</label>
								<input type="text" id="" class="span10" value="john.doe2012" disabled="disabled" />
								<span style="margin: 0;" class="btn-action single glyphicons circle_question_mark" rel="popover" data-placement="top" data-original-title="Help" data-content="Username can't be changed"><i></i></span>
								<div class="separator"></div>
										
								<label for="inputPasswordOld">Old password</label>
								<input type="password" id="inputPasswordOld" class="span10" value="" placeholder="Leave empty for no change" />
								<span style="margin: 0;" class="btn-action single glyphicons circle_question_mark" rel="popover" data-placement="top" data-original-title="Help" data-content="Leave empty if you don't wish to change the password"><i></i></span>
								<div class="separator"></div>
								
								<label for="inputPasswordNew">New password</label>
								<input type="password" id="inputPasswordNew" class="span12" value="" placeholder="Leave empty for no change" />
								<div class="separator"></div>
								
								<label for="inputPasswordNew2">Repeat new password</label>
								<input type="password" id="inputPasswordNew2" class="span12" value="" placeholder="Leave empty for no change" />
								<div class="separator"></div>
							</div>
						</div>
						<hr class="separator bottom" />
						<div class="row-fluid">
							<div class="span3">
								<strong>Contact details</strong>
								<p class="muted">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
							</div>
							<div class="span9">
								<div class="row-fluid">
								<div class="span6">
									<label for="inputEmail">Phone</label>
									<div class="input-prepend">
										<span class="add-on glyphicons phone"><i></i></span>
										<input type="text" id="inputEmail" class="input-large" placeholder="01234567897" />
									</div>
									<div class="separator"></div>
										
									<label for="inputEmail">E-mail</label>
									<div class="input-prepend">
										<span class="add-on glyphicons envelope"><i></i></span>
										<input type="text" id="inputEmail" class="input-large" placeholder="contact@mosaicpro.biz" />
									</div>
									<div class="separator"></div>
										
									<label for="inputEmail">Website</label>
									<div class="input-prepend">
										<span class="add-on glyphicons link"><i></i></span>
										<input type="text" id="inputEmail" class="input-large" placeholder="http://www.mosaicpro.biz" />
									</div>
									<div class="separator"></div>
								</div>
								<div class="span6">
									<label for="inputYahoo">Facebook</label>
									<div class="input-prepend">
										<span class="add-on glyphicons facebook"><i></i></span>
										<input type="text" id="inputYahoo" class="input-large" placeholder="/mosaicpro" />
									</div>
									<div class="separator"></div>
									
									<label for="inputYahoo">Twitter</label>
									<div class="input-prepend">
										<span class="add-on glyphicons twitter"><i></i></span>
										<input type="text" id="inputYahoo" class="input-large" placeholder="/mosaicpro" />
									</div>
									<div class="separator"></div>
									
									<label for="inputSkype">Skype ID</label>
									<div class="input-prepend">
										<span class="add-on glyphicons skype"><i></i></span>
										<input type="text" id="inputSkype" class="input-large" placeholder="mySkypeID" />
									</div>
									<div class="separator"></div>
									
									<label for="inputYahoo">Yahoo ID</label>
									<div class="input-prepend">
										<span class="add-on glyphicons yahoo"><i></i></span>
										<input type="text" id="inputYahoo" class="input-large" placeholder="myYahooID" />
									</div>
									<div class="separator"></div>
								</div>
								</div>
							</div>
						</div>
						<div class="form-actions" style="margin: 0; padding-right: 0;">
							<button type="submit" class="btn btn-icon btn-primary glyphicons circle_ok pull-right"><i></i>Save changes</button>
						</div>
					</div>
				</div>
				
			</div>
		</div>
		</form>
		
	</div>
	
	<div class="span3">
		<div class="widget widget-2 primary widget-body-white">
			<div class="widget-head">
				<h4 class="heading glyphicons pencil"><i></i> 系统设置</h4>
			</div>
			<div class="widget-body list list-2">
				<ul>
					<li class="active"><a class="glyphicons user" href="#account-details" data-toggle="tab"><i></i>基本设置</a></li>
	   				<li><a class="glyphicons settings" href="#account-settings" data-toggle="tab"><i></i>客服设置</a></li>
				</ul>
			</div>
		</div>
		<div class="widget widget-2 primary widget-body-white">
			<div class="widget-head">
				<h4 class="heading glyphicons picture"><i></i>图片预览</h4>
			</div>
			<div class="widget-body center">
				<div class="fileupload fileupload-new" data-provides="fileupload">
				  <div class="fileupload-new thumbnail"><img src="" /></div>
				  <div class="fileupload-preview fileupload-exists thumbnail" style="max-width: 100%;"></div>
				  <div>
					  <span class="btn btn-file btn-inverse btn-icon glyphicons picture"><i></i><span class="fileupload-new">选择图片</span><span class="fileupload-exists">修改</span><input type="file" /></span>
					  <a href="#" class="btn fileupload-exists" data-dismiss="fileupload">移除</a>
				  </div>
				</div>
			</div>
		</div>
	</div>
</div>
<br />
    
    </div>
    <div id="tab2">
    顶顶顶
    
    </div>
    <div id="tab3">.顶顶顶顶顶顶规划.</div>
  
</div>

											</div>
						</div>
					</div>
				</div>
			</div>

		<!-- End Content -->
		</div>
		
		<!-- Sticky Footer -->
	<%@include file="/WEB-INF/jsp/public/footer.jspf" %>
		
	</div>
	
	


	

</body>
</html>