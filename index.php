<!DOCTYPE html>
<html>
    <head>
        <title>Chroma</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="styles.css" type="text/css" />
        <link href='http://fonts.googleapis.com/css?family=Terminal+Dosis' rel='stylesheet' type='text/css' />
    </head>
    <body>
        <?php
        $SQLerr = "";
        $SQLerr1 = "";
        $s = "";
        ?>
        <div id='one'>Chroma</div>
        <div id='two'>The Biggest Electronics Store</div>
        <form name="trans" id="trans" method="post" action="result.php" >
        <table>
            <tr>
                <td>
                    <img src='item1.jpg' alt='no image'/><br>
                    <figcaption>hp Pavilion Series</figcaption>
                    <input type="checkbox" name="chk_list[]" value="1"/>
                </td>
                <td>
                    <img src='item2.jpg' alt='no image'/><br>
                    <figcaption>hp Pavilion2 Series</figcaption>
                    <input type="checkbox" name="chk_list[]" value="2"/>
                </td>
                <td>
                    <img src='item3.jpg' alt='no image'/><br>
                    <figcaption>Toshiba's Laptop</figcaption>
                    <input type="checkbox" name="chk_list[]" value="3"/>
                </td>
            </tr>
            <tr>
                <td>
                    <img src='item4.jpg' alt='no image'/><br>
                    <figcaption>Asus Laptop</figcaption>
                    <input type="checkbox" name="chk_list[]" value="4"/>
                </td>
                <td>
                    <img src='item5.jpg' alt='no image'/><br>
                    <figcaption>hp Touch Screen</figcaption>
                    <input type="checkbox" name="chk_list[]" value="5"/>
                </td>
                <td>
                    <img src='item6.jpg' alt='no image'/><br>
                    <figcaption>hp Ultimate Series</figcaption>
                    <input type="checkbox" name="chk_list[]" value="6"/>
                </td>
            </tr>
            <tr>
                <td>
                    <img src='item7.jpg' alt='no image'/><br>
                    <figcaption>Skullcandy Headphones</figcaption>
                    <input type="checkbox" name="chk_list[]" value="7"/>
                </td>
                <td>
                    <img src='item8.jpg' alt='no image'/><br>
                    <figcaption>Boss Headphones</figcaption>
                    <input type="checkbox" name="chk_list[]" value="8"/>
                </td>
                <td>
                    <img src='item9.jpg' alt='no image'/><br>
                    <figcaption>Headphones by JVC</figcaption>
                    <input type="checkbox" name="chk_list[]" value="9"/>
                </td>
            </tr>
            <tr>
                <td>
                    <img src='item10.jpg' alt='no image'/><br>
                    <figcaption>Windows 8 Tablet</figcaption>
                    <input type="checkbox" name="chk_list[]" value="10"/>
                </td>
                <td>
                    <img src='item11.jpg' alt='no image'/><br>
                    <figcaption>Samsung Tablet</figcaption>
                    <input type="checkbox" name="chk_list[]" value="11"/>
                </td>
                <td>
                    <img src='item12.jpg' alt='no image'/><br>
                    <figcaption>Apple ipad</figcaption>
                    <input type="checkbox" name="chk_list[]" value="12"/>
                </td>
            </tr>
            <tr>
                <td>
                    <img src='item13.jpg' alt='no image'/><br>
                    <figcaption>Samsung Galaxy A7</figcaption>
                    <input type="checkbox" name="chk_list[]" value="13"/>
                </td>
                <td>
                    <img src='item14.jpg' alt='no image'/><br>
                    <figcaption>Samsung S6 Edge</figcaption>
                    <input type="checkbox" name="chk_list[]" value="14"/>
                </td>
                <td>
                    <img src='item15.jpg' alt='no image'/><br>
                    <figcaption>Apple iphone 7</figcaption>
                    <input type="checkbox" name="chk_list[]" value="15"/>
                </td>
            </tr>
        </table>
            <button type="submit" id="sub" value="Submit">Submit</button>
        </form>
    </body>
</html>