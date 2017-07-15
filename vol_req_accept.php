<?php
include "credentials.php";

$vol_id=$_POST['vol_id'];
$req_id=$_POST['req_id'];

/*$vol_id=92;
$req_id=22;*/

$sql1="SELECT req_status,primarys,secondary,backup from student where req_id='$req_id'";
$res1=mysqli_query($dbconnected,$sql1);
if($res1)
{echo "hi";
  while($row = mysqli_fetch_assoc($res1))
  {
    echo "hi1";
    $req_status=$row['req_status'];
    $primarys=$row['primarys'];
    $secondary=$row['secondary'];
    $backup=$row['backup'];
  }
  if($req_status=="pending")
  {
    echo "hi2";
    $req_status="active";
  }
  if($primarys==NULL)
  {
    $primarys=$vol_id;
  }
  else if($primarys!=0)
  {
    $secondary=$vol_id;
  }
  else if($primarys!=0 && $secondary!=0)
  {
    $backup=$vol_id;
  }
  else {
      $list['uid']="full";
      echo json_encode($list);
  }
  $sql2="UPDATE student SET req_status='$req_status',primarys='$primarys',secondary='$secondary',backup='$backup' where req_id='$req_id'";
  $res2=mysqli_query($dbconnected,$sql2);
  if($res2==TRUE)
  {
    $list['uid']="success";
    echo json_encode($list);
  }
  else {
    $list['uid']="uerror";
    echo json_encode($list);
  }
  $sql3="INSERT into events(req_id,vol_id) values('$req_id','$vol_id')";
  $res3=mysqli_query($dbconnected,$sql3);
  if($res3==TRUE)
  {
    $list['uid1']="success1";
    echo json_encode($list);
  }
  else{
    $list['uid1']="ierror";
    echo json_encode($list);
  }
}
else {
  $list['uid']="error";
}
