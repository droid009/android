<?php
	session_start();
	require_once('init.php');

		//this isset function will check register button is pressed
			
				// create three variable for input field
				$name = $_POST['name'];
				$Email = $_POST['email'];
				$Password = $_POST['password'];

				$query = "insert into userdb values ('$name','$Email','$Password')";
	
				$query_run = mysqli_query($con,$query);

					if ($query_run) 
					{
						# code...
						echo 'Registered Successfull';
					}
					else
					{							
						echo 'Registered Not Successfull';
					}
?>
	