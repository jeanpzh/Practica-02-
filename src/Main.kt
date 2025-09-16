fun main() {
    val ahorros = CuentaAhorros(saldoInicial = 8000f, tasaAnual = 12f)

    println("Estado inicial:")
    ahorros.imprimir()

    println("\nIntento de retiro estando inactiva:")
    ahorros.retirar(500f)

    println("\nConsignando para activar la cuenta:")
    ahorros.consignar(3000f)

    val ahorrosActiva = CuentaAhorros(saldoInicial = 12_000f, tasaAnual = 12f)

    println("\nCuenta activa creada:")
    ahorrosActiva.imprimir()

    println("\nOperaciones del mes:")
    ahorrosActiva.consignar(1000f)
    repeat(5) { ahorrosActiva.retirar(500f) }

    println("\nAntes del extracto:")
    ahorrosActiva.imprimir()

    println("\nGenerando extracto mensual...")
    ahorrosActiva.extractoMensual()

    println("\nDespués del extracto:")
    ahorrosActiva.imprimir()

    // (Opcional) Demostración rápida de cuenta corriente
    println("\n--- Prueba Cuenta Corriente ---")
    val corriente = CuentaCorriente(saldoInicial = 2000f, tasaAnual = 12f)
    corriente.retirar(3500f)
    corriente.consignar(1000f)
    corriente.extractoMensual()
    corriente.imprimir()
}
