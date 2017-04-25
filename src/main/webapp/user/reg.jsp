<%@ page language="java" pageEncoding="utf-8"%>
<!-- 	注册 -->
	<div id="regId" style="width:250px;" class="easyui-dialog" data-options="title:'注册',modal:true,closed:true,
		buttons:[{
				text:'注册',
				iconCls:'icon-edit',
				handler:function(){
					regUser();
				}
			}]">
		<form id="regForm" method="post">
			<table>
				<tr>
					<th>用户名</th>
					<td><input name="username" class="easyui-validatebox" data-options="required:true,missingMessage:'用户名必填' "/></td>
				</tr>
				<tr>
					<th>密码</th>
					<td><input type="password" name="password" class="easyui-validatebox" data-options="required:true,missingMessage:'密码必填'"/></td>
				</tr>
				<tr>
					<th>重复密码</th>
					<td><input type="password" name="rePassword" class="easyui-validatebox" data-options="required:true,validType:'eqPwd[\'#regForm input[name=password]\']' "/></td>
				</tr>
			</table>
		</form>
	</div>