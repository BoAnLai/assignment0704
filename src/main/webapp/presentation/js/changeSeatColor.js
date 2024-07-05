/**
 * 
 */


function changeSeat(floorNo, seatNo, empId) {

	let text = floorNo + "樓: 座位" + seatNo
	let seq = floorNo + "-" + seatNo;
	let selector = ".floorContainer[data-floor='" + floorNo + "'] .seat[data-seat='" + seq + "']";
	let seat = $(selector);

	if (empId) {
		text += "[員編:" + empId + "]";
		seat.removeClass("btn-secondary");
		seat.removeClass("btn-success");
		seat.addClass("btn-danger");
	} else {
		seat.removeClass("btn-danger");
		seat.removeClass("btn-success");
		seat.addClass("btn-secondary");
	}

	seat.text(text);
}

function colorSeatSelected(seq){
	let selector = ".seat[data-seat='" + seq + "']";
	let seat = $(selector);
	
	seat.removeClass("btn-secondary");
	seat.removeClass("btn-danger");
	seat.addClass("btn-success");
}

function colorSeatUnselected(seq){
	let selector = ".seat[data-seat='" + seq + "']";
	let seat = $(selector);
	
	seat.removeClass("btn-success");
	
	if(seat.text().includes("員編")){
		seat.addClass("btn-danger");
	}else{
		seat.addClass("btn-secondary");		
	}
	
}