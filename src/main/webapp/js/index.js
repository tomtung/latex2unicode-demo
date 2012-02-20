$.ajaxSetup({
	cache: false
});

function query(){
	var $tex = $('#tex');

	if($tex.val() == ''){
		$('#result').html('');
		return false;
	}

	$('#result').load("/q", {tex: $tex.val()})
	$.post("/q", {tex: $tex.val()}, function(data){
		$('#result').text(data)
	})
}

var text = "\nNow type in this box and try it yourself.\\;\\;\\ddot\\smile";
var charIndex = 0;
function type(){
	var delta = Math.floor(Math.random()*3);
	if(charIndex<=text.length){
		var delta = Math.floor(Math.random()*7);
		$('#tex').val($('#tex').val() + text.substr(charIndex, delta));
		$('#tex').keyup();
		charIndex = charIndex + delta;
		setTimeout("type();", 150 + Math.floor(Math.random()*11));
	}
}

var flag = false;

$(function() {				
	$('#tex').keyup(function(e){
		e.preventDefault();
		if(flag){
			return false;
		}
		flag = true;
		query();
		setTimeout("flag=false; query();",1000);
	});

	query();

	$('#tex').autoResize({
		animate: 100,
		maxHeight: 2000
	});

	setTimeout("type();", 2000);
	$('#tex').focus();
});