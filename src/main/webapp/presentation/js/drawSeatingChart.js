/**
 * 
 */
function addFloorToChart(floorRow,floorNo){
	floorRow.push(floorNo);
	let floorDivStr = "<div class='floorContainer' data-floor=\"" + floorNo + "\"></div>";
	
	let floorDiv = $(floorDivStr);
	$("#seatingChartContainer").append(floorDiv);
}

function addSeatToChart(floorNo, seatNo){
	
	let text = floorNo + "樓: 座位" + seatNo;
	let seq = floorNo + "-" + seatNo;
	let seatDivStr = "<div class='seat btn btn-secondary' data-seat=\"" + seq + "\">" + text + "</div>";
	let seatDiv = $(seatDivStr);
	
	let selector = ".floorContainer[data-floor='" + floorNo + "']";
	$(selector).append(seatDiv);
	
}

$(document).ready(function () {
   $.ajax({
        url: "/assignment0704/api/seatingChart",
        type: "GET",
        dataType: "json",
        success: function (data) { 
        	
     		let floorRow = [];
     		
        	data.forEach((seat)=>{
        		let floorSeatSeq = seat.floorSeatSeq;
        		let floorNo = seat.floorNo;
        		let seatNo = seat.seatNo;
        		
        		if(floorRow.includes(floorNo)){
        			addSeatToChart(seat.floorNo,seat.seatNo);
        		}else{
        			// add floor
					addFloorToChart(floorRow, floorNo);
					addSeatToChart(seat.floorNo,seat.seatNo);
        		}
        	})
        	
        	insertDbEmpToSeat();
        	
     },
        error: function (xhr, status, error) {
          console.error('AJAX request failed:', error);
        }
      });
    });