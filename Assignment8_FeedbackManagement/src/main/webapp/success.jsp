<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Feedback Submitted</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div class="container">
  <div class="success-icon">&#10004;</div>
  <h2>Thank You, <%= request.getAttribute("name") %>!</h2>
  <p style="text-align:center;">Your feedback has been saved successfully.</p>
  <br><a href="index.html">Submit Another Feedback</a>
</div>
</body>
</html>
