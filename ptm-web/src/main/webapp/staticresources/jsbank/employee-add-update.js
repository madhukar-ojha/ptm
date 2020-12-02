$(document).ready(function(){
	// Making ajax requet to populate rold dropdown
	// based on selected department dropdown
	$("#departmentId").change(function(){
		let dropdown = $('#roleId');
		 dropdown.empty();
		 dropdown.append('<option value="-1">-Select Role-</option>');
	//	 dropdown.prop('selectedIndex', 0);
		var id = $('#departmentId').val();
	//	var url = $('#empSearchUrl').val();
		var url = "/ptm/public/employee/getRoleList";
		 console.log(id);
		 var params = {departmentId : id, contentType: "application/json"}; 
		 var ajaxReq = $.getJSON(url, params);
		 ajaxReq.done(function (response) {
			 console.log(response);
			 $.each(response, function (key, entry) {
				dropdown.append($('<option></option>').attr('value', entry.id).text(entry.name));
			 });
		 });
	});
	// Validating radion and select element on form submit
	$("form").submit(function(event) {
		var rval =$("input[name='gender']:checked").val();
			if(rval == undefined) {
			alert("Select Gender");
			event.preventDefault();
			return false;
		}
		$('form select').each(function(){
			var input = $(this);
			// If select value is < 0
			if (input.val() < 0) {
				// Making first char of element name to upper case
				var v = input.attr('name').charAt(0);
				var t = v.toUpperCase();
				v = input.attr('name').replace(v,t);
				alert("Select " + v);
				event.preventDefault();
				return false;
			};
		});
	});
});

