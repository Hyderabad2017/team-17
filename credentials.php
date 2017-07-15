<?php
$hostname = "localhost";
$username = "root";
$password = "";
$dbname = "cfg_17";
$tb_events = "events";
$tb_student = "student";
$tb_volunteer = "volunteer";
$dbconnected=mysqli_connect($hostname,$username,$password);
if(!$dbconnected)
{
    die("Could not connect: " . mysql_error());
}
$dbselected=mysqli_select_db($dbconnected,$dbname);
?>
