<%-- 
    Document   : FormularioCamarero
    Created on : 02-mar-2017, 12:17:14
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>

         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <!-- <meta name="viewport" content="width=device-width, initial-scale=1.0">-->
        <title>Alta Camarero</title>
        <link href="CSS/estiloRestaurante.css" rel="stylesheet" type="text/css"/>
    </head>
    
    <body>
        <img id="restaurante" src="imagenes/images.jpeg" alt="Hosteleria" tittle="Restaurante con vistas"/>
        <form id="altaCamarero" action="/RestauranteBueno/InsertarServletCamarero" method="POST">
            <fieldset>

                <legend>Alta Camarero</legend>

                <p>
                    <label for="idCamarero">Codigo Camarero</label>
                    <input id="idCamarero" type="text" name="idCamarero" value="" />
                </p>


                <p>
                    <label for="nombre">Nombre Camarero</label>
                    <input id="nombre" type="text" name="nombre" value="" />
                </p>

                <p>
                    <label for="apellido">Apellido Camarero</label>
                    <input id="apellido" type="text" name="apellido" value="" />
                </p>

                 <p>
                    <label for="especialidad">Especialidad</label>
                    <input id="especialidad" type="text" name="especialidad" value="" />
                </p>
                
                <input type="submit" value="Enviar" name="btnGuardar"/>
            </fieldset>
        </form>
    </body>
</html>

