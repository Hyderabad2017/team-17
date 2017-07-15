<?
include "credentials.php";

$stu_name=$_POST["stu_name"];
$stu_exam=$_POST["stu_exam"];
$exam_date=$_POST["exam_date"];
$city=$_POST["location"];
$stu_gender=$_POST["stu_gender"];
$stu_mobile=$_POST["stu_mobile"];
$stu_language=$_POST["stu_language"];
$stu_email=$_POST["stu_email"];

$sql1="INSERT into student(stu_name,stu_exam,date_exam,location,gender,mobile,language,email) values('$stu_name','$stu_exam','$exam_date','$city','$stu_gender','$stu_mobile','$stu_language','$stu_email');";
$res=mysqli_query($dbconnected,$sql1);
if($res==TRUE)
{
  $list1['uid']="success";
  echo json_encode($list1);
}
else {
$list1['uid']="error";
echo json_encode($list1);
}
