<?php
include "credentials.php";


      $vol_name=isset($_POST["vol_name"]);
      $vol_pswd=isset($_POST["vol_pswd"]);
      $vol_gender=isset($_POST["vol_gender"]);
      $vol_mobile=isset($_POST["mobile"]);
      $vol_city=isset($_POST["city"]);
      $vol_email=isset($_POST["email"]);
      $vol_lang=isset($_POST["language"]);
      $vol_qualification=isset($_POST["qualification"]);

      $sql1="SELECT * from volunteer where vol_mobile='$vol_mobile';";
      $res=mysqli_query($dbconnected,$sql1);
      if(mysqli_num_rows($res)>0)
      {
        $list['uid']="error1";
        echo json_encode($list);
      }
      else
      {
        $sql2="INSERT into volunteer(vol_name,vol_gender,vol_location,vol_mobile,vol_email,vol_language,vol_pswd,vol_qualification) values('$vol_name','$vol_gender','$vol_city','$vol_mobile','$vol_email','$vol_lang','$vol_pswd','$vol_qualification');";
        $res1=mysqli_query($dbconnected,$sql2);
        if($res1==TRUE)
        {
          $list['uid']="Success";
          echo json_encode($list);}
        else
        {
          $list['uid']="error";
          echo json_encode($list);
        }
      }



   
?>
