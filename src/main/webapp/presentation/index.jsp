<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.data.seatingChart.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>OaSis Home</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<style>
.floorContainer, .legend {
	display: flex;
	flex-wrap: wrap; /* Allow wrapping to multiple lines if needed */
}

.seat {
	width: 200px; /* Example width for child divs */
	margin: 5px; /* Example margin for spacing */
	border: 1px solid #ddd;
}
</style>
</head>
<body>
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"
		integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
		integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>

	<h1>員工座位系統</h1>
	<%
	SeatService seatSvc = new SeatService();
	List<SeatVO> seatList = seatSvc.getAll();

	for (SeatVO seat : seatList) {
		System.out.println(seat);
		System.out.println("inside for loop");
	}
	%>

	<div class="dropdown">
		<button class="btn btn-outline-secondary dropdown-toggle" type="button"
			data-bs-toggle="dropdown" aria-expanded="false">選擇員工</button>
		<ul class="dropdown-menu">
			<li><a class="dropdown-item" href="#">Action</a></li>
			<li><a class="dropdown-item" href="#">Another action</a></li>
			<li><a class="dropdown-item" href="#">Something else here</a></li>
		</ul>
	</div>

	<div id="seatingChartContainer">
	</div>
	
	<br>
	
	<div class="legend">
		<div><button type="button" class="btn btn-secondary">空位</button></div>
		<div><button type="button" class="btn btn-danger">已占用</button></div>
		<div><button type="button" class="btn btn-success">請選擇</button></div>
	</div>
	
	<br>
	
	<button type="button" class="btn btn-primary">送出</button>


	<script>
	   $(document).ready(function () {
		   $.ajax({
		        url: "/assignment0704/api/employees",
		        type: "GET",
		        dataType: "json",
		        success: function (data) { 
		        	
	        		let floorRow = [];
	        		
		        	data.forEach((seat)=>{
		        		let floorSeatSeq = seat.floorSeatSeq;
		        		let floorNo = seat.floorNo;
		        		let seatNo = seat.seatNo;
		        		console.log(floorSeatSeq);
		        		
		        		if(floorRow.includes(floorNo)){
		        			console.log("in if block");
		        		}else{
		        			// add floor
							addFloorToChart(floorRow, floorNo);
		        		}
		        	})
		        	
		        	data.forEach((seat)=>{
		        		addSeatToChart(seat.floorNo,seat.seatNo);
		        	})
	        },
		        error: function (xhr, status, error) {
		          console.error('AJAX request failed:', error);
		        }
		      });
		    });
	</script>

	<script>
	
	function addFloorToChart(floorRow,floorNo){
		floorRow.push(floorNo);
		let floorDivStr = "<div class='floorContainer' data-floor=\"" + floorNo + "\"></div>";
		
		let floorDiv = $(floorDivStr);
		$("#seatingChartContainer").append(floorDiv);
	}
	
	function addSeatToChart(floorNo, seatNo){
		
		let seatDivStr = "<div class='seat btn btn-secondary' data-seat=\"" + seatNo + "\">" + floorNo + seatNo + "</div>";
		let seatDiv = $(seatDivStr);
		
		let selector = ".floorContainer[data-floor='" + floorNo + "']";
		$(selector).append(seatDiv);
		
		$(".floorContainer[data-floor='5']").text("hi");
		
		console.log("func addSeatToChart execute");
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
	        		console.log(floorSeatSeq);
	        		
	        		if(floorRow.includes(floorNo)){
	        			console.log("in if block");
	        		}else{
	        			// add floor
						addFloorToChart(floorRow, floorNo);
	        		}
	        	})
	        	
	        	data.forEach((seat)=>{
	        		addSeatToChart(seat.floorNo,seat.seatNo);
	        	})
        },
	        error: function (xhr, status, error) {
	          console.error('AJAX request failed:', error);
	        }
	      });
	    });

   </script>

</body>
</html>