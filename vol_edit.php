<?php
{include('credentials.php');
}
$vol_id = $_POST['vol_id'];
$vol_name = $_POST['vol_name'];
$vol_gender = $_POST['vol_gender'];
$vol_qualification = $_POST['vol_qualification'];
$vol_location = $_POST['vol_location'];
$vol_status = $_POST['vol_status'];
$vol_mobile = $_POST['vol_mobile'];
$vol_new_mobile = $_POST['vol_new_mobile'];
$vol_email = $_POST['vol_email'];
$vol_language = $_POST['vol_language'];
$vol_pswd = $_POST['vol_pswd'];
$list['uid']="error";
if(isset($vol_id)){
  $sql = "UPDATE volunteer SET vol_id = '$vol_id' WHERE volunteer.vol_mobile = '$vol_mobile'";
  if(mysqli_query($dbconnected, $sql)){
$list['uid']="success";
}
}
if(isset($vol_name)){
  $sql = "UPDATE volunteer SET vol_name = '$vol_name' WHERE volunteer.vol_mobile = '$vol_mobile'";
  if(mysqli_query($dbconnected, $sql)){
$list['uid']="success";
}
}
if(isset($vol_gender)){
  $sql = "UPDATE volunteer SET vol_gender = '$vol_gender' WHERE volunteer.vol_mobile = '$vol_mobile'";
  if(mysqli_query($dbconnected, $sql)){
$list['uid']="success";
}
}
if(isset($vol_qualification)){
  $sql = "UPDATE volunteer SET vol_qualification = '$vol_qualification' WHERE volunteer.vol_mobile = '$vol_mobile'";
  if(mysqli_query($dbconnected, $sql)){
$list['uid']="success";
}
}
if(isset($vol_location)){
  $sql = "UPDATE volunteer SET vol_location = '$vol_location' WHERE volunteer.vol_mobile = '$vol_mobile'";
  if(mysqli_query($dbconnected, $sql)){
$list['uid']="success";
}
}
if(isset($vol_status)){
  $sql = "UPDATE volunteer SET vol_status = '$vol_status' WHERE volunteer.vol_mobile = '$vol_mobile'";
  if(mysqli_query($dbconnected, $sql)){
$list['uid']="success";
}
}
if(isset($vol_mobile)){
  $sql = "UPDATE volunteer SET vol_mobile = '$vol_new_mobile' WHERE volunteer.vol_mobile = '$vol_mobile'";
  if(mysqli_query($dbconnected, $sql)){
  $list['uid']="success";
  }
}
if(isset($vol_email)){
  $sql = "UPDATE volunteer SET vol_email = '$vol_email' WHERE volunteer.vol_mobile = '$vol_mobile'";
  if(mysqli_query($dbconnected, $sql)){
$list['uid']="success";
}
}
if(isset($vol_language)){
  $sql = "UPDATE volunteer SET vol_language = '$vol_language' WHERE volunteer.vol_mobile = '$vol_mobile'";
  if(mysqli_query($dbconnected, $sql)){
  $list['uid']="success";
  }
}
if(isset($vol_pswd)){
  $sql = "UPDATE volunteer SET vol_pswd = '$vol_pswd' WHERE volunteer.vol_mobile = '$vol_mobile'";
  if(mysqli_query($dbconnected, $sql)){
$list['uid']="success";
}
}
echo json_encode($list);
 ?>
