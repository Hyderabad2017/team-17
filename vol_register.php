<?php
include "credentials.php";


      /*$vol_name=$_POST["vol_name"];
      $vol_pswd=$_POST["vol_pswd"];
      $vol_gender=$_POST["vol_gender"];
      $vol_mobile=$_POST["mobile"];
      $vol_city=$_POST["city"];
      $vol_email=$_POST["email"];
      $vol_lang=$_POST["language"];*/
      $vol_name="dasarada";
      $vol_pswd="dasarada";
      $vol_gender="m";
      $vol_mobile=9908535;
      $vol_city="hyderabad";
      $vol_email="dachi8958@gmail.com";
      $vol_lang="telugu";
      $sql1="SELECT * from volunteer where vol_mobile='$vol_mobile';";
      $res=mysqli_query($dbconnected,$sql1);
      if(mysqli_num_rows($res)>0)
      {
        $list['uid']="error1";
        echo json_encode($list);
      }
      else
      {
        $sql2="INSERT into volunteer(vol_name,vol_gender,vol_location,vol_mobile,vol_email,vol_language,vol_pswd) values('$vol_name','$vol_gender','$vol_city','$vol_mobile','$vol_email','$vol_lang','$vol_pswd');";
        $res1=mysqli_query($dbconnected,$sql2);
        if($res1==TRUE){
        $list['uid']="Success";
        echo json_encode($list);
      }



    }
?>
