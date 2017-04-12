<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Kysymyslomake</title>
<link rel="stylesheet" type="text/css" href="resources/styles/common.css">
</head>
<body>
	<h1>KYSELYLOMAKE</h1>
<FORM>
<br>

            <label>1. Sukupuoli</label>
            <table>
            <tr>
            <td><input type="radio" name="sukupuoli" value="Nainen">Nainen</td><td>&nbsp; &nbsp;</td>
            <td><input type="radio" name="sukupuoli" value="Mies">Mies</td>
            </tr>
            </table>
            <BR>
            
            <label>2. Ikä</label>
            <table>
            <tr>
            <td><input type="radio" name="ika" value="1">alle 20-vuotiaat</td><td>&nbsp; &nbsp;</td>
            <td><input type="radio" name="ika" value="2">20-24 -vuotiaat</td><td>&nbsp; &nbsp;</td>
            <td><input type="radio" name="ika" value="3">25-29 -vuotiaat</td><td>&nbsp; &nbsp;</td>
            <td><input type="radio" name="ika" value="4">30-34 -vuotiaat</td><td>&nbsp; &nbsp;</td>
            <td><input type="radio" name="ika" value="5">yli 35-vuotiaat</td><td>&nbsp; &nbsp;</td>
            </tr>
            </table>
            <br>
            
            <label>3. Kuinka usein käytät alkoholia?</label>
            <table>
            <tr>
            <td><input type="radio" name="kaytto" value="1">Päivittäin</td><td>&nbsp; &nbsp;</td>
            <td><input type="radio" name="kaytto" value="2">Kerran viikossa</td><td>&nbsp; &nbsp;</td>
            <td><input type="radio" name="kaytto" value="3">Useita kertoja viikossa</td><td>&nbsp; &nbsp;</td>
            <td><input type="radio" name="kaytto" value="4">Muutaman kerran kuukaudessa</td><td>&nbsp; &nbsp;</td>
            <td><input type="radio" name="kaytto" value="5">En juo alkoholia</td><td>&nbsp; &nbsp;</td>
            </tr>
            </table>
            <BR>
            
            <label>4. Mistä pääsääntöisesti hankit alkoholijuomia?</label>
            <table>
            <tr>
            <td><input type="checkbox" name="hankinta" value="1">Alko</td><td>&nbsp; &nbsp;</td>
            <td><input type="checkbox" name="hankinta" value="2">Viro</td><td>&nbsp; &nbsp;</td>
            <td><input type="checkbox" name="hankinta" value="3">Laiva</td><td>&nbsp; &nbsp;</td>
            <td><input type="checkbox" name="hankinta" value="4">Muut Ulkomaat</td><td>&nbsp; &nbsp;</td>
            <td><input type="checkbox" name="hankinta" value="5">Ruotsi</td><td>&nbsp; &nbsp;</td>
            <td><input type="checkbox" name="hankinta" value="6">Venäjä</td><td>&nbsp; &nbsp;</td>
            <td><input type="checkbox" name="hankinta" value="7">Päivittäistavarakauppa</td><td>&nbsp; &nbsp;</td>
            <td><input type="checkbox" name="hankinta" value="8">Kioski</td><td>&nbsp; &nbsp;</td>
            <td><input type="checkbox" name="hankinta" value="9">Ravintola</td><td>&nbsp; &nbsp;</td>
            <td><input type="checkbox" name="hankinta" value="10">Yökerho</td><td>&nbsp; &nbsp;</td>
            </tr>
            </table>
            <BR>
           
            <label>5. Kuinka tyytyväinen olet alkoholin saatavuuteen asteikolla
             1-5 (1=erittäin tyytymätön, 5= erittäin tyytyväinen)</label>
            <table>
            <tr>
            <td><input type="radio" name="tyytyvaisyys" value="1">1</td><td>&nbsp; &nbsp;</td>
            <td><input type="radio" name="tyytyvaisyys" value="2">2</td><td>&nbsp; &nbsp;</td>
            <td><input type="radio" name="tyytyvaisyys" value="3">3</td><td>&nbsp; &nbsp;</td>
            <td><input type="radio" name="tyytyvaisyys" value="4">4</td><td>&nbsp; &nbsp;</td>
            <td><input type="radio" name="tyytyvaisyys" value="5">5</td><td>&nbsp; &nbsp;</td>
            </tr>
            </table>
            <BR>
            
			 <label>6. Mihin olet tyytyväinen alkoholin saatavuudessa?</label>
             <BR>
             <TEXTAREA NAME="textarea1" placeholder="Vastaus tähän..." ROWS="5" cols="40"></TEXTAREA>
             <br>
             <br>
             <br>
             <label>7. Mihin et ole tyytyväinen alkoholin saatavuudessa?</label>
             <BR>
             <TEXTAREA NAME="textarea1" placeholder="Vastaus tähän..." ROWS="5" cols="40"></TEXTAREA>
             <BR>
             <br>
             <br>
            <INPUT TYPE="reset" VALUE="RESET">
            <br>
            <br>
        </FORM>
        <form action="kiitos">
        <button>Kiitos Vastauksesta</button>
        </form>
        
</body>
</html>