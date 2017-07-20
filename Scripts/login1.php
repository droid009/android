<?php
	session_start();
	require_once('init.php');
	
				$Email= $_POST['email'];
				$Password= $_POST['password'];

				$query = "SELECT * FROM userdb WHERE email = '$Email' and Password = '$Password'";
				
				//echo $query;
				$res = mysqli_query($con,$query);
				
				//echo mysql_num_rows($query_run);
				if($res)
				{
					echo "login sucess";
				}
				else
				{
					echo "login not success";
				}
?>
		
	