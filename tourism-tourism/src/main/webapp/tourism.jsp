<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tourism Package Form</title>
</head>
<body>
<h2>Tourism Package Details</h2>
<form action="saveTourism" method="post">

    <label for="packageName">Package Name:</label>
    <input type="text" id="packageName" name="packageName" required><br><br>

    <label for="destination">Destination:</label>
    <input type="text" id="destination" name="destination" required><br><br>

    <label for="days">Number of Days:</label>
    <input type="number" id="days" name="days" required><br><br>

    <label for="packagePrice">Package Price:</label>
    <input type="number" step="0.01" id="packagePrice" name="packagePrice" required><br><br>

    <label for="personCount">Person Count:</label>
    <input type="number" id="personCount" name="personCount" required><br><br>

    <input type="submit" value="Save Package">
</form>
</body>
</html>
