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
$flag=0;
$i=0;
$mobile_list = array();
$stu_name=$_POST["stu_name"];
$stu_exam=$_POST["stu_exam"];
$exam_date=$_POST["exam_date"];
$city=$_POST["location"];
$stu_gender=$_POST["stu_gender"];
$stu_mobile=$_POST["stu_mobile"];
$stu_language=$_POST["stu_language"];
$stu_email=$_POST["stu_email"];
$req_status="pending";
$sql1="INSERT into student(stu_name,stu_exam,stu_date_exam,stu_location,stu_gender,stu_mobile,stu_language,stu_email,stu_req_status) values('$stu_name','$stu_exam','$exam_date','$city','$stu_gender','$stu_mobile','$stu_language','$stu_email','$req_status');";
$res=mysqli_query($dbconnected,$sql1);
if($res===TRUE)
{
  $flag=1;
  $list1['uid']="success";
  echo json_encode($list1);
}
else {
$list1['uid']="error";
echo json_encode($list1);
}
?>
<?php
if($flag==1)
{
 $sql2="SELECT vol_mobile from volunteer;";
 $res2=mysqli_query($dbconnected,$sql2);
 if($res==TRUE)
 {
   while($row=mysqli_fetch_assoc($res2))
   {
     #echo "hi";
     #echo $row["vol_mobile"];
    $temp=$row["vol_mobile"];
    $mobile_list[$i]=$temp;
    $i++;
   }
   echo json_encode($mobile_list);
   #echo "hia";
 }

}
foreach ($mobile_list as $value) {
  echo $value;
  # code...
}
 ?>
 <?php
$sql3="SELECT max(req_id) as reid from student;";
$res3=mysqli_query($dbconnected,$sql3);
$row=mysqli_fetch_assoc($res3);
$request_id=$row["reid"];
echo $request_id;
  ?>
