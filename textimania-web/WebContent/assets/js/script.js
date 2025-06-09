$(function(){
	
	ts = (new Date()).getTime() + 30*1000;
	newYear = false;
		
	$('#countdown').countdown({
		timestamp	: ts,
		callback	: function(minutes, seconds) {
			if(minutes == 0 && seconds == 0) {
				window.location.href = 'host!listResults.action';
			}
		}
	});
});
