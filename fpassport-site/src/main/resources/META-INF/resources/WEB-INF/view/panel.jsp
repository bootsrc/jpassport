<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="common.jsp"  %>

<!DOCTYPE html>
<html>
<head>
	<script src="<%=basePath%>js/panel.js"></script>
	<link rel="stylesheet" href="<%=basePath %>css/panel.css">
</head>
<body>
	<div>定时找回丢失的审核任务的调度程序。 SchedulingTask状态：</div><br/>
	<button onclick="start()">启动 </button><br/><br/>
	<button onclick="stop()">停止 </button><br/><br/><br/>
	<div id="output">运行中...</div><br/>
	<button onclick="getBackOneDayTask()">找回从现在起的24小时以内任务</button><br/><br/><br/>
	<div id="getBackOutput"></div><br/>
</body>
</html>