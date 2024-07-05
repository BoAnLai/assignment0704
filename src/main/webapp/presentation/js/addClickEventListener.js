/**
 * 
 */
var action = ""; //empId or "清空座位"
var seatSelected = "";

function addClickEventListener(){
    $('.dropdown-item').click(function() {
        action = $(this).text();		
		$("#selectEmp").text(action);
    });
	
	$('.seat').click(function(){
		
		// 尚未選擇座位 > 選擇座位
		if(!seatSelected){
			seatSelected = $(this).attr('data-seat');
			colorSeatSelected(seatSelected);
			
		// 點選了已選擇的座位 > 取消選擇
		}else if(seatSelected == $(this).attr('data-seat')){
			colorSeatUnselected(seatSelected);
			seatSelected = "";
			
		// 已選擇其他座位 > 改變選擇
		}else{
			colorSeatUnselected(seatSelected);
			seatSelected = $(this).attr('data-seat');
			colorSeatSelected(seatSelected);			
		}
	})
}

function addSubmitEventListener(){
	$('#submit').click(function() {
		
		let jsonForSubmit = {
			action: action,
			seatSelected: seatSelected
		}
		
		$.ajax({
			url: "/assignment0704/api/employee/setSeat",
			type: "POST",
			data: jsonForSubmit,
			dataType: "json",
			success: function(data) {
/*
				data.forEach((emp) => {
					let empId = emp.empId;
					let floorSeatSeq = emp.floorSeatSeq;

					let dropdownItemStr = "<li><a class='dropdown-item' href='#'>" + empId + "</a></li>"
					let dropdownItem = $(dropdownItemStr);
					$("ul.dropdown-menu").append(dropdownItem);

					if (floorSeatSeq) {
						let floorNo = floorSeatSeq.split('-')[0];
						let seatNo = floorSeatSeq.split('-')[1];

						changeSeat(floorNo, seatNo, empId);
					}
				})
				
				addClickEventListener();
				*/
			},
			error: function(xhr, status, error) {
				console.error('AJAX request failed:', error);
			}
		})

	});
}