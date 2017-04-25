<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="jslib/jquery-easyui-1.3.1/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="jslib/jquery-easyui-1.3.1/jquery.easyui.min.js"></script>
<script type="text/javascript" src="jslib/jquery-easyui-1.3.1/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" href="jslib/jquery-easyui-1.3.1/themes/default/easyui.css" type="text/css">
<link rel="stylesheet" href="jslib/jquery-easyui-1.3.1/themes/icon.css" type="text/css">
<script type="text/javascript" src="jslib/uasyui-Util.js"></script>
<script type="text/javascript">
	
	$(function(){
	});
	
	function regUser(){
		/*
		$('#regForm').form('submit',{
		    url:'${pageContext.request.contextPath}/userAction!reg.action',
		    success:function(data){
		    console.info(data);
		    	
		    $.messager.show({
		    	title:'注册',
		    	msg:data.msg
		    });
		    }
		});
		*/
		//是否通过easyui的校验
		if($("#regForm").form("validate")){
			
		$.ajax({
			url:'${pageContext.request.contextPath}/userAction!reg.action',
			data:$("#regForm").serialize(),
			dataType:'json',
			success:function(data){
				if(data.success){
					$('#regId').dialog('close');
				}
				$.messager.show({
					title:'注册',
					msg:data.msg,
				});
			}
		});
		
		}else{
			alert("数据校验失败！");
		}
		
		
	}
	
</script>
<title>Login Page</title>
</head>
<body class="easyui-layout">
	<div region="north" style="height: 60px;"></div> 
	<div region="south" style="height: 20px;"></div> 
	<div region="west"  style="width: 200px;">
		<div class="easyui-panel" data-options="title:'ssss',border:false"></div>
	</div> 
	<div region="east" title="east" style="width: 200px;"></div> 
	<div region="center" title="center"></div>
<jsp:include page="user/login.jsp"></jsp:include>

<jsp:include page="user/reg.jsp"></jsp:include>

<a href="${pageContext.request.contextPath}/userAction!getOrderList.action">订单列表</a>
	
</body>
</html>