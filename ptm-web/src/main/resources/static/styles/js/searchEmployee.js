$(document).ready(function(){
	// Setting focus on search text field
	$("#empid").focus(); 
	
	$("#search").click(function(){
	var id = $('#empid').val();
	// Validating emp id. If blank or 0, return 
	if(id <= 0) {
		alert('enter employee id');
		return;
	}
	// Clearing text and children inside div
	$('#divEmpDetail').empty();
	// Clearing anchor span
	$('#spUpdate').empty();
	
	 var url = $('#empSearchUrl').val();
	 console.log(url);
	 var params = {id : id, contentType: "application/json",}; 
	 var ajaxReq = $.getJSON(url, params);
	 ajaxReq.done(function (response) {
		 console.log(response);
		 // create table
		 $('#id').val(response.id);
		 var empid = $('#id').val()
		 console.log("empid="+empid);
		 console.log("id="+ $('#id').val());
		 var $table = $('<table>');
		 // caption
		 $table.append('<caption>EmployeePersonal Detail</caption>')
		 // thead
		 .append('<thead>').children('thead')
		 .append('<tr />').children('tr').append('<th>Id</th><th>Name</th><th>Designation</th><th>Date of birth</th><th>Father Name</th><th>Mother Name</th><th>Mobile</th>');
		//tbody
		 var $tbody = $table.append('<tbody />').children('tbody');
		// add row
		 var tblRow = $tbody.append('<tr />').children('tr:last');
		  tblRow.append("<td>"+empid+"</td>")
		 .append("<td>"+response.fullName+"</td>")
		 .append("<td>"+response.designation+"</td>")
		 .append("<td>"+response.dateOfBirth+"</td>")
		 .append("<td>"+response.fatherName+"</td>")
		 .append("<td>"+response.motherName+"</td>")
		 .append("<td>"+response.mobile+"</td>");
		  var anchor = $("<a>");
		  anchor.append("<a href=/ptm/employee/search?id="+id+"&action=empUpdate>edit</a>");
		  var update = $('#actionUpdate').val();
		  if(update != null && update != "") {
			  tblRow.append(anchor);  
		  }
		  $table.appendTo('#divEmpDetail');
		  // setting id to form field
		  $('#id').val(response.id);
		  // Fetching action name
		  var action = $('#action').val();
		
		  // preparing anchor tag for update action
		  
		  // Adding anchor tag to span
		  anchor.appendTo('#spUpdate');
		  // show employee reset form
		  $('#divEmpUpdateForm').show();
	    })
	 	ajaxReq.fail(function (response){
		 	$('#divEmpDetail').text('no record found');
		  // hide employee update form
		 	$('#divEmpUpdateForm').hide();
		 });
     });
});
