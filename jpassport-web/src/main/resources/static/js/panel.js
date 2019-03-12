function start() {
	$.ajax({
		url: basePath + "start",
		type: 'POST',
		dataType: "text",
		success: function (result) {
			console.log("----------> start.");
			
			$("#output").text("运行中...");
		}
	});
}

function stop() {
	$.ajax({
		url: basePath + "stop",
		type: 'POST',
		dataType: "text",
		success: function(result) {
			console.log("----------> stop.");
			$("#output").text("已暂停");
		}
	});
}

function getBackOneDayTask() {
	$.ajax({
		url: basePath + "getbackonedaytask",
		type: 'POST',
		dataType: "text",
		success: function(result) {
			console.log("----------> stop.");
			$("#getBackOutput").text("已经执行24小时找回操作");
		}
	});
}