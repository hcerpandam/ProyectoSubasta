# ProyectoSubasta

Implementa un sistema de subastas donde los usuarios puedan pujar por un producto o servicio. A continuación, se describen los requisitos de la aplicación:

• Un usuario se caracteriza por una cadena que lo identifica y el crédito disponible para poder pujar en subastas.

• El identificador de un usuario no puede cambiar, mientras que el crédito puede ser incrementado y decrementado.

• Una subasta se caracteriza por el usuario que la crea (propietario) y por una cadena que describe el producto o servicio que está subastando. Estos valores son fijos en una subasta y no podrán variar.

• Sobre una subasta se puede pujar. Esta operación requiere conocer el usuario que está realizando la puja y la cantidad por la que puja. La puja es aceptada si: a) el crédito del usuario que la realiza es suficiente para la cantidad por la que puja; b) el usuario no es propietario de la subasta; c) la cantidad es mayor que la cantidad de la puja mayor, si la hubiera. Por tanto, esta operación finaliza indicando si la puja ha sido aceptada.

• Una subasta recuerda todas las pujas que han sido aceptadas. La lista de pujas aceptadas puede ser consultada.

• Una puja se caracteriza por la subasta a la que pertenece, la cantidad pujada y el usuario que ha realizado la puja. Estas propiedades no varían una vez que han sido establecidas.

• También se podrá pujar sin indicar la cantidad. Se asume que la cantidad será un euro mayor que la última puja. Si no hubiera última puja, la cantidad sería de un euro.

• La puja mayor corresponde con la última puja aceptada. Si no hay pujas, esta consulta devuelve un valor nulo.

• Una subasta se puede cerrar. El cierre de una subasta implica que no se van a aceptar nuevas pujas. Es posible consultar si una puja está cerrada.

• Una subasta cerrada puede ser ejecutada. La ejecución de una subasta consiste en decrementar el crédito del usuario de la puja mayor e incrementar el crédito del propietario de la subasta por el importe de la puja ganadora. Es posible consultar si una subasta ha sido ejecutada.

• Los usuarios conocen las subastas de las que son propietarios y las pujas que han sido aceptadas. La operación que realiza la puja se encarga de establecer esta última asociación.

• Un usuario permite consultar las subastas de las que es propietario y las pujas que ha realizado y han sido aceptadas.

• Los usuarios también conocen las subastas que han ganado. Esta información puede ser consultada. El método de ejecución se encarga de establecer esta asociación.

Escribe el siguiente programa:

• Crea los usuarios Juan, Pedro y Enrique con un saldo inicial de 100, 150 y 300 euros, respectivamente.

• Crea una subasta asociada al usuario Juan ofreciendo como producto "Teléfono Móvil".

• El usuario Pedro puja por esa subasta 100 euros.

• Muestra en la consola la puja mayor de la subasta (producto, usuario y cantidad).

• El usuario Enrique puja por esa subasta 50 euros.

• Muestra en la consola la puja mayor. Comprueba que esta segunda puja no ha sido acepta, ya que es menor que la primera.

• Cierra la subasta.

• El usuario Enrique puja de nuevo por esa subasta con 200 euros. Comprueba que no es aceptada, ya que la subasta ha sido cerrada.

• Ejecuta la subasta.

• Muestra por la consola los créditos de los tres usuarios. Observa que los saldos de Juan y Pedro han cambiado.

• Para cada usuario, muestra por la consola las subastas de las que son propietarios, subastas ganadoras y pujas realizadas. Como información de la subasta muestra sólo el nombre del producto y como información de las pujas el producto subastado y la cantidad pujada
.
