<?php
{include('credentials.php');
}
$vol_mobile = 10;//$_POST['vol_mobile'];
$vol_pswd = "abd";//$_POST['vol_pswd'];
if($vol_mobile != NULL && $vol_pswd != NULL) {
$sql = "SELECT vol_mobile, vol_pswd FROM cfg_17.volunteer WHERE vol_mobile = '$vol_mobile' and vol_pswd = '$vol_pswd'";

$res = mysqli_query($dbconnected, $sql);
if(mysqli_num_rows($res) == 1){
  $list['uid']="success";
  echo json_encode($list);
}
else {
  $list['uid']="error";
  echo json_encode($list);
}
}
 ?>
