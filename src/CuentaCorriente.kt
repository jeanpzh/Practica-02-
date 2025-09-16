class CuentaCorriente(
    saldoInicial: Float,
    tasaAnual: Float
) : Cuenta(saldoInicial, tasaAnual) {

    private var sobregiro: Float = 0f

    override fun retirar(monto: Float): Boolean {
        require(monto > 0f) { "El monto a retirar debe ser positivo." }
        if (monto <= saldo) {
            saldo -= monto
        }
        else {
            val deficit = monto - saldo
            saldo = 0f
            sobregiro += deficit
        }
        numeroRetiros++
        return true
    }

    override fun consignar(monto: Float) {
        require(monto > 0f) { "El monto a consignar debe ser positivo." }
        var restante = monto

        if (sobregiro > 0f) {
            val cubre = minOf(sobregiro, restante)
            sobregiro -= cubre
            restante -= cubre
        }

        if (restante > 0f) {
            saldo += restante
        }
        numeroConsignaciones++
    }

    override fun extractoMensual() {
        super.extractoMensual()
    }

    override fun imprimir() {
        println("=== Cuenta Corriente ===")
        println("Saldo: $saldo")
        println("Comisión mensual (último corte): $comisionMensual")
        println("Transacciones (consignaciones + retiros): ${numeroConsignaciones + numeroRetiros}")
        println("Sobregiro: $sobregiro")
    }
}
