<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.data.seatingChart.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>員工座位系統</title>
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

	%>

	<div class="dropdown">
		<button id="selectEmp" class="btn btn-outline-secondary dropdown-toggle" type="button"
			data-bs-toggle="dropdown" aria-expanded="false">選擇員工</button>
		<ul class="dropdown-menu">
			<li><a id="removeEmp" class='dropdown-item' href='#'>清空座位</a></li>
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
	
	<button id="submit" type="button" class="btn btn-primary">送出</button>



	<!-- drawing seating chart -->
	<script src="js/drawSeatingChart.js"></script>
   
   <!-- insert emp seating info already in db -->
   <!-- list all emp to dropdown -->
   	<script src="js/insertDbEmpToSeat.js"></script>

	<script src="js/addClickEventListener.js"></script>

	<script src="js/changeSeatColor.js"></script>

</body>
</html>