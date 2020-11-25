// Form validation for select tags with numeric values
$("#userForm").submit(function(event) {
	console.log("form submitted");
	$('form select').each(function() {
		var input = $(this);
		if (input.val() < 0) {
			alert("Select " + input.attr('name'));
			event.preventDefault();
			return false;
		};
	});
});