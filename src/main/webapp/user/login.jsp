<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 	登陆 -->
	<div class="easyui-dialog" data-options="title:'登陆',modal:true,closable:false,
		buttons:[{
				text:'注册',
				iconCls:'icon-edit',
				handler:function(){
				$('#regId input').val('');
				$('#regId').dialog('open');
				}
			},{
				text:'登陆',
				iconCls:'icon-help',
				handler:function(){alert('help')}
			}]">
		<table>
			<tr>
				<th>用户名</th>
				<td><input></td>
			</tr>
			<tr>
				<th>密码</th>
				<td><input></td>
			</tr>
		</table>
	</div>