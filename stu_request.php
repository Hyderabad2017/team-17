<?php
include "credentials.php";

/*$stu_name="stu_name";
$stu_exam="stu_exam";
$exam_date="exam_date";
$city="location";
$stu_gender="stu_gender";
$stu_mobile=9908535199;
$stu_language="stu_language";
$stu_email="stu_email";
$req_status="pending";*/

$stu_name=isset($_POST["stu_name"]);
$stu_exam=isset($_POST["stu_exam"]);
$exam_date=isset($_POST["exam_date"]);
$city=isset($_POST["location"]);
$stu_gender=isset($_POST["stu_gender"]);
$stu_mobile=isset($_POST["stu_mobile"]);
$stu_language=isset($_POST["stu_language"]);
$stu_email=isset($_POST["stu_email"]);
$req_status="pending";

$sql1="INSERT into student(stu_name,stu_exam,stu_date_exam,stu_location,stu_gender,stu_mobile,stu_language,stu_email,stu_req_status) values('$stu_name','$stu_exam','$exam_date','$city','$stu_gender','$stu_mobile','$stu_language','$stu_email','$req_status')";
$res=mysqli_query($dbconnected,$sql1);
if($res===TRUE)
{
  $list1['uid']="success";
  echo json_encode($list1);
}
else {
$list1['uid']="error";
echo json_encode($list1);
}
