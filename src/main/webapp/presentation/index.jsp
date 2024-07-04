<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.data.employee.*"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>OaSis Home</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	<style>
		
    </style>
</head>
<body>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

	<h1>hello assignment0704</h1>
	<% 
		EmployeeService empSvc = new EmployeeService();
		List<EmployeeVO> empList = empSvc.getAll();

		for(EmployeeVO emp:empList){
			System.out.println(emp);
			System.out.println("inside for loop");			
		}
	%>	
	
	
	<script>
   $(document).ready(function () {
	   $.ajax({
	        url: "/oasis/art",
	        type: "POST",
	        data: { act: "getFamousForum" },
	        dataType: "json",
	        success: function (data) { 
	        	console.log(data);
	        	const containers = $('.first-container, .second-container, .third-container');

            containers.each(function(index) {
                if (index < data.length) {
                    const container = $(this);
                    const img = container.find('.famous-img');
                    const title = container.find('.famous-title');
                    const articleCount = container.find('.famous-article-count');
                    const form = container.find('.famous-path');

                    img.attr('src', data[index].gameImg);
                    title.text(data[index].gameName);
                    articleCount.text("文章數(含回文): " + data[index].artCounts);
                    form.attr('action', "/oasis/game/forum/"+data[index].gameId)
                }
            });
        },
	        error: function (xhr, status, error) {
	          console.error('AJAX request failed:', error);
	        }
	      });
	    });

   </script> 	
  
</body>
</html>