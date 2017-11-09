<?php 
    if(!empty($_POST))
    {
         if(!empty($_POST['chk_list'])){
            foreach ($_POST['chk_list'] as $key => $value) {
                    $s .= $value . " ";
            }
        }
        $con = mysqli_connect("localhost", "root", "", "store_db");
        if(mysqli_connect_errno()){
            $SQLerr = "SQL connection failed" . mysqli_connect_errno();
        }
        $stmt = "INSERT INTO `store_db`.`register` (`c_id`, `items_purchased`) VALUES ('1', '$s');";
        $res = mysqli_query($con, $stmt);
        if(!$res){
            $SQLerr1 = "Query Failed" . mysqli_error($con);
        }
        mysqli_close($con);          
    }

    $o = exec('java -cp C:\xampp\htdocs\dmbiproject Apriori 2>&1', $output, $return_var);
    header('Location: http://localhost:1234/dmbiproject/finalpage.php?op='.$o);
?>