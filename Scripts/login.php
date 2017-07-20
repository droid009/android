<?php
 
	require "init.php";

	$Email = $_POST["email"];
	$Password = $_POST["password"];

	$query = mysqli_query("SELECT * From userdb WHERE email like '$Email' and password like '$Password'");

	$result = mysqli_query($con,$query);

	if (mysqli_num_rows($result) > 0) {
		# code...
		echo "login sucess";
	}
	else{
		echo "login not success";
	}
 ?>
 