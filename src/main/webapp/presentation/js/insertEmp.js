/**
 * 
 */

function insertEmpToDropdown(){
	$.ajax({
		url: "/assignment0704/api/employees",
		type: "GET",
		dataType: "json",
		success: function(data) {

			data.forEach((emp) => {
				let empId = emp.empId;

				let dropdownItemStr = "<li><a class='dropdown-item' href='#'>" + empId + "</a></li>"
				let dropdownItem = $(dropdownItemStr);
				$("ul.dropdown-menu").append(dropdownItem);
				addDropdownEventListener();
			})

		},
		error: function(xhr, status, error) {
			console.error('AJAX request failed:', error);
		}
	});
}

function insertEmpToSeat() {
	$.ajax({
		url: "/assignment0704/api/employees",
		type: "GET",
		dataType: "json",
		success: function(data) {

			data.forEach((emp) => {
				let empId = emp.empId;
				let floorSeatSeq = emp.floorSeatSeq;

				if (floorSeatSeq) {
					let floorNo = floorSeatSeq.split('-')[0];
					let seatNo = floorSeatSeq.split('-')[1];

					changeSeat(floorNo, seatNo, empId);
				}
			})
			

		},
		error: function(xhr, status, error) {
			console.error('AJAX request failed:', error);
		}
	});
}