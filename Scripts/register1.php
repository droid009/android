<?php  

	$name = $_Post["name"];
	$email = $_Post["email"];
	$pass = $_Post["password"];

	require  "init.php";

	$query = "select * from user userdb where email like '".$email."';";
	$result = mysqli_query($con,$query);

	if(mysqli_num_rows($result)>0)
	{
		$response = array();
		$code = "reg_false";
		$message = "User Already Exists..";
		array_push($response, array("code"=>$code,"message"=>$message));
		echo json_encode(array("server_response"=>$response));
	}

	else
	{
		$query = "insert into userdb values('".$name."','".$email."','".$pass."');";
		$result = mysqli_query($con,$query);

		if (!$result) {

			$response = array();
			$code = "reg_false";
			$message = "Some Server error Try again...";
			array_push($response, array("code"=>$code,"message"=>$message));
			echo json_encode(array("server_response"=>$response));
		}
		else
		{
			$response = array();
			$code = "reg_true";
			$message = "Registration Sucess..";
			array_push($response, array("code"=>$code,"message"=>$message));
			echo json_encode(array("server_response"=>$response));
		}
	}
	require "init.php";
	$Email = $_Post["email"];
	$password = $_Post["password"];


?>