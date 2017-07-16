<?php
{include('credentials.php');
}
$req_id = $_POST['req_id'];
$sql = "SELECT stu_primary,stu_secondary,stu_backup FROM cfg_17.student WHERE req_id = '$req_id'";
$result = mysqli_query($dbconnected, $sql);
while($row = mysqli_fetch_assoc($result)){
  $stu_primary = $row['stu_primary'];
  $stu_secondary = $row['stu_secondary'];
  $stu_backup = $row['stu_backup'];
  echo $stu_primary."<br>";
  echo $stu_secondary."<br>";
  echo $stu_backup."<br>";
}
 ?>
