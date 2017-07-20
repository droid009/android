 <?php

    //Varible to store 
    $host = "localhost";
    $user = "root";
    $password = "";
    $dbname = "android";

    //$con is variable and mysqli_connect is in-built php function to connect to DB
    $con = mysqli_connect($host,$user,$password,$dbname);

    //If Above con variable fail to connect to DB it will give error message.
    /*if(!$con)
    {
        die("Error in db Connection".mysqli_connect_error());
    }
    //If Above con variable sucess to connect to DB it will give error message.
    else
    {
        echo "<h3>DB connection Successfull</h3>";
    }*/
?> 