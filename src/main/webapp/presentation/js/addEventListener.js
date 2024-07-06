/**
 * 
 */
var action = ""; //empId or "清空座位"
var seatSelected = "";

function addDropdownEventListener(){
	$('.dropdown-item').click(function(event) {
		event.preventDefault();
	    action = $(this).text();		
		$("#selectEmp").text(action);
	});	
}

function addSeatEventListener(){

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
			url: "/assignment0704/api/employee/seat",
			type: "POST",
			data: jsonForSubmit,
			dataType: "json",
			success: function(data) {
				resetSeatingChart();
				seatSelected = "";
			},
			error: function(xhr, status, error) {
				console.error('AJAX request failed:');
				console.error("請選擇員工編號/清空座位，並點選座位。");
				alert("請選擇員工編號(或清空座位選項)，並點選一個座位。");
				resetSeatingChart();
			}
		})

	});
}