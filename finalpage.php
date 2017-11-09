<?php

	$con = mysqli_connect("localhost", "root", "", "store_db");
    if(mysqli_connect_errno()){
            $SQLerr = "SQL connection failed" . mysqli_connect_errno();
    }

    $stmt = "SELECT `itemset` FROM `related_items`";
    $res = mysqli_query($con, $stmt) or die(mysql_error());

    $itemset = array();
    while ($row = mysqli_fetch_array($res)) {
    	array_push($itemset, $row[0]);
    }

    $arr = array();
    for ($i = 0; $i < count($itemset); $i++) {
    	array_push($arr, explode(" ",$itemset[$i]));
	}

    $stmt = "SELECT `name` from `item_details`";
    $res = mysqli_query($con, $stmt) or die(mysql_error());

    $name = array();
    while ($row = mysqli_fetch_array($res)) {
        array_push($name, $row[0]);
    }

    mysqli_close($con);
?>

<html>
<head><title>Apriori algorithm results</title>
<meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="styles.css" type="text/css" />
        <link href='http://fonts.googleapis.com/css?family=Terminal+Dosis' rel='stylesheet' type='text/css' />
</head>
<body>
    <h2 align=center>Results given by Apriori Algorithm :</h2>
<table align=center>

	<?php foreach($arr as $key=>$row) : ?>
		<tr>
            <?php foreach ($row as $k => $value) : ?>
    		    <td>
                <img src=<?php echo "item".$value.".jpg";?> alt='no image' /><br>
                <figcaption><?php echo $name[$value - 1]; ?></figcaption>
                </td>
            <?php endforeach; ?>
		</tr>
        <br><br><br>
    <?php endforeach; ?>       
</table>
</body>
</html>