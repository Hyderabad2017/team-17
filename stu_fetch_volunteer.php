<?php
{include('credentials.php');
}
$stu_mobile = isset($_POST['stu_mobile']);
$sql = "SELECT stu_primary,stu_exam,stu_date_exam FROM student WHERE stu_mobile = '$stu_mobile'";
$result = mysqli_query($dbconnected, $sql);
while($rows = mysqli_fetch_assoc($result)){
  $stu_primary = $rows['stu_primary'];
  $stu_exam = $rows['stu_exam'];
  $stu_date_exam = $rows['stu_date_exam'];
}
$sql2 = "SELECT vol_name,vol_mobile FROM cfg_17.volunteer WHERE vol_id = '$stu_primary'";
$result2 = mysqli_query($dbconnected, $sql2);
while($rows = mysqli_fetch_assoc($result2)){
  $vol_name = $rows['vol_name'];
  $vol_mobile = $rows['vol_mobile'];
}
 ?>
