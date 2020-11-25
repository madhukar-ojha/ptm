$(document).ready(function(){
	 $("#departmentId").change(function(){
		 var value = $("#departmentId").val();
		 console.log("value : " + value);
		 makeAjaxRequest(value);
	 })

	 function makeAjaxRequest(opts){
    $.ajax({
    	type: "GET",
        url : "http://localhost:8080/ptm/public/employee/getRoleList",
        data: { departmentId : opts },
        success: function(data) {
        	console.log("data " + data);
        	$.each( data, function( key, value ) {
                console.log( key + " : " + value );
            });
            popupateRoleList(data);
        }
    });
}

function popupateRoleList(params) {
	console.log("params" + params);
    $('#roleId').empty();
    $('#roleId').append('<option value="-1">--Select Role--</option>');
	
    params.forEach(function(entry){
        console.log("key : " + entry.id);
        console.log("name : " + entry.name);
        $('#roleId').append('<option value="' + entry.id+ '">' + entry.name + '</option>');
    });

}});