SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `cem44` DEFAULT CHARACTER SET latin1 ;
USE `cem44` ;

-- -----------------------------------------------------
-- Table `cem44`.`departamento`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `cem44`.`departamento` (
  `Id` CHAR(2) NOT NULL ,
  `Nombre` VARCHAR(20) NULL DEFAULT NULL ,
  PRIMARY KEY (`Id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `cem44`.`provincia`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `cem44`.`provincia` (
  `Id` VARCHAR(20) NOT NULL ,
  `IdDepartamento` CHAR(2) NOT NULL ,
  `Nombre` VARCHAR(20) NULL DEFAULT NULL ,
  PRIMARY KEY (`Id`, `IdDepartamento`) ,
  INDEX `XIF1Provincia` (`IdDepartamento` ASC) ,
  CONSTRAINT `provincia_ibfk_1`
    FOREIGN KEY (`IdDepartamento` )
    REFERENCES `cem44`.`departamento` (`Id` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `cem44`.`distrito`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `cem44`.`distrito` (
  `Id` CHAR(2) NOT NULL ,
  `IdProvincia` VARCHAR(20) NOT NULL ,
  `IdDepartamento` CHAR(2) NOT NULL ,
  `Nombre` VARCHAR(20) NULL DEFAULT NULL ,
  PRIMARY KEY (`Id`, `IdProvincia`, `IdDepartamento`) ,
  INDEX `XIF1Distrito` (`IdProvincia` ASC, `IdDepartamento` ASC) ,
  CONSTRAINT `distrito_ibfk_1`
    FOREIGN KEY (`IdProvincia` , `IdDepartamento` )
    REFERENCES `cem44`.`provincia` (`Id` , `IdDepartamento` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `cem44`.`estacionservicio`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `cem44`.`estacionservicio` (
  `Id` INT(11) NOT NULL ,
  `Nombre` VARCHAR(20) NULL DEFAULT NULL ,
  `Direccion` VARCHAR(20) NULL DEFAULT NULL ,
  `IdDistrito` CHAR(2) NOT NULL ,
  `IdProvincia` VARCHAR(20) NOT NULL ,
  `IdDepartamento` CHAR(2) NOT NULL ,
  `Latitud` DECIMAL(10,0) NULL DEFAULT NULL ,
  `Longitud` DECIMAL(10,0) NULL DEFAULT NULL ,
  `RazonSocial` VARCHAR(20) NULL DEFAULT NULL ,
  `RUC` VARCHAR(20) NULL DEFAULT NULL ,
  `Telefono` VARCHAR(20) NULL DEFAULT NULL ,
  `FechaApertura` DATE NULL DEFAULT NULL ,
  `FechaRegistro` DATE NULL DEFAULT NULL ,
  PRIMARY KEY (`Id`) ,
  INDEX `XIF1EstacionServicio` (`IdDistrito` ASC, `IdProvincia` ASC, `IdDepartamento` ASC) ,
  CONSTRAINT `estacionservicio_ibfk_1`
    FOREIGN KEY (`IdDistrito` , `IdProvincia` , `IdDepartamento` )
    REFERENCES `cem44`.`distrito` (`Id` , `IdProvincia` , `IdDepartamento` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `cem44`.`trabajador`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `cem44`.`trabajador` (
  `Id` INT(11) NOT NULL ,
  `IdEstacionServicio` INT(11) NOT NULL ,
  `Nombre` VARCHAR(20) NULL DEFAULT NULL ,
  `ApellidoPaterno` VARCHAR(20) NULL DEFAULT NULL ,
  `ApellidoMaterno` VARCHAR(20) NULL DEFAULT NULL ,
  `DNI` VARCHAR(20) NULL DEFAULT NULL ,
  `Correo` VARCHAR(20) NULL DEFAULT NULL ,
  `Telefono` VARCHAR(20) NULL DEFAULT NULL ,
  `IdCargo` INT(11) NULL DEFAULT NULL ,
  `IdEstadoCivil` INT(11) NULL DEFAULT NULL ,
  `FechaNacimiento` DATE NULL DEFAULT NULL ,
  `FechaRegistro` DATE NULL DEFAULT NULL ,
  PRIMARY KEY (`Id`) ,
  INDEX `XIF1Trabajador` (`IdEstacionServicio` ASC) ,
  CONSTRAINT `trabajador_ibfk_1`
    FOREIGN KEY (`IdEstacionServicio` )
    REFERENCES `cem44`.`estacionservicio` (`Id` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `cem44`.`caja`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `cem44`.`caja` (
  `Id` INT(11) NOT NULL ,
  `IdTrabajador` INT(11) NOT NULL ,
  `Codigo` VARCHAR(20) NULL DEFAULT NULL ,
  `FechaRegistro` DATE NULL DEFAULT NULL ,
  PRIMARY KEY (`Id`) ,
  INDEX `XIF1Caja` (`IdTrabajador` ASC) ,
  CONSTRAINT `caja_ibfk_1`
    FOREIGN KEY (`IdTrabajador` )
    REFERENCES `cem44`.`trabajador` (`Id` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `cem44`.`surtidor`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `cem44`.`surtidor` (
  `Id` INT(11) NOT NULL ,
  `IdEstacionServicio` INT(11) NOT NULL ,
  `IdMarca` INT(11) NULL DEFAULT NULL ,
  `IdModelo` INT(11) NULL DEFAULT NULL ,
  `Descripcion` VARCHAR(20) NULL DEFAULT NULL ,
  `Nombre` VARCHAR(20) NULL DEFAULT NULL ,
  `NroCaras` INT(11) NULL DEFAULT NULL ,
  `NumeroSerie` VARCHAR(20) NULL DEFAULT NULL ,
  `FechaRegistro` DATE NULL DEFAULT NULL ,
  `IdFamiliaElectronica` INT(11) NULL DEFAULT NULL ,
  `NroMangueras` INT(11) NULL DEFAULT NULL ,
  `Lote` VARCHAR(20) NULL DEFAULT NULL ,
  PRIMARY KEY (`Id`) ,
  INDEX `XIF1Surtidor` (`IdEstacionServicio` ASC) ,
  CONSTRAINT `surtidor_ibfk_1`
    FOREIGN KEY (`IdEstacionServicio` )
    REFERENCES `cem44`.`estacionservicio` (`Id` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `cem44`.`cara`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `cem44`.`cara` (
  `Id` INT(11) NOT NULL ,
  `IdSurtidor` INT(11) NOT NULL ,
  `FechaRegistro` DATE NULL DEFAULT NULL ,
  `Codigo` VARCHAR(20) NULL DEFAULT NULL ,
  PRIMARY KEY (`Id`) ,
  INDEX `XIF1Manguera` (`IdSurtidor` ASC) ,
  CONSTRAINT `cara_ibfk_1`
    FOREIGN KEY (`IdSurtidor` )
    REFERENCES `cem44`.`surtidor` (`Id` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `cem44`.`producto`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `cem44`.`producto` (
  `Id` INT(11) NOT NULL ,
  `IdTipoProducto` INT(11) NULL DEFAULT NULL ,
  `Nombre` VARCHAR(20) NULL DEFAULT NULL ,
  `FechaRegistro` DATE NULL DEFAULT NULL ,
  PRIMARY KEY (`Id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `cem44`.`caraproducto`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `cem44`.`caraproducto` (
  `IdCara` INT(11) NOT NULL ,
  `IdProducto` INT(11) NOT NULL ,
  `FechaRegistro` DATE NULL DEFAULT NULL ,
  PRIMARY KEY (`IdCara`, `IdProducto`) ,
  INDEX `XIF1CaraProducto` (`IdCara` ASC) ,
  INDEX `XIF2CaraProducto` (`IdProducto` ASC) ,
  CONSTRAINT `caraproducto_ibfk_2`
    FOREIGN KEY (`IdProducto` )
    REFERENCES `cem44`.`producto` (`Id` ),
  CONSTRAINT `caraproducto_ibfk_1`
    FOREIGN KEY (`IdCara` )
    REFERENCES `cem44`.`cara` (`Id` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `cem44`.`puntoventa`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `cem44`.`puntoventa` (
  `Id` INT(11) NOT NULL ,
  `IdEstacionServicio` INT(11) NOT NULL ,
  `Nombre` VARCHAR(20) NULL DEFAULT NULL ,
  `Descripcion` VARCHAR(20) NULL DEFAULT NULL ,
  `IdTipoPuntoVenta` INT(11) NULL DEFAULT NULL ,
  `FechaRegistro` DATE NULL DEFAULT NULL ,
  PRIMARY KEY (`Id`) ,
  INDEX `XIF1PuntoVenta` (`IdEstacionServicio` ASC) ,
  CONSTRAINT `puntoventa_ibfk_1`
    FOREIGN KEY (`IdEstacionServicio` )
    REFERENCES `cem44`.`estacionservicio` (`Id` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `cem44`.`centroemisor`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `cem44`.`centroemisor` (
  `Id` INT(11) NOT NULL ,
  `IdPuntoVenta` INT(11) NOT NULL ,
  `Emisor` VARCHAR(20) NULL DEFAULT NULL ,
  `FechaRegistro` DATE NULL DEFAULT NULL ,
  PRIMARY KEY (`Id`) ,
  INDEX `XIF1CentroEmisor` (`IdPuntoVenta` ASC) ,
  CONSTRAINT `centroemisor_ibfk_1`
    FOREIGN KEY (`IdPuntoVenta` )
    REFERENCES `cem44`.`puntoventa` (`Id` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `cem44`.`centroemisortipocomprobante`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `cem44`.`centroemisortipocomprobante` (
  `IdTipoComprobante` INT(11) NOT NULL ,
  `IdCentroEmisor` INT(11) NOT NULL ,
  `FechaRegistro` DATE NULL DEFAULT NULL ,
  PRIMARY KEY (`IdTipoComprobante`, `IdCentroEmisor`) ,
  INDEX `XIF1PuntoVentaTipoComprobante` (`IdCentroEmisor` ASC) ,
  CONSTRAINT `centroemisortipocomprobante_ibfk_1`
    FOREIGN KEY (`IdCentroEmisor` )
    REFERENCES `cem44`.`centroemisor` (`Id` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `cem44`.`cliente`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `cem44`.`cliente` (
  `Id` INT(11) NOT NULL ,
  `NumeroDocumento` VARCHAR(20) NULL DEFAULT NULL ,
  `RazonSocial` VARCHAR(20) NULL DEFAULT NULL ,
  `IdTipoDocumento` INT(11) NULL DEFAULT NULL ,
  `FechaRegistro` DATE NULL DEFAULT NULL ,
  PRIMARY KEY (`Id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `cem44`.`cuenta`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `cem44`.`cuenta` (
  `Id` INT(11) NOT NULL ,
  `IdCliente` INT(11) NOT NULL ,
  `TieneLimiteCredito` INT(11) NULL DEFAULT NULL ,
  `TieneLimiteDiario` INT(11) NULL DEFAULT NULL ,
  `PeriodoFacturacion` INT(11) NULL DEFAULT NULL ,
  `IdTipoPeriodoFacturacion` INT(11) NULL DEFAULT NULL ,
  `NroDiasVencimiento` INT(11) NULL DEFAULT NULL ,
  `FechaRegistro` DATE NULL DEFAULT NULL ,
  `LimiteCredito` INT(11) NULL DEFAULT NULL ,
  `LimiteDiario` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`Id`) ,
  INDEX `XIF1Cuentas` (`IdCliente` ASC) ,
  CONSTRAINT `cuenta_ibfk_1`
    FOREIGN KEY (`IdCliente` )
    REFERENCES `cem44`.`cliente` (`Id` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `cem44`.`turno`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `cem44`.`turno` (
  `Id` INT(11) NOT NULL ,
  `IdEstacionServicio` INT(11) NOT NULL ,
  `FechaApertura` DATE NULL DEFAULT NULL ,
  `FechaCierre` DATE NULL DEFAULT NULL ,
  PRIMARY KEY (`Id`) ,
  INDEX `XIF2Turno` (`IdEstacionServicio` ASC) ,
  CONSTRAINT `turno_ibfk_1`
    FOREIGN KEY (`IdEstacionServicio` )
    REFERENCES `cem44`.`estacionservicio` (`Id` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `cem44`.`turnopuntoventacaja`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `cem44`.`turnopuntoventacaja` (
  `IdTurno` INT(11) NOT NULL ,
  `IdPuntoVenta` INT(11) NOT NULL ,
  `IdCaja` INT(11) NOT NULL ,
  `FechaRegistro` DATE NULL DEFAULT NULL ,
  PRIMARY KEY (`IdTurno`, `IdPuntoVenta`, `IdCaja`) ,
  INDEX `XIF1TurnoPuntoVentaCaja` (`IdTurno` ASC) ,
  INDEX `XIF2TurnoPuntoVentaCaja` (`IdPuntoVenta` ASC) ,
  INDEX `XIF3TurnoPuntoVentaCaja` (`IdCaja` ASC) ,
  CONSTRAINT `turnopuntoventacaja_ibfk_3`
    FOREIGN KEY (`IdCaja` )
    REFERENCES `cem44`.`caja` (`Id` ),
  CONSTRAINT `turnopuntoventacaja_ibfk_1`
    FOREIGN KEY (`IdTurno` )
    REFERENCES `cem44`.`turno` (`Id` ),
  CONSTRAINT `turnopuntoventacaja_ibfk_2`
    FOREIGN KEY (`IdPuntoVenta` )
    REFERENCES `cem44`.`puntoventa` (`Id` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `cem44`.`deposito`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `cem44`.`deposito` (
  `Id` INT(11) NOT NULL ,
  `IdTurno` INT(11) NOT NULL ,
  `IdPuntoVenta` INT(11) NOT NULL ,
  `IdCaja` INT(11) NOT NULL ,
  `MontoTotal` DECIMAL(10,0) NULL DEFAULT NULL ,
  `FechaRegistro` DATE NULL DEFAULT NULL ,
  `IdTipoPago` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`Id`) ,
  INDEX `XIF1Deposito` (`IdTurno` ASC, `IdPuntoVenta` ASC, `IdCaja` ASC) ,
  CONSTRAINT `deposito_ibfk_1`
    FOREIGN KEY (`IdTurno` , `IdPuntoVenta` , `IdCaja` )
    REFERENCES `cem44`.`turnopuntoventacaja` (`IdTurno` , `IdPuntoVenta` , `IdCaja` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `cem44`.`despacho`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `cem44`.`despacho` (
  `Id` INT(11) NOT NULL ,
  `IdEstado` INT(11) NULL DEFAULT NULL ,
  `MontoSoles` DECIMAL(10,0) NULL DEFAULT NULL ,
  `NroGalones` DECIMAL(10,0) NULL DEFAULT NULL ,
  `PrecioUnitario` DECIMAL(10,0) NULL DEFAULT NULL ,
  `FechaRegistro` DATE NULL DEFAULT NULL ,
  `IdProducto` INT(11) NOT NULL ,
  `IdCara` INT(11) NOT NULL ,
  PRIMARY KEY (`Id`) ,
  INDEX `XIF3Despacho` (`IdProducto` ASC) ,
  INDEX `XIF4Despacho` (`IdCara` ASC, `IdProducto` ASC) ,
  CONSTRAINT `despacho_ibfk_2`
    FOREIGN KEY (`IdCara` , `IdProducto` )
    REFERENCES `cem44`.`caraproducto` (`IdCara` , `IdProducto` ),
  CONSTRAINT `despacho_ibfk_1`
    FOREIGN KEY (`IdProducto` )
    REFERENCES `cem44`.`producto` (`Id` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `cem44`.`impresora`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `cem44`.`impresora` (
  `Id` INT(11) NOT NULL ,
  `Nombre` VARCHAR(20) NULL DEFAULT NULL ,
  `Descripcion` VARCHAR(20) NULL DEFAULT NULL ,
  `Puerto` VARCHAR(20) NULL DEFAULT NULL ,
  `FechaRegistro` DATE NULL DEFAULT NULL ,
  PRIMARY KEY (`Id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `cem44`.`impresorapuntoventa`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `cem44`.`impresorapuntoventa` (
  `IdPuntoVenta` INT(11) NOT NULL ,
  `IdImpresora` INT(11) NOT NULL ,
  `FechaRegistro` DATE NULL DEFAULT NULL ,
  PRIMARY KEY (`IdPuntoVenta`, `IdImpresora`) ,
  INDEX `XIF1ImpresoraPuntoVenta` (`IdPuntoVenta` ASC) ,
  INDEX `XIF2ImpresoraPuntoVenta` (`IdImpresora` ASC) ,
  CONSTRAINT `impresorapuntoventa_ibfk_2`
    FOREIGN KEY (`IdImpresora` )
    REFERENCES `cem44`.`impresora` (`Id` ),
  CONSTRAINT `impresorapuntoventa_ibfk_1`
    FOREIGN KEY (`IdPuntoVenta` )
    REFERENCES `cem44`.`puntoventa` (`Id` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `cem44`.`lista`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `cem44`.`lista` (
  `Id` INT(11) NOT NULL ,
  `Nombre` VARCHAR(20) NULL DEFAULT NULL ,
  `FechaRegistro` DATE NULL DEFAULT NULL ,
  PRIMARY KEY (`Id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `cem44`.`listavalor`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `cem44`.`listavalor` (
  `Id` INT(11) NOT NULL ,
  `Nombre` VARCHAR(20) NULL DEFAULT NULL ,
  `IdLista` INT(11) NOT NULL ,
  `IdCategoria` INT(11) NULL DEFAULT NULL ,
  `FechaRegistro` DATE NULL DEFAULT NULL ,
  PRIMARY KEY (`Id`) ,
  INDEX `XIF1ListaValor` (`IdLista` ASC) ,
  INDEX `XIF2ListaValor` (`IdCategoria` ASC) ,
  CONSTRAINT `listavalor_ibfk_2`
    FOREIGN KEY (`IdCategoria` )
    REFERENCES `cem44`.`listavalor` (`Id` ),
  CONSTRAINT `listavalor_ibfk_1`
    FOREIGN KEY (`IdLista` )
    REFERENCES `cem44`.`lista` (`Id` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `cem44`.`transaccion`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `cem44`.`transaccion` (
  `Id` INT(11) NOT NULL ,
  `IdTipoTransaccion` INT(11) NULL DEFAULT NULL ,
  `IdCliente` INT(11) NOT NULL ,
  `IdDespacho` INT(11) NOT NULL ,
  `IdEstado` INT(11) NULL DEFAULT NULL ,
  `NumeroTransaccion` VARCHAR(20) NULL DEFAULT NULL ,
  `NumeroPlaca` VARCHAR(20) NULL DEFAULT NULL ,
  `NumeroVale` VARCHAR(20) NULL DEFAULT NULL ,
  `MontoTotal` DECIMAL(10,0) NULL DEFAULT NULL ,
  `FechaRegistro` DATE NULL DEFAULT NULL ,
  PRIMARY KEY (`Id`) ,
  INDEX `XIF1Comprobante` (`IdCliente` ASC) ,
  INDEX `XIF3Comprobante` (`IdDespacho` ASC) ,
  CONSTRAINT `transaccion_ibfk_2`
    FOREIGN KEY (`IdDespacho` )
    REFERENCES `cem44`.`despacho` (`Id` ),
  CONSTRAINT `transaccion_ibfk_1`
    FOREIGN KEY (`IdCliente` )
    REFERENCES `cem44`.`cliente` (`Id` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `cem44`.`movimiento`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `cem44`.`movimiento` (
  `Id` INT(11) NOT NULL ,
  `IdTurno` INT(11) NOT NULL ,
  `IdPuntoVenta` INT(11) NOT NULL ,
  `IdCaja` INT(11) NOT NULL ,
  `IdTipoPago` INT(11) NULL DEFAULT NULL ,
  `MontoRecibido` DECIMAL(10,0) NULL DEFAULT NULL ,
  `MontoTotal` DECIMAL(10,0) NULL DEFAULT NULL ,
  `MontoDevuelto` DECIMAL(10,0) NULL DEFAULT NULL ,
  `FechaRegistro` DATE NULL DEFAULT NULL ,
  `IdTransaccion` INT(11) NOT NULL ,
  `NroOperacion` VARCHAR(20) NULL DEFAULT NULL ,
  PRIMARY KEY (`Id`) ,
  INDEX `XIF1Movimiento` (`IdTurno` ASC, `IdPuntoVenta` ASC, `IdCaja` ASC) ,
  INDEX `XIF2Movimiento` (`IdTransaccion` ASC) ,
  CONSTRAINT `movimiento_ibfk_2`
    FOREIGN KEY (`IdTransaccion` )
    REFERENCES `cem44`.`transaccion` (`Id` ),
  CONSTRAINT `movimiento_ibfk_1`
    FOREIGN KEY (`IdTurno` , `IdPuntoVenta` , `IdCaja` )
    REFERENCES `cem44`.`turnopuntoventacaja` (`IdTurno` , `IdPuntoVenta` , `IdCaja` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `cem44`.`opcion`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `cem44`.`opcion` (
  `Id` INT(11) NOT NULL ,
  `Nombre` VARCHAR(20) NULL DEFAULT NULL ,
  `FechaRegistro` DATE NULL DEFAULT NULL ,
  PRIMARY KEY (`Id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `cem44`.`perfil`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `cem44`.`perfil` (
  `Id` INT(11) NOT NULL ,
  `Nombre` VARCHAR(20) NULL DEFAULT NULL ,
  `FechaRegistro` DATE NULL DEFAULT NULL ,
  PRIMARY KEY (`Id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `cem44`.`perfilopcion`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `cem44`.`perfilopcion` (
  `IdOpcion` INT(11) NOT NULL ,
  `IdPerfil` INT(11) NOT NULL ,
  `FechaRegistro` DATE NULL DEFAULT NULL ,
  PRIMARY KEY (`IdOpcion`, `IdPerfil`) ,
  INDEX `XIF1PerfilOpcion` (`IdOpcion` ASC) ,
  INDEX `XIF2PerfilOpcion` (`IdPerfil` ASC) ,
  CONSTRAINT `perfilopcion_ibfk_2`
    FOREIGN KEY (`IdPerfil` )
    REFERENCES `cem44`.`perfil` (`Id` ),
  CONSTRAINT `perfilopcion_ibfk_1`
    FOREIGN KEY (`IdOpcion` )
    REFERENCES `cem44`.`opcion` (`Id` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `cem44`.`tarjeta`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `cem44`.`tarjeta` (
  `Id` INT(11) NOT NULL ,
  `NombreChofer` VARCHAR(20) NULL DEFAULT NULL ,
  `NumeroPlaca` VARCHAR(20) NULL DEFAULT NULL ,
  `FechaCaducidad` DATE NULL DEFAULT NULL ,
  `FechaRegistro` DATE NULL DEFAULT NULL ,
  `IdCliente` INT(11) NOT NULL ,
  PRIMARY KEY (`Id`) ,
  INDEX `XIF1Tarjeta` (`IdCliente` ASC) ,
  CONSTRAINT `tarjeta_ibfk_1`
    FOREIGN KEY (`IdCliente` )
    REFERENCES `cem44`.`cliente` (`Id` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `cem44`.`puntoacumulado`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `cem44`.`puntoacumulado` (
  `IdTransaccion` INT(11) NOT NULL ,
  `IdTarjeta` INT(11) NOT NULL ,
  `FechaRegistro` DATE NULL DEFAULT NULL ,
  `NumeroPuntos` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`IdTransaccion`, `IdTarjeta`) ,
  INDEX `XIF1PuntosAcumulados` (`IdTransaccion` ASC) ,
  INDEX `XIF2PuntosAcumulados` (`IdTarjeta` ASC) ,
  CONSTRAINT `puntoacumulado_ibfk_2`
    FOREIGN KEY (`IdTarjeta` )
    REFERENCES `cem44`.`tarjeta` (`Id` ),
  CONSTRAINT `puntoacumulado_ibfk_1`
    FOREIGN KEY (`IdTransaccion` )
    REFERENCES `cem44`.`transaccion` (`Id` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `cem44`.`subcuenta`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `cem44`.`subcuenta` (
  `Id` INT(11) NOT NULL ,
  `Descriocion` VARCHAR(20) NULL DEFAULT NULL ,
  `IdTipoMoneda` INT(11) NULL DEFAULT NULL ,
  `Saldo` INT(11) NULL DEFAULT NULL ,
  `LimiteCredito` INT(11) NULL DEFAULT NULL ,
  `IdProducto` INT(11) NOT NULL ,
  `FechaRegistro` DATE NULL DEFAULT NULL ,
  `IdCuenta` INT(11) NOT NULL ,
  `IdTarjeta` INT(11) NOT NULL ,
  PRIMARY KEY (`Id`) ,
  INDEX `XIF1SubCuenta` (`IdProducto` ASC) ,
  INDEX `XIF2SubCuenta` (`IdCuenta` ASC) ,
  INDEX `XIF3SubCuenta` (`IdTarjeta` ASC) ,
  CONSTRAINT `subcuenta_ibfk_3`
    FOREIGN KEY (`IdTarjeta` )
    REFERENCES `cem44`.`tarjeta` (`Id` ),
  CONSTRAINT `subcuenta_ibfk_1`
    FOREIGN KEY (`IdProducto` )
    REFERENCES `cem44`.`producto` (`Id` ),
  CONSTRAINT `subcuenta_ibfk_2`
    FOREIGN KEY (`IdCuenta` )
    REFERENCES `cem44`.`cuenta` (`Id` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `cem44`.`tanque`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `cem44`.`tanque` (
  `Id` INT(11) NOT NULL ,
  `IdEstacionServicio` INT(11) NOT NULL ,
  `FechaRegistro` DATE NULL DEFAULT NULL ,
  `Capacidad` INT(11) NULL DEFAULT NULL ,
  `Numero` INT(11) NULL DEFAULT NULL ,
  `AlturaVarillaje` INT(11) NULL DEFAULT NULL ,
  `AlturaSensor` INT(11) NULL DEFAULT NULL ,
  `IdProducto` INT(11) NOT NULL ,
  PRIMARY KEY (`Id`) ,
  INDEX `XIF1Tanque` (`IdEstacionServicio` ASC) ,
  INDEX `XIF2Tanque` (`IdProducto` ASC) ,
  CONSTRAINT `tanque_ibfk_2`
    FOREIGN KEY (`IdProducto` )
    REFERENCES `cem44`.`producto` (`Id` ),
  CONSTRAINT `tanque_ibfk_1`
    FOREIGN KEY (`IdEstacionServicio` )
    REFERENCES `cem44`.`estacionservicio` (`Id` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `cem44`.`tipocambio`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `cem44`.`tipocambio` (
  `Id` INT(11) NOT NULL ,
  `Cambio` DECIMAL(10,0) NULL DEFAULT NULL ,
  `IdMoneda` INT(11) NULL DEFAULT NULL ,
  `FechaRegistro` DATE NULL DEFAULT NULL ,
  PRIMARY KEY (`Id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `cem44`.`transacciondetalle`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `cem44`.`transacciondetalle` (
  `Id` INT(11) NOT NULL ,
  `IdTransaccion` INT(11) NOT NULL ,
  `Monto` DECIMAL(10,0) NULL DEFAULT NULL ,
  `Cantidad` INT(11) NULL DEFAULT NULL ,
  `IdProducto` INT(11) NOT NULL ,
  `FechaRegistro` DATE NULL DEFAULT NULL ,
  PRIMARY KEY (`Id`) ,
  INDEX `XIF1TransaccionDetalle` (`IdTransaccion` ASC) ,
  INDEX `XIF2TransaccionDetalle` (`IdProducto` ASC) ,
  CONSTRAINT `transacciondetalle_ibfk_2`
    FOREIGN KEY (`IdProducto` )
    REFERENCES `cem44`.`producto` (`Id` ),
  CONSTRAINT `transacciondetalle_ibfk_1`
    FOREIGN KEY (`IdTransaccion` )
    REFERENCES `cem44`.`transaccion` (`Id` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `cem44`.`usuario`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `cem44`.`usuario` (
  `Id` INT(11) NOT NULL ,
  `Login` VARCHAR(20) NULL DEFAULT NULL ,
  `Clave` VARCHAR(20) NULL DEFAULT NULL ,
  `IdTrabajador` INT(11) NOT NULL ,
  `FechaRegistro` DATE NULL DEFAULT NULL ,
  PRIMARY KEY (`Id`) ,
  INDEX `XIF1Usuario` (`IdTrabajador` ASC) ,
  CONSTRAINT `usuario_ibfk_1`
    FOREIGN KEY (`IdTrabajador` )
    REFERENCES `cem44`.`trabajador` (`Id` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `cem44`.`usuarioperfil`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `cem44`.`usuarioperfil` (
  `IdUsuario` INT(11) NOT NULL ,
  `IdPerfil` INT(11) NOT NULL ,
  `FechaRegistro` DATE NULL DEFAULT NULL ,
  PRIMARY KEY (`IdUsuario`, `IdPerfil`) ,
  INDEX `XIF1UsuarioPerfil` (`IdUsuario` ASC) ,
  INDEX `XIF2UsuarioPerfil` (`IdPerfil` ASC) ,
  CONSTRAINT `usuarioperfil_ibfk_2`
    FOREIGN KEY (`IdPerfil` )
    REFERENCES `cem44`.`perfil` (`Id` ),
  CONSTRAINT `usuarioperfil_ibfk_1`
    FOREIGN KEY (`IdUsuario` )
    REFERENCES `cem44`.`usuario` (`Id` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `cem44`.`varillaje`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `cem44`.`varillaje` (
  `Id` INT(11) NOT NULL ,
  `IdTanque` INT(11) NOT NULL ,
  `FechaLectura` DATE NULL DEFAULT NULL ,
  `MedicionVolumen` INT(11) NULL DEFAULT NULL ,
  `MedicionAgua` INT(11) NULL DEFAULT NULL ,
  `FechaNegocio` CHAR(18) NULL DEFAULT NULL ,
  `FechaRegistro` DATE NULL DEFAULT NULL ,
  PRIMARY KEY (`Id`) ,
  INDEX `XIF1MedicionTanque` (`IdTanque` ASC) ,
  CONSTRAINT `varillaje_ibfk_1`
    FOREIGN KEY (`IdTanque` )
    REFERENCES `cem44`.`tanque` (`Id` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `cem44`.`varillajeajuste`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `cem44`.`varillajeajuste` (
  `Id` INT(11) NOT NULL ,
  `IdVarillaje` INT(11) NOT NULL ,
  `Volumen` INT(11) NULL DEFAULT NULL ,
  `Concepto` VARCHAR(20) NULL DEFAULT NULL ,
  `FechaRegistro` DATE NULL DEFAULT NULL ,
  PRIMARY KEY (`Id`) ,
  INDEX `XIF1VarillajeAjuste` (`IdVarillaje` ASC) ,
  CONSTRAINT `varillajeajuste_ibfk_1`
    FOREIGN KEY (`IdVarillaje` )
    REFERENCES `cem44`.`varillaje` (`Id` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

USE `cem44` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
