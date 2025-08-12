<html>
<body>




<!--<tr>-->
<!--    <td>${ref.packageId}</td>-->
<!--    <td>${ref.packageName}</td>-->
<!--    <td>${ref.packagePrice}</td>-->
<!--    <td>${ref.destination}</td>-->
<!--    <td>${ref.days}</td>-->
<!--    <td>${ref.packageCount}</td>-->
<!--    <td><a href="view?id=${ref.packageId}"</td>-->
<!--</tr>-->


<div class="details-box">
    <div class="success-message">
        <h3>Tourism Package Saved Successfully!</h3>
    </div>
    <h2>Package Details</h2>
    <h3>Package Name: ${tourismDto.packageName}</h3>
    <h3>Destination: ${tourismDto.destination}</h3>
    <h3>Number of Days: ${tourismDto.days}</h3>
    <h3>Package Price: ${tourismDto.packagePrice}</h3>
    <h3>Person Count: ${tourismDto.personCount}</h3>
    <td><a href="view?id=${ref.packageId}"view></a></td>

</div>

</body>
</html>